/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 * Clase que representa la factura generada al pagar una orden.
 * @author Genesis Pineda
 */
public class Factura 
{
    private String numeroFactura;
    private OrdenTrabajo orden;
    private double subtotal;
    private double impuesto;
    private double total;
    private double pagoEfectivo;
    private double cambio;

    // Recibe el porcentaje de impuesto (por ejemplo 15.0 para el 15%)
    public Factura(String numeroFactura, OrdenTrabajo orden, double impuestoPorcentaje) 
    {
        this.numeroFactura = numeroFactura;
        this.orden = orden;
        this.subtotal = orden.getCostoTotal();
        this.impuesto = this.subtotal * (impuestoPorcentaje / 100);
        this.total = this.subtotal + this.impuesto;
    }

    // Calcula el cambio a devolver
    public void calcularCambio(double pagoEfectivo) 
    {
        this.pagoEfectivo = pagoEfectivo;
        this.cambio = this.pagoEfectivo - this.total;
    }

    public String getNumeroFactura() { return numeroFactura; }
    public OrdenTrabajo getOrden() { return orden; }
    public double getSubtotal() { return subtotal; }
    public double getImpuesto() { return impuesto; }
    public double getTotal() { return total; }
    public double getPagoEfectivo() { return pagoEfectivo; }
    public double getCambio() { return cambio; }
}