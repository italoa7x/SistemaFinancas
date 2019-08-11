package model.requisicoes;

public interface ITrequeste {

	public Object request(String moeda, String tipoRetorno) throws Exception;

	public abstract String consultarValor() throws Exception;
}
