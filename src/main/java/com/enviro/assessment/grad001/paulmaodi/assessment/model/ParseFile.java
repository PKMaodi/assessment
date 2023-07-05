package com.enviro.assessment.grad001.paulmaodi.assessment.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ParseFile implements FileParser{
    //The file extension type to be read from the csv file
    private String fileExtension;
    private EntityManagerFactory entityManagerFactory;
    
    public ParseFile(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void parseCSV(File csvFile) throws IOException{
    
        //Read and store all lines from the csv file
        List<String> records = Files.readAllLines(csvFile.toPath());

        //Iterate through the lines
        for(String line: records){
            String[] tokens = line.split(",");
            //create a new AccountProfile object
            AccountProfile accountProfile = new AccountProfile();
            //set the name
            accountProfile.setName(tokens[0]);
            //set the surname
            accountProfile.setSurname(tokens[1]);
            //set the image format
            fileExtension = tokens[2].split("/")[1];
            accountProfile.setImageFormat(fileExtension);
            //set the http image link
            File fileImage = convertCSVDataToImage(tokens[3]);
            accountProfile.setHttpImageLink(createImageLink(fileImage));
            //persist the object
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            //begin the transaction
            entityManager.getTransaction().begin();
            //persist the object
            entityManager.persist(accountProfile);
            //commit the transaction
            entityManager.getTransaction().commit();
            //close the entity manager
            entityManager.close();

        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) throws IOException{
        //decode the base64 data
        byte[] imgData = Base64.getDecoder().decode(base64ImageData);
        //create a new file
        File imaFile = File.createTempFile("image", fileExtension);
        //write the data to the file
        OutputStream outputStream = new FileOutputStream(imaFile);
        outputStream.write(imgData);
        outputStream.close();
        //return the file
        return imaFile;

    }

    @Override
    public URI createImageLink(File fileImage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createImageLink'");
    }
    
}
