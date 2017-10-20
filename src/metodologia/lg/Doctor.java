    /* 
    Clase Doctor, Catalogo de doctores que están registrados en el sistema.
    */
package metodologia.lg;

import metodologia.cn.ConexionBD;

/**
 *
 * @author yorda
 */
public class Doctor {
   
    ConexionBD conect = new ConexionBD();
    String tabla = "Doctor";

    //metodo constructor
    public Doctor(){}

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
   
}//fin clase Doctor
