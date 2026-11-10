/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 * Clase que representa un vehiculo asociado a un cliente.
 * @author Genesis Pineda
 */
public class Vehiculo 
{
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private Cliente propietario; // Aqui guardamos el objeto Cliente completo

    public Vehiculo(String placa, String marca, String modelo, int anio, String color, Cliente propietario) 
    {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.propietario = propietario;
    }

    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio() { return anio; }
    public String getColor() { return color; }
    public Cliente getPropietario() { return propietario; }

    @Override
    public String toString() 
    {
        return placa + " - " + marca + " " + modelo;
    }
}
