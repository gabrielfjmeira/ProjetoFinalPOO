import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class Screen extends JFrame{
    public Screen(){
        //Configuração da tela
        setTitle("Criação de Personagem");
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
        titulo.setBounds(450, 100, 250, 70);
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

        //Adiciona eventos nos botões
        criarPersonagem.addActionListener(this::criarPersonagem);
        sair.addActionListener(this::sair);

    }

    public void criarPersonagem(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Personagem Criado!");
    }

    private void sair(ActionEvent e) {
        dispose();
    }
}
