package model.requisicoes;

public class RequisicaoBCash extends RequisicaoHttpCripto{
	
	@Override
	public String consultarValor() throws Exception {
		
		return consultar("BCH");
	}
	
	private  String consultar(String moeda) throws Exception {
		try {
			return (String) super.request(moeda, "buy");
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor do BCash");
		}
	}

	@Override
	public String maiorValor(String moeda) throws Exception {
		try {
			return (String) super.request(moeda, "high");
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor do BCash");
		}
	}

	@Override
	public String menorValor(String moeda) throws Exception {
		try {
			return (String) super.request(moeda, "low");
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor do BCash");
		}
	}

}
