//3.1 - declaracao (Funções)

//funcao tradicional
function dizerOi(nome) {
	console.log('Olá ' + nome);
}

dizerOi('Jon');
dizerOi('Robb');

//Funcao anonima
var dizerOla = function (nome) {
	console.log('Olá ' + nome);
};

dizerOla('Bran');


//Funcao construtora
var dizerTchau = new Function("nome", "console.log('Tchau ' + nome);"); 
dizerTchau('Rickon');