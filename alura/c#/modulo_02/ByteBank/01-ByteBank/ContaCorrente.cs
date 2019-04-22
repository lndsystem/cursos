using System;
namespace ByteBank
{
    public class ContaCorrente
    {

        public string titular;
        public int agencia;
        public int numero;
        public double saldo;

        public ContaCorrente()
        {
        }

        public string Titular
        {
            get { return titular; }
            set { titular = value; }
        }

        public bool Sacar(double valor)
        {
            if (saldo < valor)
                return false;

            this.saldo -= valor;
            return true;
        }

        public String toString()
        {
            return string.Format("%s", titular);
        }
    }
}
