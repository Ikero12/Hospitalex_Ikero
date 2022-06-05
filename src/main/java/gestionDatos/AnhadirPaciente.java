package gestionDatos;

import DataBase.DAO.DAOPacientes;
import DataBase.DAO.DAOPersonas;
import DataBase.DVO.Pacientes;
import logIn.Password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class AnhadirPaciente {
    //JTextField

    private static final String CARPETA = "src/main/resources/imagenes/".replace("/", File.separator);

    /**
     * Pestaña donde se puede introducir un paciente a la base de datos
     * @return La pestaña con los campos para añadir el paciente
     */
    public static JPanel anhadirPaciente(){
        Font general = new Font("Sans-Serif",Font.BOLD,22);
        Font general2 = new Font("Sans-Serif",Font.PLAIN,15);

        ImageIcon fondo = new ImageIcon(CARPETA +File.separator+ "bgañadir.jpg");
        JLabel fondobg = new JLabel();
        fondobg.setIcon(fondo);
        fondobg.setBounds(0,0,840,450);

        JPanel panelAnhadir = new JPanel();
        panelAnhadir.setBackground(Color.white);
        panelAnhadir.setSize(820,450);
        panelAnhadir.setLayout(null);

        JTextField escribirDNI = new JTextField();
        JTextField  escribirApellido = new JTextField();
        JTextField escribirFechaNacimiento = new JTextField();
        JTextField escribirNombre = new JTextField();
        JPasswordField escribirContrasenha = new JPasswordField();
        JTextField escribirEnfermedad = new JTextField();
        JTextField escribirFechaMuerte = new JTextField();
        JTextField escribirNSS = new JTextField();


        JLabel anhadirDNI = new JLabel("DNI: ");
        JLabel anhadirNombre = new JLabel("Nombre: ");
        JLabel anhadirApellido = new JLabel("Apellido:");
        JLabel anhadirFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        JLabel anhadirContrasenha = new JLabel("Contraseña:");
        JLabel anhadirEnfermedad = new JLabel("Enfermedad: ");
        JLabel anhadirFechaMuerte = new JLabel("Fecha de fallecimiento: ");
        JLabel anhadirNSS = new JLabel("Nº Seguridad Social: ");

        anhadirDNI.setFont(general);
        anhadirNombre.setFont(general);
        anhadirApellido.setFont(general);
        anhadirFechaNacimiento.setFont(general);
        anhadirContrasenha.setFont(general);
        anhadirEnfermedad.setFont(general);
        anhadirFechaMuerte.setFont(general);
        anhadirNSS.setFont(general);

        escribirApellido.setFont(general2);
        escribirNombre.setFont(general2);
        escribirDNI.setFont(general2);
        escribirFechaNacimiento.setFont(general2);
        escribirContrasenha.setFont(general2);
        escribirEnfermedad.setFont(general2);
        escribirFechaMuerte.setFont(general2);
        escribirNSS.setFont(general2);



        anhadirDNI.setBounds(10,30,150,20);
        anhadirNombre.setBounds(10,70,250,20);
        anhadirApellido.setBounds(10,110,250,20);
        anhadirFechaNacimiento.setBounds(10,150,310,20);
        anhadirContrasenha.setBounds(10,190,290,20);
        anhadirEnfermedad.setBounds(10,230,290,20);
        anhadirFechaMuerte.setBounds(10,270,350,20);
        anhadirNSS.setBounds(10,310,350,20);


        escribirDNI.setBounds(460,30,290,20);
        escribirNombre.setBounds(460,70,290,20);
        escribirApellido.setBounds(460,110,290,20);
        escribirFechaNacimiento.setBounds(460,150,290,20);
        escribirContrasenha.setBounds(460,190,290,20);
        escribirEnfermedad.setBounds(460,230,290,20);
        escribirFechaMuerte.setBounds(460,270,290,20);
        escribirNSS.setBounds(460,310,290,20);




        JButton botonAnhadir = new JButton("Añadir");
        botonAnhadir.setBounds(360,370,110,30);
        botonAnhadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAOPersonas daope = new DAOPersonas();
                DAOPacientes daopa = new DAOPacientes();

                Pacientes pa = new Pacientes(escribirDNI.getText(), Password.hashPassword(escribirContrasenha.getText()),escribirNombre.getText()
                        ,escribirApellido.getText(),escribirFechaNacimiento.getText(),escribirNSS.getText()
                        ,escribirEnfermedad.getText(),escribirFechaMuerte.getText());

                if(new DAOPacientes().get(pa.getDni())!=null){
                    daope.update(pa);
                    daopa.update(pa);
                    JOptionPane.showMessageDialog(botonAnhadir,"El paciente ya existía, la base de datos ha sido actualizada","Hospitalex Ikero",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    daopa.insert(pa);
                    daope.insert(pa);
                    JOptionPane.showMessageDialog(botonAnhadir,"Paciente nuevo insertado","Hospitalex Ikero",JOptionPane.INFORMATION_MESSAGE);
                }

                escribirNombre.setText("");
                escribirApellido.setText("");
                escribirDNI.setText("");
                escribirFechaNacimiento.setText("");
                escribirContrasenha.setText("");
                escribirNSS.setText("");
                escribirEnfermedad.setText("");
                escribirFechaMuerte.setText("");
            }
        });

        panelAnhadir.add(botonAnhadir);
        panelAnhadir.add(anhadirApellido);
        panelAnhadir.add(anhadirNombre);
        panelAnhadir.add(anhadirFechaNacimiento);
        panelAnhadir.add(anhadirDNI);
        panelAnhadir.add(anhadirContrasenha);
        panelAnhadir.add(escribirNombre);
        panelAnhadir.add(escribirApellido);
        panelAnhadir.add(escribirDNI);
        panelAnhadir.add(escribirFechaNacimiento);
        panelAnhadir.add(escribirContrasenha);
        panelAnhadir.add(anhadirEnfermedad);
        panelAnhadir.add(anhadirFechaMuerte);
        panelAnhadir.add(escribirEnfermedad);
        panelAnhadir.add(escribirFechaMuerte);
        panelAnhadir.add(escribirNSS);
        panelAnhadir.add(anhadirNSS);

        panelAnhadir.add(fondobg);



        return panelAnhadir;

    }

}
