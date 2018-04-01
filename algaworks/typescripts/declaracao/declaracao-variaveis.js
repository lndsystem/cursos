function iniciarTime(iniciarJogoEmUrbelandia) {
    var nome = 'Messi e amigos';
    var cidade = 'em São Paulo';
    if (iniciarJogoEmUrbelandia) {
        cidade = 'em Uberlandia';
    }
    console.log(nome + " v\u00E3o jogar " + cidade);
}
iniciarTime(true);
