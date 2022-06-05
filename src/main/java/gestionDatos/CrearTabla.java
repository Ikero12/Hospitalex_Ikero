package gestionDatos;

import DataBase.DAO.DAOPacientes;
import DataBase.DAO.DAOPersonas;
import DataBase.DAO.DAOPlanta;
import DataBase.DVO.Citas;
import DataBase.DVO.Ingresan;
import DataBase.DVO.Pacientes;
import DataBase.DVO.Planta;
import logIn.user.IUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class CrearTabla {

    public static final String CITAS = "Citas";
    public static final String INGRESOS = "Ingresos";


    /**
     * Crea una tabla con una barra deslizadora de los ingresos o citas del usuario
     * @param usuario quien esta ingresado
     * @param tipo Si es una cita o un ingreso lo ue deseamos
     * @return
     */
    public static JScrollPane createTable(IUsuario usuario, String tipo) {

        DefaultTableModel model;

        if (tipo.equals(CITAS)) model = createModelCitas(usuario);
        else model = createModelIngresos(usuario);

        JTable table = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        table.getTableHeader().setReorderingAllowed(false);
        return new JScrollPane(table);

    }

    /**
     * Crea un modelo de la tabla con las citas del usuario dado
     * @param usuario El usuario con cita
     * @return El modelo de la tabla
     */
    public static DefaultTableModel createModelCitas(IUsuario usuario) {

        ArrayList<Citas> citas = usuario.getUserCitas();
        String[] title = new String[]{"Paciente", "Medico", "Tipo", "Fecha"};
        String[][] data = new String[citas.size()][4];

        for (int i = 0; i < citas.size(); i++) {

            data[i][0] = new DAOPersonas().getCompleteName(citas.get(i).getDniMedico());
            data[i][1] = new DAOPersonas().getCompleteName(citas.get(i).getDniPaciente());
            data[i][2] = citas.get(i).getTipo();
            data[i][3] = citas.get(i).getFecha();
        }

        return new DefaultTableModel(data, title);
    }

    /**
     * Crea un modelo de la tabla con los ingresos del usuario dado
     * @param usuario El usuario cuyos ingresos deseamos ver
     * @return El modelo de la tabla
     */
    public static DefaultTableModel createModelIngresos(IUsuario usuario) {

        ArrayList<Ingresan> ingresos = usuario.getUserIngresos();
        String[] title = new String[]{"DNI", "Nombre", "Apellidos", "Dolencia", "Planta", "Piso", "Fecha Ingreso", "Fecha Alta"};

        String[][] data = new String[ingresos.size()][8];

        Pacientes paciente;
        Planta planta;

        for (int i = 0; i < ingresos.size(); i++) {

            paciente = new DAOPacientes().get(ingresos.get(i).getDniPaciente());
            planta = new DAOPlanta().get(ingresos.get(i).getNombrePlanta());

            if (paciente == null || planta == null) break;
            data[i][0] = paciente.getDni();
            data[i][1] = paciente.getNombre();
            data[i][2] = paciente.getApellidos();
            data[i][3] = paciente.getEnfermedad();
            data[i][4] = planta.getNombre();
            data[i][5] = Integer.toString(planta.getPiso());
            data[i][6] = ingresos.get(i).getFechaIngreso();
            data[i][7] = ingresos.get(i).getFechaAlta();
        }

        return new DefaultTableModel(data, title);
    }


}
