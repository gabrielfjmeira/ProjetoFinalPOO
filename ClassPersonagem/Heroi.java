public class Heroi extends Personagem {
    private String nome;

    private String tipo;

    private int ouro;

    public Heroi(int vida, int mana, int defesa, int inteligencia, int forca, String nome, String tipo, int ouro) {
        super(vida, mana, defesa, inteligencia, forca);
        this.nome = nome;
        this.tipo = tipo;
        this.ouro = ouro;
    }

    @Override
    public String falaPersonagem(){
        return "......";
    }
}
