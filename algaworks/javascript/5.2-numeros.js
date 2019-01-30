var x = 34; //inteiro
var y = 34.0; //ponto flutuante
var t = 456e5; //exponencial 45600000
var z = 123e-6; //0.000123 (123*10^-6)

//Javascript tem a capacidade de até 15 digitos inteiro
//decimal 16 digitos, aredonda para cima
console.log(999999999999999);
console.log(9999999999999999);
console.log(0.9999999999999999);
console.log(0.99999999999999999);

//gravar em hexa decimal
var a = 0xfff;
console.log(a);

//gravar octal - não funciona em todos javascript
var b = 07777; //iniciar com 0 
console.log(b);

console.log(b.toString(16)); //informar a base para imprimir bit/ocat/hexa

console.log(t);
console.log(t.toExponential()); //exibir em expressao

console.log(z.toFixed(2));

var gasolina = 3.357;
console.log(gasolina);
console.log(gasolina.toFixed(2));
console.log(gasolina.toPrecision(2));