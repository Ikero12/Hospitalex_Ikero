package GUI;

import logIn.LogIn;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class GUIUsuario {

    private JFrame usuario = new JFrame("Hospitalex Ikero");
    private JPanel bg = new JPanel();
    private JPanel info = new JPanel();
    private JLabel logo = new JLabel();
    private JLabel titulo = new JLabel("Hospitalex Ikero");
    private JLabel background = new JLabel();
    private JButton desconexion;

    private final String CARPETA = "src/main/resources/imagenes/".replace("/", File.separator);

    public void GUIUsuario() {
        //Al final de cada componente se añade al bg(Background) label.
        //Declaraciones


        //region Frame
        usuario.setSize(920, 920);
        usuario.setResizable(false);
        usuario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        usuario.setLayout(null);
        usuario.setLocationRelativeTo(null);

        ImageIcon HI2 = new ImageIcon(CARPETA + File.separator + "bgmaybe.jpg");
        background.setIcon(HI2);
        background.setBounds(0, 0, 920, 920);

        bg.setBounds(0, 0, 920, 920);
        bg.setLayout(null);
        //endregion

        //region Labels
        titulo.setBounds(250, 10, 350, 60);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 22));

        ImageIcon HI = new ImageIcon(CARPETA + File.separator + "hospitalex ikero.png");
        logo.setIcon(HI);
        logo.setBounds(720, 20, 180, 180);

        bg.add(titulo);
        bg.add(logo);
        //endregion

        //regionButtons
        ImageIcon disconnectIcon = new ImageIcon(CARPETA + File.separator + "disconnect.png");
        desconexion = new JButton();
        desconexion.setBounds(20,18,28,28);
        desconexion.setOpaque(false);
        desconexion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        desconexion.setContentAreaFilled(false);
        desconexion.setFocusPainted(false);
        desconexion.setBorderPainted(false);
        desconexion.setIcon(disconnectIcon);

        desconexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogIn.disconnect(usuario);
            }
        });
        bg.add(desconexion);
        //endregion

        //region Panel
        info.setLayout(null);
        info.setBounds(20, 60, 700, 300);
        info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 3)));
        info.setBackground(new Color(186, 237, 230));
        bg.add(info);


        bg.add(background);
        usuario.add(bg);
        usuario.setVisible(true);
        //endregion

    }

    public void addToUsuario(JComponent x) {
        bg.add(x);
        usuario.add(bg);
    }

    public JPanel getInfo() {
        return info;
    }

    public void setInfo(JPanel info) {
        this.info = info;
    }

    public JPanel getBg() {
        return bg;
    }

    public void setBg(JPanel bg) {
        this.bg = bg;
    }
}
