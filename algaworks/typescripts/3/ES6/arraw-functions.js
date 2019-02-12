var precos = ['10', '23', '19'];
var precosEmReais = precos.map(function (preco) {
    return 'R$ ' + preco + ',00';
});
var precosEmReaisArrow = precos.map(function (preco) {
    return 'R$ ' + preco + ',00';
});
console.log(precosEmReais);
console.log(precosEmReaisArrow);
