package com.enviro.assessment.grad001.paulmaodi.assessment.service.File;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;
import com.enviro.assessment.grad001.paulmaodi.assessment.repository.AccountRepository;
import com.enviro.assessment.grad001.paulmaodi.assessment.service.AccountProfile.AccountProfileService;

@Service
public class ParseFile implements FileParser {
    private FileParser fileParser;

    @Autowired
    private AccountRepository accProfileRepo;

    @Override
    public void parseCSV(File csvFile) throws IOException {

        // Read and store all lines from the csv file
        List<String> records = Files.readAllLines(csvFile.toPath());

        for (String line : records) {
            String[] tokens = line.split(",");

            String name = tokens[0];
            String surname = tokens[1];
            String base64ImageData = tokens[3];
            File ImageLink = convertCSVDataToImage(base64ImageData);

            URL httpImageLink = createImageLink(ImageLink);

            // create a new AccountProfile object
            AccountProfile accountProfile = new AccountProfile();
            // set the name
            accountProfile.setName(name);
            // set the surname
            accountProfile.setSurname(surname);
            // set the httpImageLink
            accountProfile.setHttpImageLink(httpImageLink);

            // store to the database
            accProfileRepo.save(accountProfile);
        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) throws IOException {
        // decode the base64 data
        byte[] imgData = Base64.getDecoder().decode(base64ImageData);
        // create a new file
        File imaFile = File.createTempFile("image", ".png");
        // write the data to the file
        OutputStream outputStream = new FileOutputStream(imaFile);
        outputStream.write(imgData);
        outputStream.close();
        // return the file
        return imaFile;

    }

    @Override
    public URL createImageLink(File fileImage) {
        String urlString = "http://localhost:37311/v1/api/image/" + fileImage.getName();
        URL httpUrl;
        try {
            httpUrl = new URL(urlString);
            return httpUrl;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void setParsing() throws IOException {
        File csvFile = new File("resources\\1672815113084-GraduateDev_AssessmentCsv_Ref003.csv");
        fileParser.parseCSV(csvFile);
    }

}
