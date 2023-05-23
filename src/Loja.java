import java.util.ArrayList;

public class Loja {
    private String nome;
    private ArrayList<Arma> armas;
    private ArrayList<Armadura> armaduras;

    public Loja(String nome) {
        this.nome = nome;
        armas = new ArrayList<>();
        armaduras= new ArrayList<>();
    }






    public void exibirEstoque(){

        for ( Arma arma :armas){
            System.out.println();
        }
        for (Armadura armadura:armaduras){
            System.out.println();
        }
    }

    public void comprarEquipamento(Arma arma){
//        Personagem.setArma();
    }
    public void comprarEquipamento(Armadura armadura){
//        Personagem.setArmadura();
    }

}
