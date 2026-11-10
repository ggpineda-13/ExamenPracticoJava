/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;
/**
 * Excepcion lanzada cuando se busca un cliente y no existe.
 * @author Genesis Pineda
 */
public class ClienteNoEncontradoException extends Exception 
{
    public ClienteNoEncontradoException(String mensaje) 
    {
        super(mensaje);
    }
}

