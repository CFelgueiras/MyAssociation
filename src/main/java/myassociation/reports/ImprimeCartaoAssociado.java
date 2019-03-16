/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.reports;

import java.awt.Container;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import myassociation.model.Member;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cláudio Felgueiras
 */
public class ImprimeCartaoAssociado {

    public  boolean imprimirCartaoAssociado(Member socio, String savePath) {
        HashMap<String,Object> parameters = new HashMap<>();
        parameters.put("numero", socio.getNumero());
        parameters.put("nome", socio.getNome());

        JasperReport report = null;
        JasperPrint reportPrint = null;

        try {
            report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reports/cartaoSocio.jrxml"));
            reportPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JasperViewer.viewReport(reportPrint, false);
//            JasperExportManager.exportReportToPdfFile(reportPrint, savePath);
            return true;
        } catch (JRException ex) {
            System.out.println("Erro ao gerar o report cartao Socio.");
            return false;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ImprimeCartaoAssociado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
