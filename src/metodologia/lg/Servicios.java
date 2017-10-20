    /* 
    Clase Servicios, Catalogo de servicios a ofrecer en el sistema
    */
package metodologia.lg;

import metodologia.cn.ConexionBD;

/**
 *
 * @author jmanu
 */
public class Servicios {
    ConexionBD conect = new ConexionBD();//conexión de base de datos.
    
    public Servicios() {
    }
    
    private String tabla = "Servicios";//tabla de base de datos.
    public boolean agregar(String datos){
        boolean agregado = false;//bandera para controlar la inserción de datos
        if(conect.agregar(tabla,datos)){
            agregado = true;//bandera para controlar la inserción de datos
        }//fin del if
        return agregado;
    }//fin del metodo agregar
    
    public boolean editar(String datos, String condicion){
        boolean editado = false;//bandera para controlar la modificación de datos
        if(conect.editar(tabla,datos,condicion)){
            editado = true;//bandera para controlar la modificación de datos
        }//fin del if
        return editado;
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
        for (int x=0; x < resultado.length; x++) {
            for (int y=0; y < resultado[x].length; y++) {
              System.out.println (resultado[x][y]);
            }//fin del for interno
        }//Fin del for
        return resultado;
    }//fin del metodo imprimir
}//fin de la clase Servicisos

