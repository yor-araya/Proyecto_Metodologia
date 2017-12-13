/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodologia.ui;

import metodologia.lg.Conexiondb;
import metodologia.ui.GuiLogin;

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
        Conexiondb conect = new Conexiondb();
        GuiLogin login = new GuiLogin();
        if(conect.connect()){
            login.setVisible(true);;
            //password = encryt.getMD5(password);
        }else{
        } 
    }

}
