package rocha.guilherme.jose.model;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ModelEstabelecimento {

	private String nome;
	private String cidade;
	private String estado;
	private double avaliacaoMinima;
	
	public ModelEstabelecimento(String nome, String cidade, String estado, double avaliacaoMinima) {
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.avaliacaoMinima = avaliacaoMinima;
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

	public double getAvaliacaoMinima() {
		return avaliacaoMinima;
	}

	public void setAvaliacaoMinima(double avaliacaoMinima) {
		this.avaliacaoMinima = avaliacaoMinima;
	}

	public void mostrarNoMapa(){
		String nomeURL = nome.replace(" ", "%20");
        String cidadeURL = cidade.replace(" ", "%20");
        String estadoURL = estado.replace(" ", "%20");
	    String avaliacao = avaliacaoURL();
	    
        try {
        	String urlString = "https://www.google.com/maps/search/" + nomeURL + "+" + cidadeURL + "+" + estadoURL + "/@-0.0000000,-00.0000000,16z/data=!3m1!4b1!4m8!2m7!5m5!" + avaliacao + "!5m2!4m1!1i2!10e4!6e3?entry=ttu";
        	Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	private String avaliacaoURL() {
		if(avaliacaoMinima == 2.0) return "4e1";
		if(avaliacaoMinima == 2.5) return "4e7";
		if(avaliacaoMinima == 3.0) return "4e2";
		if(avaliacaoMinima == 3.5) return "4e8";
		if(avaliacaoMinima == 4.0) return "4e3";
		if(avaliacaoMinima == 4.5) return "4e9";
		
		return "";
	}
	
}
