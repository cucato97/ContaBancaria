
package Programa;

import javax.swing.JOptionPane;
import utilitarios.Utils;


public class Conta {
    
    public static int contadorDeContas = 1;
    
   private int numeroConta;
   private Pessoa pessoa;
   private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas +=1;
    }

    public Conta() {
    }

    public static int getContadorDeContas() {
        return contadorDeContas;
    }

    public static void setContadorDeContas(int contadorDeContas) {
        Conta.contadorDeContas = contadorDeContas;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    public String toString () {
    return "\nNumero da conta : " + this.getNumeroConta() +
           "\nNome : " + this.pessoa.getNome() +
           "\nCPF: " + this.pessoa.getCpf()+
           "\nEmail: " + this.pessoa.getEmail() +
           "\nSaldo : " + Utils.doubleToString(this.getSaldo()) +
           "\n";
}
    
    public void depositar (Double valor) {
        if(valor >0) {
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null,"Seu deposito foi realizado com Sucesso!");
            } else {
            JOptionPane.showMessageDialog(null,"Erro ao depositar!");
        }
    }
    
    public void sacar (Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
           setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null,"Saque Realizado!!");
            } else {
           JOptionPane.showMessageDialog(null,"Saldo Insuficiente!!");
        }
    }
    
    public void transferir (Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null,"Transferencia realizada com Sucesso!!");
            } else {
            JOptionPane.showMessageDialog(null,"Erro ao transferir, tente novamente!!");
        }
        
    }
    
}
