import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class MenuPrincipal extends JFrame{
    public MenuPrincipal(){
        //Configuração da tela
        setTitle("Menu - RPG");
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
        titulo.setBounds(475, 100, 250, 70);
        titulo.setFont(title);
        titulo.setForeground(orange);

        //SubTítulo
        JLabel subtitulo = new JLabel("Bem vindo herói " + MenuCriarHeroi.heroi.getNome());
        subtitulo.setBounds(420, 150, 250, 70);
        subtitulo.setFont(font);
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

        //Adiciona os botões na tela
        add(titulo);
        add(subtitulo);
        add(jogar);
        add(loja);
        add(sair);

        //Adiciona eventos nos botões
        jogar.addActionListener(this::jogar);
        loja.addActionListener(this::loja);
        sair.addActionListener(this::sair);

    }
    private void jogar(ActionEvent e){
        setVisible(false);
        MenuDungeon menuDungeon = new MenuDungeon();
    }
    private void loja(ActionEvent e){
        JOptionPane.showMessageDialog(null, "Página da loja");
    }
    private void sair(ActionEvent e) {
        dispose();
    }
}
