/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodologia.lg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jmanu
 */
public class Conexiondb {

    Statement s;
    Connection connection;
    String url = "jdbc:mysql://queleparece.com:3306/quelepar_db_prueba";
    String user = "quelepar_userdb";
    String pass = "^fo$A=xFlLa_";
    
    public boolean connect(){
        boolean coneccion = false;
        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            s = connection.createStatement();
            coneccion = true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return coneccion;
    }
    
    public boolean agregar(String tabla, String data){
        boolean agregado = false;
        String campos = "";
        String valores = "";
        if(data != null){
            String[] parte1 = data.split(",");
            for (int y=0; y < parte1.length; y++) {
              if( y != 0){
                  campos = campos+" , ";
                  valores = valores+" , ";
              }
              String[] parte2= parte1[y].split("->");
              campos = campos +" "+parte2[0];
              valores = valores +" "+parte2[1];
            }
        }else{
            campos = "";
            valores = "";
        }
        String query = "INSERT INTO "+tabla+" ("+campos+") VALUES ("+valores+")";
        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            s = connection.createStatement();
            s.executeUpdate(query);
            agregado = true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return agregado;
    }
    public boolean editar(String tabla, String data, String condicion){
        boolean editar = false;
        String datos = datos(data);
        String condiciondata = datos(condicion);
        if(condiciondata != ""){
            condicion = " where "+condiciondata; 
        }
        String query = "UPDATE "+tabla+" SET "+datos+""+condicion;
        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            s = connection.createStatement();
            s.executeUpdate(query);
            editar = true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return editar;
    }
    
    public boolean eliminar(String tabla, String condicion){
        boolean eliminar = false;
        String condiciondata = datos(condicion);
        if(condiciondata != ""){
            condicion = " where "+condiciondata; 
        }
        String query = "DELETE FROM "+tabla+""+condicion;
        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            s = connection.createStatement();
            s.executeUpdate(query);
            eliminar = true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return eliminar;
    }
    
    public String [][] imprimir(String tabla, String datos, String condicion,  String order){
        ResultSet r = null;
        String [][] resultado =  new String[0][0];
        String condiciondata = datos(condicion);
        if(condicion != null){
            condicion = " where "+condiciondata; 
        }else{
            condicion = "";
        }
        String[] partes = order.split("->");
        String orderby = "";
        if(order != null){
            orderby = " ORDER BY "+partes[0]+" "+partes[1];
        }
        String query = "SELECT "+datos+" FROM "+tabla+""+condicion+""+orderby;
        try(Connection connection = DriverManager.getConnection(url,user,pass)){
            s = connection.createStatement();
            r = s.executeQuery(query); 
            ResultSetMetaData rs = r.getMetaData();
            int columnsNumber = rs.getColumnCount();
            if(!r.next())
            {
                System.out.println("NO TIENE DATOS");
            }else{
                int j = 1;
                while(r.next())
                {
                   j++;
                }
                resultado =  new String[j][columnsNumber];
                r = s.executeQuery(query); 
                for(int h=0; h < j; h++)
                {
                   r.next(); 
                   int k = 0;
                   for(int i=1; i <= columnsNumber; i++){
                       resultado[h][k] = r.getString(i);
                       k++;
                   }
                }
            }
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    private String datos(String data){
        String datos = "";
        if(data != null){
            String[] parte1 = data.split(",");
                for (int y=0; y < parte1.length; y++) {
                  if( y != 0){
                      datos = datos+" , ";
                  }
                  String[] parte2= parte1[y].split("->");
                  datos = datos +" "+parte2[0]+" = "+parte2[1];
             } 
        }else{
            datos = "";
        }
        return datos;
    }
}
