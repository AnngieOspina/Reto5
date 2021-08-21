package vista;

import javax.swing.*;

import controlador.ControladorRequerimientos;

import java.awt.event.*;


public class VistaPrincipal extends JFrame implements ActionListener {

    private JTextArea areaIntroduccion;
    private JLabel labelTitulo;
    private JButton botonAceptar;
    private ControladorRequerimientos controlador;
    
    
    public VistaPrincipal() {
        controlador= new ControladorRequerimientos();

        setSize(480,400);
        setTitle("Reto 5 ");
        setLocale(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        labelTitulo = new JLabel("Misión TIC ");
        labelTitulo.setBounds(60,40, 300, 30);
        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));
		add(labelTitulo);

        areaIntroduccion = new JTextArea(" Tripulante: Anngie Carolina Ospina Suarez \n Grupo: G57 \n\n\n    ¡GRACIAS POR VER!" );

		areaIntroduccion.setBounds(50, 90, 380, 140);
		areaIntroduccion.setEditable(false);
        areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 12));
		areaIntroduccion.setLineWrap(true);
		
		areaIntroduccion.setWrapStyleWord(true);
		add(areaIntroduccion);

        botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(170, 280, 120, 25);
		add(botonAceptar);
		botonAceptar.addActionListener(this);




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonAceptar){
            controlador.mostrarVentana();

        }        
    }
    
}
