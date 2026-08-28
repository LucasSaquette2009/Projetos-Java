import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Pedido {

    private String data;
    private StatusPedido status;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(String data, StatusPedido status) {
        this.data = data;
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double total() {
        double sum = 0;

        for (ItemPedido c : itens) {
            sum += c.subTotal();
        }

        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: " + data
                + " \nStatus: " + status
                + "\n\nItens:\n");

        for (ItemPedido c: itens) {
            sb.append(c).append("\n");
        }

        sb.append("Total do Pedido: R$ " + total());

        return sb.toString();
    }
}
