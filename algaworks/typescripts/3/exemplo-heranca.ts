class Funcionario {
    nome: string;
    salario: number;

    constructor(nome: string, salario: number){
        this.nome = nome;
        this.salario = salario;
    }

    pagarImpostos(taxa: number= 7.5) {
        console.log(`Pagando ${this.salario * taxa / 100} de imposto`);
    }
}

class Secretario extends Funcionario {

}

class Executivo extends Funcionario {
    pagarImpostos(taxa: number = 27.5){
        console.log('Executivo paga mais');
        super.pagarImpostos(taxa);
    }
}

let sarah = new Secretario('Sarah', 2000);
sarah.pagarImpostos();

let jorge = new Executivo('Jorge', 30000);
jorge.pagarImpostos();

let leandro = new Executivo('Leandro', 30000);
leandro.pagarImpostos(10);