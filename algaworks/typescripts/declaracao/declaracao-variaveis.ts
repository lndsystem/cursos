function iniciarTime(iniciarJogoEmUrbelandia:boolean){
    const nome: string = 'Messi e amigos';
    let cidade: string = 'em São Paulo';
    if(iniciarJogoEmUrbelandia){
        cidade = 'em Uberlandia';
    }

    console.log(`${nome} vão jogar ${cidade}`)
}

iniciarTime(true);