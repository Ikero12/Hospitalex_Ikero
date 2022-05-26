package GUI;

import javax.swing.*;

import java.awt.*;

public class GUIUsuario {
    //private JFrame usuario;
    //private JPanel info,bg;
    //private JLabel logo,titulo,background;
    private JFrame usuario = new JFrame("Hospitalex Ikero");
    private JPanel bg = new JPanel();
    private JPanel info = new JPanel();
    private JLabel logo = new JLabel();
    private JLabel titulo = new JLabel("Hospitalex Ikero");
    private JLabel background = new JLabel();
    public void GUIUsuario() {
        //Al final de cada componente se añade al bg(Background) label.
        //Declaraciones


        //Frame
        usuario.setSize(920 ,920);
        usuario.setResizable(false);
        usuario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        usuario.setLayout(null);
        usuario.setLocationRelativeTo(null);

        ImageIcon HI2 = new ImageIcon("bgmaybe.jpg");
        background.setIcon(HI2);
        background.setBounds(0,0,920,920);

        bg.setBounds(0,0,920,920);
        bg.setLayout(null);




        //Labels
        titulo.setBounds(250,10,350,60);
        titulo.setFont(new Font("SansSerif",Font.BOLD,22));

        ImageIcon HI = new ImageIcon("hospitalex ikero.png");
        logo.setIcon(HI);
        logo.setBounds(720,20,180,180);

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

    public void addToUsuario(JComponent x){
        bg.add(x);
        usuario.add(bg);
    }

    public JPanel getBg() {
        return bg;
    }

    public void setBg(JPanel bg) {
        this.bg = bg;
    }
}
