package GUI;

import DataBase.DVO.Medicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIMedico extends GUIUsuario{


    private JPanel citas,anhadir;
    private JTextField busqueda = new JTextField("Buscar paciente");
    private JTabbedPane tabsMedico;
    private JLabel  lcitas,lanhadir;
    private Medicos medico;
    private Font general;
    private JLabel nombre,apellidos,fechaNacimiento,campo,dni;
    private JLabel actualnombre,actualapellidos,actualfechaNacimiento,actualcampo,actualdni;

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
        lanhadir = new JLabel("Añadir");
        lanhadir.setFont(new Font("Sans-Serif",Font.BOLD,15));

        //Panels
        //Citas
        citas = new JPanel();
        citas.setLayout(null);
        //Añadir
        anhadir = new JPanel();
        anhadir.setLayout(null);

        //Busqueda de pacientes


        //regionLabelsInfo
        general = new Font("Sans-Serif",Font.BOLD,20);

        nombre = new JLabel("Nombre: ");
        apellidos = new JLabel("Apellidos: ");
        fechaNacimiento = new JLabel("Fecha de Nacimiento: ");
        campo = new JLabel("Especialidad: ");
        dni = new JLabel("DNI: ");


        nombre.setFont(general);
        apellidos.setFont(general);
        fechaNacimiento.setFont(general);
        campo.setFont(general);
        dni.setFont(general);



        nombre.setBounds(20,20,150,20);
        apellidos.setBounds(20,60,150,20);
        fechaNacimiento.setBounds(20,100,290,20);
        dni.setBounds(20,140,150,20);
        campo.setBounds(20,180,190,20);

        actualnombre = new JLabel(medico.getNombre());
        actualapellidos = new JLabel(medico.getApellidos());
        actualfechaNacimiento = new JLabel(medico.getFechaNacimiento());
        actualcampo = new JLabel(medico.getCampo());
        actualdni = new JLabel(medico.getDni());


        actualnombre.setFont(general);
        actualapellidos.setFont(general);
        actualfechaNacimiento.setFont(general);
        actualcampo.setFont(general);

        actualdni.setFont(general);


        actualnombre.setBounds(350,20,150,20);
        actualapellidos.setBounds(350,60,150,20);
        actualfechaNacimiento.setBounds(350,100,220,20);
        actualdni.setBounds(350,140,150,20);
        actualcampo.setBounds(350,180,290,23);




        //endregion

        //regionPanel Info

        getInfo().add(nombre);
        getInfo().add(apellidos);
        getInfo().add(fechaNacimiento);
        getInfo().add(campo);
        getInfo().add(dni);
        getInfo().add(actualnombre);
        getInfo().add(actualapellidos);
        getInfo().add(actualfechaNacimiento);
        getInfo().add(actualcampo);
        getInfo().add(actualdni);

        //endregion

        //regionTabs
        tabsMedico = new JTabbedPane();
        tabsMedico.setBounds(50,400,820,450);
        tabsMedico.add(citas);
        tabsMedico.add(anhadir);

        tabsMedico.setTabComponentAt(0,lcitas);
        tabsMedico.setTabComponentAt(1,lanhadir);



        addToUsuario(busqueda);
        addToUsuario(tabsMedico);
        GUIUsuario();
        //endregion






    }

    public JTextField getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(JTextField busqueda) {
        this.busqueda = busqueda;
    }
}
