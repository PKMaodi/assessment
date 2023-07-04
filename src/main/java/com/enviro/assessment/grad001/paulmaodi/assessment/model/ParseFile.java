package com.enviro.assessment.grad001.paulmaodi.assessment.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;

public class ParseFile implements FileParser{
    //The file extension type to be read from the csv file
    private String fileExtension;

    @Override
    public void parseCSV(File csvFile) throws IOException{
        //Read the CSV records
        FileReader flReader;
        BufferedReader buReader;
        String lineString;
        String[] records;

        List<AccountProfile> profiles = new ArrayList<>();
        flReader = new FileReader(csvFile);
        buReader = new BufferedReader(flReader);
        lineString = buReader.readLine();

        while(lineString != null){
            records = lineString.split(",");
            
            //Creating an Account Profile
            AccountProfile accountProfile = new AccountProfile();
            accountProfile.setName(records[0]);
            accountProfile.setSurname(records[1]);
            fileExtension = records[2];
            accountProfile.setHttpImageLink(records[3]);
            
            //Save each profile
            profiles.add(accountProfile);

        }

        //Persist the profiles to the database
        
        
        
        
        
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
