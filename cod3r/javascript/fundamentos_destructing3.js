function rand({min = 0, max = 1000}) {
    const valor = Math.random() * (max-min)+min;
    return Math.floor(valor);
}

const obj = {max:50,min:40}
console.log(rand(obj));
console.log(rand({min:955}));
console.log(rand({}));
//console.log(rand());

console.log('================')
function randArray([minArray = 0, maxArray = 1000]){
    if(minArray > maxArray) [minArray, maxArray] = [maxArray, minArray]
    const valorArray = Math.random() * (maxArray-minArray)+minArray;
    return Math.floor(valorArray);
}

console.log(randArray([50,40]))

