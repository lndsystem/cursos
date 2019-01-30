//declarando objeto
var name = {}; //vazio

var obj = {
	nome: 'Joh', 
	sobreNome: 'Snow', 
	idade: 16,
	apresentar: function(){
		console.log('Olá, eu sou ' + this.nome + ' ' + this.sobreNome + '.');
	},
	apresentar2: apresentacao
};

function apresentacao() {
	console.log('Olá, eu sou ' + this.nome + ' ' + this.sobreNome + '.');
}

console.log(obj);

//acessar valores das propriedades

console.log(obj.nome);
console.log(obj.sobreNome);

//chamando uma funcão anonima
obj.apresentar();

obj.apresentar2();