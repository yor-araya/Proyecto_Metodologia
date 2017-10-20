/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodologia.lg;

import metodologia.cn.ConexionBD;

/**
 *
 * @author yorda
 */
public class Agenda {
  ConexionBD conect = new ConexionBD();
     
    private String tabla = "Citas";
    public boolean agregar(String datos){
        boolean agregado = false;
        if(conect.agregar(tabla,datos)){
            agregado = true;
        }
        return agregado;
    }//fin del
    /* 
    Edición de los datos
    */
    public boolean editar(String datos, String condicion){
        boolean editado = false;
        if(conect.editar(tabla,datos,condicion)){
            editado = true;
        }//fin del if
        return editado;
    }//fin del metodo editar
    /* 
    Eliminación de datos
    */
    public boolean eliminar(String condicion){
        boolean eliminado = false;
        if(conect.eliminar(tabla,condicion)){
            eliminado = true;
        }//fin del if
        return eliminado;
    }//fin del metodo eliminar
    /* 
    Procedimiento para imprimir la información de agendas
    */
    public String [][] imprimir(String datos, String condicion, String order){
        String [][] resultado = conect.imprimir(tabla,datos,condicion,order);
        for (int x=0; x < resultado.length; x++) {
            for (int y=0; y < resultado[x].length; y++) {
              System.out.println (resultado[x][y]);
            }//fin del for añadido
        }//fin del for
        return resultado;
    }//fin metodo imprimir   
}//fin clase Agenda
