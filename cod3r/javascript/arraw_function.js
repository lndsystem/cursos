//tradicional
let dobro = function (a) {
    return 2 * a;
}

//arraw function
dobro = (a) => {
    return 2 * a;
}

//arraw function (return implicito)
dobro = a => 2 * a;
console.log(dobro(Math.PI));

let ola = function() {
    return 'Ola'
}

ola = () => 'Ola'; //funcao sem parametro
ola = _ => 'Ola'; //possui um parametro
console.log(ola);

