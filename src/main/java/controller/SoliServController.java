/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import dao.SoliServDao;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Image.Im;
import model.Image.ImGestion;
import model.SoliServ;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

/**
 *
 * @author Asus
 */
@Named(value = "soliServController")
@SessionScoped
public class SoliServController extends SoliServ implements Serializable {

    public SoliServController(){
        
    }
    
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public String opasa(int d){
        this.setIdSoliServ(d);
        
        return "soliServController";
    }
    
    public List<SoliServ> getTaIma() {
        
        return SoliServDao.getTaIma(this.getIdSoliServ());
    }
    
    public List<SoliServ> getSOLIMages() {
        return SoliServDao.getSOLIMages();
    }
    
    public List<SoliServ> getSolisS() {
        return SoliServDao.getSolisS();
    }
    public List<SoliServ> getEnvioSS() {
        return SoliServDao.getEnvioSS();
    }
    public String enviadoSS() {
        SoliServDao.enviado(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha enviado la Solicitud de Servicio."));
        return "VerSoliServicio.xhtml";
    }

    /*CARGAR DATOS AL DAR EDITAR*/
    public String edita(int IdSoliServ, int ed) throws IOException {
        SoliServ soliServ
                = SoliServDao.getSoliServ(IdSoliServ);
        if (soliServ != null) {
            this.setIdSoliServ(soliServ.getIdSoliServ());
            this.setNombClient(soliServ.getNombClient());
            this.setPriApeClient(soliServ.getPriApeClient());
            this.setSegApeClient(soliServ.getSegApeClient());
            this.setProyecto(soliServ.getProyecto());
            this.setIdTipoCedu(soliServ.getIdTipoCedu());
            this.setCedula(soliServ.getCedula());
            this.setTelefono(soliServ.getTelefono());
            this.setDireccion(soliServ.getDireccion());
            this.setNotasMue(soliServ.getNotasMue());
            this.setNotasDise(soliServ.getNotasDise());
            this.setDisenoCli(soliServ.getDisenoCli());
            this.setNotasMedi(soliServ.getNotasMedi());
            this.setNotasElem(soliServ.getNotasElem());
            if (ed == 1) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/VerSoliServicio.xhtml");
                return "VerSoliServicio.xhtml";
            } else if (ed == 2) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/EditaSoliServicio.xhtml");
                return "EditaSoliServicio.xhtml";
            }else if(ed ==3){
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/Clasif_SoliServicio.xhtml");
                return "Clasif_SoliServicio.xhtml";
            }
        } else {
            return "SolicitudesServicio.xhtml";
        }
        return "soliServController";
    }

    public String actualizarSoliS() throws IOException {
        SoliServDao.actualizarSoli(this);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/VerSoliServicio.xhtml");
        return "VerSoliServicio.xhtml";
    }

    public String guardarInformacion() {
        SoliServDao soliServDao = new SoliServDao();
        soliServDao.crearSoliS(this);
        return "SolicitudesServicio.xhtml";
    }

    public String vaciarEspacios() {
        this.setNombClient("");
        this.setPriApeClient("");
        this.setSegApeClient("");
        this.setProyecto("");
        this.setIdTipoCedu(0);
        this.setCedula(0);
        this.setTelefono(0);
        this.setDireccion("");
        this.setNotasMue("");
            this.setNotasDise("");
            this.setDisenoCli("");
            this.setNotasMedi("");
            this.setNotasElem("");
        return "soliServController";
    }
    
    public String clasificarSS() throws IOException {
        SoliServDao.clasifSS(this);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/SolicitudesServicio.xhtml");
        return "SolicitudesServicio.xhtml";
    }
    
    public String modificarRechazar() throws IOException {
        SoliServDao.modificarRecha(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Se ha rechazado la solicitud de servicio."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/SolicitudesServicio.xhtml");
        
        return "SolicitudesServicio.xhtml";
    }
    
    public void uploadObject(
            String projectId, String bucketName, String objectName, String filePath, int tipo, int idser, int idOt) throws IOException, Exception {

        if (file != null) {
            int ul;
            SoliServ SoliServ
                    = SoliServDao.getUl();
            ul=SoliServ.getIdSoliServ();
            
            ul=ul+1;
            


            String pdf = file.getFileName();
            String fe = FilenameUtils.getExtension(pdf);
            Path path;
            projectId = "cogent-point-341421";
            bucketName = "scfm1";

            path = Files.createTempFile(null, "." + fe);
            Files.write(path, file.getContent());
            
            objectName = "DisenoCliente" + Integer.toString(ul)+"-"+pdf;

            Storage storage = StorageOptions.newBuilder()
                    .setProjectId(projectId)
                    .setCredentials(GoogleCredentials.fromStream(new FileInputStream(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/cogent-point-341421-c070a17a8019.json")))).build().getService();

            BlobId blobId = BlobId.of(bucketName, objectName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

            storage.create(blobInfo, Files.readAllBytes(path));

            String url = "https://storage.googleapis.com/" + bucketName + "/" + objectName;

            this.setDisenoCli(url);
            

// el tipo se refiere a la parte de donde se guarda la imagen 
//solicitud de servico=1

//diseno final=2
//
//cotizacion del proveedor=3
//
//Produc----Orden trabajo=4
//
//calida_______CalidadCliente=5
//
//Calidad Empresa=6
//
//Orden Reparacion Calidad=7
//
//Orden Reparacion Logistica=8
//
//Orden Reparacion Garantia=9
//
//Instalacion=10
            Files.delete(path);

            System.out.println("subio");

        } else {
            FacesMessage message = new FacesMessage("No hay datos", "Ingresar imagen");
        }

    }


  
}
