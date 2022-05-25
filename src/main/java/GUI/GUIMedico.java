package GUI;

import javax.swing.*;

public class GUIMedico extends GUIUsuario{

    //private GUIUsuario loginMedico=new GUIUsuario();
    private JPanel bgmedico;

    public GUIMedico() {
       JPanel bgmedico = new JPanel();
        bgmedico.setSize(200,200);
        JLabel prueba = new JLabel("Esto es una prueba");
        prueba.setBounds(150,150,300,300);
        bgmedico.add(prueba);

        addToUsuario(bgmedico);
        GUIUsuario();







    }
}
