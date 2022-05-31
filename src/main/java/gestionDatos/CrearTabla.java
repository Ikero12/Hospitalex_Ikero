package gestionDatos;

import DataBase.DAO.DAOPersonas;
import DataBase.DVO.Citas;
import DataBase.DVO.Ingresan;
import logIn.user.IUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class CrearTabla {

        public static final String CITAS="Citas";
        public static final String INGRESOS="Ingresos";

    public static JScrollPane createTable(IUsuario usuario, String tipo) {

        DefaultTableModel model;

        if (tipo.equals(CITAS)) model = createModelCitas(usuario);
        else model = createModelIngresos(usuario);

        JTable table = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        return new JScrollPane(table);

    }

    public static DefaultTableModel createModelCitas(IUsuario usuario) {

        ArrayList<Citas> citas = usuario.getUserCitas();
        String[] title = new String[]{"Paciente", "Medico", "Tipo", "Fecha"};
        String[][] data= new String[citas.size()][4];

        for (int i=0;i<citas.size();i++){

            data[i][1]=new DAOPersonas().getCompleteName(citas.get(i).getDniMedico());
            data[i][2]=new DAOPersonas().getCompleteName(citas.get(i).getDniPaciente());
            data[i][3]=citas.get(i).getTipo();
            data[i][4]=citas.get(i).getFecha();
        }

        return new DefaultTableModel(data, title);
    }

    public static DefaultTableModel createModelIngresos(IUsuario usuario) {

        ArrayList<Ingresan> ingresos = usuario.getUserIngresos();
        String[] title = new String[]{"DNI", "Nombre", "Apellidos", "Dolencia", "Planta", "Piso", "Fecha Ingreso", "Fecha Alta"};

        String[][] data= new String[ingresos.size()][4];

        for (int i=0;i<ingresos.size();i++){

            data[i][1]="";
            data[i][2]="";
            data[i][3]="";
            data[i][4]="";
            data[i][5]="";
            data[i][6]="";
            data[i][7]="";
            data[i][8]="";
        }



        return new DefaultTableModel(data, title);
    }



}
