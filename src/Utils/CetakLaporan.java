/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
/**
 *
 * @author fadil
 */
public class CetakLaporan {
    public static String generateHTML(String judul, JTable tabel) {
    StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>");
        html.append("<html>");
        html.append("<head>");
        html.append("<meta charset='UTF-8'>");

        html.append("<title>");
        html.append(judul);
        html.append("</title>");

        html.append("<style>");
        html.append("body{font-family:Arial,sans-serif;margin:25px;}");
        html.append("h2{text-align:center;}");
        html.append("p{text-align:right;font-size:12px;}");
        html.append("table{border-collapse:collapse;width:100%;margin-top:15px;}");
        html.append("th,td{border:1px solid black;padding:8px;}");
        html.append("th{background:#e6e6e6;}");
        html.append("</style>");

        // Jika ingin dialog print langsung muncul
        // html.append("<script>window.onload=function(){window.print();}</script>");

        html.append("</head>");
        html.append("<body>");

        html.append("<h2>");
        html.append(judul);
        html.append("</h2>");

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        html.append("<p>Tanggal Cetak : ");
        html.append(LocalDateTime.now().format(format));
        html.append("</p>");

        html.append("<hr>");

        html.append("<table>");

        // Header
        html.append("<tr>");

        for (int i = 0; i < tabel.getColumnCount(); i++) {

            html.append("<th>");
            html.append(tabel.getColumnName(i));
            html.append("</th>");

        }

        html.append("</tr>");

        // Data
        for (int i = 0; i < tabel.getRowCount(); i++) {

            html.append("<tr>");

            for (int j = 0; j < tabel.getColumnCount(); j++) {

                Object value = tabel.getValueAt(i, j);

                html.append("<td>");
                html.append(value == null ? "" : value.toString());
                html.append("</td>");

            }

            html.append("</tr>");

        }

        html.append("</table>");

        html.append("</body>");
        html.append("</html>");

        return html.toString();

    }

    // ==========================
    // Simpan HTML lalu buka browser
    // ==========================
    public static void bukaHTML(String html, String namaFile) throws IOException {

        File file = new File(System.getProperty("user.home"), namaFile);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(html);
        }

        try {

            Process process = new ProcessBuilder(
                    "/usr/bin/flatpak-spawn",
                    "--host",
                    "xdg-open",
                    file.toURI().toString()
            ).start();

            process.waitFor();

        } catch (Exception e) {

            throw new IOException(
                    "File berhasil dibuat di:\n"
                    + file.getAbsolutePath()
                    + "\n\nTetapi browser gagal dibuka.",
                    e
            );

        }

    }
}
