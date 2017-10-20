    /* 
    Clase Pantalla, Clase base para generar las demás clases
    Patron utilizado Builder.
    */
package metodologia.lg;

import metodologia.cn.ConexionBD;

/**
 *
 * @author jmanu
 */
public class Pantalla {
    ConexionBD conect = new ConexionBD();//conexión de base de datos
    
    public Pantalla() {
    }
    
    private String tabla = "Pantallas";//tabla en la base de datos.
    
    public boolean agregar(String datos){
        boolean agregado = false;//bandera para controlar la inserción de datos
        System.out.println(datos);
        agregado = conect.agregar(tabla,datos);
        return agregado;//bandera para controlar la inserción de datos
    }//fin del metodo agregar
    
    public boolean editar(String datos, String condicion){
        boolean editado = false;//bandera para controlar la modificación de datos
        editado = conect.editar(tabla,datos,condicion);
        return editado;//bandera para controlar la modificación de datos
    }//fin del metodo editar
    
    public boolean eliminar(String condicion){
        boolean eliminado = false;//bandera para controlar la eliminación de datos
        if(conect.eliminar(tabla,condicion)){
            eliminado = true;//bandera para controlar la eliminación de datos
        }//fin del if
        return eliminado;
    }//fin del metodo eliminar
    
    public String [][] imprimir(String datos, String condicion, String order){
        //conexión de base de datos para mostrar la data.
        String [][] resultado = conect.imprimir(tabla,datos,condicion,order);
        return resultado;
    }//fin del metodo imprimir   
}//fin de la clase pantalla
