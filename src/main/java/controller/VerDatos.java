/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrdenSerDao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.OrdenServicioBD;

/**
 *
 * @author emily
 */
@Named(value = "verDatos")
@SessionScoped
public class VerDatos extends OrdenServicioBD implements Serializable {

    public VerDatos() {
    }

    /*INSERTAR DATOS NUEVOS*/
    public String guardarInformacion() {
        OrdenSerDao ordenSerDao = new OrdenSerDao();
        ordenSerDao.crearOrdenS(this);
        return "OrdenServicio.xhtml";
    }

    /*VACIA LOS CAMPOS AL HACER UNO NUEVO*/
    public String vaciarEspacios() {
        this.setCliente("");
        this.setVisitaUno(1);
        this.setVisitaDos(1);
        this.setDireccion("");
        this.setFechaVisi("");
        this.setHoraVisi("");
        this.setIdEspacio(1);
        this.setMuestra("");
        this.setEstado("No Realizada");
        return "verDatos";

    }

    /*VISUALIZAR LISTA*/
    public List<OrdenServicioBD> getOrdenesSer() {
        return OrdenSerDao.getOrdenesSer();
    }

    /*CARGAR DATOS AL DAR EDITAR*/
    public String edita(int IdOrdenSer) {
        OrdenServicioBD ordenServicioBD
                = OrdenSerDao.getOrdenServicioBD(IdOrdenSer);
        if (ordenServicioBD != null) {
            this.setIdOrdenSer(ordenServicioBD.getIdOrdenSer());
            this.setCliente(ordenServicioBD.getCliente());
            this.setVisitaUno(ordenServicioBD.getVisitaUno());
            this.setVisitaDos(ordenServicioBD.getVisitaDos());
            this.setDireccion(ordenServicioBD.getDireccion());
            this.setFechaVisi(ordenServicioBD.getFechaVisi());
            this.setHoraVisi(ordenServicioBD.getHoraVisi());
            this.setIdEspacio(ordenServicioBD.getIdEspacio());
            this.setMuestra(ordenServicioBD.getMuestra());
            this.setEstado(ordenServicioBD.getEstado());
            return "EditarOrdenServ.xhtml";
        } else {
            return "OrdenServicio.xhtml";
        }
    }

    /*MODIFICA LOS CAMBIOS*/
    public String modifica() {
        OrdenSerDao.modificar(this);
        return "OrdenServicio.xhtml";
    }
}
