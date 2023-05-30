import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class MenuDungeon extends JFrame{

    ImageIcon background;
    ArrayList<Dungeon> dungeons = new ArrayList<>();
    public MenuDungeon(){
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

        //Background
//        background = new ImageIcon("caminho");
//        JLabel backgroundLabel = new JLabel();
//        backgroundLabel.setIcon(background);
//        backgroundLabel.setSize(1080, 720);
//        add(backgroundLabel);

        //Botão para voltar para o menu
        JButton voltar = new JButton();
        voltar.setText("Voltar");
        voltar.setBounds(100, 100, 100, 50);
        voltar.setFont(font);
        voltar.setForeground(orange);
        voltar.setBackground(white);

        //Título
        JLabel titulo = new JLabel("DUNGEONS");
        titulo.setBounds(400, 100, 320, 70);
        titulo.setFont(title);
        titulo.setForeground(orange);

        add(voltar);
        add(titulo);

        //Fases do RPG

        //Popula os inimigos da Dungeon 1
        ArrayList<Personagem> inimigosDungeon1 = new ArrayList<>();
        for (int i = 0; i <=10; i++){
            inimigosDungeon1.add(new Inimigo(50, 10, 10, 10, 10, 10, "Goblin", 10));
        }
        dungeons.add(new Dungeon("Acampamento Goblin", inimigosDungeon1));

        //Popula os inimigos da Dungeon 2
        ArrayList<Personagem> inimigosDungeon2 = new ArrayList<>();
        for (int i = 0; i <=10; i++){
            inimigosDungeon2.add(new Inimigo(60, 15, 15, 15, 15, 15, "Goblin", 10));
        }
        dungeons.add(new Dungeon("Planície dos Goblins", inimigosDungeon2));

        //Popula os inimigos da Dungeon 3
        ArrayList<Personagem> inimigosDungeon3 = new ArrayList<>();
        for (int i = 0; i <=4; i++){
            inimigosDungeon3.add(new Inimigo(70, 20, 20, 20, 20, 20, "Goblin", 10));
        }
        inimigosDungeon3.add(new Inimigo(100, 150, 50, 130, 5, 10, "Goblin Feiticeiro", 50));
        dungeons.add(new Dungeon("Floresta dos Goblins", inimigosDungeon3));

        //Lista de botões
        ArrayList<JButton> botoes = new ArrayList<>();

        //Adiciona os botões na lista de botões
        for (int i = 0; i < dungeons.size(); i++) {
            //Criar button das dungeons
            JButton dungeon = new JButton();
            dungeon.setText(dungeons.get(i).getNome());
            dungeon.setFont(font);
            dungeon.setForeground(orange);
            dungeon.setBackground(white);
            dungeon.addActionListener(this::iniciaDungeon);
            botoes.add(dungeon);
        }

        //Adiciona eventos nos botões
        voltar.addActionListener(this::voltar);


        //Imprime o botão
        int x = 100;
        int y = 200;
        int i = 0;
        int l = 1;

        for (JButton botao: botoes) {
            botao.setBounds(x, y*l, 250, 70);
            add(botao);
            x += 300;
            i += 1;
            if(i % 3 == 0){
                x = 100;
                l += 1;
            }
        }



    }

    //Evento de Voltar
    private void voltar(ActionEvent e){
        setVisible(false);
        MenuPrincipal menuPrincipal = new MenuPrincipal();
    }

    //Evento de inicializar dungeon
    private void iniciaDungeon(ActionEvent e){
        setVisible(false);
        dungeons.get(0).inicializarDungeon();
    }
}
