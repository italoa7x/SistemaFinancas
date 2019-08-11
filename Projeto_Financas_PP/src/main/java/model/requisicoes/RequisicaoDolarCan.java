package model.requisicoes;

public class RequisicaoDolarCan extends RequisicaoHttpMoedas{
	@Override
	public String consultarValor() throws Exception {
		
		return consultar("CAD");
	}
	
	
	private String consultar(String moeda) throws Exception {
		try {
			return (String) super.request(moeda,moeda);
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor do Dolar Canadense");
		}
	}
}
