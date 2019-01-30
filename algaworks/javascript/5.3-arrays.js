var array = 'Ned Jon Robb Bran Rickon'.split(' ');
console.log(array);
console.log(array.toString());
console.log(array.join(' '));

//Adicionar no array
array.push('Sansa'); //fim
console.log(array);

array.unshift('Sansa'); //inicio
console.log(array);

//Remover
var elemento = array.pop(); //do fim
console.log(array);

var elemento = array.shift(); //do inicio
console.log(array);

//Manipular conteudo do array
array[1] = 'Jon Snow';
console.log(array);

var slice = array.slice(3);
console.log(slice);

var slice = array.slice(3,4);
console.log(slice);

//remover
array.splice(1,1);//posicao iniciar + qtde de posicoes
console.log(array);

array.splice(1,1, 'Arya', 'Sansa');//posicao iniciar + qtde de posicoes + add
console.log(array);

//juntando dois arrays
var array1 = ['Ola'];

var novoArray = array.concat(array1);
console.log(novoArray);

