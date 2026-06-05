package Sistema.application;

import Sistema.entities.contas.Login;

import java.util.Scanner;

import Sistema.entities.enums.Pagamento;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("E-mail: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        Login login = new Login(email, senha);
        login.setEmail(email);
        login.setSenha(senha);
        login.loginConta();
        System.out.println();
        login.cardapio();
        System.out.println();
        System.out.println("Qual prato deseja escolher? ");
        String pratoEscolha = sc.nextLine();
        Login escolha = new Login(pratoEscolha);
        escolha.setPratoEscolha(pratoEscolha);
        escolha.pedidoCalculo();
        System.out.println();
        escolha.cardapioEscolha(sc);
        login.pagamentos();
        String pagamento = sc.nextLine();
        login.pagamentoDefinicao(pagamento);
        login.recibo();


    }
}
