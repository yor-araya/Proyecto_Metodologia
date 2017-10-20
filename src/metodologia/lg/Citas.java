    /* 
    Clase Citas, encargada calendarizar las citas de los pacientes
    */
package metodologia.lg;

import metodologia.cn.ConexionBD;

/**
 *
 * @author jmanu
 */
public class Citas {
    ConexionBD conect = new ConexionBD();
    
    Citas() {
    }
    
    private String tabla = "Citas";
    public boolean agregar(String datos){
        boolean agregado = false;
        if(conect.agregar(tabla,datos)){
            agregado = true;
        }//fin del if
        return agregado;
    }//fin del metodo agregar
    /* 
    Procedimiento de edición de datos
    */    
    public boolean editar(String datos, String condicion){
        boolean editado = false;//bandera para controlar la edición
        if(conect.editar(tabla,datos,condicion)){
            editado = true;//bandera para controlar la edición
        }//fin del if
        return editado;
    }//fin metodo editar
    /* 
    Procedimiento de eliminicación de datos.
    */    
    public boolean eliminar(String condicion){
        boolean eliminado = false;//bandera para controlar la eliminación
        if(conect.eliminar(tabla,condicion)){
            eliminado = true;//bandera para controlar la eliminación
        }//fin del if
        return eliminado;
    }//fin metodo eliminar
    /* 
    Procedimiento de impresión de los datos.
    */
    public String [][] imprimir(String datos, String condicion, String order){
        //Conexión a base de datos para la impresión de datos
        String [][] resultado = conect.imprimir(tabla,datos,condicion,order);
        for (int x=0; x < resultado.length; x++) {
            for (int y=0; y < resultado[x].length; y++) {
              System.out.println (resultado[x][y]);
            }//fin for interno
        }//Fin for
        return resultado;
    }//fin metodo imprimir
}//fin clase
