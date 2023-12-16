import java.sql.*;

import org.apache.commons.dbutils.DbUtils;

//Programa JDBC que acceda a la tabla "categorias", de la base de datos "pedidos", para mostrar todasd las filas cuya clave "categoriaid"
//sea inferior a 500. La consulta debe hacerse parametrizada, con un unico parametro que sea el valor de 500
//en la ejecucion de la consulta.


public class preparedStatementExamen {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;


        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost/categorias","root","root");
            pstmt = con.prepareStatement("select * from categorias where categoriaid < ?");

            pstmt.setInt(1,500);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                System.out.println("id: " + id + " nombre " + nombre);
            }




        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            closeQuietly(con);
            closeQuietly(pstmt);
        }
    }
}
