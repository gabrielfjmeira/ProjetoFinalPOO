import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal extends JFrame {
    private JFrame menu =new JFrame();
    private File file = new File("");
    private ArrayList heroiCarregado = new ArrayList<>();
    Scanner scan;
    public static Heroi heroi;

    public MenuPrincipal(){
        //Configuração da tela
        menu.setTitle("Menu - GoblinSlayer");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.BOLD, 20);
        Font title = new Font("Arial", Font.BOLD, 40);
        Color black = new Color(0, 0, 0);

        BackgroundImage background = new BackgroundImage("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\MenuImage.jpg");
        BackgroundImage backgroundForm = new BackgroundImage("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\BackgroundForm3.jpg");
        ImageIcon backgroundButton = new ImageIcon("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\Button.png");

        menu.add(background);
        background.setLayout(null);
        background.add(backgroundForm);

        // Titulo
        JLabel titulo= new JLabel();
        titulo.setText("Goblin Slayer");
        titulo.setFont(title);
        titulo.setForeground(black);
        titulo.setBounds(50,50, 300, 60);


        //Botão de Criar Personagem
        JButton criarPersonagem = new JButton();
        criarPersonagem.setBounds(50,150,250,60);
        criarPersonagem.setLayout(null);
        criarPersonagem.setIcon(backgroundButton);
        JLabel nomeBotao1 = new JLabel();
        nomeBotao1.setText("Criar Personagem");
        nomeBotao1.setFont(font);
        criarPersonagem.add(nomeBotao1);
        nomeBotao1.setBounds(40,-6,250,70);

        //Botão de Carregar Personagem
        JButton carregarPersonagem = new JButton();
        carregarPersonagem.setBounds(50,250,250,60);
        carregarPersonagem.setLayout(null);
        carregarPersonagem.setIcon(backgroundButton);
        JLabel nomeBotao3 = new JLabel();
        nomeBotao3.setText("Carregar Personagem");
        nomeBotao3.setFont(font);
        carregarPersonagem.add(nomeBotao3);
        nomeBotao3.setBounds(20,-6,250,70);


        //Botão de Sair
        JButton sair = new JButton();
        sair.setBounds(50,350,250,60);
        sair.setLayout(null);
        sair.setIcon(backgroundButton);
        JLabel nomeBotao2 = new JLabel();
        nomeBotao2.setText("Sair");
        nomeBotao2.setFont(font);
        sair.add(nomeBotao2);
        nomeBotao2.setBounds(100,-6,250,70);


        //Ações dos Botões
        criarPersonagem.addActionListener(this::criarPersonagem);
        carregarPersonagem.addActionListener(this::carregarPersonagem);
        sair.addActionListener(this::sair);
        

        // montando componentes
        backgroundForm.setLayout(null);
        backgroundForm.setBounds(375,100, 350,450);
        backgroundForm.add(titulo);
        backgroundForm.add(criarPersonagem);
        backgroundForm.add(carregarPersonagem);
        backgroundForm.add(sair);

        menu.setVisible(true);

    }

    private void carregarPersonagem(ActionEvent actionEvent) {
        try {
            scan = new Scanner(file);
            while(scan.hasNextLine()){
                heroiCarregado.add(scan.nextLine());
            }
            heroi = new Heroi((String) heroiCarregado.get(0), (String) heroiCarregado.get(1), (String) heroiCarregado.get(2), (String) heroiCarregado.get(3));
            JOptionPane.showMessageDialog(null, "Personagem Carregado!");
            menu.setVisible(false);
            MenuJogo menuJogo = new MenuJogo();
        } catch (FileNotFoundException event) {
            throw new RuntimeException(event);
        }
    }


    public void criarPersonagem(ActionEvent e) {
        menu.setVisible(false);
        MenuCriarHeroi menuHeroi = new MenuCriarHeroi();
    }

    private void sair(ActionEvent e) {
        System.exit(0);
    }
}
