package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GUIUsuario {
    private JFrame usuario;
    private JPanel info,bg;
    private JLabel logo,titulo,background;

    public GUIUsuario() {
        //Al final de cada componente se añade al bg(Background) label.
        //Declaraciones
        usuario = new JFrame("Hospitalex Ikero");
        bg = new JPanel();
        info = new JPanel();
        logo = new JLabel();
        titulo = new JLabel("Hospitalex Ikero");
        background = new JLabel();

        //Frame
        usuario.setSize(920 ,920);
        usuario.setResizable(false);
        usuario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        usuario.setLayout(null);

        ImageIcon HI2 = new ImageIcon("bgmaybe.jpg");
        background.setIcon(HI2);
        background.setBounds(0,0,920,920);

        bg.setSize(920,920);
        bg.setLayout(null);




        //Labels
        titulo.setBounds(250,10,350,60);
        titulo.setFont(new Font("SansSerif",Font.BOLD,22));

        ImageIcon HI = new ImageIcon("hospitalex ikero.png");
        logo.setIcon(HI);
        logo.setBounds(720,20,200,180);

        bg.add(titulo);
        bg.add(logo);

        //Panel
        info.setBounds(20,60,700,300);
        info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,3),"Persona"));
        info.setBackground(new Color(186, 237, 230));
        bg.add(info);


        bg.add(background);
        usuario.add(bg);
        usuario.setVisible(true);





    }
}
