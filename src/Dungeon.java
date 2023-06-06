import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Dungeon extends JFrame{
    private String nome;
    private Heroi heroi;
    private ArrayList<Personagem> inimigos;

    Dado dadoHeroi = new Dado(20);
    Dado dadoInimigo = new Dado(20);

    public Dungeon(String nome, ArrayList<Personagem> inimigos) {
        this.nome = nome;
        this.heroi = MenuCriarHeroi.heroi;
        this.inimigos = inimigos;
    }

    public void inicializarDungeon(String mensagem, String mensagemH, String mensagemI){
        //Começa a dungeon enfrentando o primeiro inimigo
        //Configuração da tela
        setTitle(this.getNome());
        setVisible(true);
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(null);

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
        add(voltar);
        add(titulo);

        //Adiciona eventos nos botões
        voltar.addActionListener(this::voltar);

        //Fala do Herói
        JLabel falaHeroi = new JLabel();
        falaHeroi.setBounds(75, 170, 450, 70);
        falaHeroi.setText(heroi.falaPersonagem());
        falaHeroi.setFont(font);
        falaHeroi.setForeground(orange);

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

        //Fala do Inimigo
        JLabel falaInimigo = new JLabel();
        falaInimigo.setBounds(525, 170, 650, 70);
        falaInimigo.setText(inimigos.get(0).falaPersonagem());
        falaInimigo.setFont(font);
        falaInimigo.setForeground(orange);

        //Informações do Inimigo
        JLabel infoInimigo = new JLabel();
        infoInimigo.setBounds(525, 200, 350, 70);
        if(inimigos.get(0) instanceof Inimigo){
            infoInimigo.setText("INIMIGO: " + ((Inimigo) inimigos.get(0)).getRaca() + " - VIDA: " + inimigos.get(0).getVida());
        }
        infoInimigo.setFont(font);
        infoInimigo.setForeground(orange);

        //Botão de Atacar
        JButton atacar = new JButton();
        atacar.setText("Atacar");
        atacar.setBounds(475, 350, 100, 50);
        atacar.setFont(font);
        atacar.setForeground(orange);
        atacar.setBackground(white);

        //Informações do ataque do heroi
        JLabel infoAtqHeroi = new JLabel();
        infoAtqHeroi.setBounds(360, 400, 650, 70);
        if(!mensagemH.equals("")){
            infoAtqHeroi.setText(mensagemH);
        }
        infoAtqHeroi.setFont(font);
        infoAtqHeroi.setForeground(orange);

        //Informações do ataque do inimigo
        JLabel infoAtqInimigo = new JLabel();
        infoAtqInimigo.setBounds(360, 450, 650, 70);
        if(!mensagemI.equals("")){
            infoAtqInimigo.setText(mensagemI);
        }
        infoAtqInimigo.setFont(font);
        infoAtqInimigo.setForeground(orange);

        //Informações do game
        JLabel infoGame = new JLabel();
        infoGame.setBounds(360, 500, 650, 70);
        if(!mensagem.equals("")){
            infoGame.setText(mensagem);
        }
        infoGame.setFont(font);
        infoGame.setForeground(orange);

        //Adiciona as informações de Herói/Inimigo e do Botão de Atacar
        add(falaHeroi);
        add(falaInimigo);
        add(infoHeroi);
        add(infoInimigo);
        add(infoGame);
        if(heroi.getVida()>0){
            add(atacar);
        }
        add(infoAtqHeroi);
        add(infoAtqInimigo);

        //Adiciona eventos de lançar dado
        atacar.addActionListener(this::atacar);

    }

    public String getNome() {
        return nome;
    }

    //Evento de Voltar
    private void voltar(ActionEvent e){
        setVisible(false);
        MenuDungeon menuDungeon = new MenuDungeon();
    }

    //Evento de atacar
    private void atacar(ActionEvent e){

        String mensagem = "";
        String mensagemH = "";
        String mensagemI = "";

        int valorHeroi = dadoHeroi.lancarDado();
        int valorInimigo = dadoInimigo.lancarDado();
        int defesaHeroi = heroi.getDefesa();
        int defesaInimigo = inimigos.get(0).getDefesa();
        if(valorHeroi > defesaInimigo){
            inimigos.get(0).setVida(inimigos.get(0).getVida()-heroi.getForca());
            mensagemH += "Voce atingiu o goblin!";
        }else{
            mensagemH += "Voce errou o ataque!";
        }

        if (valorInimigo > defesaHeroi){
            heroi.setVida(heroi.getVida()-inimigos.get(0).getForca());
            mensagemI += "O goblin te acertou!";
            if(inimigos.get(0).getVida()<=0){
                mensagemI += " E morreu!";
            }
        }else{
            if(inimigos.get(0).getVida()>0){
                mensagemI += "O goblin errou o ataque!";
            }else {
                mensagemI += "O goblin morreu";
            }
        }


        if(inimigos.get(0).getVida() <= 0){
            inimigos.remove(0);
            mensagem += "Voce encontrou outro goblin pelo caminho!";
        }else if(heroi.getVida() <= 0){
            mensagem += "Voce morreu :(";
        }

        //Fecha tela e abre uma nova dungeon com novos dados para continuar
        setVisible(false);
        Dungeon dungeonNextStep = new Dungeon(nome, inimigos);
        dungeonNextStep.inicializarDungeon(mensagem, mensagemH, mensagemI);
    }

}
