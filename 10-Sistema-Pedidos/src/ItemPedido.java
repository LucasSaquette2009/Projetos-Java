public class ItemPedido {

    private String nome;
    private Double preco;
    private Integer quantidade;

    public ItemPedido(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double subTotal() {
        return preco * quantidade;
    }

    public String toString() {
        return "- " + nome + ", R$ " + preco + ", Qtd: " + quantidade + ", Subtotal: R$ " + subTotal();

    }
}
