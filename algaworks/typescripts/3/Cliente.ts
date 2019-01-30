class Cliente {

    nome: string;
    idade: number;

    constructor(nome: string, idade: number) {
        this.nome = nome;
        this.idade = idade;
    }
}

let joao: Cliente = new Cliente('João', 25);