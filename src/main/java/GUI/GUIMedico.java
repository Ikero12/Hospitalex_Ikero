package GUI;

import DataBase.DAO.DAOPacientes;
import DataBase.DVO.Medicos;
import gestionDatos.BusquedaPaciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import gestionDatos.Ingresos;
import logIn.Password;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton ingresar,darAlta,cambiarContrasenha;

    public GUIMedico(Medicos medico) {

        //Barra de búsqueda
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

        //regionButton
        darAlta = new JButton("Dar el alta");
        ingresar = new JButton("Ingresar");
        cambiarContrasenha = new JButton("Cambiar contraseña");

        cambiarContrasenha.setBounds(235,400,165,20);
        darAlta.setBounds(570,400,130,20);
        ingresar.setBounds(420,400,130,20);
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = null;
                String planta = null;
                try{
                        dni = JOptionPane.showInputDialog(ingresar,"Introduzca el dni del paciente a ingresar","Hospitalex Ikero", JOptionPane.QUESTION_MESSAGE);
                        planta = JOptionPane.showInputDialog(new DAOPacientes().get(dni).getNombre()
                                + " " + new DAOPacientes().get(dni).getApellidos()
                                + " es el paciente a ingresar.\n"
                                + "En que planta será ingresado?");
                    }catch(NullPointerException x){
                        x.printStackTrace();
                }finally {
                        Ingresos.ingresarPaciente(dni,planta);
                    }

            }
        });

        darAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = JOptionPane.showInputDialog(darAlta,"Introducir DNI del paciente que se le dio el alta: ","Hospitalex Ikero", JOptionPane.QUESTION_MESSAGE);
                Ingresos.darAltaPaciente(dni);
            }
        });

        cambiarContrasenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Password.changePassword(medico,GUIMedico.super.getInfo());
            }
        });









        //endregion

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


        //regionAñadir



        //endregion


        //regionTabs
        tabsMedico = new JTabbedPane();
        tabsMedico.setBounds(50,400,820,450);
        tabsMedico.add(citas);
        tabsMedico.add(anhadir);

        tabsMedico.setTabComponentAt(0,lcitas);
        tabsMedico.setTabComponentAt(1,lanhadir);

        addToUsuario(cambiarContrasenha);
        addToUsuario(darAlta);
        addToUsuario(ingresar);
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
