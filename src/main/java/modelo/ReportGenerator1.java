package modelo;
import vistas.vCrearReportes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



public class ReportGenerator1 {
    
    public void generarReporte(String ruta) {
            try {
                Connection con;
                Config bd = new Config();
                
                // Cargando el driver de conexión
                Class.forName(bd.getDriver());
                
                // Realizando la conexión a la base de datos (URL, Usuario, Contraseña)
                con = DriverManager.getConnection(bd.getUrl(), bd.getUsuario(), bd.getContrasena());
                
                JasperReport reporte = null;
                String path = ruta;
                
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, con);
                
                JasperViewer view = new JasperViewer(jprint, false);
                
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(vCrearReportes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(vCrearReportes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(vCrearReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }
}