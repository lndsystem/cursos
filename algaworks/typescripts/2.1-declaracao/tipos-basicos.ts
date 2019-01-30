//boolean
let estaPago: boolean = true;

//number
let idade: number = 18;
let valor: number = 9.99;

//string
let empresa: string = 'AlgaWorks';

//template string
console.log(`Olá, meu nome ${empresa} e tenho ${idade} anos`);
let concatenacaoTradicional = 'Olá, meu nome ' + empresa + ' e tenho ' + idade + 'anos';

//array
let notas: number[] = [8, 19, 2];

//tuple
let alunos: [string, number, string] = ['João', 10 , 'Matemática'];
console.log(alunos[0]);

//Enum
enum  Cor{Verde, Amarelo, Azul, Branco};
let corFunco: Cor = Cor.Amarelo;

//Any (qualquer coisa)
let algumValor: any = 4;
algumValor = 'Agora é uma string';
algumValor = true;
//Biblioteca de terceiros....
//Migração de JavaScript para TypeScript...
//Outro exemplo: Array com varios tipos de dados

//void (usado em retorno do métddo)
function alerta(): void {
    //...alert('Operacao nao permitida');
}

//null e undefined
let u: undefined = undefined;
let n: null = null;
//null e undefined são subtipos dos outros tipos


empresa = undefined;
empresa = null;

