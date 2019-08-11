package model.requisicoes;

public class RequisicaoLiteCoin extends RequisicaoHttpCripto{

	@Override
	public String consultarValor() throws Exception {
		
		return consultar("LTC");
	}
	
	private String consultar(String moeda) throws Exception {
		return (String) super.request("LTC", "vol");
	}

	@Override
	public String maiorValor(String moeda) throws Exception {
		try {
			return (String) super.request(moeda, "high");
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor do LiteCoin");
		}
	}

	@Override
	public String menorValor(String moeda) throws Exception {
		try {
			return (String) super.request(moeda, "low");
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor do Litecoin");
		}
	}

}
