/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import excepciones.ClienteNoEncontradoException;
import excepciones.PagoInsuficienteException;
import excepciones.StockInsuficienteException;
import modelo.*;
import repositorio.RepositorioGenerico;

/**
 * Controlador principal que maneja la logica del sistema.
 * @author Genesis Pineda
 */
public class SistemaController 
{
    private RepositorioGenerico<Cliente> repoClientes;
    private RepositorioGenerico<Vehiculo> repoVehiculos;
    private RepositorioGenerico<Servicio> repoServicios;
    private RepositorioGenerico<Repuesto> repoRepuestos;
    private RepositorioGenerico<OrdenTrabajo> repoOrdenes;
    private RepositorioGenerico<Factura> repoFacturas;

    public SistemaController() 
    {
        repoClientes = new RepositorioGenerico<>();
        repoVehiculos = new RepositorioGenerico<>();
        repoServicios = new RepositorioGenerico<>();
        repoRepuestos = new RepositorioGenerico<>();
        repoOrdenes = new RepositorioGenerico<>();
        repoFacturas = new RepositorioGenerico<>();
        
        cargarDatosDePrueba(); // Para que no empieces con el sistema vacio
    }

    // --- METODOS DE CLIENTES ---
    public boolean registrarCliente(Cliente c)
    {
        if (repoClientes.existeClave(c.getCodigo())) 
        {
            return false; // Codigo duplicado
        }
        repoClientes.agregar(c.getCodigo(), c);
        return true;
    }

    public Cliente buscarCliente(String codigo) throws ClienteNoEncontradoException 
    {
        Cliente c = repoClientes.buscarPorClave(codigo);
        if (c == null) 
        {
            throw new ClienteNoEncontradoException("No existe un cliente con el codigo: " + codigo);
        }
        return c;
    }

    public java.util.List<Cliente> obtenerClientes() 
    {
        return repoClientes.obtenerTodos();
    }

    // Metodo para eliminar un cliente
    public void eliminarCliente(String codigo) 
    {
        repoClientes.eliminar(codigo); 
    }

    // Metodo para deshacer la ultima eliminacion
    public boolean deshacerEliminacionCliente() 
    {
        Cliente recuperado = repoClientes.deshacerUltimo();
        if (recuperado != null)
        {
            // El metodo deshacerUltimo ya lo metio a la lista. 
            // Ahora lo metemos al mapa con su clave (codigo).
            repoClientes.registrarDeNuevo(recuperado.getCodigo(), recuperado);
            return true;
        }
        return false;
    }

    // --- METODOS DE VEHICULOS ---
    public boolean registrarVehiculo(Vehiculo v) {
        if (repoVehiculos.existeClave(v.getPlaca()))
        {
            return false; // Placa duplicada
        }
        repoVehiculos.agregar(v.getPlaca(), v);
        return true;
    }
    
    public Vehiculo eliminarVehiculo(String placa) 
    {
        return repoVehiculos.eliminar(placa);
    }
    
    public java.util.List<Vehiculo> obtenerVehiculos() 
    {
        return repoVehiculos.obtenerTodos();
    }

    // --- METODOS DE SERVICIOS Y REPUESTOS ---
    public void registrarServicio(Servicio s) 
    {
        repoServicios.agregar(s.getCodigo(), s);
    }
    public java.util.List<Servicio> obtenerServicios() 
    {
        return repoServicios.obtenerTodos();
    }

    public void registrarRepuesto(Repuesto r)
    {
        repoRepuestos.agregar(r.getCodigo(), r);
    }
    public Repuesto eliminarRepuesto(String codigo) 
    {
        return repoRepuestos.eliminar(codigo);
    }
    public java.util.List<Repuesto> obtenerRepuestos() 
    {
        return repoRepuestos.obtenerTodos();
    }

    // --- METODOS DE ORDENES ---
    public void registrarOrden(OrdenTrabajo orden) 
    {
        repoOrdenes.agregar(orden.getNumeroOrden(), orden);
    }
    public java.util.List<OrdenTrabajo> obtenerOrdenes() 
    {
        return repoOrdenes.obtenerTodos();
    }

    // --- METODO PARA FACTURAR ---
    public Factura generarFactura(String numFactura, OrdenTrabajo orden, double impuesto, double pagoEfectivo) 
            throws PagoInsuficienteException, StockInsuficienteException 
    {
        Factura factura = new Factura(numFactura, orden, impuesto);

        // Verificamos si el pago alcanza
        if (pagoEfectivo < factura.getTotal()) 
        {
            throw new PagoInsuficienteException("El pago de L " + pagoEfectivo + " es menor al total de L " + factura.getTotal());
        }
        factura.calcularCambio(pagoEfectivo);

        // Descontamos inventario si no se ha hecho
        if (!orden.isInventarioDescontado()) 
        {
            for (Repuesto r : orden.getRepuestos()) 
            {
                if (r.getCantidad() <= 0) 
                {
                    throw new StockInsuficienteException("No hay stock suficiente del repuesto: " + r.getNombre());
                }
                r.setCantidad(r.getCantidad() - 1);
            }
            orden.setInventarioDescontado(true);
        }

        repoFacturas.agregar(numFactura, factura);
        orden.setEstado("Finalizada");

        return factura;
    }
    
    public java.util.List<Factura> obtenerFacturas() 
    {
        return repoFacturas.obtenerTodos();
    }

    // --- DATOS DE PRUEBA ---
    private void cargarDatosDePrueba() 
    {
        Cliente c1 = new Cliente("C01", "Genesis Pineda", "0801-2000-12345", "9999-9999", "La Gran Villa");
        repoClientes.agregar(c1.getCodigo(), c1);
        
        Vehiculo v1 = new Vehiculo("HAB-1234", "Toyota", "Corolla", 2020, "Rojo", c1);
        repoVehiculos.agregar(v1.getPlaca(), v1);

        Servicio s1 = new Servicio("S01", "Cambio de aceite", 500.0, 1);
        Servicio s2 = new Servicio("S02", "Revision de frenos", 800.0, 2);
        repoServicios.agregar(s1.getCodigo(), s1);
        repoServicios.agregar(s2.getCodigo(), s2);

        Repuesto r1 = new Repuesto("R01", "Filtro de aceite", 10, 150.0, 2);
        Repuesto r2 = new Repuesto("R02", "Pastillas de freno", 5, 450.0, 2);
        repoRepuestos.agregar(r1.getCodigo(), r1);
        repoRepuestos.agregar(r2.getCodigo(), r2);
    }
}