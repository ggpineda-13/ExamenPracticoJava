/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;
/**
 * Excepcion lanzada cuando no hay suficientes repuestos en el inventario.
 * @author Genesis Pineda
 */
public class StockInsuficienteException extends Exception 
{
    public StockInsuficienteException(String mensaje) 
    {
        super(mensaje);
    }
}

