package GUI;

import DataBase.DVO.Pacientes;

import javax.swing.*;
import java.awt.*;

public class GUIPaciente extends GUIUsuario {

    private JPanel citas,anotaciones,pedir;
    private JTabbedPane tabsPaciente;
    private JLabel  lcitas,lanotaciones,lpedir;
    private JLabel nombre,apellidos,fechaNacimiento,enfermedad,numeroSS,dni;
    private Font general;
    private Pacientes paciente;

    public GUIPaciente(Pacientes paciente){


        //regionPanels
        //Citas
        citas = new JPanel();
        citas.setLayout(null);
        //Anotaciones
        anotaciones = new JPanel();
        anotaciones.setLayout(null);
        //Añadir
        pedir = new JPanel();
        pedir.setLayout(null);
        //endregion



        //Labels
        //region LabelsTABS
        lcitas = new JLabel("Citas");
        lcitas.setFont(new Font("Sans-Serif",Font.BOLD,15));
        lanotaciones = new JLabel("Anotaciones");
        lanotaciones.setFont(new Font("Sans-Serif",Font.BOLD,15));
        lpedir = new JLabel("Pedir cita");
        lpedir.setFont(new Font("Sans-Serif",Font.BOLD,15));
        //endregion

        //regionLabelsInfo
        general = new Font("Sans-Serif",Font.BOLD,15);

        nombre = new JLabel("Nombre: ");
        apellidos = new JLabel("Apellidos: ");
        fechaNacimiento = new JLabel("Fecha de Nacimiento: ");
        enfermedad = new JLabel("Enfermedad: ");
        numeroSS = new JLabel("Nº Seguridad Social: ");
        dni = new JLabel("DNI: ");


        nombre.setFont(general);
        apellidos.setFont(general);
        fechaNacimiento.setFont(general);
        enfermedad.setFont(general);
        numeroSS.setFont(general);
        dni.setFont(general);


        //endregion




        //Panel Info

        getInfo().add(nombre);
        getInfo().add(apellidos);
        getInfo().add(fechaNacimiento);
        getInfo().add(enfermedad);
        getInfo().add(numeroSS);
        getInfo().add(dni);





        //regionTabs
        tabsPaciente = new JTabbedPane();
        tabsPaciente.setBounds(50,400,820,450);
        tabsPaciente.add(citas);
        tabsPaciente.add(anotaciones);
        tabsPaciente.add(pedir);

        tabsPaciente.setTabComponentAt(0,lcitas);
        tabsPaciente.setTabComponentAt(1,lanotaciones);
        tabsPaciente.setTabComponentAt(2,lpedir);
        //endregion

        addToUsuario(tabsPaciente);
        GUIUsuario();
    }
}
