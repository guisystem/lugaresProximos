package rocha.guilherme.jose.controller;

import rocha.guilherme.jose.controller.helper.EstabelecimentoProximoHelper;
import rocha.guilherme.jose.model.ModelEstabelecimento;
import rocha.guilherme.jose.view.EstabelecimentoProximoTela;

public class EstabelecimentoProximoController {

	private final EstabelecimentoProximoTela estabelecimentoProximoTela;
	private final EstabelecimentoProximoHelper helper;
	
	public EstabelecimentoProximoController(EstabelecimentoProximoTela estabelecimentoProximoTela) {
		super();
		this.estabelecimentoProximoTela = estabelecimentoProximoTela;
		this.helper = new EstabelecimentoProximoHelper(estabelecimentoProximoTela);
	}

	public void pesquisarNoMapa() {
		ModelEstabelecimento estabelecimento = helper.obterLugar();
		
		if(helper.verificarCampos()) {
			if(helper.validarCidadeEstado()) {
				estabelecimento.mostrarNoMapa();
			}else {
				estabelecimentoProximoTela.exibeMensagemInformativa("A cidade e o estado deve conter apenas letras.");
			}
		}else {
			estabelecimentoProximoTela.exibeMensagemInformativa("Preencha todos os campos.");
		}
	}

	public void limparTela() {
		helper.limparTela();
		
	}
}
