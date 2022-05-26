package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIEnfermero extends GUIUsuario{
    private JPanel ingresos,anotaciones,anhadir;
    private JTextField busqueda = new JTextField("Buscar paciente");
    private JTabbedPane tabsEnfermero;
    private JLabel  lingresos,lanotaciones,lanhadir;

    public GUIEnfermero(){

        //Busqueda de pacientes
        busqueda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                busqueda.setText("");
            }
        });
        busqueda.setBounds(720,400,150,20);
        busqueda.setFont(new Font("Sans-Serif",Font.PLAIN,12));


        //Labels
        lingresos = new JLabel("Ingresos");
        lingresos.setFont(new Font("Sans-Serif",Font.BOLD,15));
        lanotaciones = new JLabel("Anotaciones");
        lanotaciones.setFont(new Font("Sans-Serif",Font.BOLD,15));
        lanhadir = new JLabel("Añadir");
        lanhadir.setFont(new Font("Sans-Serif",Font.BOLD,15));


        //Panels
        //ingresos
        ingresos = new JPanel();
        ingresos.setLayout(null);
        //Anotaciones
        anotaciones = new JPanel();
        anotaciones.setLayout(null);
        //Añadir
        anhadir = new JPanel();
        anhadir.setLayout(null);

        //Tabs
        tabsEnfermero = new JTabbedPane();
        tabsEnfermero.setBounds(50,400,820,450);

        tabsEnfermero.add(ingresos);
        tabsEnfermero.add(anotaciones);
        tabsEnfermero.add(anhadir);

        tabsEnfermero.setTabComponentAt(0,lingresos);
        tabsEnfermero.setTabComponentAt(1,lanotaciones);
        tabsEnfermero.setTabComponentAt(2,lanhadir);


        addToUsuario(busqueda);
        addToUsuario(tabsEnfermero);
        GUIUsuario();
    }
}
