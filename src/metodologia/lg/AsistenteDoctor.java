    /* 
    Yorda 13/10/2017
    Clase Asistentes de doctores, encargada del catalogo de los asistentes por doctores
    en la clinica
    */
package metodologia.lg;

import metodologia.cn.ConexionBD;

/**
 *
 * @author yorda
 */
public class AsistenteDoctor {
    /*Declaración de variables*/
    private int idAsistente;//Identificación del asistente del doctor tipo entero
    private String nombre;//Nombre del asistente del doctor tipo caracter
    private String telefono;//Telefono del asistente del doctor tipo caracter
    ConexionBD conect = new ConexionBD();
    String tabla = "Asistentes";

    /*Mejora de codigo*/
    /*metodo para agregar un doctor*/
     public boolean agregar(String datos){
        boolean agregado = false;
        if(conect.agregar(tabla,datos)){
            agregado = true;
        }//fin del if
        return agregado;
    }//fin metodo agregar
    /*metodo para editar algun dato de un doctor*/
    public boolean editar(String datos, String condicion){
        boolean editado = false;
        if(conect.editar(tabla,datos,condicion)){
            editado = true;
        }//fin del if
        return editado;
    }//fin metodo editar   
    /*metodo para eliminar un doctor*/
    public boolean eliminar(String condicion){
        boolean eliminado = false;
        if(conect.eliminar(tabla,condicion)){
            eliminado = true;
        }//fin del if
        return eliminado;
    }//fin metodo eliminar   
    /*metodo para imprimir todos los doctores*/
    public String [][] imprimir(String datos, String condicion, String order){
        String [][] resultado = conect.imprimir(tabla,datos,condicion, order);
        return resultado;
    }//fin metodo imprimir
}//fin clase AsistenteDoctor
