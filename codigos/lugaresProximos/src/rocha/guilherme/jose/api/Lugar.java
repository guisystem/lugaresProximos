package rocha.guilherme.jose.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Lugar {

	private final static String GEONAMES_USERNAME = "SEU_NOME_DE_USUARIO_NO_GEONAMES";
	
	public static boolean estadoExiste(String estado) {
		return validarLocal(null, estado);
	}
	
	public static boolean cidadeExiste(String cidade, String estado){
		return validarLocal(cidade, estado);
	}

	private static boolean validarLocal(String cidade, String estado) {
		HttpURLConnection conn = null;
		InputStreamReader in = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			String encodedEstado = URLEncoder.encode(estado, "UTF-8");
			
			String urlString;
			if(cidade != null) {
				String encodedCidade = URLEncoder.encode(cidade, "UTF-8");
				urlString = "http://api.geonames.org/searchJSON?q=" + encodedCidade + "&adminName1=" + encodedEstado + "&country=BR&maxRows=1&username=" + GEONAMES_USERNAME;
			}else {
	            urlString = "http://api.geonames.org/searchJSON?q=" + encodedEstado + "&country=BR&featureCode=ADM1&maxRows=1&username=" + GEONAMES_USERNAME;
			}
			
			URL url = new URL(urlString);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			in = new InputStreamReader(conn.getInputStream());
			try (Scanner scanner = new Scanner(in)) {
				while (scanner.hasNext()) {
					sb.append(scanner.nextLine());
				}
			}
			
			JSONObject json = new JSONObject(sb.toString());
			if (json.has("geonames")) {
				JSONArray geonames = json.getJSONArray("geonames");
				return geonames.length() > 0;
			} else {
				return false;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
