Brewer.TabelaItens = (function() {
	function TabelaItens(autocomplete) {
		this.autocomplete = autocomplete;
	}
	
	TabelaItens.prototype.iniciar = function() {
		this.autocomplete.on('item-selecionado', onItemSelecionado.bind(this));
	}
	
	function onItemSelecionado(event, item) {
		var resposta = $.ajax({
			url: 'item',
			method: 'POST',
			data: {
				codigoCerveja: item.codigo
			}
		});
		
		resposta.done(function(data) {
			console.log('retorno', data);
		});
		//console.log('Item recebido do autocomplete', item);
	}
	
	return TabelaItens;
})();

$(function() {
	var autoComplete = new Brewer.Autocomplete();
	autoComplete.iniciar();
	
	var tabelaItens = new Brewer.TabelaItens(autoComplete);
	tabelaItens.iniciar();
});