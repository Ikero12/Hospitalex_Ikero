package gestionDatos;

import DataBase.DAO.DAOPacientes;
import DataBase.DAO.DAOPersonas;
import DataBase.DVO.Pacientes;
import DataBase.DVO.Personas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class añadirPaciente {
    //JTextField

    private static final String CARPETA = "src/main/resources/imagenes/".replace("/", File.separator);
    public static JPanel añadirPaciente(){
        Font general = new Font("Sans-Serif",Font.BOLD,22);
        Font general2 = new Font("Sans-Serif",Font.PLAIN,15);

        ImageIcon fondo = new ImageIcon(CARPETA +File.separator+ "bgañadir.jpg");
        JLabel fondobg = new JLabel();
        fondobg.setIcon(fondo);
        fondobg.setBounds(0,0,840,450);

        JPanel panelAñadir = new JPanel();
        panelAñadir.setBackground(Color.white);
        panelAñadir.setSize(820,450);
        panelAñadir.setLayout(null);

        JTextField escribirDNI = new JTextField();
        JTextField  escribirApellido = new JTextField();
        JTextField escribirFechaNacimiento = new JTextField();
        JTextField escribirNombre = new JTextField();
        JPasswordField escribirContraseña = new JPasswordField();
        JTextField escribirEnfermedad = new JTextField();
        JTextField escribirFechaMuerte = new JTextField();
        JTextField escribirNSS = new JTextField();


        JLabel añadirDNI = new JLabel("DNI: ");
        JLabel añadirNombre = new JLabel("Nombre: ");
        JLabel añadirApellido = new JLabel("Apellido:");
        JLabel añadirFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        JLabel añadirContraseña = new JLabel("Contraseña:");
        JLabel añadirEnfermedad = new JLabel("Enfermedad: ");
        JLabel añadirFechaMuerte = new JLabel("Fecha de fallecimiento: ");
        JLabel añadirNSS = new JLabel("Nº Seguridad Social: ");

        añadirDNI.setFont(general);
        añadirNombre.setFont(general);
        añadirApellido.setFont(general);
        añadirFechaNacimiento.setFont(general);
        añadirContraseña.setFont(general);
        añadirEnfermedad.setFont(general);
        añadirFechaMuerte.setFont(general);
        añadirNSS.setFont(general);

        escribirApellido.setFont(general2);
        escribirNombre.setFont(general2);
        escribirDNI.setFont(general2);
        escribirFechaNacimiento.setFont(general2);
        escribirContraseña.setFont(general2);
        escribirEnfermedad.setFont(general2);
        escribirFechaMuerte.setFont(general2);
        escribirNSS.setFont(general2);



        añadirDNI.setBounds(10,30,150,20);
        añadirNombre.setBounds(10,70,250,20);
        añadirApellido.setBounds(10,110,250,20);
        añadirFechaNacimiento.setBounds(10,150,310,20);
        añadirContraseña.setBounds(10,190,290,20);
        añadirEnfermedad.setBounds(10,230,290,20);
        añadirFechaMuerte.setBounds(10,270,350,20);
        añadirNSS.setBounds(10,310,350,20);


        escribirDNI.setBounds(460,30,290,20);
        escribirNombre.setBounds(460,70,290,20);
        escribirApellido.setBounds(460,110,290,20);
        escribirFechaNacimiento.setBounds(460,150,290,20);
        escribirContraseña.setBounds(460,190,290,20);
        escribirEnfermedad.setBounds(460,230,290,20);
        escribirFechaMuerte.setBounds(460,270,290,20);
        escribirNSS.setBounds(460,310,290,20);




        JButton botonAñadir = new JButton("Añadir");
        botonAñadir.setBounds(360,370,110,30);
        botonAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAOPersonas daope = new DAOPersonas();
                DAOPacientes daopa = new DAOPacientes();

                Pacientes pa = new Pacientes(escribirDNI.getText(),Password.hashPassword(escribirContraseña.getText());,escribirNombre.getText()
                        ,escribirApellido.getText(),escribirFechaNacimiento.getText(),escribirNSS.getText()
                        ,escribirEnfermedad.getText(),escribirFechaMuerte.getText());

                if(new DAOPacientes().get(pa.getDni())!=null){
                    daope.update(pa);
                    daopa.update(pa);
                    JOptionPane.showMessageDialog(botonAñadir,"El paciente ya existía, la base de datos ha sido actualizada","Hospitalex Ikero",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    daopa.insert(pa);
                    daope.insert(pa);
                    JOptionPane.showMessageDialog(botonAñadir,"Paciente nuevo insertado","Hospitalex Ikero",JOptionPane.INFORMATION_MESSAGE);
                }

                escribirNombre.setText("");
                escribirApellido.setText("");
                escribirDNI.setText("");
                escribirFechaNacimiento.setText("");
                escribirContraseña.setText("");
                escribirNSS.setText("");
                escribirEnfermedad.setText("");
                escribirFechaMuerte.setText("");
            }
        });

        panelAñadir.add(botonAñadir);
        panelAñadir.add(añadirApellido);
        panelAñadir.add(añadirNombre);
        panelAñadir.add(añadirFechaNacimiento);
        panelAñadir.add(añadirDNI);
        panelAñadir.add(añadirContraseña);
        panelAñadir.add(escribirNombre);
        panelAñadir.add(escribirApellido);
        panelAñadir.add(escribirDNI);
        panelAñadir.add(escribirFechaNacimiento);
        panelAñadir.add(escribirContraseña);
        panelAñadir.add(añadirEnfermedad);
        panelAñadir.add(añadirFechaMuerte);
        panelAñadir.add(escribirEnfermedad);
        panelAñadir.add(escribirFechaMuerte);
        panelAñadir.add(escribirNSS);
        panelAñadir.add(añadirNSS);

        panelAñadir.add(fondobg);



        return panelAñadir;

    }

}
