import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Dungeon extends JFrame {
    private String nome;
    private Heroi heroi;
    private ArrayList<Personagem> inimigos;

    public Dungeon(String nome,ArrayList<Personagem> inimigos){
        this.nome = nome;
        this.heroi = MenuCriarHeroi.heroi;
        this.inimigos = inimigos;
    }

    public String getNome() {
        return nome;
    }
    private JFrame menu =new JFrame();
    public void inicializarDungeon(){
        menu.setTitle("Floresta Goblin");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.BOLD, 20);
        Font title = new Font("Arial", Font.BOLD, 50);
        Color orange = new Color(231, 107, 49);
        Color white = new Color(255, 255, 255);

        BackgroundImage background =new BackgroundImage("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\FlorestaGoblin.jpg");
        menu.add(background);
        background.setLayout(null);

        //Título
        JLabel titulo = new JLabel();
        titulo.setText(this.getNome());
        titulo.setBounds(300, 100, 550, 70);
        titulo.setFont(title);
        titulo.setForeground(orange);
        background.add(titulo);

        //Fala do Herói
        JLabel falaHeroi = new JLabel();
        falaHeroi.setBounds(75, 170, 450, 70);
        falaHeroi.setText(heroi.falaPersonagem());
        falaHeroi.setFont(font);
        falaHeroi.setForeground(orange);
        background.add(falaHeroi);
        //Informações do Herói
        JLabel infoHeroi = new JLabel();
        infoHeroi.setBounds(75, 200, 350, 70);
        if (heroi.getVida() > 0) {
            infoHeroi.setText("HEROI: " + heroi.getNome() + " - VIDA: " + heroi.getVida());
        }else{
            infoHeroi.setText("HEROI: " + heroi.getNome() + " - VIDA: 0");
        }
        infoHeroi.setFont(font);
        infoHeroi.setForeground(orange);
        background.add(infoHeroi);
        //Fala do Inimigo
        JLabel falaInimigo = new JLabel();
        falaInimigo.setBounds(525, 170, 650, 70);
        falaInimigo.setText(inimigos.get(0).falaPersonagem());
        falaInimigo.setFont(font);
        falaInimigo.setForeground(orange);
        background.add(falaInimigo);

        //Informações do Inimigo
        JLabel infoInimigo = new JLabel();
        infoInimigo.setBounds(525, 200, 350, 70);
        if(inimigos.get(0) instanceof Inimigo){
            infoInimigo.setText("INIMIGO: " + ((Inimigo) inimigos.get(0)).getRaca() + " - VIDA: " + inimigos.get(0).getVida());
        }
        infoInimigo.setFont(font);
        infoInimigo.setForeground(orange);
        background.add(infoInimigo);

        //Botão de Atacar
        JButton btnatacar = new JButton();
        btnatacar.setText("Atacar");
        btnatacar.setBounds(475, 350, 100, 50);
        btnatacar.setFont(font);
        btnatacar.setForeground(orange);
        btnatacar.setBackground(white);
        if(heroi.getVida()>0) {
            background.add(btnatacar);
        }
        //Botão de fugir
        JButton btnfugir = new JButton();
        btnfugir.setText("Fugir");
        btnfugir.setBounds(475, 450, 100, 50);
        btnfugir.setFont(font);
        btnfugir.setForeground(orange);
        btnfugir.setBackground(white);
        if(heroi.getVida()>0) {
            background.add(btnfugir);
        }
        //Botão de Voltar
        JButton btnvoltar = new JButton();
        btnvoltar.setText("Voltar");
        btnvoltar.setBounds(475, 350, 100, 50);
        btnvoltar.setFont(font);
        btnvoltar.setForeground(orange);
        btnvoltar.setBackground(white);
        if(heroi.getVida()<=0) {
            background.add(btnvoltar);
        }

        //Ações dos Botões
        btnatacar.addActionListener(this::ataque);
        btnfugir.addActionListener(this::fugir);
        btnvoltar.addActionListener(this::voltar);







        menu.setVisible(true);

    }

    private void voltar(ActionEvent e) {
        MenuDungeon menuDungeon=new MenuDungeon();
    }

    private void fugir(ActionEvent e) {
        Random rd =new Random();
        if(rd.nextInt(10)+1>=8){
            menu.setVisible(false);
            MenuDungeon menuDungeon=new MenuDungeon();

        }else{
            inimigos.get(0).atacar(heroi);
            menu.setVisible(false);
            Dungeon dungeonNextStep = new Dungeon(nome, inimigos);
            dungeonNextStep.inicializarDungeon();
        }
    }

    private void ataque(ActionEvent e) {
        heroi.atacar(inimigos.get(0));
        inimigos.get(0).atacar(heroi);
        if(inimigos.get(0).getVida() <= 0){
            inimigos.remove(0);
//            mensagem += "Voce encontrou outro goblin pelo caminho!";
        }else if(heroi.getVida() <= 0){
//            mensagem += "Voce morreu :(";

        }
        menu.setVisible(false);
        Dungeon dungeonNextStep = new Dungeon(nome, inimigos);
        dungeonNextStep.inicializarDungeon();
    }
}
