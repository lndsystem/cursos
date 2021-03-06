var Brewer = Brewer || {};

Brewer.EstiloCadastroRapido = (function() {
	function EstiloCadastroRapido() {
		this.modal = $('#modalCadastroRapidoEstilo');
		this.botaoSalvar = this.modal.find('.js-modal-cadastro-estilo-salvar-btn');
		this.form = this.modal.find('form');
		this.url = this.form.attr('action');
		this.inputNomeEstilo = $('#nomeEstilo');
		this.containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo');
	}
	
	EstiloCadastroRapido.prototype.iniciar = function() {
		//Utilizado para quando clicar com o ENTER, o formulário não seja submetido.
		this.form.on('submit', function(event) { event.preventDefault() });
		this.modal.on('shown.bs.modal', onModalShow.bind(this)); //Após carregar o modal
		this.modal.on('hide.bs.modal', onModalClose.bind(this)); //Antes de fechar o modal
		this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
	}
	
	function onModalShow() {
		this.inputNomeEstilo.focus();
	}
	
	function onModalClose() {
		this.inputNomeEstilo.val('');
		this.containerMensagemErro.addClass('hidden');
		this.modal.find('.form-group').removeClass('has-error');		
	}
	
	function onBotaoSalvarClick() {
		var nomeEstilo = this.inputNomeEstilo.val().trim();
		
		$.ajax({ 
			url: this.url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({nome: nomeEstilo}),
			error: onErroSalvandoEstilo.bind(this),
			success: onEstiloSalvo.bind(this)
		});
		
		function onErroSalvandoEstilo(obj) {
			var mensagemErro = obj.responseText;
			this.containerMensagemErro.removeClass('hidden');
			this.containerMensagemErro.html('<span>' + mensagemErro + '</span>');
			this.form.find('.form-group').addClass('has-error');
		}
		
		function onEstiloSalvo(estilo) {
			var comboEstilo = $('#estilo');
			comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.nome + '</option>');
			comboEstilo.val(estilo.codigo);
			this.modal.modal('hide');
		}
	}
	return EstiloCadastroRapido;
}());

$(function() {

	var estiloCadastroRapido = new Brewer.EstiloCadastroRapido();
	estiloCadastroRapido.iniciar();
		
});