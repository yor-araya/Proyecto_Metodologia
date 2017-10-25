/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodologia.lg;

import metodologia.cn.ConexionBD;

/**
 *
 * @author yoorda
 */
public class Funciones {
    ConexionBD conect = new ConexionBD();
    
    Funciones(){}
    /* 
    Metodo para agregar datos.
    */
     public boolean agregar(String datos, String tabla){
        boolean agregado = false;
        if(conect.agregar(tabla,datos)){
            agregado = true;
        }//fin del if
        return agregado;
    }//fin del metodo agregar
    /* 
    Metodo de edición de datos.
    */    
    public boolean editar(String datos, String condicion, String tabla){
        boolean editado = false;//bandera para controlar la edición
        if(conect.editar(tabla,datos,condicion)){
            editado = true;//bandera para controlar la edición
        }//fin del if
        return editado;
    }//fin metodo editar
    /* 
    Metodo de eliminicación de datos.
    */    
    public boolean eliminar(String condicion, String tabla){
        boolean eliminado = false;//bandera para controlar la eliminación
        if(conect.eliminar(tabla,condicion)){
            eliminado = true;//bandera para controlar la eliminación
        }//fin del if
        return eliminado;
    }//fin metodo eliminar
    /* 
    Metodo de impresión de los datos.
    */
    public String [][] imprimir(String datos, String condicion, String order, String tabla){
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
