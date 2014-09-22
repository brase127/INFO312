import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kendall Lauren Chin
 */
public class Main {
// select from the view

    public static void main(String[] args) throws JRException {
        String sql = "select * from invoice_report";
        try (
                // get a connection to the database
                Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/labs/lab10", "sa", "");
                // execute the statement
                PreparedStatement s = con.prepareStatement(sql);) {
            ResultSet rs = s.executeQuery();
            // create the report using the result set as a data source
            JasperPrint report = JasperFillManager.fillReport("C:\\Users\\Kendall Lauren Chin\\Documents\\INFO221\\project\\iReport\\JasperReports\\src\\BeautyBoxInvoice.jasper", new HashMap<String, Object>(), new JRResultSetDataSource(rs));
            // view the report
            JasperViewer.viewReport(report);
            // close the database connection
            JasperExportManager.exportReportToPdfFile(report,
                    "C:\\Users\\Kendall Lauren Chin\\Documents\\INFO221\\project\\iReport\\JasperReports\\src\\BeautyBoxInvoice.pdf");
            con.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
