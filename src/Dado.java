import java.util.Random;

public class Dado {
    private int n_lados;

    public Dado(int n_lados) {
        this.n_lados = 20;
    }

    public int lancarDado(){
        Random random = new Random();
        return random.nextInt(n_lados) + 1;
    }

}
