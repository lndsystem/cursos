Brewer.TabelaItens = (function() {
	function TabelaItens(autocomplete) {
		this.autocomplete = autocomplete;
		this.tabelaCervejasContainer = $('.js-tabela-cervejas-container');
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
		
		resposta.done(onItemAtualizadoNoServidor.bind(this));
	}
	
	function onItemAtualizadoNoServidor(html) {
		this.tabelaCervejasContainer.html(html);		
		$('.js-tabela-cerveja-quantidade-item').on('change', onQuantidadeItemAlterado.bind(this));
		//para funcionar em mobile estamos usando a funçao de baixo
		//$('.js-tabela-item').on('dblclick', onDoubleClick); 
		$('.js-tabela-item').doubletap(onDoubleClick);
		$('.js-exclusao-item-btn').on('click', onExclusaoItemClick.bind(this));
	}
	
	function onQuantidadeItemAlterado(evento) {
		var input = $(evento.target);
		var quantidade = input.val();
		var codigoCerveja = input.data('codigo-cerveja');
		
		var resposta = $.ajax({
			url: 'item/' + codigoCerveja,
			method: 'PUT',
			data: {
				quantidade: quantidade
			}
		});
		
		resposta.done(onItemAtualizadoNoServidor.bind(this));
	}
	
	function onDoubleClick(evento) {
		$(this).toggleClass('solicitando-exclusao');
	}
	
	function onExclusaoItemClick(evento) {
		var codigoCerveja = $(evento.target).data('codigo-cerveja');
		var resposta = $.ajax({
			url: 'item/' + codigoCerveja,
			method: 'DELETE'
		});
		
		resposta.done(onItemAtualizadoNoServidor.bind(this));
	}
	return TabelaItens;
})();

$(function() {
	var autoComplete = new Brewer.Autocomplete();
	autoComplete.iniciar();
	
	var tabelaItens = new Brewer.TabelaItens(autoComplete);
	tabelaItens.iniciar();
});