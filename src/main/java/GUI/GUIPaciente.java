package GUI;

import DataBase.DAO.DAOPacientes;
import DataBase.DVO.Pacientes;

import javax.swing.*;
import java.awt.*;

public class GUIPaciente extends GUIUsuario {

    private JPanel citas,pedir;
    private JTabbedPane tabsPaciente;
    private JLabel  lcitas,lpedir;
    private JLabel nombre,apellidos,fechaNacimiento,enfermedad,numeroSS,dni,fechaMuerte;
    private JLabel actualnombre,actualapellidos,actualfechaNacimiento,actualenfermedad,actualnumeroSS,actualdni,actualfechaMuerte;
    private Font general;
    private Pacientes paciente;

    public GUIPaciente(Pacientes paciente,boolean isSearched){


        //regionPanels
        //Citas
        citas = new JPanel();
        citas.setLayout(null);
        //Añadir
        pedir = new JPanel();
        pedir.setLayout(null);
        //endregion



        //Labels
        //region LabelsTABS
        lcitas = new JLabel("Citas");
        lcitas.setFont(new Font("Sans-Serif",Font.BOLD,15));
        lpedir = new JLabel("Pedir cita");
        lpedir.setFont(new Font("Sans-Serif",Font.BOLD,15));
        //endregion

        //regionLabelsInfo
        general = new Font("Sans-Serif",Font.BOLD,20);

        nombre = new JLabel("Nombre: ");
        apellidos = new JLabel("Apellidos: ");
        fechaNacimiento = new JLabel("Fecha de Nacimiento: ");
        enfermedad = new JLabel("Enfermedad: ");
        numeroSS = new JLabel("Nº Seguridad Social: ");
        dni = new JLabel("DNI: ");
        fechaMuerte = new JLabel();

        if(paciente.getFechaMuerte()!=null){
            fechaMuerte = new JLabel("Fecha de muerte: ");
        }

        nombre.setFont(general);
        apellidos.setFont(general);
        fechaNacimiento.setFont(general);
        enfermedad.setFont(general);
        numeroSS.setFont(general);
        dni.setFont(general);
        fechaMuerte.setFont(general);

        nombre.setBounds(20,20,150,20);
        apellidos.setBounds(20,60,150,20);
        fechaNacimiento.setBounds(20,100,280,20);
        dni.setBounds(20,140,150,20);
        numeroSS.setBounds(20,180,290,23);
        enfermedad.setBounds(20,220,170,20);
        fechaMuerte.setBounds(20,260,250,20);

        actualnombre = new JLabel(paciente.getNombre());
        actualapellidos = new JLabel(paciente.getApellidos());
        actualfechaNacimiento = new JLabel(paciente.getFechaNacimiento());
        actualdni = new JLabel(paciente.getDni());
        actualnumeroSS = new JLabel(paciente.getNumeroSeguridadSocial());
        actualenfermedad = new JLabel(paciente.getEnfermedad());
        actualfechaMuerte = new JLabel(paciente.getFechaMuerte());


        actualnombre.setFont(general);
        actualapellidos.setFont(general);
        actualfechaNacimiento.setFont(general);
        actualdni.setFont(general);
        actualnumeroSS.setFont(general);
        actualenfermedad.setFont(general);
        actualfechaMuerte.setFont(general);

        actualnombre.setBounds(350,20,150,20);
        actualapellidos.setBounds(350,60,150,20);
        actualfechaNacimiento.setBounds(350,100,220,20);
        actualdni.setBounds(350,140,150,20);
        actualnumeroSS.setBounds(350,180,290,23);
        actualenfermedad.setBounds(350,220,150,20);
        actualfechaMuerte.setBounds(350,260,200,20);



        //endregion





        //regionPanel Info

        getInfo().add(nombre);
        getInfo().add(apellidos);
        getInfo().add(fechaNacimiento);
        getInfo().add(dni);
        getInfo().add(numeroSS);
        getInfo().add(enfermedad);
        getInfo().add(fechaMuerte);
        getInfo().add(actualnombre);
        getInfo().add(actualapellidos);
        getInfo().add(actualfechaNacimiento);
        getInfo().add(actualenfermedad);
        getInfo().add(actualnumeroSS);
        getInfo().add(actualdni);
        getInfo().add(actualfechaMuerte);



        //endregion

        //regionTabs
        tabsPaciente = new JTabbedPane();
        tabsPaciente.setBounds(50,400,820,450);
        tabsPaciente.add(citas);
        tabsPaciente.add(pedir);

        tabsPaciente.setTabComponentAt(0,lcitas);
        tabsPaciente.setTabComponentAt(1,lpedir);
        //endregion

        //regionisSearched
        if(isSearched){
            tabsPaciente.removeTabAt(1);
            super.getDesconexion().setEnabled(false);
            super.getDesconexion().setVisible(false);

        }


        //endregion

        addToUsuario(tabsPaciente);
        GUIUsuario();
    }

    public GUIPaciente() {

    }
}
