package model.requisicoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public abstract class RequisicaoHttpCripto implements ITrequeste{
	
	
	public Object request(String moeda,String tipoRetorno) throws Exception {
		try {
			URL url = getURl("https://www.mercadobitcoin.net/api/"+moeda+"/ticker");
			JSONObject jsonObj = getJSON(url);
			
			return jsonObj.getJSONObject("ticker").getString(tipoRetorno);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private URL getURl(String url) throws IOException {
		URL urls = new URL(url);
		HttpURLConnection con = (HttpURLConnection) urls.openConnection();
		con.setRequestMethod("GET");
		con.connect();
		return urls;
	}

	private JSONObject getJSON(URL url) throws Exception {
		if (url == null) {
			throw new RuntimeException("Url nula");
		}
		return new JSONObject(getStringbuilder(url.openStream()).toString());
	}

	private  StringBuilder getStringbuilder(InputStream is) throws IOException {
		String html = null;
		StringBuilder sB = new StringBuilder();
		BufferedReader bR = new BufferedReader(new InputStreamReader(is));

		while ((html = bR.readLine()) != null) {
			sB.append(html);
		}
		return sB;
	}

	public abstract String consultarValor() throws Exception;
	
	public abstract String maiorValor(String moeda) throws Exception;
	
	public abstract String menorValor(String moeda) throws Exception;

	
}
