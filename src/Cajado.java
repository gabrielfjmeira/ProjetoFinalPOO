public class Cajado extends Arma{
    private String descricao;
    private int bonus;
    public Cajado(String nome, int preco,int bonus,String descricao) {
        super(nome, preco);
        this.bonus=bonus;
        this.descricao=descricao;

    }

    @Override
    public void bonusAdd() {
        //Set no atributo ou Set no ataque
    }

    @Override
    public void descricaoTela() {
        System.out.println();
    }
}
