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
        Font title = new Font("Arial", Font.BOLD, 50);
        Color orange = new Color(231, 107, 49);
        Color white = new Color(255, 255, 255);

        BackgroundImage background =new BackgroundImage("C:\\Users\\brunn\\OneDrive\\Documentos\\PUC 2023.1\\POO\\POO_PJBL10\\src\\Imagens\\MenuInicial.jpg");
        menu.add(background);
        // Titulo
        JLabel titulo = new JLabel("Bem vindo herói");
        titulo.setBounds(390, 100, 400, 70);
        titulo.setFont(title);
        titulo.setForeground(orange);
        //subtitulo
        JLabel subtitulo = new JLabel(MenuCriarHeroi.heroi.getNome());
        subtitulo.setBounds(420, 150, 350, 70);
        subtitulo.setFont(title);
        subtitulo.setForeground(orange);
        //Botão para Jogar
        JButton jogar = new JButton();
        jogar.setText("Jogar");
        jogar.setBounds(400, 200, 250, 70);
        jogar.setFont(font);
        jogar.setForeground(orange);
        jogar.setBackground(white);
        //Botão para Loja
        JButton loja = new JButton();
        loja.setText("Loja");
        loja.setBounds(400, 300, 250, 70);
        loja.setFont(font);
        loja.setForeground(orange);
        loja.setBackground(white);
        //Botão para fechar o jogo
        JButton sair = new JButton();
        sair.setText("Sair");
        sair.setBounds(400, 400, 250, 70);
        sair.setFont(font);
        sair.setForeground(orange);
        sair.setBackground(white);

        background.setLayout(null);
        background.add(titulo);
        background.add(subtitulo);
        background.add(jogar);
        background.add(jogar);
        background.add(loja);
        background.add(sair);

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
