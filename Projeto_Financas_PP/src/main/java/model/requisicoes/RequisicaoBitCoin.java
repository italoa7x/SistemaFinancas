package model.requisicoes;

public class RequisicaoBitCoin extends RequisicaoHttpCripto {
	
	@Override
	public String consultarValor() throws Exception {
		
		return consultar("BTC");
	}
	
	private String consultar(String moeda) throws Exception {
		try {
			return (String) super.request(moeda, "buy");
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor do Bitcoin");
		}
	}

	@Override
	public String maiorValor(String moeda) throws Exception {
		try {
			return (String) super.request(moeda, "high");
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor do Bitcoin");
		}
	}

	@Override
	public String menorValor(String moeda) throws Exception {
		try {
			return (String) super.request(moeda, "low");
		} catch (Exception e) {
			throw new Exception("Erro ao consultar valor do Bitcoin");
		}
	}

}
