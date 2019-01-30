// if (bool) { }
var x = 3;

if( x == 5){  //se
	console.log('Olá');
}


var teste = true;
if (teste) {
	console.log('Teste');
}



var y = 15;
var teste1 = y == 15;
if (teste1) {
	console.log('teste y');
}



var idade = 17;
var result;
if (idade >= 18){
	result='Maior';
}else{
	result='Menor';
}

console.log(result);


var o = 20;
var res;
switch(o) {
	case 18: 
		res = 'dezoito';
		break;
	case 19:
		res = 'dezenove';
		break;
	default:
		res = 'sei lá';
	
}
console.log(res);