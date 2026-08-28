import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Digite a data do pedido (DD/MM/YYYY): ");
        String data = sc.next();
        System.out.print("Digite o status do pedido (AGUARDANDO_PAGAMENTO, PROCESSANDO, ENVIADO): ");
        String status = sc.next();
        StatusPedido statusPedido = StatusPedido.valueOf(status);
        Pedido pedido = new Pedido(data, statusPedido);

        System.out.print("Quantos itens tem o pedido? ");
        int n = sc.nextInt();

        for (int f = 1; f < n+1; f++) {
            sc.nextLine();
            System.out.println("-- Dados do " + n + " Item --");
            System.out.print("Nome do produto: ");
            String nome = sc.nextLine();
            System.out.print("Preço do produto: ");
            double preco = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();
            pedido.adicionarItem(new ItemPedido(nome, preco, quantidade));
        }

        System.out.println("RESUMO DO PEDIDO:");
        System.out.println(pedido.toString());




        sc.close();
    }
}
