// loops (estrutura de repetição)
// for, for in, while, do while

//Teste depois executa
var x = 0;
while( x <= 10 ) { //expressao boolean - while -> enquanto
	console.log('X é igual a ' + x);
	x++;
}	

//Executa depois testa
console.log('##########################');
do {
	console.log('X é igual a ' + x);
	x--;
} while(x >=0);

//testa e executa
for (var y = 0; y < 10; y++) {
	console.log('Y é igual a ' + y);
}

var obj = {
	nome: 'Jon',
	sobreNome: 'Snow'
};

for(var prop in obj) {
	console.log(prop); //propriedades
	console.log(obj[prop]); //valor propriedade
}