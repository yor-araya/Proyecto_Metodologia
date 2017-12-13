/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodologia.lg;

/**
 *
 * @author jmanu
 */
public class Pantalla {
    Conexiondb conect = new Conexiondb();
    
    public Pantalla() {
    }
    
    private String tabla = "Pantallas";
    
    public boolean agregar(String datos){
        boolean agregado = false;
        System.out.println(datos);
        agregado = conect.agregar(tabla,datos);
        return agregado;
    }
    
    public boolean editar(String datos, String condicion){
        boolean editado = false;
        editado = conect.editar(tabla,datos,condicion);
        return editado;
    }
    
    public boolean eliminar(String condicion){
        boolean eliminado = false;
        if(conect.eliminar(tabla,condicion)){
            eliminado = true;
        }
        return eliminado;
    }
    
    public String [][] imprimir(String datos, String condicion, String order){
        String [][] resultado = conect.imprimir(tabla,datos,condicion,order);
        return resultado;
    }
    public boolean permisouser(int tipo_usuario, int Pantalla){
        boolean permiso = false;
        String datos = "bloqueo";
        String condicion = "idPantalla->"+Pantalla;
        String order = null;
        String [][] resultado = conect.imprimir(tabla,datos,condicion,order);
        if(resultado[0][0] == Integer.toString(tipo_usuario)){
            permiso = true;
        }
        switch (resultado[0][0]) {
            case "1":
                permiso = true;
            break;
            case "2":
                if(tipo_usuario != 3){
                    permiso = true;
                }
            break;
            case "3":
                if(tipo_usuario == 1){
                    permiso = true;
                }
            break;
            default:
                permiso = false;
            break;
        }
        return permiso;
    }
    
}
