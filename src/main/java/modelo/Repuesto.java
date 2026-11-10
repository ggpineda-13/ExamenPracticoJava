/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 * Clase que representa un repuesto en el inventario.
 * @author Genesis Pineda
 */
public class Repuesto 
{
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precioUnitario;
    private int stockMinimo;

    public Repuesto(String codigo, String nombre, int cantidad, double precioUnitario, int stockMinimo) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.stockMinimo = stockMinimo;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public int getStockMinimo() { return stockMinimo; }

    // Este setter nos servira para descontar el inventario cuando se facture
    public void setCantidad(int cantidad) 
    {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() 
    {
        return nombre + " (Stock: " + cantidad + ")";
    }
}