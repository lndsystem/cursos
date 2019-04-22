using System;
using static System.Console;

namespace CalculaPoupanca
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            WriteLine("Hello World!");

            double valorInvestido = 1000.0;

            int mes1 = 1;

            while(mes1++ <= 12)
            {
                valorInvestido += valorInvestido * 0.0036;
                WriteLine("Após " + mes1 + " mês, você terá R$ " + valorInvestido);

            }


            double fator = 1.0036;
            double valorInvestimento = 1000;
            for (int ano = 1; ano <=5; ano++)
            {
                for (int mes = 1; mes <=12; mes++)
                {
                    valorInvestimento = valorInvestimento * fator;
                    WriteLine("Rendimento do rendimento em " + ano + "/" + mes + ": " + valorInvestimento);
                }
                fator += 0.0010;
            }

            ReadLine();
        }
    }
}
