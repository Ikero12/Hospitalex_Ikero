package GUI;

import DataBase.DVO.Medicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMedico extends GUIUsuario{


    private JPanel citas,anotaciones,anhadir;
    private JTextField busqueda = new JTextField("Buscar paciente");
    private JTabbedPane tabsMedico;
    private JLabel  lcitas,lanotaciones,lanhadir;
    private Medicos medico;

    public GUIMedico(Medicos medico) {

        //Barra de búsqueda
        busqueda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                busqueda.setText("");
            }
        });
        busqueda.setBounds(720,400,150,20);
        busqueda.setFont(new Font("Sans-Serif",Font.PLAIN,12));


        //Labels
        lcitas = new JLabel("Citas");
        lcitas.setFont(new Font("Sans-Serif",Font.BOLD,15));
        lanotaciones = new JLabel("Anotaciones");
        lanotaciones.setFont(new Font("Sans-Serif",Font.BOLD,15));
        lanhadir = new JLabel("Añadir");
        lanhadir.setFont(new Font("Sans-Serif",Font.BOLD,15));

        //Panels
        //Citas
        citas = new JPanel();
        citas.setLayout(null);
        //Anotaciones
        anotaciones = new JPanel();
        anotaciones.setLayout(null);
        //Añadir
        anhadir = new JPanel();
        anhadir.setLayout(null);

        //Busqueda de pacientes



        //Tabs
        tabsMedico = new JTabbedPane();
        tabsMedico.setBounds(50,400,820,450);
        tabsMedico.add(citas);
        tabsMedico.add(anotaciones);
        tabsMedico.add(anhadir);

        tabsMedico.setTabComponentAt(0,lcitas);
        tabsMedico.setTabComponentAt(1,lanotaciones);
        tabsMedico.setTabComponentAt(2,lanhadir);



        addToUsuario(busqueda);
        addToUsuario(tabsMedico);
        GUIUsuario();







    }

    public JTextField getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(JTextField busqueda) {
        this.busqueda = busqueda;
    }
}
