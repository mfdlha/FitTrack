/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JTable;
/**
 *
 * @author fadil
 */
public class CetakLaporan {
public static void exportToHTML(JTable table, String namaFile) throws Exception {
        // Path khusus untuk report, misalnya di dalam folder "report" di root proyek
        File folder = new File("report");
        if (!folder.exists()) folder.mkdir(); // Buat folder jika belum ada

        FileWriter out = new FileWriter("report/" + namaFile + ".html");
        out.write("<html><body>");
        out.write("<h1>Laporan Transaksi FitTrack</h1>");
        out.write("<table border='1' cellpadding='5' style='border-collapse:collapse; width:100%'>");
        
        // Header
        out.write("<tr style='background-color:#f2f2f2;'>");
        for (int i = 0; i < table.getColumnCount(); i++) {
            out.write("<th>" + table.getColumnName(i) + "</th>");
        }
        out.write("</tr>");
        
        // Data
        for (int i = 0; i < table.getRowCount(); i++) {
            out.write("<tr>");
            for (int j = 0; j < table.getColumnCount(); j++) {
                out.write("<td>" + table.getValueAt(i, j).toString() + "</td>");
            }
            out.write("</tr>");
        }
        
        out.write("</table></body></html>");
        out.close();
    }
}
