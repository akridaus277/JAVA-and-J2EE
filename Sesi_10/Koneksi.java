

import java.sql.*;

import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection koneksiDatabase;

    public static Connection koneksiDB() throws SQLException{
        try {
            String DB = "jdbc:mysql://localhost/cimb";
            String user = "root";
            String password = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksiDatabase = (Connection) DriverManager.getConnection(DB, user, password);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Gagal konek","Error",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return koneksiDatabase;
    }

}
