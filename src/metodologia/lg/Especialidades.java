    /* 
    Clase Especialidades, Catalogo de especialidades del sistema.
    */
package metodologia.lg;

import metodologia.cn.ConexionBD;


/**
 *
 * @author jmanu
 */
public class Especialidades {
    ConexionBD conect = new ConexionBD();//inicio de conexión de base datos.
    
    public Especialidades() {
    }
    
    private String tabla = "Especialidades";//tabla en la base de datos 
    public boolean agregar(String datos){
        boolean agregado = false;//bandera para controlar la inserción de data
        if(conect.agregar(tabla,datos)){
            agregado = true;//bandera para controlar la inserción de base de data
        }//fin del if
        return agregado;
    }//fin del metodo agregar
    
    public boolean editar(String datos, String condicion){
        boolean editado = false;//bandera para controlar la actualización de datos
        if(conect.editar(tabla,datos,condicion)){
            editado = true;//bandera para controlar la actualización de datos
        }//fin del if
        return editado;
    }//fin del metodo editar
    
    public boolean eliminar(String condicion){
        boolean eliminado = false;//bandera para controlar la eliminación de datos
        if(conect.eliminar(tabla,condicion)){
            eliminado = true;//bandera para controlar la eliminación de datos
        }//fin del if
        return eliminado;
    }//Fin del metodo eliminar
    
    public String [][] imprimir(String datos, String condicion, String order){
        //conexión para enviar la data a imprimir.
        String [][] resultado = conect.imprimir(tabla,datos,condicion,order);
        for (int x=0; x < resultado.length; x++) {
            for (int y=0; y < resultado[x].length; y++) {
              System.out.println (resultado[x][y]);
            }//fin del for interno
        }//fin del for
        return resultado;
    }//fin del metodo imprimir
}//fin de la clase especialidades
