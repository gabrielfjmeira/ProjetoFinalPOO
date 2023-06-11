import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuJogo extends JFrame {
    private JFrame menu = new JFrame();
    public MenuJogo(){
        menu.setTitle("Menu - Jogo");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.BOLD, 23);
        Font title = new Font("Arial", Font.BOLD, 27);
        Color black = new Color(0, 0, 0);


        BackgroundImage background = new BackgroundImage("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\MenuImage.jpg");
        BackgroundImage backgroundForm = new BackgroundImage("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\BackgroundForm3.jpg");
        ImageIcon backgroundButton = new ImageIcon("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\Button.png");

        menu.add(background);
        background.setLayout(null);
        background.add(backgroundForm);

        // Titulo
        JLabel titulo = new JLabel("Bem-vindo Aventureiro!");
        titulo.setBounds(50, 20, 400, 70);
        titulo.setFont(title);
        titulo.setForeground(black);

        //subtitulo
//        JLabel subtitulo = new JLabel("Herói: " + MenuCriarHeroi.heroi.getNome());
//        subtitulo.setBounds(100, 45, 350, 70);
//        subtitulo.setFont(font);
//        subtitulo.setForeground(black);

        //Botão para Jogar
        JButton jogar = new JButton();
        jogar.setText("Jogar");
        jogar.setBounds(80, 100, 250, 70);
        jogar.setLayout(null);
        jogar.setIcon(backgroundButton);
        JLabel nomeBotao1 = new JLabel();

        nomeBotao1.setText("Jogar");
        nomeBotao1.setFont(font);
        nomeBotao1.setForeground(black);
        jogar.add(nomeBotao1);
        jogar.add(nomeBotao1, BorderLayout.CENTER);
        nomeBotao1.setBounds(95,-3,250,70);

        //Botão para Loja
        JButton loja = new JButton();
        loja.setBounds(80, 200, 250, 70);
        loja.setLayout(null);
        loja.setIcon(backgroundButton);
        JLabel nomeBotao2 = new JLabel();
        nomeBotao2.setText("Loja");
        nomeBotao2.setFont(font);
        nomeBotao2.setForeground(black);
        loja.add(nomeBotao2);
        nomeBotao2.setBounds(100,-3,250,70);

        //Botão para salvar o jogo
        JButton salvar = new JButton();
        salvar.setBounds(80, 300, 250, 70);
        salvar.setLayout(null);
        salvar.setIcon(backgroundButton);
        JLabel nomeBotao4 = new JLabel();
        nomeBotao4.setText("Salvar");
        nomeBotao4.setFont(font);
        nomeBotao4.setForeground(black);
        salvar.add(nomeBotao4);
        nomeBotao4.setBounds(90,-3,250,70);

        //Botão para fechar o jogo
        JButton sair = new JButton();
        sair.setBounds(80, 400, 250, 70);
        sair.setLayout(null);
        sair.setIcon(backgroundButton);
        JLabel nomeBotao3 = new JLabel();
        nomeBotao3.setText("Sair");
        nomeBotao3.setFont(font);
        nomeBotao3.setForeground(black);
        sair.add(nomeBotao3);
        nomeBotao3.setBounds(103,-3,250,70);


        // Organizando elementos da tela
        backgroundForm.setLayout(null);
        backgroundForm.setBounds(375,100, 400,500);
        backgroundForm.add(titulo);
//        backgroundForm.add(subtitulo);
        backgroundForm.add(jogar);
        backgroundForm.add(jogar);
        backgroundForm.add(loja);
        backgroundForm.add(salvar);
        backgroundForm.add(sair);

        //Adiciona eventos nos botões
        jogar.addActionListener(this::jogar);
        loja.addActionListener(this::loja);
        salvar.addActionListener(this::salvar);
        sair.addActionListener(this::sair);

        menu.setVisible(true);
    }

    private void salvar(ActionEvent actionEvent) {
        try {
            FileWriter fw = new FileWriter("savePersonagem.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(MenuCriarHeroi.heroi.getNome());
            pw.println(MenuCriarHeroi.heroi.getClasse());
            pw.println(MenuCriarHeroi.heroi.getOuro());
            pw.println(MenuCriarHeroi.heroi.getVida());
            pw.flush();
            pw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "Progresso salvo no diretório do jogo como: savePersonagem.txt");

        } catch (IOException event) {
            throw new RuntimeException(event);
        }
    }

    private void sair(ActionEvent e) {
        System.exit(0);
    }

    private void loja(ActionEvent e) {
    }

    private void jogar(ActionEvent e) {
        menu.setVisible(false);
        MenuDungeon menuDungeon = new MenuDungeon();
        MenuPrincipal.nextPage();
        MenuPrincipal.parar();
    }

}
