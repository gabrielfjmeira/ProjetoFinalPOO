public class Inimigo extends Personagem{
    //Atributo raça
    private String raca;

    //Atributo recompensa do inimigo
    private int recompensa;

    //Método construtor
    public Inimigo(int vida, int mana, int defesa, int inteligencia, int forca, int agilidade, String raca, int recompensa) {
        super(vida, mana, defesa, inteligencia, forca, agilidade);
        this.raca = raca;
        this.recompensa = recompensa;
    }

    //Fala do inimigo
    @Override
    public String falaPersonagem(){
        return "Arrrrr você não vai escapar! MUAHAHAHA";
    }
}
