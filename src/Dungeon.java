import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Dungeon {
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
    public void inicializarDungeon(String status, String mensagemHeroi, String mensagemInimigo){
        menu.setTitle("Floresta Goblin");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.BOLD, 20);
        Font title = new Font("Arial", Font.BOLD, 50);
        Color orange = new Color(231, 107, 49);
        Color white = new Color(255, 255, 255);

        BackgroundImage background =new BackgroundImage("C:\\Users\\brunn\\OneDrive\\Documentos\\PUC 2023.1\\POO\\POO_PJBL10\\src\\Imagens\\FlorestaGoblin.jpg");
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

        //Nome do Herói
        JLabel nomeHeroi = new JLabel();
        nomeHeroi.setBounds(75, 200, 350, 70);
        nomeHeroi.setText(heroi.getNome());
        nomeHeroi.setFont(font);
        nomeHeroi.setForeground(orange);
        background.add(nomeHeroi);

        //Vida do Herói
        JLabel vidaHeroi = new JLabel();
        vidaHeroi.setBounds(75, 230, 350, 70);
        if(heroi.getVida() > 0){
            vidaHeroi.setText("Vida: " + heroi.getVida());
        }else{
            vidaHeroi.setText("Vida: 0");
        }
        vidaHeroi.setFont(font);
        vidaHeroi.setForeground(orange);
        background.add(vidaHeroi);

        //Poções do Herói
        JLabel pocaoVida = new JLabel();
        pocaoVida.setBounds(75, 250, 350, 70);
        pocaoVida.setText("Poções disponíveis: " + heroi.getQtdPocao());
        pocaoVida.setFont(font);
        pocaoVida.setForeground(orange);
        background.add(pocaoVida);

        if(inimigos.size() < 1){

        }else {
            //Fala do Inimigo
            JLabel falaInimigo = new JLabel();
            falaInimigo.setBounds(525, 170, 650, 70);
            falaInimigo.setText(inimigos.get(0).falaPersonagem());
            falaInimigo.setFont(font);
            falaInimigo.setForeground(orange);
            background.add(falaInimigo);

            //Nome do Inimigo
            JLabel nomeInimigo = new JLabel();
            nomeInimigo.setBounds(525, 200, 350, 70);
            nomeInimigo.setText(((Inimigo) inimigos.get(0)).getRaca());
            nomeInimigo.setFont(font);
            nomeInimigo.setForeground(orange);
            background.add(nomeInimigo);

            //Vida do Inimigo
            JLabel vidaInimigo = new JLabel();
            vidaInimigo.setBounds(525, 230, 350, 70);
            if (inimigos.get(0).getVida() > 0) {
                vidaInimigo.setText("Vida: " + inimigos.get(0).getVida());
            } else {
                vidaInimigo.setText("Vida: 0");
            }
            vidaInimigo.setFont(font);
            vidaInimigo.setForeground(orange);
            background.add(vidaInimigo);
        }

        //Botão de Atacar
        JButton btnatacar = new JButton();
        btnatacar.setText("Atacar");
        btnatacar.setBounds(475, 350, 100, 50);
        btnatacar.setFont(font);
        btnatacar.setForeground(orange);
        btnatacar.setBackground(white);
        if (inimigos.size() >= 1) {
            if (heroi.getVida() > 0) {
                background.add(btnatacar);
            }
        }

        //Botão de fugir
        JButton btnfugir = new JButton();
        btnfugir.setText("Fugir");
        btnfugir.setBounds(475, 450, 100, 50);
        btnfugir.setFont(font);
        btnfugir.setForeground(orange);
        btnfugir.setBackground(white);
        if (inimigos.size() >= 1) {
            if (heroi.getVida() > 0) {
                background.add(btnfugir);
            }
        }

        //Botão de Voltar
        JButton btnvoltar = new JButton();
        if (heroi.getVida() > 0){
            btnvoltar.setText("Voltar");
        }else{
            btnvoltar.setText("Game Over");
        }
        btnvoltar.setBounds(475, 350, 150, 50);
        btnvoltar.setFont(font);
        btnvoltar.setForeground(orange);
        btnvoltar.setBackground(white);
        if(heroi.getVida()<=0 || inimigos.size() < 1) {
            background.add(btnvoltar);
        }

        //Usar Poção
        JButton btnPocao = new JButton();
        btnPocao.setText("Usar Poção");
        btnPocao.setBounds(75, 300, 250, 50);
        btnPocao.setFont(font);
        btnPocao.setForeground(orange);
        btnPocao.setBackground(white);
        if(heroi.getQtdPocao() > 0 && inimigos.size() >= 1) {
            background.add(btnPocao);
        }

        //Mensagem de Status da Dungeon
        JLabel mensagemStatus = new JLabel();
        mensagemStatus.setBounds(320, 400, 550, 70);
        mensagemStatus.setText(status);
        mensagemStatus.setFont(font);
        mensagemStatus.setForeground(orange);
        background.add(mensagemStatus);

        //Mensagem de Info Herói
        JLabel mensagemInfoHeroi = new JLabel();
        mensagemInfoHeroi.setBounds(75, 350, 550, 70);
        mensagemInfoHeroi.setText(mensagemHeroi);
        mensagemInfoHeroi.setFont(font);
        mensagemInfoHeroi.setForeground(orange);
        background.add(mensagemInfoHeroi);

        //Mensagem de Info Inimigo
        JLabel mensagemInfoInimigo = new JLabel();
        mensagemInfoInimigo.setBounds(525, 350, 550, 70);
        mensagemInfoInimigo.setText(mensagemInimigo);
        mensagemInfoInimigo.setFont(font);
        mensagemInfoInimigo.setForeground(orange);
        background.add(mensagemInfoInimigo);

        //Ações dos Botões
        btnatacar.addActionListener(this::ataque);
        btnfugir.addActionListener(this::fugir);
        btnPocao.addActionListener(this::usarPocao);
        btnvoltar.addActionListener(this::voltar);

        menu.setVisible(true);

    }

    private void voltar(ActionEvent e) {
        menu.setVisible(false);
        if(heroi.getVida() > 0){
            MenuDungeon menuDungeon = new MenuDungeon();
        }else{
            MenuPrincipal menuPrincipal = new MenuPrincipal();
        }

    }

    private void fugir(ActionEvent e) {
        Random rd =new Random();
        if(rd.nextInt(10)+1>=8){
            JOptionPane.showMessageDialog(null, heroi.getNome() + " escapou!");
            menu.setVisible(false);
            MenuDungeon menuDungeon=new MenuDungeon();
        }else{
            //Mensagem do inimigo
            String msgInimigo = inimigos.get(0).atacar(heroi);

            //Mensagem do herói
            String msgHeroi = heroi.getNome() + " não conseguiu escapar!";
            if(heroi.getVida() <= 0){
                msgHeroi = heroi.getNome() + " morreu!";
            }

            menu.setVisible(false);
            Dungeon dungeonNextStep = new Dungeon(nome, inimigos);
            dungeonNextStep.inicializarDungeon("", msgHeroi, msgInimigo);
        }
    }

    private void ataque(ActionEvent e)  {
        //Mensagem do Herói
        String msgHeroi =heroi.atacar(inimigos.get(0));

        //Mensagem do Inimigo
        String msgInimigo = inimigos.get(0).atacar(heroi);

        if(inimigos.get(0).getVida() <= 0){ //Herói derrotou o inimigo

            //Recompensa adicionada no saldo do Herói
            heroi.setOuro(heroi.getOuro() + ((Inimigo) inimigos.get(0)).getRecompensa());

            //Passa para o próximo inimigo
            inimigos.remove(0);

            //Mensagem do Inimigo
            msgInimigo = heroi.getNome() + "derrotou o inimigo!";

        }else if(heroi.getVida() <= 0){ //Herói morreu
            msgHeroi = heroi.getNome() + " morreu!";
        }

        //Continua Dungeon
        menu.setVisible(false);

        //Fim da Dungeon
        if (inimigos.size() < 1){
            Dungeon dungeonEnd = new Dungeon(nome, inimigos);
            dungeonEnd.inicializarDungeon("Dungeon finalizada!", msgHeroi, msgInimigo);
        }else{
            Dungeon dungeonNextStep = new Dungeon(nome, inimigos);
            dungeonNextStep.inicializarDungeon("", msgHeroi, msgInimigo);
        }
    }

    private void usarPocao(ActionEvent e){
        if(heroi.getQtdPocao() > 0){
            //Seta a vida do herói
            heroi.setQtdPocao(heroi.getQtdPocao() - 1);

            //Mensagem do Herói
            String msgHeroi = "Poção de vida usada com sucesso!";

            String classeHeroi = heroi.getClasse();
            switch (classeHeroi){
                case "Guerreiro":
                    heroi.setVida(60);
                    break;
                case "Arqueiro":
                    heroi.setVida(50);
                    break;
                case "Mago":
                    heroi.setVida(45);
                    break;
            }

            //Mensagem do Inimigo
            String msgInimigo = inimigos.get(0).atacar(heroi);

            menu.setVisible(false);
            Dungeon dungeonNextStep = new Dungeon(nome, inimigos);
            dungeonNextStep.inicializarDungeon("", msgHeroi, msgInimigo);
        }
    }
}
