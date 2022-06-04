package gestionDatos;

import DataBase.DAO.DAOCitas;
import DataBase.DAO.DAOMedicos;
import DataBase.DVO.Citas;
import DataBase.DVO.Pacientes;
import GUI.GUIPaciente;
import logIn.user.UserPaciente;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class PedirCita {

    private static final String CARPETA = "src/main/resources/imagenes/".replace("/", File.separator);


    /**
     * Genera un panel donde el paciente puede pedir cita
     * @param paciente GUI desde donde se lanza, se emplea para actualizar la tabla de citas una vez añadida
     * @return El pae con los campos para pedir la cita
     */
    public static JPanel PanelPedirCita(GUIPaciente paciente){
        //Declaración de componentes
        Font general = new Font("Sans-Serif",Font.BOLD,18);
        Font general2 = new Font("Sans-Serif",Font.PLAIN,15);

        String [] tipos = {"Psicologia","Traumatologia","Consulta",};
        JComboBox pedirTipo = new JComboBox(tipos);
        JLabel pedirFecha = new JLabel("Introducir Fecha(yyyy/mm/dd): ");
        JLabel pedirDni = new JLabel("Introduzca su DNI: ");
        JLabel pedirtipo= new JLabel("Tipo de cita: ");
        JLabel labelBg = new JLabel();
        JButton pedirCita = new JButton("Pedir cita");
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


        pedirFecha.setBounds(40,20,370,22);
        pedirDni.setBounds(40,60,200,22);
        pedirtipo.setBounds(40,100,190,22);
        pedirTipo.setBounds(440,100,320,32);

        pedirFecha.setFont(general);
        pedirTipo.setFont(general);
        pedirDni.setFont(general);
        pedirtipo.setFont(general);



        escribirDni.setBounds(440,60,320,20);
        escribirFecha.setBounds(440,20,320,20);

        escribirDni.setFont(general2);
        escribirFecha.setFont(general2);



        pedirCita.setBounds(345,350,150,60);
        pedirCita.setFont(general);



        //regionAdd
        panelPedirCita.add(escribirDni);
        panelPedirCita.add(escribirFecha);
        panelPedirCita.add(pedirFecha);
        panelPedirCita.add(pedirDni);
        panelPedirCita.add(pedirTipo);
        panelPedirCita.add(pedirtipo);
        panelPedirCita.add(pedirCita);
        //endregion


        //regionConfigBoton
        pedirCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DAOCitas citas = new DAOCitas();

                //Es necesario tener una cita añadida previamente sino no funciona.
                Citas cita = new Citas(citas.select().get(citas.select().size()-1).getIdCita()+1
                        ,RandomMedico()
                        ,escribirDni.getText()
                        ,escribirFecha.getText()
                        ,tipos[pedirTipo.getSelectedIndex()]);



                for(int i=0;i<citas.select().size();i++){
                    if(cita.getFecha().equals(citas.select().get(i).getFecha())){
                        JOptionPane.showMessageDialog(panelPedirCita
                                ,"La fecha escogida ya está ocupada"
                                ,"Hospitalex Iker"
                                ,JOptionPane.WARNING_MESSAGE);
                        break;
                    }else{
                        JOptionPane.showMessageDialog(panelPedirCita
                                ,"Cita pedida Satisfactoriamente"
                                ,"Hospitalex Iker"
                                ,JOptionPane.INFORMATION_MESSAGE);
                        citas.insert(cita);

                        paciente.setCitas();
                        break;
                    }
                }

            }
        });
        //endregion

        panelPedirCita.add(labelBg);
        return panelPedirCita;
    }

    /**
     * Devuelve un medico aleatorio
     * @return un medico aleatorio
     */
    public static String RandomMedico(){

        int numRandom = (int)(Math.random()*new DAOMedicos().select().size());
        String random = new DAOMedicos().select().get(numRandom).getDni();

        return random;
    }


}
