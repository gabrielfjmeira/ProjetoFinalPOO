public class Heroi extends Personagem{
    private String nome;
    private String classe;
    private int ouro;

    public Heroi(String nome,String classe) {
        super(0, 0,0);
        this.nome = nome;
        this.classe = classe;
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

    public Heroi(String nome, String classe, String ouro, String vida) {
        super(0, 0, 0);
        int intOuro = Integer.parseInt(ouro);
        int intVida = Integer.parseInt(vida);
        this.nome = nome;
        this.classe = classe;
        if (classe.equals("Guerreiro")) {
            super.setVida(intVida);
            super.setAtaque(10);
            super.setDefesa(10);
            this.ouro = intOuro;
        } else if (classe.equals("Arqueiro")) {
            super.setVida(intVida);
            super.setAtaque(15);
            super.setDefesa(8);
            this.ouro = intOuro;
        } else if (classe.equals("Mago")) {
            super.setVida(intVida);
            super.setAtaque(35);
            super.setDefesa(6);
            this.ouro = intOuro;
        }
    }

    public String getNome() {
        return nome;
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

    @Override
    public void atacar(Personagem personagem){
        int dadoHeroi = rd.nextInt(20)+1;
        int defesaInimigo=personagem.getDefesa();
        if(dadoHeroi>defesaInimigo){
            personagem.setVida(personagem.getVida()-this.getAtaque());
        }

    }
}
