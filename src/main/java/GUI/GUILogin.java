package GUI;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILogin {
    private JFrame window;
    private JPanel userpanel;
    private JButton bconnect;
    private JTextField tfdni;
    private JPasswordField pfpw;
    private JLabel ldni,lpw,logo,luserlogo,luserpassword,lbackground;

    private JCheckBox recordar;
    private String[]opciones = {"Médico","Enfermer@","Paciente"};
    private JComboBox personas = new JComboBox<>(opciones);
    private JLabel error = new JLabel("");


//Mensaje de error: "*Contraseña incorrecta o usuario inexistente"
    //Al final de cada apartado se añaden al mainPanel.

    public GUILogin(){

        //Declaración de componentes
        window = new JFrame("Hospitalex Ikero");
        window.setSize(1000,950);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);

        //panel
        userpanel = new JPanel();
        lbackground = new JLabel();
        ImageIcon bgicon = new ImageIcon("bgmaybe.jpg");
        lbackground.setIcon(bgicon);
        lbackground.setBounds(0,0,1000,950);
        userpanel.setSize(1000,950);
        userpanel.setLayout(null);

        //Combobox
        personas.setBounds(380,425,300,35);
        personas.setOpaque(false);
        JTextField boxField = (JTextField)personas.getEditor().getEditorComponent();
        boxField.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1.0f)));
        userpanel.add(personas);

        //Chechbox
        recordar = new JCheckBox("Recordarme");
        recordar.setBounds(475,650,150,15);
        recordar.setOpaque(false);
        recordar.setToolTipText("La próxima vez que inicies sesión te saltarás esta pantalla. Recuerda desconectarte manualmente para evitar que te roben tus datos.");

        recordar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox jc = (JCheckBox) e.getSource();
                if(jc.isSelected()){
                    //Al loggear genera archivo que automáticamente loggea
                }

            }
        });
        userpanel.add(recordar);


        //button
        bconnect = new JButton("Connect");
        bconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aquí va la conexión a la base de datos y el cambio de window.
            }
        });
        bconnect.setBounds(475,700,100,50);
        userpanel.add(bconnect);

        //Textfields
        tfdni = new JTextField();
        pfpw = new JPasswordField();

        tfdni.setBounds(380,500,300,30);
        pfpw.setBounds(380,600,300,30);
        tfdni.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                tfdni.requestFocus();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }
            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });


        userpanel.add(tfdni);
        userpanel.add(pfpw);

        //Labels
        ldni = new JLabel("DNI: ");
        lpw = new JLabel("Password: ");
        error.setBounds(420,630,300,20);
        error.setForeground(Color.red);
        error.setFont(new Font("sans-Serif", Font.PLAIN, 10));
        ldni.setBounds(380,470,100,30);
        lpw.setBounds(380,570,100,30);

        userpanel.add(ldni);
        userpanel.add(lpw);
        userpanel.add(error);


        //Logo
        ImageIcon icon = new ImageIcon("hospitalex ikero.png");
        ImageIcon us = new ImageIcon("username.png");
        ImageIcon pw = new ImageIcon("password.png");

        luserlogo = new JLabel();
        luserpassword = new JLabel();
        logo = new JLabel();

        luserpassword.setIcon(pw);
        luserpassword.setBounds(334,600,30,30);
        luserlogo.setIcon(us);
        luserlogo.setBounds(335,500,30,30);

        logo.setIcon(icon);
        logo.setBounds(420,50,300,300);

        userpanel.add(luserlogo);
        userpanel.add(luserpassword);
        userpanel.add(logo);
        userpanel.add(lbackground);


        window.add(userpanel);
        window.setVisible(true);

    }
    public JComboBox getPersonas() {
        return personas;
    }

    public void setPersonas(JComboBox personas) {
        this.personas = personas;
    }

    public JLabel getError() {
        return error;
    }

    public void setError(JLabel error) {
        this.error = error;
    }
}
