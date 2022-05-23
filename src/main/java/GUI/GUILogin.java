package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILogin {
    private JFrame window;
    private JPanel userpanel;
    private JButton bconnect;
    private JTextField tfdni,tfpw;
    private JLabel ldni,lpw,logo;



    public void GUILogin(){
        //Declaración de componentes
        window = new JFrame("Hospitalex Ikero");
        window.setSize(1000,950);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);

        //panel
        userpanel = new JPanel();
        userpanel.setBackground(Color.white);
        userpanel.setSize(1000,950);
        userpanel.setLayout(null);

        //button
        bconnect = new JButton("Connect");
        bconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aquí va la conexión a la base de datos y el cambio de window.
            }
        });
        bconnect.setBounds(450,700,100,50);
        userpanel.add(bconnect);

        //Textfields
        tfdni = new JTextField();
        tfpw = new JTextField();
        tfdni.setBounds(350,500,300,30);
        tfpw.setBounds(350,600,300,30);
        userpanel.add(tfdni);
        userpanel.add(tfpw);

        //Labels
        ldni = new JLabel("DNI: ");
        lpw = new JLabel("Password: ");
        //ldni.setFont("Roboto");
        ldni.setBounds(350,470,100,30);
        lpw.setBounds(350,570,100,30);
        userpanel.add(ldni);
        userpanel.add(lpw);


        //Logo
        ImageIcon icon = new ImageIcon("hospitalex ikero.png");
        logo = new JLabel();
        logo.setIcon(icon);
        logo.setBounds(400,50,300,300);
        userpanel.add(logo);


        window.add(userpanel);
        window.setVisible(true);

    }

}
