import java.sql.*;

public class ejExamenJDBC {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;

        try{
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");
            stmt = con.prepareStatement("select * from CLIENTES");

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                System.out.print("ID: " + rs.getString(1));
                System.out.print(" | Cédula: " + rs.getString(2));
                System.out.print(" | Nombre Compañía: " + rs.getString(3));
                System.out.print(" | Contacto: " + rs.getString(4));
                System.out.println(" | Dirección: " + rs.getString(5));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //closeQuietly(stmt);
            //closeQuietly(con);
        }
        System.out.println("DEL FINAL AL PRINCIPIO");
        try{
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");
            stmt = con.prepareStatement("select * from CLIENTES",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery();

            rs.afterLast();

            while(rs.previous()){
                System.out.print("ID: " + rs.getString(1));
                System.out.print(" | Cédula: " + rs.getString(2));
                System.out.print(" | Nombre Compañía: " + rs.getString(3));
                System.out.print(" | Contacto: " + rs.getString(4));
                System.out.println(" | Dirección: " + rs.getString(5));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //closeQuietly(stmt);
            //closeQuietly(con);
        }
    }
}
