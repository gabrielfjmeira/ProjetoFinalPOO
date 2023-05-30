import java.util.ArrayList;

public abstract class Personagem {
//    Criacao dos atributos da classe
    private int vida;
    private int mana;
    private int defesa;
    private int inteligencia;
    private int forca;
    private int agilidade;
//    private Arma arma;
    private Armadura armadura;

//    criacao do construtor
    public Personagem(int vida, int mana, int defesa, int inteligencia, int forca, int agilidade) {
        this.vida = vida;
        this.mana = mana;
        this.defesa = defesa;
        this.inteligencia = inteligencia;
        this.forca = forca;
        this.agilidade = agilidade;
    }

//    Implementacao dos metodos get
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

    public int getAgilidade() {
        return agilidade;
    }

    //    public Arma getArma() {
//        return arma;
//    }
    public Armadura getArmadura() {
        return armadura;
    }

//    Implementacao dos metodos set
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }
    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

//    cricao do metodo abstrato(sem implementacao)
    public abstract String falaPersonagem();

//    criando a funcao de hit ou miss
    protected boolean hitMiss(Dado dado, Armadura armadura) {
        int valorDado = dado.lancarDado();
        int defesa = getDefesa() + armadura.bonusAdd();
        if (valorDado >= defesa) {
            return true;
        } else {
            return false;
        }
    }

//    criacao da funcao de ataque do personagem
    public abstract void atacar(Arma arma, Dado dado, Armadura armadura);

    }



