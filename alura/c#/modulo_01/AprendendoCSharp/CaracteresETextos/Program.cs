using System;
using static System.Console;

namespace CaracteresETextos
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            WriteLine("Hello World!");


            char primeiraLetra = 'a';
            WriteLine(primeiraLetra);

            primeiraLetra = (char) 65;
            WriteLine(primeiraLetra);


            primeiraLetra = (char) (primeiraLetra+1);
            WriteLine(primeiraLetra);


            


            ReadLine();
        }
    }
}
