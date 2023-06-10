import java.util.Random;

public class Inimigo extends Personagem{
    private int recompensa;
    private String raca;
    Random rd = new Random();
    public Inimigo(String raca) {
        super(0, 0, 0);
        this.raca=raca;
        if (raca.equals("Goblins")){
            super.setVida(20);
            super.setAtaque(10);
            super.setDefesa(10);
            this.recompensa = rd.nextInt(25)+10;
        }
    }

    public String getRaca() {
        return raca;
    }

    public int getRecompensa() {
        return recompensa;
    }

    @Override
    public String falaPersonagem(){
        if(raca.equals("Goblins")){
            return "Arrrrr você não vai escapar! MUAHAHAHA";
        }
        return "";
    }
    @Override
    public String atacar(Personagem personagem){
        int dadoInimigo = rd.nextInt(20)+1;
        int defesaHeroi=personagem.getDefesa();
        if(dadoInimigo>defesaHeroi){
            personagem.setVida(personagem.getVida()-this.getAtaque());
            return "O " + this.getRaca() + " atacou o herói, causando " + this.getAtaque() + " de dano";
        }else{
            return "O " + this.getRaca() + " errou o ataque";
        }
    }
}
