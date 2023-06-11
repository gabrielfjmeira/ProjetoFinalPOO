import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuCriarHeroi extends JFrame {
    public static Heroi heroi;
    public JTextField nomeHeroiInput;
    public JComboBox tipoHeroiInput;
   private JFrame menu =new JFrame();

    public MenuCriarHeroi(){
        menu.setTitle("Menu - Criar Heroi");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.BOLD, 20);
        Font title = new Font("Arial", Font.BOLD, 50);
        Color black = new Color(0, 0, 0);
        Color input = new Color(73, 64, 54);

        BackgroundImage background =new BackgroundImage("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\MenuImage.jpg");
        ImageIcon backgroundButton = new ImageIcon("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\Button.png");
        BackgroundImage backgroundForm = new BackgroundImage("C:\\Users\\user\\IdeaProjects\\POOProjeto\\src\\Images\\BackgroundForm3.jpg");

        menu.add(background);
        background.setLayout(null);
        background.add(backgroundForm);

        // Titulo
        JLabel titulo = new JLabel("Criar Herói");
        titulo.setBounds(70, 70, 400, 70);
        titulo.setFont(title);
        titulo.setForeground(black);

        //Campo de inserção de nome do herói
        JLabel titleNomeHeroi = new JLabel();
        titleNomeHeroi.setBounds(30, 150, 250, 70);
        titleNomeHeroi.setFont(font);
        titleNomeHeroi.setText("Nome:");
        titleNomeHeroi.setForeground(black);
        JTextField nomeHeroi = new JTextField();
        nomeHeroi.setBounds(110, 150, 250, 70);
        nomeHeroi.setBorder(BorderFactory.createLineBorder(new Color(47, 42, 34)));
        nomeHeroi.setBackground(input);
        nomeHeroi.setForeground(black);
        nomeHeroi.setFont(font);
        nomeHeroiInput = nomeHeroi;

        //Seleção do tipo de herói
        JLabel titleHeroisList = new JLabel();
        titleHeroisList.setBounds(30, 250, 250, 70);
        titleHeroisList.setFont(font);
        titleHeroisList.setText("Classe:");
        titleHeroisList.setForeground(black);
        String[] tipoHerois = {"Selecione uma opção", "Mago", "Guerreiro", "Arqueiro"};
        JComboBox heroisList = new JComboBox(tipoHerois);
        heroisList.setSelectedIndex(0);
        heroisList.setFont(font);
        heroisList.setForeground(black);
        heroisList.setBackground(input);
//        heroisList.setBorder(BorderFactory.createLineBorder(new Color(47, 42, 34)));
        heroisList.setBounds(110, 250, 250, 70);
        tipoHeroiInput = heroisList;

        //Botão para criar herói
        JButton btnAddHeroi = new JButton();
        btnAddHeroi.setBounds(83, 370, 250, 70);
        btnAddHeroi.setLayout(null);
        btnAddHeroi.setIcon(backgroundButton);
        JLabel nomeBotao = new JLabel();
        nomeBotao.setText("Criar Herói");
        nomeBotao.setFont(font);
        btnAddHeroi.add(nomeBotao);
        nomeBotao.setBounds(70,-3,250,70);


        backgroundForm.setLayout(null);
        backgroundForm.setBounds(375,100, 400,500);
        backgroundForm.add(titulo);
        backgroundForm.add(titleNomeHeroi);
        backgroundForm.add(nomeHeroi);
        backgroundForm.add(titleHeroisList);
        backgroundForm.add(heroisList);
        backgroundForm.add(btnAddHeroi);

        //Ações dos botões

        btnAddHeroi.addActionListener(this::addHeroi);


        menu.setVisible(true);

    }

    private void addHeroi(ActionEvent e) {
        String nome = nomeHeroiInput.getText();
        String classe = (String) tipoHeroiInput.getSelectedItem();
        try{
            heroi = new Heroi(nome, classe);
            JOptionPane.showMessageDialog(null, "Personagem Criado!");
            menu.setVisible(false);
            MenuJogo menuJogo = new MenuJogo();
            MenuPrincipal.nextPage();
        }catch(RuntimeException f){
            JOptionPane.showMessageDialog(null, f.getMessage());
        }
    }
}



