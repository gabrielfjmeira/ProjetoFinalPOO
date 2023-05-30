import java.util.Random;

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

    @Override
    //    implementando a funcao de atacar
    public void atacar(Arma arma, Dado dado, Armadura armadura) {
        boolean verificarAcerto = hitMiss(dado, armadura);
        int danoCausado;
        if (verificarAcerto){
            danoCausado = getForca();
        } else {
            danoCausado = 0;
        }
    }

//    implementacao do metodo de recompensa do inimigo
    public int recompensaInimigo(){
        Random valor = new Random();
        int recompensa = valor.nextInt(25)+10;
        return recompensa;
    }

    public String getRaca() {
        return raca;
    }
}
