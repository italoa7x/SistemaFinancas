package model.requisicoes;

public class RequisicaoEuro extends RequisicaoHttpMoedas{
	@Override
	public String consultarValor() throws Exception {
		
		return consultar("EUR");
	}
	
	
	private String consultar(String moeda) throws Exception {
		try {
			return (String) super.request(moeda,moeda);
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor do Euro");
		}
	}
}
