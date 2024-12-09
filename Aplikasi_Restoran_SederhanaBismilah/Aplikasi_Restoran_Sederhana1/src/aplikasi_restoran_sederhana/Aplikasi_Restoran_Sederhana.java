package aplikasi_restoran_sederhana;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Aplikasi_Restoran_Sederhana {

    public static void main(String[] args) {
        // Membuat objek koneksi
        koneksi k = new koneksi();
        Connection con = k.getCon(); // Mendapatkan koneksi database
        
        // Pastikan koneksi berhasil sebelum melanjutkan
        if (con != null) {
            try {
                // Contoh query untuk membaca data dari tabel
                String sql = "SELECT * FROM menu_makanan"; // Ganti 'menu_makanan' dengan nama tabel Anda
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                // Menampilkan data yang diambil dari database
                while (rs.next()) {
                    // Ganti 'nama_menu', 'harga' sesuai nama kolom dalam tabel Anda
                    System.out.println("Menu: " + rs.getString("nama_menu") + ", Harga: " + rs.getInt("harga"));
                }
                
                // Menutup resources setelah digunakan
                rs.close();
                ps.close();
                
            } catch (SQLException e) {
                System.out.println("Error saat menjalankan query: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    con.close(); // Tutup koneksi setelah selesai
                    System.out.println("Koneksi berhasil ditutup.");
                } catch (SQLException e) {
                    System.out.println("Error saat menutup koneksi: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Koneksi ke database gagal. Tidak dapat melanjutkan.");
        }
    }
}
