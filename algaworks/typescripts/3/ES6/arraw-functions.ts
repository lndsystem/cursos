const precos = ['10', '23', '19'];
const precosEmReais = precos.map(function(preco) {
    return 'R$ ' + preco + ',00';
});

const precosEmReaisArrow = precos.map((preco) => {
    return 'R$ ' + preco + ',00';
});

const t1 = precos.map((preco) =>  'R$ ' + preco + ',00' );
const t2 = precos.map((preco) =>  `R$ ${preco},00` );
const t3 = precos.filter(preco => preco > '20').map(preco => `R$ ${preco},00`);

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