var b = 2; //variável global

function ola() {
	var a = 1;
	console.log(a);
	console.log(b);
};
ola();


//Acesso ao escopo mesmo que destruido
function tick() {
	var contador = 0;
	contador++;
	console.log(contador);
}

tick();
tick();
tick();



var tick = (function (){
	var contador = 0;
	return function() {
		contador++;
		console.log(contador);
	}
})();

tick();
tick();
tick();

