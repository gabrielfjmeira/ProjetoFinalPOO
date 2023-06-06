public class Heroi extends Personagem {
//    Criando os atributos da classe
    private String nome;
    private String tipo;
    private int ouro;

//    Criando construtor da classe
    public Heroi(String nome, String tipo) {
//      chamando construtor da classe pai com valores zerados
        super(0, 0, 0, 0, 0, 0);

        this.nome = nome;
        this.tipo = tipo;
//      seta os atributos da classe pai com novos valores baseado no tipo de heroi
        if (tipo.equals("Guerreiro")) {
            super.setVida(60);
            super.setMana(10);
            super.setDefesa(10);
            super.setInteligencia(4);
            super.setForca(11);
            super.setAgilidade(5);
            this.ouro = 20;
        } else if (tipo.equals("Arqueiro")) {
            super.setVida(50);
            super.setMana(15);
            super.setDefesa(8);
            super.setInteligencia(6);
            super.setForca(7);
            super.setAgilidade(12);
            this.ouro = 20;
        } else if (tipo.equals("Mago")) {
            super.setVida(45);
            super.setMana(35);
            super.setDefesa(6);
            super.setInteligencia(13);
            super.setForca(4);
            super.setAgilidade(8);
            this.ouro = 20;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    //    implementacao do metodo abstrato da classe pai
    @Override
    public String falaPersonagem(){
        return "Pelos Poderes de Graiscou";
    }

    @Override
    //    implementando a funcao de atacar
    public void atacar(Arma arma, Dado dado, Armadura armadura) {
        boolean verificarAcerto = hitMiss(dado, armadura);
        int danoCausado;
        String classe = getTipo();
        if (verificarAcerto){
            if (classe.equals("Guerreiro")) {
                danoCausado = getForca() + arma.bonusAdd();
            } else if (classe.equals("Mago")) {
                danoCausado = getInteligencia() + arma.bonusAdd();
            } else {
                danoCausado = getAgilidade() + arma.bonusAdd();
            }
        } else {
            danoCausado = 0;
        }
    }
}
