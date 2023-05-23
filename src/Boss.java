public class Boss extends Personagem{

    //Atributo nome
    private String nome;

    //Atributo raça
    private String raca;

    //Atributo recompensa do inimigo
    private int recompensa;

    //Método construtor
    public Boss(int vida, int mana, int defesa, int inteligencia, int forca, int agilidade, String nome, String raca, int recompensa){
        super(vida, mana, defesa, inteligencia, forca, agilidade);
        this.nome = nome;
        this.raca = raca;
        this.recompensa = recompensa;
    }

    //Fala do boss
    @Override
    public String falaPersonagem(){
        return "Eu sou o poderoso " + nome + " líder da raça " + raca + " você não pode contra mim!";
    }
}
