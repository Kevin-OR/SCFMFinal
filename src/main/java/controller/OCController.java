/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

//import com.itextpdf.text.BadElementException;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Conexion;
import model.OCmostr.OCGestion;
import model.OCmostr.TablaMList;
import model.OCmostr.TablaOC;
//import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
//import net.sf.dynamicreports.report.builder.DynamicReports;
//import net.sf.dynamicreports.report.builder.column.Columns;
//import net.sf.dynamicreports.report.builder.component.Components;
//import net.sf.dynamicreports.report.builder.datatype.DataTypes;
//import net.sf.dynamicreports.report.constant.HorizontalAlignment;
//import net.sf.dynamicreports.report.exception.DRException;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.component.export.PDFOrientationType;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "OCController")
@SessionScoped
public class OCController extends TablaOC implements Serializable {

    public String ponerOC(int id) {

        this.setIdOt(id);

        return "CompraMateriales.xhtml";
    }

    public String modifica() {

        OCGestion.modificar(this.getIdOt());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha aceptado la orden de compra."));
        return "CompraMateriales.xhtml";
    }

    public List<TablaOC> getTablaOC() {
        return OCGestion.getTablaOC();
    }

    public List<TablaMList> getMOTa() {
        return OCGestion.getMOTa(this.getIdOt());
    }

//    public String pdfOC() {
//
//        try {
//            HashMap hm = new HashMap();
//            hm.put("id", "%57%");
//            JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
//                    "C:\\Users\\KevinOcampo\\JaspersoftWorkspace\\MyReports\\prue.jasper", null,
//                    Conexion.getConexion());
//            
//            JasperViewer.viewReport ( jasperPrintWindow, false) ;
//            
////            JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
////            jasperViewer.setVisible(true);
//        } catch (JRException ex) {
//            ex.printStackTrace();
//        }
//
////            JRPdfExporter pdfExporter = new JRPdfExporter();
////            pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
////            pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(reportOutput));
////            pdfExporter.exportReport();
////
//////
//////            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/produccion/list.jasper"));
//////            JasperPrint reporteJasper = JasperFillManager.fillReport(jasper.getPath(), hm, Conexion.getConexion());
//////
//////            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//////            respuesta.setContentType("application/pdf");
//////            respuesta.addHeader("Content-Type", "application/pdf");
//////            ServletOutputStream flujo = respuesta.getOutputStream();
//////
//////            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
//////            FacesContext.getCurrentInstance().responseComplete();
////
////
////
////        try {
////
////            HashMap hm = new HashMap();
////            hm.put("id", this.getIdOt());
////            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/produccion/list.jasper"));
////            JasperPrint reporteJasper = JasperFillManager.fillReport(jasper.getPath(), null, Conexion.getConexion());
////
////            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
////            respuesta.addHeader("Content-disposition", "attachment; filename=reporte.pdf");
////            ServletOutputStream flujo = respuesta.getOutputStream();
////
////            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
////            FacesContext.getCurrentInstance().responseComplete();
////        } catch (JRException | IOException ex) {
////            ex.printStackTrace();
////        }
//
//        return "OCController";
//    }
   

    

}
