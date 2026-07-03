package Sistema.entities.contas;


import Sistema.entities.enums.Pagamento;

import java.util.Random;

import java.util.Scanner;

public class Login {
    private Random rnd = new Random();
    private String email;
    private String senha;
    private String[] emails = {"abobrinha@gmail.com", "betinhogames@gmail.com"};
    private String[] senhas = {"Hd87555", "bubu"};
    private Cardapio cardapio;
    private String pratoEscolha;
    private String pratoEscolha2;
    private int totalPedido = 0;
    private Pagamento[] pagamentos = Pagamento.values();

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.cardapio = new Cardapio();
    }

    public Login(String pratoEscolha) {
        this.pratoEscolha = pratoEscolha;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha.trim();
    }

    public void setPratoEscolha(String pratoEscolha) {
        this.pratoEscolha = pratoEscolha.toLowerCase();
    }

    public String getPratoEscolha() {
        return pratoEscolha;
    }

    public String getPratoEscolha2() {
        return pratoEscolha2;
    }

    public void setPratoEscolha2(String pratoEscolha2) {
        this.pratoEscolha2 = pratoEscolha2;
    }

    public int getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(int totalPedido) {
        this.totalPedido = totalPedido;
    }


    public void loginConta() {
        boolean correto = false;

        for (int i = 0; i < emails.length; i++) {
            if (getEmail().equals(emails[i]) && getSenha().equals(senhas[i])) {
                correto = true;
                break;
            }
        }

        if (correto) {
            System.out.println("Bem vindo!");
        } else {
            System.out.println("Usuário ou senha inválidos");
            System.exit(0);
        }

    }

    public void cardapio() {
        for (String dishes : cardapio.getOpcoes()) {
            if (!dishes.isEmpty()) {
                System.out.println(cardapio);
                break;
            }
        }

    }

    public void pedidoCalculo() {
        if (pratoEscolha.equals("porcao de camarao")) {
            setTotalPedido(totalPedido = 30);
        } else if (pratoEscolha.equals("lasanha")) {
            setTotalPedido(totalPedido = 25);
        } else if (pratoEscolha.equals("almondega")) {
            setTotalPedido(totalPedido = 15);
        }
    }

    //Dar seguimento na seleção e calculo total do pedido
    public void cardapioEscolha(Scanner sc) {
        do {
            System.out.println("O que mais? ");
            pratoEscolha2 = sc.nextLine();
            switch (pratoEscolha2) {
                case "porcao de camarao" -> setTotalPedido(totalPedido += 30);
                case "lasanha" -> setTotalPedido(totalPedido += 25);
                case "almondega" -> setTotalPedido(totalPedido += 15);
            }
            System.out.println("Deseja pedir mais alguma coisa? ");
            pratoEscolha2 = sc.nextLine();
        } while (pratoEscolha2.equalsIgnoreCase("sim"));
        System.out.println("Total do pedido: " + getTotalPedido());
        if (getTotalPedido() < 50) {
            System.out.println("Total com frete: " + (totalPedido += 8));
            System.out.println();
        }
    }

    public void pagamentos() {
        System.out.println("Escolha sua forma de pagamento: ");
        for (Pagamento pagamentoOpcoes : pagamentos) {
            System.out.println(pagamentoOpcoes);
        }
    }

    public void pagamentoDefinicao(String pagamento) {
        if (pagamento.equalsIgnoreCase("pix") || pagamento.equalsIgnoreCase("cartao") || pagamento.equalsIgnoreCase("dinheiro")) {
            System.out.println("Pagamento Aprovado");
        } else {
            System.out.println("Pagamento não autorizado");
        }
    }

    public void recibo() {
        for (int i = 0; i >= 0; ) {
            System.out.println("Pedido: " + rnd.nextInt());
            break;
        }
        System.out.println("Pedido realizado com sucesso");
    }

}




