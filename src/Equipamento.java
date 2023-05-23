public abstract class Equipamento {
    private String nome;
    private int preco;


    public Equipamento(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public abstract void bonusAdd();
    public abstract void descricaoTela();


}
