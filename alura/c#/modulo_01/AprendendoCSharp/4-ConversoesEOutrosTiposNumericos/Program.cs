using System;
using static System.Console;

namespace ConversoesEOutrosTiposNumericos
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            WriteLine("Hello World!");

            double salario = 1200.50;
            int salarioEmInteiro = (int) salario;



            WriteLine("Salario original: " + salario);
            WriteLine("Salario in cast: " + salarioEmInteiro);


            ReadLine();
        }
    }
}
