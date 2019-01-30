function dizerOi(nome) {
	console.log('Oi, ' + nome);
	console.log(this); // objeto global
}

//1 - chama contexto global
dizerOi('1 - Arya');

//2 - define o contexto global
dizerOi.call({}, '2 - Arya');

//3 - define o contexto global + passa um array
dizerOi.apply({}, ['3 - Arya']);
