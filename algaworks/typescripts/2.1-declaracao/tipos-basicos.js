//boolean
var estaPago = true;
//number
var idade = 18;
var valor = 9.99;
//string
var empresa = 'AlgaWorks';
//template string
console.log("Ol\u00E1, meu nome " + empresa + " e tenho " + idade + " anos");
var concatenacaoTradicional = 'Olá, meu nome ' + empresa + ' e tenho ' + idade + 'anos';
//array
var notas = [8, 19, 2];
//tuple
var alunos = ['João', 10, 'Matemática'];
console.log(alunos[0]);
//Enum
var Cor;
(function (Cor) {
    Cor[Cor["Verde"] = 0] = "Verde";
    Cor[Cor["Amarelo"] = 1] = "Amarelo";
    Cor[Cor["Azul"] = 2] = "Azul";
    Cor[Cor["Branco"] = 3] = "Branco";
})(Cor || (Cor = {}));
;
var corFunco = Cor.Amarelo;
//Any (qualquer coisa)
var algumValor = 4;
algumValor = 'Agora é uma string';
algumValor = true;
//Biblioteca de terceiros....
//Migração de JavaScript para TypeScript...
//Outro exemplo: Array com varios tipos de dados
//void (usado em retorno do métddo)
function alerta() {
    //...alert('Operacao nao permitida');
}
//null e undefined
var u = undefined;
var n = null;
//null e undefined são subtipos dos outros tipos
empresa = undefined;
empresa = null;
