//Prototype - conseito de classe

function Stark(nome, idade, corDoCabelo) {
	this.nome = nome;
	this.idade = idade;
	this.corDoCabelo = corDoCabelo;

	this.sobreNome = 'Stark';

	this.apresentar = function() {
		console.log( 'Olá, eu sou ' + this.nome + ' ' + this.sobreNome + '.');
	};
}

var ned = new Stark('Ned', 40, 'Preto');
Stark.prototype.darTchau = function() {console.log('Tchau');};
var sansa = new Stark('Sansa', 13, "Cobre");

console.log(ned);
ned.apresentar();
ned.darTchau();

console.log(sansa);
sansa.apresentar();
ned.darTchau();

String.prototype.apagar = function() {
	return 'vazia';
}

console.log('oi'.apagar());