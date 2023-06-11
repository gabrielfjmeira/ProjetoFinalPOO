import java.util.Random;

public class Heroi extends Personagem {
    private String nome;
    private String classe;
    private int ouro;
    private int qtdPocao;
    private Arma arma;
    Random rd =new Random();
    public Heroi(String nome,String classe) {
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
        this.arma=new Arma("Mão",0);
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

    public Heroi(String nome, String classe, String ouro, String vida,String qtdPocao,Arma arma) {
        super(0, 0, 0);
        int intOuro = Integer.parseInt(ouro);
        int intVida = Integer.parseInt(vida);
        int intPocao = Integer.parseInt(qtdPocao);
        this.nome = nome;
        this.classe = classe;
        this.qtdPocao = intPocao;
        this.ouro = intOuro;
        this.arma = arma;
        if (classe.equals("Guerreiro")) {
            super.setVida(intVida);
            super.setAtaque(10);
            super.setDefesa(10);
        } else if (classe.equals("Arqueiro")) {
            super.setVida(intVida);
            super.setAtaque(15);
            super.setDefesa(8);
        } else if (classe.equals("Mago")) {
            super.setVida(intVida);
            super.setAtaque(35);
            super.setDefesa(6);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public int getOuro() {
        return ouro;
    }

    public int getQtdPocao() {
        return qtdPocao;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void setQtdPocao(int qtdPocao) {
        this.qtdPocao = qtdPocao;
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


    @Override
    public String atacar(Personagem personagem){
        int dadoHeroi = rd.nextInt(20) + 1;
        int defesaInimigo = personagem.getDefesa();
        if (dadoHeroi > defesaInimigo) {
            personagem.setVida(personagem.getVida() - this.getAtaque() - arma.getDano());
            return  this.getNome()+ " atacou o inimigo usando "+ arma.getNome()+ (this.getAtaque()+arma.getDano()) + "de dano!";

        } else {
            return this.getNome() + " errou o ataque!";
        }
    }
}
