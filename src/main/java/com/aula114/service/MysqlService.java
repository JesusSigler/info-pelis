/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aula114.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Jesus Sigler Martinez
 */
public class MysqlService implements Serializable{

    final static String nombre = "root";//cambia segun el equipo
    final static String password = "root";//cambia segun el equipo
    final static String database = "peliculas";
    final static String archivo_sql = "peliculas.sql";
    final static Logger logger = Logger.getLogger(MysqlService.class.getName());

    //Servicio encargado de manejar la exportacion de la base de datos
    public StreamedContent getBackup() {
        //Se inicializa una lista a la que se le pasara el comando necesario para la importacion
        List<String> command = new ArrayList<String>();
        command.add("mysqldump");
        command.add("--default_character_set=utf8");
        command.add("--single-transaction");
        command.add("-u" + nombre);
        command.add("-p" + password);
        command.add(database);
        try {
            ProcessBuilder builder = new ProcessBuilder(command).redirectErrorStream(
                    true);
            Process process = builder.start();
//            process.waitFor();
            InputStream inputStream = process.getInputStream();
            StreamedContent backupContent = new DefaultStreamedContent(inputStream,
                    "application/sql", archivo_sql);
            return backupContent;
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //servicio encargado de importar la base de datos
    public boolean restore(UploadedFile file) {
        throw new UnsupportedOperationException("metodo no implementado.");
    }
}
