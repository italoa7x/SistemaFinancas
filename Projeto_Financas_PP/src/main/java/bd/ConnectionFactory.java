package bd;
import java.sql.*;

public class ConnectionFactory{
    private final static  String   USER = "postgres";
    private final static  String   PASS = "root";
    private final static  String   URL = "jdbc:postgresql://localhost:5432/db_financas";


    public Connection conectar() throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL,USER,PASS);
        }catch(Exception e){
        	throw new Exception("erro ao fechar conexão. " + e.getMessage());
        }
    }

    public void desconectar(Connection con, PreparedStatement pst) throws Exception{
        try{
            if(con != null && pst != null){
                con.close();
                pst.close();
            }
        }catch(Exception e){
        	throw new Exception("erro ao fechar conexão. " + e.getMessage());
        }
    }

    public void desconectar(Connection con, PreparedStatement pst, ResultSet rs) throws Exception{
        this.desconectar(con,pst);
        try{
            if(rs != null){
                rs.close();
                            }
        }catch(Exception e){
            throw new Exception("erro ao fechar conexão. " + e.getMessage());
        }
    }
    
    private ConnectionFactory() {}
    
    private static volatile ConnectionFactory obj;
    
    public static ConnectionFactory getInstance() {
    	if(obj == null) {
    		synchronized(ConnectionFactory.class) {
    			if(obj == null) {
    				obj = new ConnectionFactory();
    			}
    		}
    	}
    	return obj;
    }
    
}