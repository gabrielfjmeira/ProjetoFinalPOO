import java.util.ArrayList;

public class Loja {
    private String nome;
    private ArrayList<Equipamento> produtos;

    public Loja(String nome) {
        this.nome = nome;
    }
    public void exibirEstoque(){

        for (Equipamento produto:produtos){
            System.out.println(produto);
        }
    }
    public void comprarEquipamento(Pesonagem personagem){
//        personagem.setEquipamento()
    }
}
