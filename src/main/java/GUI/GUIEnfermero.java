package GUI;

import DataBase.DVO.Enfermeros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIEnfermero extends GUIUsuario{
    private JPanel ingresos,anotaciones,anhadir;
    private JTextField busqueda = new JTextField("Buscar paciente");
    private JTabbedPane tabsEnfermero;
    private JLabel  lingresos,lanotaciones,lanhadir;
    private Enfermeros enfermero;
    private Font general;
    private JLabel nombre,apellidos,fechaNacimiento,planta,dni;
    private JLabel actualnombre,actualapellidos,actualfechaNacimiento,actualplanta,actualdni;
    public GUIEnfermero(Enfermeros enfermero){

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


        //regionLabelsInfo
        general = new Font("Sans-Serif",Font.BOLD,20);

        nombre = new JLabel("Nombre: ");
        apellidos = new JLabel("Apellidos: ");
        fechaNacimiento = new JLabel("Fecha de Nacimiento: ");
        planta = new JLabel("Planta asignada: ");
        dni = new JLabel("DNI: ");


        nombre.setFont(general);
        apellidos.setFont(general);
        fechaNacimiento.setFont(general);
        planta.setFont(general);

        dni.setFont(general);



        nombre.setBounds(20,20,150,20);
        apellidos.setBounds(20,60,150,20);
        fechaNacimiento.setBounds(20,100,220,20);
        dni.setBounds(20,140,150,20);
        planta.setBounds(20,180,290,23);

        actualnombre = new JLabel(enfermero.getNombre());
        actualapellidos = new JLabel(enfermero.getApellidos());
        actualfechaNacimiento = new JLabel(enfermero.getFechaNacimiento());
        actualplanta = new JLabel(enfermero.getPlanta());
        actualdni = new JLabel(enfermero.getDni());


        actualnombre.setFont(general);
        actualapellidos.setFont(general);
        actualfechaNacimiento.setFont(general);
        actualplanta.setFont(general);
        actualdni.setFont(general);


        actualnombre.setBounds(50,20,150,20);
        actualapellidos.setBounds(50,60,150,20);
        actualfechaNacimiento.setBounds(50,100,220,20);
        actualdni.setBounds(50,140,150,20);
        actualplanta.setBounds(50,180,290,23);




        //endregion



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

    public JTextField getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(JTextField busqueda) {
        this.busqueda = busqueda;
    }
}
