package Sistema.application;

import Sistema.entities.JDBC.ClassConnection;
import Sistema.entities.contas.Cardapio;
import Sistema.entities.contas.Login;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Sistema.entities.enums.Pagamento;

public class Program {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conexao = ClassConnection.getConnection();
        Statement stmt = conexao.createStatement();
        try {
            System.out.print("E-mail: ");
            String email = sc.nextLine();

            System.out.print("Senha: ");
            String senha = sc.nextLine();

            String contas = "Insert Into login (email,senhas) values('"+email+"','"+senha+"')";
            stmt.execute(contas);

            Login login = new Login(email, senha);

            login.setEmail(email);

            login.setSenha(senha);

            login.loginConta();

            System.out.println();
            login.cardapio();

            System.out.println();

            System.out.println("Qual prato deseja escolher? ");
            String pratoEscolha = sc.nextLine();

            String pratos = "Insert into pratos (pratos_escolhidos) value('"+pratoEscolha+"')";
            stmt.execute(pratos);

            stmt.execute(pratos);

            Login escolha = new Login(pratoEscolha);

            escolha.setPratoEscolha(pratoEscolha);
            escolha.pedidoCalculo();

            System.out.println();
            escolha.cardapioEscolha(sc);
            login.pagamentos();

            String pagamento = sc.nextLine();

            String pagamento_escolhido = "Insert ignore into pagamentos (pagamentosFeitos) value('"+pagamento+"')";
            stmt.execute(pagamento_escolhido);

            login.pagamentoDefinicao(pagamento);
            login.recibo();

            sc.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
