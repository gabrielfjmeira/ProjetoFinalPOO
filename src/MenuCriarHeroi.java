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
        Color orange = new Color(231, 107, 49);
        Color white = new Color(255, 255, 255);

        BackgroundImage background =new BackgroundImage("C:\\Users\\brunn\\OneDrive\\Documentos\\PUC 2023.1\\POO\\POO_PJBL10\\src\\Imagens\\MenuInicial.jpg");
        menu.add(background);
        // Titulo
        JLabel titulo = new JLabel("Criar Herói");
        titulo.setBounds(390, 100, 400, 70);
        titulo.setFont(title);
        titulo.setForeground(orange);

        //Campo de inserção de nome do herói
        JLabel titleNomeHeroi = new JLabel();
        titleNomeHeroi.setBounds(335, 200, 250, 70);
        titleNomeHeroi.setFont(font);
        titleNomeHeroi.setText("Nome:");
        titleNomeHeroi.setForeground(orange);
        JTextField nomeHeroi = new JTextField();
        nomeHeroi.setBounds(400, 200, 250, 70);
        nomeHeroi.setBackground(white);
        nomeHeroi.setForeground(orange);
        nomeHeroi.setFont(font);
        nomeHeroiInput = nomeHeroi;

        //Seleção do tipo de herói
        JLabel titleHeroisList = new JLabel();
        titleHeroisList.setBounds(170, 300, 250, 70);
        titleHeroisList.setFont(font);
        titleHeroisList.setText("Escolha o tipo de herói:");
        titleHeroisList.setForeground(orange);
        String[] tipoHerois = {"Selecione uma opção", "Mago", "Guerreiro", "Arqueiro"};
        JComboBox heroisList = new JComboBox(tipoHerois);
        heroisList.setSelectedIndex(0);
        heroisList.setFont(font);
        heroisList.setForeground(orange);
        heroisList.setBackground(white);
        heroisList.setBounds(400, 300, 250, 70);
        tipoHeroiInput = heroisList;

        //Botão para criar herói
        JButton btnAddHeroi = new JButton();
        btnAddHeroi.setText("Criar Herói");
        btnAddHeroi.setBounds(400, 400, 250, 70);
        btnAddHeroi.setFont(font);
        btnAddHeroi.setForeground(orange);
        btnAddHeroi.setBackground(white);



        background.setLayout(null);
        background.add(titulo);
        background.add(titleNomeHeroi);
        background.add(nomeHeroi);
        background.add(titleHeroisList);
        background.add(heroisList);
        background.add(btnAddHeroi);

        //Ações dos botões

        btnAddHeroi.addActionListener(this::addHeroi);


        menu.setVisible(true);

    }

    private void addHeroi(ActionEvent e) {
        String nome = nomeHeroiInput.getText();
        String classe = (String) tipoHeroiInput.getSelectedItem();
        if(nome.length() > 0 && !classe.equals("Selecione uma opção")){
            heroi = new Heroi(nome, classe);
            JOptionPane.showMessageDialog(null, "Personagem Criado!");
            menu.setVisible(false);
            MenuJogo menuJogo = new MenuJogo();
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }
}



