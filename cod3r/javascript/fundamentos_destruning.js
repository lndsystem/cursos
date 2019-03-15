//desestruturar

// novo recursodo ES2015
const pessoa = {
    nome: 'Ana',
    idade: 5,
    endereco: {
        logradouro: 'Rua ABC',
        numero: 10000
    }
}
console.log(pessoa);
//const xpto <-- identificador
//const { }desestururar
const { nome, idade } = pessoa
console.log(nome, idade);


const { sobrenome, bemHumorada = true} = pessoa;
console.log(sobrenome, bemHumorada);

const { endereco: { logradouro, numero, cep}} = pessoa;
console.log(logradouro, numero, cep);