package contabancaria;

import Programa.Conta;
import Programa.Pessoa;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;

public class ContaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();

    }

    public static void operacoes() {

        int operacao
                = Integer.parseInt(JOptionPane.showInputDialog(" ------- Selecione uma Operação -----"
                        + "|         \n Opcao 1 - Criar Conta "
                        + "|         \n Opcao 2 - Depositar   "
                        + "|         \n Opcao 3 - Sacar       "
                        + "|         \n Opcao 4 - Transferir  "
                        + "|         \n Opcao 5 - Listar      "
                        + "|         \n Opcao 6 - Sair        "));

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Obrigado, volte Sempre!");

                System.exit(0);

            default:
                JOptionPane.showMessageDialog(null, "Opção Invalida!");
                operacoes();
                break;

        }

    }

    public static void criarConta() {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
        pessoa.setCpf(JOptionPane.showInputDialog("Cpf : "));
        pessoa.setEmail(JOptionPane.showInputDialog("Email : "));

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        JOptionPane.showMessageDialog(null, "Conta criada com Sucesso!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta);
                {
                    conta = c;
                }
            }
        }
        return conta;

    }

    public static void depositar() {

        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog(" Numero da Conta :"));

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual Valor deseja depositar? ");
            Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar :"));
            conta.depositar(valorDeposito);
            JOptionPane.showMessageDialog(null, "Valor Depositado com Sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "Conta nao encontrada!! ");

        }
        operacoes();
    }

    public static void sacar() {
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog(" Numero da Conta para Saque:"));
        System.out.println("Numero da conta : ");
        

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
          Double valorSaque =
                  Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar? "));
            conta.sacar(valorSaque);

        } else {
            JOptionPane.showMessageDialog(null, "Conta nao encontrada!! ");

        }
        operacoes();
    }

    public static void transferir() {
       int numeroContaRemetente =
               Integer.parseInt(JOptionPane.showInputDialog("Numero da conta do Remetente : "));

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            int numeroContaDestinatario =
               Integer.parseInt(JOptionPane.showInputDialog("Numero da conta do Destinatario : "));
            

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                Double valor =
               Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia : "));
               

                contaRemetente.transferir(contaDestinatario, valor);
            } else {
                JOptionPane.showMessageDialog(null, " A conta para deposito nao foi encontrada");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Conta para transferencia nao encontrada");

        }

        operacoes();

    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                JOptionPane.showMessageDialog(null, conta);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não ha contas cadastradas");

        }
        operacoes();
    }

}
