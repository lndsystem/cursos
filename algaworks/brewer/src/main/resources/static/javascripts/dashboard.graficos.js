var Brewer = Brewer || {};

Brewer.GraficoVendaPorMes = (function() {
	function GraficoVendaPorMes() {
		this.ctx = $('#graficoVendaPorMes')[0].getContext('2d');
	}
	
	GraficoVendaPorMes.prototype.iniciar = function() {
		var graficoVendasPorMes = new Chart(this.ctx,{
			type: 'line',
			data: {
				labels: ['Jan', 'Fev', 'Mar', 'Abr', 'Jun'],
				datasets: [{
					label: 'Vendas por mês',
					backgroundColor: 'rgb(26,179,148,0.5)',
					pointBorderColor: 'gb(26,179,148,1)',
					pointBackgroundColor: '#fff',
					data: [10, 5, 7, 2, 9]
				}]
			}
		});
 	}
	
	return GraficoVendaPorMes;
})();

$(function() {
	var graficoVendaPorMes = new Brewer.GraficoVendaPorMes();
	graficoVendaPorMes.iniciar();
});