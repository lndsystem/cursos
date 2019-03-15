var precos = ['10', '23', '19'];
var precosEmReais = precos.map(function (preco) {
    return 'R$ ' + preco + ',00';
});
var precosEmReaisArrow = precos.map(function (preco) {
    return 'R$ ' + preco + ',00';
});
var t1 = precos.map(function (preco) { return 'R$ ' + preco + ',00'; });
var t2 = precos.map(function (preco) { return "R$ " + preco + ",00"; });
var t3 = precos.filter(function (preco) { return preco > '20'; }).map(function (preco) { return "R$ " + preco + ",00"; });
console.log('tradicional');
console.log(precosEmReais);
console.log('arraw functions 1');
console.log(precosEmReaisArrow);
console.log('arraw functions 2');
console.log(t1);
console.log('arraw functions 3');
console.log(t2);
console.log('arraw functions 4');
console.log(t3);
