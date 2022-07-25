/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.StorageOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Conexion;
import model.Image.Im;
import model.Image.ImGestion;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "ImController")
@SessionScoped
public class ImController extends Im implements Serializable {

    private UploadedFile file;

    public ImController() {
    }

    public ImController(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }


    public void uploadObject(
            String projectId, String bucketName, String objectName, String filePath, int tipo, int idser, int idOt) throws IOException, Exception {

        if (file != null) {
            int ul;
            Im Im
                    = ImGestion.getUl();
            ul=Im.getIdIm();
            
            ul=ul+1;
            


            String pdf = file.getFileName();
            String fe = FilenameUtils.getExtension(pdf);
            Path path;
            projectId = "cogent-point-341421";
            bucketName = "scfm1";

            path = Files.createTempFile(null, "." + fe);
            Files.write(path, file.getContent());
            
            objectName = Integer.toString(ul)+"."+fe;
            

            Storage storage = StorageOptions.newBuilder()
                    .setProjectId(projectId)
                    .setCredentials(GoogleCredentials.fromStream(new FileInputStream(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/cogent-point-341421-c070a17a8019.json")))).build().getService();

            BlobId blobId = BlobId.of(bucketName, objectName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

            storage.create(blobInfo, Files.readAllBytes(path));

            String url = "https://storage.googleapis.com/" + bucketName + "/" + objectName;

            ImGestion ImGestion = new ImGestion();
            ImGestion.insertar(idser, idOt, url, tipo);

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
