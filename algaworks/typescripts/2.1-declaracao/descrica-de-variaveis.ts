//var, let e const

//var
function iniciarTime(iniciaJogo: boolean) {
    var nome = 'Messi e amigos';
    if(iniciaJogo) {
        var cidade = 'em Uberlândia';
    }

    console.log(`${nome} vão jogar ${cidade}`);
}

iniciarTime(false);

//let - funciona no escopo
function iniciarTimeLet(iniciarJogo: boolean) {
    const nome: string = 'Messi e amigos';
    let cidade: string = 'em São Paulo';

    if(iniciarJogo){
        cidade = ' em Uberlândia';
    }

    console.log(`${nome} vão jogar ${cidade}`);
}

iniciarTimeLet(true);

//const - contante