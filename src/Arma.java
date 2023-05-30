public abstract class Arma {
    private String nome;
    private int preco;

    public Arma(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
    }
    public abstract int bonusAdd();
    public abstract void descricaoTela();
}
