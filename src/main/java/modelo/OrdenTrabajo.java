/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa una orden de trabajo en el taller.
 * @author Genesis Pineda
 */
public class OrdenTrabajo 
{
    private String numeroOrden;
    private String fecha;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private String diagnostico;
    private String mecanico;
    private List<Servicio> servicios;
    private List<Repuesto> repuestos;
    private String estado; // Pendiente, En proceso, Finalizada, Cancelada
    
    // Bandera para saber si ya se descontaron los repuestos del inventario
    private boolean inventarioDescontado; 
    public OrdenTrabajo(String numeroOrden, String fecha, Cliente cliente, Vehiculo vehiculo, String diagnostico, String mecanico) 
    {
        this.numeroOrden = numeroOrden;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.diagnostico = diagnostico;
        this.mecanico = mecanico;
        this.servicios = new ArrayList<>();
        this.repuestos = new ArrayList<>();
        this.estado = "Pendiente";
        this.inventarioDescontado = false;
    }

    // Metodo para calcular el costo total sumando servicios y repuestos
    public double getCostoTotal() 
    {
        double total = 0;
        for (Servicio s : servicios) 
        {
            total += s.getPrecioBase();
        }
        for (Repuesto r : repuestos) 
        {
            total += r.getPrecioUnitario(); 
        }
        return total;
    }

    // Getters y Setters necesarios
    public String getNumeroOrden() { return numeroOrden; }
    public String getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public String getEstado() { return estado; }
    public String getMecanico() { return mecanico; }
    public String getDiagnostico() { return diagnostico; }
    public void setEstado(String estado) { this.estado = estado; }
    public List<Servicio> getServicios() { return servicios; }
    public List<Repuesto> getRepuestos() { return repuestos; }
    public boolean isInventarioDescontado() { return inventarioDescontado; }
    public void setInventarioDescontado(boolean inventarioDescontado) { this.inventarioDescontado = inventarioDescontado; }
    
    // Metodos para agregar elementos a la orden
    public void agregarServicio(Servicio s) { this.servicios.add(s); }
    public void agregarRepuesto(Repuesto r) { this.repuestos.add(r); }
    
    @Override
    public String toString() 
    {
        return numeroOrden + " - " + estado;
    }
}