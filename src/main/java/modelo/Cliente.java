/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 * Clase que representa a un cliente del taller.
 * @author Genesis Pineda
 */
public class Cliente 
{
    private String codigo;
    private String nombre;
    private String identidad;
    private String telefono;
    private String direccion;

    public Cliente(String codigo, String nombre, String identidad, String telefono, String direccion) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.identidad = identidad;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getIdentidad() { return identidad; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }

    
    @Override
    public String toString() 
    {
        return nombre + " (" + codigo + ")";
    }
}
