package GUI;

import DataBase.DVO.Enfermeros;
import gestionDatos.BusquedaPaciente;
import gestionDatos.añadirPaciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIEnfermero extends GUIUsuario{
    private JPanel ingresos,anotaciones,anhadir;
    private JTextField busqueda = new JTextField("Buscar paciente");
    private JTabbedPane tabsEnfermero;
    private JLabel  lingresos;
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
        busqueda.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                if (keycode == KeyEvent.VK_ENTER){
                    new BusquedaPaciente(busqueda.getText(),busqueda);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        busqueda.setBounds(720,400,150,20);
        busqueda.setFont(new Font("Sans-Serif",Font.PLAIN,12));


        //Labels
        lingresos = new JLabel("Ingresos");
        lingresos.setFont(new Font("Sans-Serif",Font.BOLD,15));



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
        anhadir.add(añadirPaciente.añadirPaciente());


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
        fechaNacimiento.setBounds(20,100,290,20);
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


        actualnombre.setBounds(350,20,150,20);
        actualapellidos.setBounds(350,60,150,20);
        actualfechaNacimiento.setBounds(350,100,220,20);
        actualdni.setBounds(350,140,150,20);
        actualplanta.setBounds(350,180,290,23);




        //endregion

        //regionPanel Info

        getInfo().add(nombre);
        getInfo().add(apellidos);
        getInfo().add(fechaNacimiento);
        getInfo().add(planta);
        getInfo().add(dni);
        getInfo().add(actualnombre);
        getInfo().add(actualapellidos);
        getInfo().add(actualfechaNacimiento);
        getInfo().add(actualplanta);
        getInfo().add(actualdni);

        //endregion

        //Tabs
        tabsEnfermero = new JTabbedPane();
        tabsEnfermero.setBounds(50,400,820,450);

        tabsEnfermero.add(ingresos);

        tabsEnfermero.setTabComponentAt(0,lingresos);


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
