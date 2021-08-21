package vista;

import java.util.ArrayList;

import controlador.ControladorRequerimientos;

import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextArea;


import javax.swing.*;



public class VistaRequerimientos extends JFrame implements ActionListener{

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();
    
    private JButton botonCancelar, botonBuscar, botonBuscar1, botonBuscar2 , botonLimpiar;
     public ControladorRequerimientos control;
     private JLabel labelTitulo; 
     private JTextArea areaIntroduccion;
     private JPanel panel;
   

    public VistaRequerimientos() {
        control= new ControladorRequerimientos();
              
        setSize(520, 430);
		setTitle("Mision TIC 2022");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
        panel= new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        labelTitulo = new JLabel("Consultas a bases de datos");
		labelTitulo.setBounds(30,20, 300, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));
        panel.add(labelTitulo); 

        JScrollPane scroll=new JScrollPane();
        scroll.setBounds(30,60, 440, 230);
        panel.add(scroll);

        areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(100, 90, 440, 140);
		areaIntroduccion.setEditable(false);
        areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduccion.setLineWrap(true);
		areaIntroduccion.setWrapStyleWord(true);
		scroll.setViewportView(areaIntroduccion); 
		
		botonBuscar = new JButton("Requerimiento 1");
		botonBuscar.setBounds(30, 320, 130, 25);
		add(botonBuscar);
		botonBuscar.addActionListener(this);

        botonBuscar1 = new JButton("Requerimiento 2");
		botonBuscar1.setBounds(180, 320, 130, 25);
		add(botonBuscar1);
		botonBuscar1.addActionListener(this);

        botonBuscar2 = new JButton("Requerimiento 3");
		botonBuscar2.setBounds(330, 320, 130, 25);
		add(botonBuscar2);
		botonBuscar2.addActionListener(this);
        
        botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(80, 360, 120, 25);
		add(botonCancelar);
		botonCancelar.addActionListener(this);

        botonLimpiar = new JButton("Limpiar");
		botonLimpiar.setBounds(280, 360, 120, 25);
		add(botonLimpiar);
		botonLimpiar.addActionListener(this);

       
    }

    public void limpiar() {
		areaIntroduccion.setText("");
		
	}         

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonBuscar){
            try{
                ArrayList<Requerimiento_1Vo> requerimiento1 = control.consultarRequerimiento1();
                String sal= "Líderes cuyo salario es inferior al promedio del salario de todos los líderes. Salarios ordenados de forma ascendente\n\nID lider\tSalario\tCiudad\n\n";
                if(requerimiento1 != null){
                    //areaIntroduccion.setText(listString);
                    for (Requerimiento_1Vo req_1 : requerimiento1){
                        sal+=req_1.getIdLider();
                        sal+="\t";
                        sal+=req_1.getSalario();
                        sal+="\t";
                        sal+=req_1.getCiudad();
                        sal+="\n";
                    }
                areaIntroduccion.setText(sal);
                                        
                }else{
                    JOptionPane.showMessageDialog(null, "No existe ese requerimiento", "ADVERTENCIA",
                    JOptionPane.WARNING_MESSAGE);
                }



            }catch(Exception e1){
                JOptionPane.showMessageDialog(null, "Error en base de datos", "ERROR",
                JOptionPane.ERROR_MESSAGE);


            }
        }

        if(e.getSource()==botonBuscar1){
            try{
                ArrayList<Requerimiento_2Vo> requerimiento2 = control.consultarRequerimiento2();
                String sal= "Listado de materiales utilizados por los proyectos con ID 23,38,50 ordenados de forma ascendente por el ID del proyecto\n\nID Proy.\tMaterial\tPrecio Unidad\n\n";
                if(requerimiento2 != null){
                    //areaIntroduccion.setText(listString);
                    for (Requerimiento_2Vo req_2 : requerimiento2){
                        sal+=req_2.getIdProyecto();
                        sal+="\t";
                        sal+=req_2.getMaterial();
                        sal+="\t";
                        sal+=req_2.getPrecioUnidad();
                        sal+="\n";
                    }
                areaIntroduccion.setText(sal);
                                        
                }else{
                    JOptionPane.showMessageDialog(null, "No existe ese requerimiento", "ADVERTENCIA",
                    JOptionPane.WARNING_MESSAGE);
                }



            }catch(Exception e1){
                JOptionPane.showMessageDialog(null, "Error en base de datos", "ERROR",
                JOptionPane.ERROR_MESSAGE);


            }
        }

        if(e.getSource()==botonBuscar2){
            try{
                ArrayList<Requerimiento_3Vo> requerimiento3 = control.consultarRequerimiento3();
                String sal= "Promedio de salario superiores a 400.000 de los lideres agrupados por clasificación. Los promedios estan ordenados de forma descendente\n\nClasificación\tPromedio\n\n";
                if(requerimiento3 != null){
                    //areaIntroduccion.setText(listString);
                    for (Requerimiento_3Vo req_3 : requerimiento3){
                        sal+=req_3.getClasificacion();
                        sal+="\t\t";
                        sal+=Math.round(req_3.getPromedio());
                        sal+="\n";
                        
                    }
                areaIntroduccion.setText(sal);
                                        
                }else{
                    JOptionPane.showMessageDialog(null, "No existe ese requerimiento", "ADVERTENCIA",
                    JOptionPane.WARNING_MESSAGE);
                }

            }catch(Exception e1){
                JOptionPane.showMessageDialog(null, "Error en base de datos", "ERROR",
                JOptionPane.ERROR_MESSAGE);


            }
        }

        if (e.getSource()==botonLimpiar){
            limpiar();
        }
        if(e.getSource()==botonCancelar){
            this.dispose();

        }
        
    }

}
