/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;
/**
 * Excepcion lanzada cuando el cliente paga menos del total de la factura.
 * @author Genesis Pineda
 */
public class PagoInsuficienteException extends Exception 
{
    public PagoInsuficienteException(String mensaje) 
    {
        super(mensaje);
    }
}

