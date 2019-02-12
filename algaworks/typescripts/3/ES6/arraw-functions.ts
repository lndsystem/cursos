const precos = ['10', '23', '19'];
const precosEmReais = precos.map(function(preco) {
    return 'R$ ' + preco + ',00';
});

const precosEmReaisArrow = precos.map((preco) => {
    return 'R$ ' + preco + ',00';
});

console.log(precosEmReais);
console.log(precosEmReaisArrow);