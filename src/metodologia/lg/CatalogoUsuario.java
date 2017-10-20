    /* 
    Clase CatalogoUsuario, Registro de los usuarios que iteractuan con el sistema.
    */
package metodologia.lg;

import metodologia.cn.ConexionBD;

/**
 *
 * @author yorda
 */
public class CatalogoUsuario {
    /*Declaración de variables*/
    private int idUsuario;//Id del usuario tipo entero
    private int codigoUsuario;//Codigo del usuario tipo entero
    private String usuario;//Usuario tipo cadena de carecteres
    private String passwordUser;//Contraseña del usuario tipo cararter
    ConexionBD conect = new ConexionBD();
    
    //metodo constructor
    public CatalogoUsuario(){}
    
String tabla = "Usuarios";
    
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

}//fin clase CatalogoUsuario
