public class Heroi extends Personagem{
    private String nome;
    private String classe;
    private int ouro;
    private int qtdPocao;

    public Heroi(String nome,String classe){
        super(0, 0,0);
        if(nome.length()==0){
            throw new RuntimeException("Personagem precisa de Nome!");
        }
        else if(nome.length()>=0 && classe.equals("Selecione uma opção")){
            throw new RuntimeException("Personagem precisa de uma Classe!");
        }

        this.nome = nome;
        this.classe = classe;
        this.qtdPocao=1;


        if (classe.equals("Guerreiro")) {
            super.setVida(60);
            super.setAtaque(10);
            super.setDefesa(10);
            this.ouro = 20;
        } else if (classe.equals("Arqueiro")) {
            super.setVida(50);
            super.setAtaque(15);
            super.setDefesa(8);
            this.ouro = 20;
        } else if (classe.equals("Mago")) {
            super.setVida(45);
            super.setAtaque(35);
            super.setDefesa(6);
            this.ouro = 20;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getQtdPocao() {
        return qtdPocao;
    }

    public void setQtdPocao(int qtdPocao) {
        this.qtdPocao = qtdPocao;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public int getOuro() {
        return ouro;
    }
    @Override
    public String falaPersonagem(){
        if(classe.equals("Guerreiro")){
            return "Pelos poderes de Grayscou";
        }
        if(classe.equals("Mago")){
            return "Pelos ensinamentos de Merlin";
        }
        if(classe.equals("Arqueiro")){
            return "Das sombras, so a morte o espera";
        }
        return "";
    }

    public String getClasse() {
        return classe;
    }

    @Override
    public String atacar(Personagem personagem) {
        int dadoHeroi = rd.nextInt(20) + 1;
        int defesaInimigo = personagem.getDefesa();
        if (dadoHeroi > defesaInimigo) {
            personagem.setVida(personagem.getVida() - this.getAtaque());
            return this.getNome() + " atacou o inimigo, causando " + this.getAtaque() + " de dano";
        } else {
            return this.getNome() + " errou o ataque!";
        }
    }
}
