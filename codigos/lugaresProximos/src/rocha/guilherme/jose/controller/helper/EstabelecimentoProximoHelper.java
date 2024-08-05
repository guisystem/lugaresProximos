package rocha.guilherme.jose.controller.helper;

import rocha.guilherme.jose.model.ModelEstabelecimento;
import rocha.guilherme.jose.view.EstabelecimentoProximoTela;

public class EstabelecimentoProximoHelper {

	private final EstabelecimentoProximoTela estabelecimentoProximoAvaliadoTela;

	public EstabelecimentoProximoHelper(EstabelecimentoProximoTela estabelecimentoProximoAvaliadoTela) {
		super();
		this.estabelecimentoProximoAvaliadoTela = estabelecimentoProximoAvaliadoTela;
	}

	public ModelEstabelecimento obterLugar() {
		String local = estabelecimentoProximoAvaliadoTela.getTextFieldNomeLocal().getText();
		String cidade = estabelecimentoProximoAvaliadoTela.getTextFieldCidade().getText();
		String estado = estabelecimentoProximoAvaliadoTela.getTextFieldEstado().getText();
		double avaliacaoMinima = obterAvaliacaoMinima();
		
		ModelEstabelecimento estabelecimento = new ModelEstabelecimento(local, cidade, estado, avaliacaoMinima);
		return estabelecimento;
	}

	private double obterAvaliacaoMinima() {
		if (estabelecimentoProximoAvaliadoTela.getRdbtn20().isSelected()) return 2.0;
		if (estabelecimentoProximoAvaliadoTela.getRdbtn25().isSelected()) return 2.5;
		if (estabelecimentoProximoAvaliadoTela.getRdbtn30().isSelected()) return 3.0;
		if (estabelecimentoProximoAvaliadoTela.getRdbtn35().isSelected()) return 3.5;
		if (estabelecimentoProximoAvaliadoTela.getRdbtn40().isSelected()) return 4.0;
		if (estabelecimentoProximoAvaliadoTela.getRdbtn45().isSelected()) return 4.5;
		
		return 4.0;
	}

	public boolean verificarCampos() {
		if(estabelecimentoProximoAvaliadoTela.getTextFieldNomeLocal().getText().trim().isEmpty() || 
				estabelecimentoProximoAvaliadoTela.getTextFieldCidade().getText().trim().isEmpty() ||
				estabelecimentoProximoAvaliadoTela.getTextFieldEstado().getText().trim().isEmpty()) {
			return false;			
		}
		
		return true;
	}

	public boolean verificarSelecaoAvaliacao() {
		if(estabelecimentoProximoAvaliadoTela.getGrupo().getSelection() == null) {
			return false;			
		}
		
		return true;
	}

	public boolean validarEstado() {
		String estado = estabelecimentoProximoAvaliadoTela.getTextFieldEstado().getText();
		
		if(!estado.matches("[\\p{L} ]+")) {
			return false;			
		}
		
		return true;
	}

	public void limparTela() {
		estabelecimentoProximoAvaliadoTela.getTextFieldNomeLocal().setText("");
		estabelecimentoProximoAvaliadoTela.getTextFieldCidade().setText("");
		estabelecimentoProximoAvaliadoTela.getTextFieldEstado().setText("");
		estabelecimentoProximoAvaliadoTela.getGrupo().clearSelection();
	}
	
}
