Brewer.TabelaItens = (function() {
	function TabelaItens(autocomplete) {
		this.autocomplite = autocomplete;
	}
	
	TabelaItens.prototype.iniciar = function() {
		
	}
	
	return TabelaItens;
})();

$(function() {
	var autoComplete = new Brewer.Autocomplete();
	autoComplete.iniciar();
	
	var tabelaItens = new Brewer.TabelaItens(autoComplete);
	tabelaItens.iniciar();
});