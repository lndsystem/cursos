// par nome/valor
const saudacao = 'Opa'; // contexto léxico (local) 1

function exec() {
    const saudacao = 'Falaaa' // contexto léxico 2
    return saudacao;
}

//Objetos são grupos aninhados de pares nome/valor
//criando objeto literal

const cliente = {
    nome: 'Pedro',
    idade: 32,
    peso: 50,
    endereco: {
        logradouro: 'Rua Muito Legal',
        numero: 123
    }
}

console.log(saudacao);
console.log(exec());
console.log(cliente);
