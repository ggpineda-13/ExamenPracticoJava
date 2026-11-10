/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
/**
 * Clase que simula el procesamiento de una orden en 5 segundos.
 * @author Genesis Pineda
 */
public class ProcesoServicioHilo implements Runnable 
{
    private JProgressBar barraProgreso;

    // Recibimos la barra de progreso de la vista para actualizarla
    public ProcesoServicioHilo(JProgressBar barraProgreso) 
    {
        this.barraProgreso = barraProgreso;
    }

    @Override
    public void run() 
    {
        // El PDF pide al menos 5 segundos. Haremos 10 ciclos de 500ms.
        for (int i = 0; i <= 100; i += 10) 
        {
            try 
            {
                Thread.sleep(500); // El hilo se pausa medio segundo

                // Las actualizaciones visuales en Swing SIEMPRE deben hacerse en el EDT
                final int progresoActual = i;
                SwingUtilities.invokeLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    {
                        barraProgreso.setValue(progresoActual);
                    }
                });
                
            } catch (InterruptedException e) 
            {
                System.err.println("El hilo fue interrumpido: " + e.getMessage());
            }
        }
    }
}