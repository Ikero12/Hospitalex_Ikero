package gestionDatos;

import GUI.GUIPaciente;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PedirCita {

    private static final String CARPETA = "src/main/resources/imagenes/".replace("/", File.separator);


    private JComboBox pedirTipo;
    public static JPanel PanelPedirCita(){
        //Declaración de componentes
        Font general = new Font("Sans-Serif",Font.BOLD,18);
        Font general2 = new Font("Sans-Serif",Font.PLAIN,15);

        String [] tipos = {"Psicologia","Traumatologia","Consulta",};
        JComboBox pedirTipo = new JComboBox(tipos);
        JLabel pedirFecha = new JLabel("Introducir Fecha(yyyy-mm-dd): ");
        JLabel pedirDni = new JLabel("Introduzca su DNI: ");
        JLabel pedirtipo= new JLabel("Tipo de cita: ");
        JLabel labelBg = new JLabel();
        JTextField escribirFecha = new JTextField();
        JTextField escribirDni = new JTextField();


        JPanel panelPedirCita = new JPanel();
        panelPedirCita.setBounds(0,0,840,450);
        panelPedirCita.setLayout(null);
        ImageIcon bg = new ImageIcon(CARPETA +File.separator+ "bgañadir.jpg");
        labelBg.setIcon(bg);
        labelBg.setBounds(0,0,840,450);
        panelPedirCita.setBackground(Color.white);






        //Instancia de componentes


        pedirFecha.setBounds(20,20,370,20);
        pedirDni.setBounds(20,60,200,20);
        pedirtipo.setBounds(20,100,190,22);
        pedirTipo.setBounds(400,100,320,32);

        pedirFecha.setFont(general);
        pedirTipo.setFont(general);
        pedirDni.setFont(general);
        pedirtipo.setFont(general);



        escribirDni.setBounds(400,60,600,20);
        escribirFecha.setBounds(400,20,320,20);

        escribirDni.setFont(general2);
        escribirFecha.setFont(general2);








        panelPedirCita.add(escribirDni);
        panelPedirCita.add(escribirFecha);
        panelPedirCita.add(pedirFecha);
        panelPedirCita.add(pedirDni);
        panelPedirCita.add(pedirTipo);
        panelPedirCita.add(pedirtipo);




        panelPedirCita.add(labelBg);
        return panelPedirCita;
    }
}
