package rocha.guilherme.jose.model;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ModelEstabelecimento {

	private String nome;
	private String cidade;
	private String estado;
	
	public ModelEstabelecimento(String nome, String cidade, String estado) {
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void mostrarNoMapa(){
		String nomeURL = nome.replace(" ", "%20");
        String cidadeURL = cidade.replace(" ", "%20");
        String estadoURL = estado.replace(" ", "%20");
        
        try {
			Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/?api=1&query=" + nomeURL + "%20" + cidadeURL + "%20" + estadoURL));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
}
