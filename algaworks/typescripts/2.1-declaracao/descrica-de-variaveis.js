//var, let e const
//var
function iniciarTime(iniciaJogo) {
    var nome = 'Messi e amigos';
    if (iniciaJogo) {
        var cidade = 'em Uberlândia';
    }
    console.log(nome + " v\u00E3o jogar " + cidade);
}
iniciarTime(false);
//let - funciona no escopo
function iniciarTimeLet(iniciarJogo) {
    var nome = 'Messi e amigos';
    var cidade = 'em São Paulo';
    if (iniciarJogo) {
        cidade = ' em Uberlândia';
    }
    console.log(nome + " v\u00E3o jogar " + cidade);
}
iniciarTimeLet(true);
//const - contante
