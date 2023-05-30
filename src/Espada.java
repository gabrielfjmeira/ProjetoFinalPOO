public class Espada extends Arma {
    private String descricao;
    private int bonus;
    public Espada(String nome, int preco,int bonus,String descricao) {
        super(nome, preco);
        this.bonus=bonus;
        this.descricao=descricao;

    }

    @Override
    public int bonusAdd() {
        //Set no atributo ou Set no ataque
        return bonus;
    }

    @Override
    public void descricaoTela() {
        System.out.println();
    }
}
