window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ValidaValor = window.blockly.js.blockly.ValidaValor
		|| {};

/**
 * ValidaValor
 */
window.blockly.js.blockly.ValidaValor.ValidaValor = function() {
	if (window.cronapi.screen.getValueOfField("Abastecimento.active.valor") > window.cronapi.screen
			.getValueOfField("Abastecimento.active.precoLitro") * 150) {
		window.cronapi.screen
				.notify(
						'error',
						'Valor do abastecimento é maior do que o preço do litro vezes 150. Isso não cabe no tanque. ');
		window.cronapi.screen.hideComponent("botaosalvar");
	} else {
		window.cronapi.screen.showComponent("botaosalvar");
	}
}
