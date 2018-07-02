/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aula114.bean;

import com.aula114.service.MysqlService;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Jesus Sigler Martinez
 */
@ManagedBean(name = "export")
@RequestScoped
public class BackUpBean implements Serializable {

    private static final Logger logger = Logger.getLogger(BackUpBean.class.
            getName());

    MysqlService mysql = new MysqlService();

    public BackUpBean() {
        logger.info("BackUpBean");
    }

    /*
        Metodo encarcargado de llamar al servicio que exportara la base de datos
     */
    public StreamedContent getBackup() throws IOException, InterruptedException {
        StreamedContent content = mysql.getBackup();
        if (content == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "La base de datos no se ha exportado correctamente"));
        }
        return content;
    }
    //Metodo que llama al servicio encargado de importar el archivo
    public void handleRestoreFileUpload(FileUploadEvent event) {
        FacesMessage msg;
        boolean result = mysql.restore(event.getFile());
        if (result) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito",
                    "La base de datos ha sido importada correctamente.");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Failure",
                    "La base de datos no se ha importado. Vuelve a intentarlo.");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
