package model.requisicoes;

public class RequisicaoLibra extends RequisicaoHttpMoedas{
	@Override
	public String consultarValor() throws Exception {
		
		return consultar("GBP");
	}
	
	
	private String consultar(String moeda) throws Exception {
		try {
			return (String) super.request(moeda,moeda);
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor da Libra");
		}
	}
}
