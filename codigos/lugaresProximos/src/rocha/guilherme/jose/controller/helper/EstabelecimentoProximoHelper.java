package rocha.guilherme.jose.controller.helper;

import rocha.guilherme.jose.model.ModelEstabelecimento;
import rocha.guilherme.jose.view.EstabelecimentoProximoTela;

public class EstabelecimentoProximoHelper {

	private final EstabelecimentoProximoTela estabelecimentoProximoTela;

	public EstabelecimentoProximoHelper(EstabelecimentoProximoTela estabelecimentoProximoTela) {
		super();
		this.estabelecimentoProximoTela = estabelecimentoProximoTela;
	}

	public ModelEstabelecimento obterLugar() {
		String local = estabelecimentoProximoTela.getTextFieldNomeLocal().getText();
		String cidade = estabelecimentoProximoTela.getTextFieldCidade().getText();
		String estado = estabelecimentoProximoTela.getTextFieldEstado().getText();
		
		ModelEstabelecimento estabelecimento = new ModelEstabelecimento(local, cidade, estado);
		return estabelecimento;
	}

	public boolean verificarCampos() {
		if(estabelecimentoProximoTela.getTextFieldNomeLocal().getText().trim().isEmpty() || estabelecimentoProximoTela.getTextFieldCidade().getText().trim().isEmpty() ||
				estabelecimentoProximoTela.getTextFieldEstado().getText().trim().isEmpty()) {
			return false;			
		}
		
		return true;
	}

	public boolean validarCidadeEstado() {
		String estado = estabelecimentoProximoTela.getTextFieldEstado().getText();
		String cidade = estabelecimentoProximoTela.getTextFieldCidade().getText();
		
		if(!estado.matches("[\\p{L} ]+")) {
			return false;			
		}
		
		if(!cidade.matches("[\\p{L} ]+")) {
			return false;			
		}
		
		return true;
	}

	public void limparTela() {
		estabelecimentoProximoTela.getTextFieldNomeLocal().setText("");
		estabelecimentoProximoTela.getTextFieldCidade().setText("");
		estabelecimentoProximoTela.getTextFieldEstado().setText("");
	}
	
	
}
