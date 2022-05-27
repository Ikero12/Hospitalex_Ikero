package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIPaciente extends GUIUsuario {

    private JPanel citas,anotaciones,pedir;
    private JTabbedPane tabsPaciente;
    private JLabel  lcitas,lanotaciones,lpedir;

    public GUIPaciente(){


        //Panels
        //Citas
        citas = new JPanel();
        citas.setLayout(null);
        //Anotaciones
        anotaciones = new JPanel();
        anotaciones.setLayout(null);
        //Añadir
        pedir = new JPanel();
        pedir.setLayout(null);


        //Labels
        //Labels
        lcitas = new JLabel("Citas");
        lcitas.setFont(new Font("Sans-Serif",Font.BOLD,15));
        lanotaciones = new JLabel("Anotaciones");
        lanotaciones.setFont(new Font("Sans-Serif",Font.BOLD,15));
        lpedir = new JLabel("Pedir cita");
        lpedir.setFont(new Font("Sans-Serif",Font.BOLD,15));

        //Tabs
        tabsPaciente = new JTabbedPane();
        tabsPaciente.setBounds(50,400,820,450);
        tabsPaciente.add(citas);
        tabsPaciente.add(anotaciones);
        tabsPaciente.add(pedir);

        tabsPaciente.setTabComponentAt(0,lcitas);
        tabsPaciente.setTabComponentAt(1,lanotaciones);
        tabsPaciente.setTabComponentAt(2,lpedir);


        addToUsuario(tabsPaciente);
        GUIUsuario();
    }
}
