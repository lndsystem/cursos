function imprimirIdade(pessoa: {idade: number}){
    console.log(pessoa.idade);
    
}

interface Pessoa {
    idad: number;
    sexo?: string; // ? não obrigatório
}

function imprimirIdad(pessoa : Pessoa) {
    console.log(pessoa.idad);
    
}

let joaoMarcos = {nome: 'João Marcos', idade: 22};
imprimirIdade(joaoMarcos);


let joaoPedro = {nome: 'João Paulo', idad: 33};
imprimirIdad(joaoPedro);