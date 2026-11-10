/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RepositorioGenerico<T> 
{
    private List<T> listaElementos = new ArrayList<>();
    private Map<String, T> mapaElementos = new HashMap<>();
    private Stack<T> historialOperaciones = new Stack<>();
    
    // PILA EXCLUSIVA PARA ELIMINADOS
    private Stack<T> pilaEliminados = new Stack<>(); 

    public void agregar(String clave, T elemento) 
    {
        listaElementos.add(elemento);
        mapaElementos.put(clave, elemento);
        historialOperaciones.push(elemento); // El historial normal sigue funcionando
    }

    public T buscarPorClave(String clave) 
    {
        return mapaElementos.get(clave);
    }

    public List<T> obtenerTodos() 
    {
        return Collections.unmodifiableList(listaElementos);
    }

    public boolean existeClave(String clave) 
    {
        return mapaElementos.containsKey(clave);
    }
    
    // Metodo para registrar de nuevo el elemento en el mapa al deshacer
    public void registrarDeNuevo(String clave, T elemento) 
    {
        mapaElementos.put(clave, elemento);
    }

    // ELIMINAR: Lo saca de la lista/mapa y lo guarda en la pila de eliminados
    public T eliminar(String clave) 
    {
        T elemento = mapaElementos.remove(clave);
        if (elemento != null) 
        {
            listaElementos.remove(elemento);
            pilaEliminados.push(elemento); //Guardamos en la pila exclusiva
        }
        return elemento;
    }

    // DESHACER: Saca de la pila de eliminados
    public T deshacerUltimo() 
    {
        if (!pilaEliminados.isEmpty()) 
        {
            T recuperado = pilaEliminados.pop();
            // Lo volvemos a meter a la lista y al mapa
            listaElementos.add(recuperado);
            // Nota: Como no tenemos la clave a la mano, usamos el toString o pedimos que el controlador lo haga.
            return recuperado;
        }
        return null;
    }
}