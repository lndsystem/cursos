// String nome; --> java
// nome: String --> TypeScript
function dizerOla(nome: string) {
    console.log('Olá ' + nome);
    console.log(`Olá ${nome}`); //interpolarização
}

dizerOla('AlgaWorks');