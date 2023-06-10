import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {
    private JFrame menu =new JFrame();
    public MenuPrincipal(){
        //Configuração da tela
        menu.setTitle("Menu - GlobinSlayer");
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

        //Botão de Criar Personagem
        JButton criarPersonagem = new JButton();
        criarPersonagem.setText("Criar Personagem");
        criarPersonagem.setBounds(400,200,250,70);
        criarPersonagem.setFont(font);
        criarPersonagem.setForeground(orange);
        criarPersonagem.setBackground(white);
        //Botão de Sair
        JButton sair = new JButton();
        sair.setText("Sair");
        sair.setBounds(400, 400, 250, 70);
        sair.setFont(font);
        sair.setForeground(orange);
        sair.setBackground(white);

        //Ações dos Botões
        criarPersonagem.addActionListener(this::criarPersonagem);
        sair.addActionListener(this::sair);

        background.setLayout(null);
        background.add(criarPersonagem);
        background.add(sair);
        menu.setVisible(true);

    }



    public void criarPersonagem(ActionEvent e) {
        menu.setVisible(false);
        MenuCriarHeroi menuHeroi = new MenuCriarHeroi();
    }

    private void sair(ActionEvent e) {
        System.exit(0);
    }
}
