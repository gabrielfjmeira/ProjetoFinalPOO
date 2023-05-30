import java.util.Random;

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

//    implementacao do metodo de recompensa do boss
    public int recompensaBoss(){
        Random valor = new Random();
        int recompensa = valor.nextInt(120)+70;
        return recompensa;
    }
}
