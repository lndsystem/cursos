var Brewer = Brewer || {};

Brewer.GraficoVendaPorMes = (function() {
	function GraficoVendaPorMes() {
		this.ctx = $('#graficoVendaPorMes')[0].getContext('2d');
	}
	
	GraficoVendaPorMes.prototype.iniciar = function() {
		$.ajax({
			url: 'vendas/totalPorMes',
			method: 'GET',
			success: onDadosRecebidos.bind(this)
		});
	}
	
	function onDadosRecebidos(vendaMes) {
		var meses = [];
		var valores = [];
		
		vendaMes.forEach(function (obj){
			meses.unshift(obj.mes);
			valores.unshift(obj.total);
		});
		
		var graficoVendasPorMes = new Chart(this.ctx,{
			type: 'line',
			data: {
				labels: meses,
				datasets: [{
					label: 'Vendas por mês',
					backgroundColor: 'rgba(26, 179, 148, 0.5)',
					pointBorderColor: 'rgba(26, 179, 148, 1)',
					pointBackgroundColor: '#fff',
					data: valores
				}]
			}
		});
	}
	
	return GraficoVendaPorMes;
})();

Brewer.GraficoVendaPorOrigem = (function() {
	function GraficoVendaPorOrigem() {
		this.ctx = $('#graficoVendasPorOrigem')[0].getContext('2d');
	}
	
	GraficoVendaPorOrigem.prototype.iniciar = function(){
		$.ajax({
			url: 'vendas/porOrigem',
			method: 'GET',
			success: onDadosRecebidos.bind(this)
		});
	}
	
	function onDadosRecebidos(vendaOrigem) {
		var meses = [];
		var cervejasNacionais = [];
		var cervejasInternacionas = [];
		
		vendaOrigem.forEach(function(obj) {
			meses.unshift(obj.mes);
			cervejasNacionais.unshift(obj.totalNacional);
			cervejasInternacionas.unshift(obj.totalInternacional);
		});
		
		var graficoVendasPorOrigem = new Chart(this.ctx, {
			type: 'bar',
			data: {
				labels: meses,
				datasets:[{
					label: 'Nacional',
					backgroundColor: 'rgba(220,220,220,0.5)',
					data: cervejasNacionais
				},
				{
					label: 'Internacional',
					backgroundColor: 'rgba(26,179,148,0.5)',
					data: cervejasInternacionas
				}]
			}
		});
	}
	
	return GraficoVendaPorOrigem;
})();

$(function() {
	var graficoVendaPorMes = new Brewer.GraficoVendaPorMes();
	graficoVendaPorMes.iniciar();
	
	var graficoVendaPorOrigem = new Brewer.GraficoVendaPorOrigem();
	graficoVendaPorOrigem.iniciar();
});