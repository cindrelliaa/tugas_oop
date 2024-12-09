package aplikasi_restoran_sederhana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksi {
    private final String url = "jdbc:mysql://localhost:3306/restoran1"; // Ganti sesuai database Anda
    private final String username = "root"; // Ganti sesuai username database Anda
    private final String password = ""; // Ganti sesuai password database Anda
    private Connection con = null;

    // Constructor otomatis memanggil connect()
    public koneksi() {
        connect();
    }

    // Method untuk membuat koneksi
    public void connect() {
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method untuk mengembalikan objek Connection
    public Connection getCon() {
        if (con == null) {
            connect(); // Jika belum terkoneksi, coba koneksi ulang
        }
        return con;
    }
}
