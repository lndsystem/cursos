using System;

namespace ByteBank
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");

            ContaCorrente c = new ContaCorrente();
            c.titular = "Leandro";
            c.agencia = 123;
            c.numero = 123456;
            c.saldo = 1000.0;
            
        }
    }
}
