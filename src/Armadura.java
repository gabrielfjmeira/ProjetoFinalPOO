public abstract class Armadura {
    private String nome;
    private int preco;

    public Armadura(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
    }
    public abstract int bonusAdd();
    public abstract void descricaoTela();

}
