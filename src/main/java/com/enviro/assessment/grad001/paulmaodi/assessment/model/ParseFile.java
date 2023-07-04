package com.enviro.assessment.grad001.paulmaodi.assessment.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;

public class ParseFile implements FileParser{
    //The file extension type to be read from the csv file
    private String fileExtension;

    @Override
    public void parseCSV(File csvFile) {
        //Read the CSV records
        FileReader flReader;
        BufferedReader buReader;
        String lineString;
        String[] records;
        try{
            flReader = new FileReader(csvFile);
            buReader = new BufferedReader(flReader);
            lineString = buReader.readLine();
            while(lineString != null){
                records = lineString.split(",");
                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertCSVDataToImage'");
    }

    @Override
    public URI createImageLink(File fileImage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createImageLink'");
    }
    
}
