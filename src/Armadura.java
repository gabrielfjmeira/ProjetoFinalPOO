public class Armadura extends Equipamento{
    private String descricao;
    private int bonus;
    public Armadura(String nome, int preco,int bonus,String descricao) {
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
