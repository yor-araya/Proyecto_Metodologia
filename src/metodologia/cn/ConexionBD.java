
package metodologia.cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yorda
 */
public class ConexionBD {

    Statement s;
    Connection connection;
    String url = "jdbc:mysql://progressivehostcr.com:3306/progress_progra4";
    String user = "progress_progra4";
    String pass = "2iQcq^9q#S4m";

    /* 
    Método de conexión de base de datos
     */

    public boolean connect() {
        boolean coneccion = false;
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            s = connection.createStatement();
            coneccion = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }//fin catch
        return coneccion;
    }//fin connect

    /* 
    Método que agrega información a la base datos.
     */

    public boolean agregar(String tabla, String data) {
        boolean agregado = false;
        String campos = "";
        String valores = "";
        if (data != null) {
            String[] parte1 = data.split(",");
            for (int y = 0; y < parte1.length; y++) {
                if (y != 0) {
                    campos = campos + " , ";
                    valores = valores + " , ";
                }//fin if
                String[] parte2 = parte1[y].split("->");
                campos = campos + " " + parte2[0];
                valores = valores + " " + parte2[1];
            }//fin for
        } else {
            campos = "";
            valores = "";
        }//fin else
        String query = "INSERT INTO " + tabla + " (" + campos + ") VALUES (" + valores + ")";
        System.out.println(query);
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            s = connection.createStatement();
            s.executeUpdate(query);
            agregado = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }//fin catch
        return agregado;
    }//fin agregar

    /* 
    Método de modificación de datos.
     */
    public boolean editar(String tabla, String data, String condicion) {
        boolean editar = false;
        String datos = datos(data);
        String condiciondata = datos(condicion);
        if (condiciondata != "") {
            condicion = " where " + condiciondata;
        }//fin if
        String query = "UPDATE " + tabla + " SET " + datos + "" + condicion;
        System.out.println(query);
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            s = connection.createStatement();
            s.executeUpdate(query);
            editar = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }//fin catch
        return editar;
    }//fin clase editar

    /* 
    Método que toma la data y la prepara para ser enviada a mostrar en las pantallas.
     */

    public boolean eliminar(String tabla, String condicion) {
        boolean eliminar = false;
        String condiciondata = datos(condicion);
        if (condiciondata != "") {
            condicion = " where " + condiciondata;
        }//fin if
        String query = "DELETE FROM " + tabla + "" + condicion;
        System.out.println(query);
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            s = connection.createStatement();
            s.executeUpdate(query);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return eliminar;
    }//fin clase eliminar

    public String[][] imprimir(String tabla, String datos, String condicion, String order) {
        ResultSet r = null;
        String[][] resultado = new String[0][0];
        String condiciondata = datos(condicion);
        if (condicion != null) {
            condicion = " where " + condiciondata;
        } else {
            condicion = "";
        }//fin else
        String[] partes = order.split("->");
        String orderby = "";
        if (order != null) {
            orderby = " ORDER BY " + partes[0] + " " + partes[1];
        }//fin if
        String query = "SELECT " + datos + " FROM " + tabla + "" + condicion + "" + orderby;
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            s = connection.createStatement();
            r = s.executeQuery(query);
            ResultSetMetaData rs = r.getMetaData();
            int columnsNumber = rs.getColumnCount();
            if (!r.next()) {
                System.out.println("NO TIENE DATOS");
            } else {
                int j = 1;
                while (r.next()) {
                    j++;
                }
                resultado = new String[j][columnsNumber];
                r = s.executeQuery(query);
                for (int h = 0; h < j; h++) {
                    r.next();
                    int k = 0;
                    for (int i = 1; i <= columnsNumber; i++) {
                        resultado[h][k] = r.getString(i);
                        k++;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }//fin catch
        return resultado;
    }//fin clase imprimir

    private String datos(String data) {
        String datos = "";
        if (data != null) {
            String[] parte1 = data.split(",");
            for (int y = 0; y < parte1.length; y++) {
                if (y != 0) {
                    datos = datos + " , ";
                }
                String[] parte2 = parte1[y].split("->");
                datos = datos + " " + parte2[0] + " = " + parte2[1];
            }
        } else {
            datos = "";
        }//fin del else
        return datos;
    }//fin metodo datos
}//fin clase conexion
