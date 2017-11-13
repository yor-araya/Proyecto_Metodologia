/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodologia.ui;

import metodologia.cn.ConexionBD;
import metodologia.lg.Encritador;

/**
 *
 * @author juan jimenez
 */
public class Metodologia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexionBD conect = new ConexionBD();
        Encritador encryt = new Encritador();
        if(conect.connect()){
            String correo = "juankasjdia";
            String password = "juankasjdia";
            password = encryt.getMD5(password);
            String tabla = "campos_idioma";
            String data  = "nombre->'Boton Guardar',descripcion->'texto del boton de guardar ',codigo->'btn_save'";
           conect.agregar(tabla,data);
        }else{
        } 
    }

}
