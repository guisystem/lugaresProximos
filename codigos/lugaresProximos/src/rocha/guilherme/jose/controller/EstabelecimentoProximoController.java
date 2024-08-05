package rocha.guilherme.jose.controller;

import rocha.guilherme.jose.controller.helper.EstabelecimentoProximoHelper;
import rocha.guilherme.jose.model.ModelEstabelecimento;
import rocha.guilherme.jose.view.EstabelecimentoProximoTela;

public class EstabelecimentoProximoController {

	private final EstabelecimentoProximoTela estabelecimentoProximoAvaliadoTela;
	private final EstabelecimentoProximoHelper helper;
	
	public EstabelecimentoProximoController(EstabelecimentoProximoTela estabelecimentoProximoAvaliadoTela) {
		super();
		this.estabelecimentoProximoAvaliadoTela = estabelecimentoProximoAvaliadoTela;
		this.helper = new EstabelecimentoProximoHelper(estabelecimentoProximoAvaliadoTela);
	}

	public void pesquisarNoMapa() {
		ModelEstabelecimento estabelecimento = helper.obterLugar();
		
		if(helper.verificarCampos()) {
			if(helper.verificarSelecaoAvaliacao()) {
				if(helper.validarEstado()) {
					estabelecimento.mostrarNoMapa();
				}else {
					estabelecimentoProximoAvaliadoTela.exibeMensagemInformativa("O estado deve conter apenas letras.");
				}
			}else {
				estabelecimentoProximoAvaliadoTela.exibeMensagemInformativa("Selecione uma avalia��o minima de estrelas para o(a) " + estabelecimento.getNome() + ".");
			}
		}else {
			estabelecimentoProximoAvaliadoTela.exibeMensagemInformativa("Preencha todos os campos.");
		}
	}

	public void limparTela() {
		helper.limparTela();
		
	}

}
