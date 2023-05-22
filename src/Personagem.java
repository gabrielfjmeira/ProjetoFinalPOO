import java.util.ArrayList;

public abstract class Personagem {
    private int vida;

    private int mana;

    private int defesa;

    private int inteligencia;

    private int forca;

    private Arma arma;
    private Armadura armadura;

    public Personagem(int vida, int mana, int defesa, int inteligencia, int forca) {
        this.vida = vida;
        this.mana = mana;
        this.defesa = defesa;
        this.inteligencia = inteligencia;
        this.forca = forca;
    }

    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getForca() {
        return forca;
    }

    public Arma getArma() {
        return arma;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public abstract String falaPersonagem();
}
