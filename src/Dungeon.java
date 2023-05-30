import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Dungeon {
    private String nome;
    private Heroi heroi;
    private ArrayList<Personagem> inimigos;

    Dado dadoHeroi = new Dado(6);
    Dado dadoInimigo = new Dado(6);
    JFrame jFrame = new JFrame();

    public Dungeon(String nome, ArrayList<Personagem> inimigos) {
        this.nome = nome;
        this.heroi = MenuCriarHeroi.heroi;
        this.inimigos = inimigos;
    }

    public void inicializarDungeon(){
        //Começa a dungeon enfrentando o primeiro inimigo
        //Configuração da tela
        jFrame.setTitle(this.getNome());
        jFrame.setVisible(true);
        jFrame.setSize(1080, 720);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);

        jFrame.setLayout(null);

        Font font = new Font("Arial", Font.BOLD, 20);
        Font title = new Font("Arial", Font.BOLD, 50);
        Color orange = new Color(231, 107, 49);
        Color white = new Color(255, 255, 255);

        //Botão de Voltar para a Seleção de Dungeon
        JButton voltar = new JButton();
        voltar.setText("Voltar");
        voltar.setBounds(100, 100, 100, 50);
        voltar.setFont(font);
        voltar.setForeground(orange);
        voltar.setBackground(white);

        //Título
        JLabel titulo = new JLabel();
        titulo.setText(this.getNome());
        titulo.setBounds(300, 100, 550, 70);
        titulo.setFont(title);
        titulo.setForeground(orange);

        //Aidicona o botão de voltar e o título da fase
        jFrame.add(voltar);
        jFrame.add(titulo);

        //Adiciona eventos nos botões
        voltar.addActionListener(this::voltar);

        //Informações do Herói
        JLabel infoHeroi = new JLabel();
        infoHeroi.setBounds(275, 200, 200, 70);
        infoHeroi.setText(MenuCriarHeroi.heroi.getNome() + " - VIDA: " + MenuCriarHeroi.heroi.getVida());
        infoHeroi.setFont(font);
        infoHeroi.setForeground(orange);

        //Informações do Inimigo
        JLabel infoInimigo = new JLabel();
        infoInimigo.setBounds(675, 200, 200, 70);
        infoInimigo.setText("");
        if(inimigos.get(0) instanceof Inimigo){
            infoInimigo.setText(((Inimigo) inimigos.get(0)).getRaca() + " - VIDA: " + inimigos.get(0).getVida());
        }
        infoInimigo.setFont(font);
        infoInimigo.setForeground(orange);

        //Botão de Atacar
        JButton atacar = new JButton();
        atacar.setText("Atacar");
        atacar.setBounds(475, 200, 100, 50);
        atacar.setFont(font);
        atacar.setForeground(orange);
        atacar.setBackground(white);

        //Adiciona as informações de Herói/Inimigo e do Botão de Atacar
        jFrame.add(infoHeroi);
        jFrame.add(infoInimigo);
        jFrame.add(atacar);

        //Adiciona eventos de lançar dado
        atacar.addActionListener(this::lancarDado);

    }

    public String getNome() {
        return nome;
    }

    //Evento de Voltar
    private void voltar(ActionEvent e){
        jFrame.setVisible(false);
        MenuDungeon menuDungeon = new MenuDungeon();
    }

    private void lancarDado(ActionEvent e){
        if(dadoHeroi.lancarDado() > dadoInimigo.lancarDado()){
            inimigos.get(0).setVida(inimigos.get(0).getVida()-15);
        }else if(dadoInimigo.lancarDado() > dadoHeroi.lancarDado()){
            MenuCriarHeroi.heroi.setVida(MenuCriarHeroi.heroi.getVida()-15);
        }
        jFrame.setVisible(false);
        this.inicializarDungeon();
    }
}
