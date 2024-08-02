package rocha.guilherme.jose.view;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import rocha.guilherme.jose.model.ModelEstabelecimento;

public class Main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		ModelEstabelecimento estabelecimento = null;
		int decisao;
		
		do {
			
			estabelecimento = null;
			while(estabelecimento == null) {
				UIManager.put("OptionPane.okButtonText", "Prosseguir");
				UIManager.put("OptionPane.cancelButtonText", "Cancelar");
				
				String nomeEstabelecimento = exibeMensagemInput("Qual o nome do estabelecimento?");
				if(nomeEstabelecimento == null) {
					return;
				}
				
				if(nomeEstabelecimento.isEmpty()) {
					UIManager.put("OptionPane.okButtonText", "Entendi");
					JOptionPane.showMessageDialog(null, "O campo não pode está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);					
				}else {
					estabelecimento = new ModelEstabelecimento(nomeEstabelecimento);				
				}
			}
			
			decisao = exibeMensagemDecisao(estabelecimento);
			if(decisao == JOptionPane.YES_OPTION) {				
				estabelecimento.mostrarNoMapa();
			}
			
		}while(decisao == JOptionPane.NO_OPTION);
		
	}

	private static int exibeMensagemDecisao(ModelEstabelecimento lugar) {
		UIManager.put("OptionPane.yesButtonText", "Buscar no Mapa");
		UIManager.put("OptionPane.noButtonText", "Digitar Novamente");
		
		return JOptionPane.showConfirmDialog(null, "Buscar por: " + lugar.getNome() + "?", "O que deseja fazer?", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	private static String exibeMensagemInput(String mensagem) {
		return JOptionPane.showInputDialog(null, mensagem, "Nome do Local", JOptionPane.QUESTION_MESSAGE);
	}
	
}