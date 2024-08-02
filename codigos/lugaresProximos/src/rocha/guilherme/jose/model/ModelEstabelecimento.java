package rocha.guilherme.jose.model;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ModelEstabelecimento {

	private String nome;
	
	public ModelEstabelecimento(String nome) {
		if(nome != null) {
			this.nome = nome.toUpperCase();						
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public void mostrarNoMapa() throws IOException, URISyntaxException {
		String nomeURL = nome.replace(" ", "%20");
		Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/?api=1&query=" + nomeURL));
	}

}
