public abstract class Personagem {
    private int vida;

    private int mana;

    private int defesa;

    private int inteligencia;

    private int forca;
    private Equipamento equipamento;

    public Personagem(int vida, int mana, int defesa, int inteligencia, int forca) {
        this.vida = vida;
        this.mana = mana;
        this.defesa = defesa;
        this.inteligencia = inteligencia;
        this.forca = forca;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public abstract String falaPersonagem();
}
