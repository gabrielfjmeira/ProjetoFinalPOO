import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class MenuDungeon extends JFrame{

    ImageIcon background;
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

        //Adiciona eventos nos botões
        voltar.addActionListener(this::voltar);

        //Fases do RPG
        ArrayList<Dungeon> dungeons = new ArrayList<>();
        dungeons.add(new Dungeon("Fase 1", 10));
        dungeons.add(new Dungeon("Fase 2", 12));
        dungeons.add(new Dungeon("Fase 3", 14));
        dungeons.add(new Dungeon("Fase 4", 16));
        dungeons.add(new Dungeon("Fase 5", 18));
        dungeons.add(new Dungeon("Fase 6", 20));

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
            botoes.add(dungeon);
        }

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

        //Icon
        ImageIcon image = new ImageIcon("C:\\Users\\meira.gabriel\\Documents\\PJBL10\\rpg\\bin\\icon.jfif");
        Image icon = image.getImage();
        this.setIconImage(icon);

    }

    private void voltar(ActionEvent e){
        setVisible(false);
        MenuPrincipal menuPrincipal = new MenuPrincipal();
    }
}
