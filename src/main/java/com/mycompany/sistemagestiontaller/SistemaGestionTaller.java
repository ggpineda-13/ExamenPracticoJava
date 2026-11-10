/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemagestiontaller;
import vista.VentanaPrincipal;

/**
 * Clase principal que arranca el sistema.
 * @author Genesis Pineda
 */
public class SistemaGestionTaller 
{

    public static void main(String[] args) 
    {
        // Hacemos visible la ventana principal en el hilo de Swing
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setVisible(true);
            }
        });
    }
}