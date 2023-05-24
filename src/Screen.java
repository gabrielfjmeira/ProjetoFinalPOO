import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screen extends JFrame{

    public Screen() throws IOException {
        //Configuração da tela
        setTitle("Tela Inicial");
        setVisible(true);
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(null);

        Font font = new Font("Arial", Font.BOLD, 20);
        Font title = new Font("Arial", Font.BOLD, 50);
        Color orange = new Color(231, 107, 49);
        Color white = new Color(255, 255, 255);

        //Título
        JLabel titulo = new JLabel("RPG");
        titulo.setBounds(470, 100, 250, 70);
        titulo.setFont(title);
        titulo.setForeground(orange);

        //Botão para criar personagem
        JButton criarPersonagem = new JButton();
        criarPersonagem.setText("Criar Personagem");
        criarPersonagem.setBounds(400, 200, 250, 70);
        criarPersonagem.setFont(font);
        criarPersonagem.setForeground(orange);
        criarPersonagem.setBackground(white);

        //Botão para fechar o jogo
        JButton sair = new JButton();
        sair.setText("Sair");
        sair.setBounds(400, 300, 250, 70);
        sair.setFont(font);
        sair.setForeground(orange);
        sair.setBackground(white);

        //Adiciona os botões na tela
        add(titulo);
        add(criarPersonagem);
        add(sair);

        //Icon
        ImageIcon image = new ImageIcon("C:\\Users\\meira.gabriel\\Documents\\PJBL10\\rpg\\bin\\icon.jfif");
        Image icon = image.getImage();
        this.setIconImage(icon);

        //Background
        BufferedImage img = ImageIO.read(new File("C:\\Users\\meira.gabriel\\Documents\\PJBL10\\rpg\\bin\\castelo.png"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, getWidth(), getHeight());
        add(background);

        //Adiciona eventos nos botões
        criarPersonagem.addActionListener(this::criarPersonagem);
        sair.addActionListener(this::sair);

    }

    public void criarPersonagem(ActionEvent e) {
        setVisible(false);
        MenuCriarHeroi menuHeroi = new MenuCriarHeroi();
    }

    private void sair(ActionEvent e) {
        dispose();
    }
}
