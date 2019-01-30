// String nome; --> java
// nome: String --> TypeScript
function dizerOla(nome) {
    console.log('Olá ' + nome);
    console.log("Ol\u00E1 " + nome); //interpolarização
}
dizerOla('AlgaWorks');
