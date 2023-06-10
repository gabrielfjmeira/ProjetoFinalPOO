import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class MenuDungeon {
    Random rd = new Random();

    ArrayList<Dungeon> dungeons=new ArrayList<>();
    private JFrame menu =new JFrame();
    public MenuDungeon(){
        menu.setTitle("Menu - Dungeons");
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
        background.setLayout(null);
        //Título
        JLabel titulo = new JLabel("DUNGEONS");
        titulo.setBounds(400, 100, 320, 70);
        titulo.setFont(title);
        titulo.setForeground(orange);
        background.add(titulo);
        //Botão para voltar para o menu
        JButton voltar = new JButton();
        voltar.setText("Voltar");
        voltar.setBounds(100, 100, 100, 50);
        voltar.setFont(font);
        voltar.setForeground(orange);
        voltar.setBackground(white);
        background.add(voltar);

        ArrayList<Personagem> inimigosDungeon1= new ArrayList<>();
        for (int i=0;i<=rd.nextInt(7,10);i++){
            inimigosDungeon1.add(new Inimigo("Goblins"));
        }
        dungeons.add(new Dungeon("Floresta dos Goblins",inimigosDungeon1));

        //Botão Dungeon 1
        JButton btnDungeon1 = new JButton();
        btnDungeon1.setText(dungeons.get(0).getNome());
        btnDungeon1.setFont(font);
        btnDungeon1.setBounds(400,200,250,70);
        btnDungeon1.setForeground(orange);
        btnDungeon1.setBackground(white);
        background.add(btnDungeon1);

        //Ações dos botões
        voltar.addActionListener(this::voltar);
        btnDungeon1.addActionListener(this::iniciaDungeon1);

        menu.setVisible(true);
    }

    private void iniciaDungeon1(ActionEvent e) {
        menu.setVisible(false);
        dungeons.get(0).inicializarDungeon("A batalha na " + dungeons.get(0).getNome() + " começa!", "", "");
    }

    private void voltar(ActionEvent e) {
        menu.setVisible(false);
        MenuJogo menuJogo = new MenuJogo();
    }
}
