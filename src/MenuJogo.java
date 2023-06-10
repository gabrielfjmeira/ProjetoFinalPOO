import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuJogo extends JFrame {
    private JFrame menu =new JFrame();
    public MenuJogo(){
        menu.setTitle("Menu - Jogo");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.BOLD, 20);
        Font title = new Font("Arial", Font.BOLD, 30);
        Color black = new Color(0, 0, 0);


        BackgroundImage background = new BackgroundImage("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\MenuImage.jpg");
        BackgroundImage backgroundForm = new BackgroundImage("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\BackgroundForm3.jpg");
        ImageIcon backgroundButton = new ImageIcon("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\Button.png");

        menu.add(background);
        background.setLayout(null);
        background.add(backgroundForm);

        // Titulo
        JLabel titulo = new JLabel("Bem-vindo Aventureiro!");
        titulo.setBounds(30, 50, 400, 70);
        titulo.setFont(title);
        titulo.setForeground(black);

        //subtitulo
        JLabel subtitulo = new JLabel(MenuCriarHeroi.heroi.getNome());
        subtitulo.setBounds(420, 150, 350, 70);
        subtitulo.setFont(title);
        subtitulo.setForeground(black);

        //Botão para Jogar
        JButton jogar = new JButton();
        jogar.setText("Jogar");
        jogar.setBounds(80, 150, 250, 70);
        jogar.setLayout(null);
        jogar.setIcon(backgroundButton);
        JLabel nomeBotao1 = new JLabel();
        nomeBotao1.setText("Jogar");
        nomeBotao1.setFont(font);
        nomeBotao1.setForeground(black);
        jogar.add(nomeBotao1);
        nomeBotao1.setBounds(100,-6,250,70);

        //Botão para Loja
        JButton loja = new JButton();
        loja.setBounds(80, 250, 250, 70);
        loja.setLayout(null);
        loja.setIcon(backgroundButton);
        JLabel nomeBotao2 = new JLabel();
        nomeBotao2.setText("Loja");
        nomeBotao2.setFont(font);
        nomeBotao2.setForeground(black);
        loja.add(nomeBotao2);
        nomeBotao2.setBounds(105,-6,250,70);

        //Botão para fechar o jogo
        JButton sair = new JButton();
        sair.setBounds(80, 350, 250, 70);
        sair.setLayout(null);
        sair.setIcon(backgroundButton);
        JLabel nomeBotao3 = new JLabel();
        nomeBotao3.setText("Sair");
        nomeBotao3.setFont(font);
        nomeBotao3.setForeground(black);
        sair.add(nomeBotao3);
        nomeBotao3.setBounds(105,-3,250,70);

        backgroundForm.setLayout(null);
        backgroundForm.setBounds(375,100, 400,500);
        backgroundForm.add(titulo);
        backgroundForm.add(subtitulo);
        backgroundForm.add(jogar);
        backgroundForm.add(jogar);
        backgroundForm.add(loja);
        backgroundForm.add(sair);

        //Adiciona eventos nos botões
        jogar.addActionListener(this::jogar);
        loja.addActionListener(this::loja);
        sair.addActionListener(this::sair);

        menu.setVisible(true);
    }

    private void sair(ActionEvent e) {
    }

    private void loja(ActionEvent e) {
    }

    private void jogar(ActionEvent e) {
        menu.setVisible(false);
        MenuDungeon menuDungeon = new MenuDungeon();
    }

}
