package com.enviro.assessment.grad001.paulmaodi.assessment.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.paulmaodi.assessment.account.FileBinder;
import com.enviro.assessment.grad001.paulmaodi.assessment.entity.AccountProfile;
import com.enviro.assessment.grad001.paulmaodi.assessment.repository.AccountRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class ParseFile implements FileParser {

    private AccountRepository accProfileRepo;

    @Autowired
    public ParseFile(AccountRepository accProfileRepo) {
        this.accProfileRepo = accProfileRepo;
    }

    @Override
    public void parseCSV(File csvFile) throws IOException, URISyntaxException {

        // Read and store all lines from the csv file
        // List<String> records = Files.readAllLines(csvFile.toPath());
        List<FileBinder> data;
        FileReader fileReader = new FileReader(csvFile);
        CsvToBean<FileBinder> csvToBean = new CsvToBeanBuilder<FileBinder>(fileReader).withType(FileBinder.class)
                .withIgnoreLeadingWhiteSpace(true).build();

        data = csvToBean.parse();

        for (FileBinder tokens : data) {
            /*
             * String[] tokens = line.split(",");
             * 
             * String name = tokens[0];
             * String surname = tokens[1];
             * String base64ImageData = tokens[3];
             */
            String name = tokens.getName();
            String surname = tokens.getSurname();
            String base64ImageData = tokens.getImageData();

            File ImageLink = convertCSVDataToImage(base64ImageData);

            URI httpImageLink = createImageLink(ImageLink);

            // create a new AccountProfile object
            AccountProfile accountProfile = new AccountProfile();
            // set the name
            accountProfile.setName(name);
            // set the surname
            accountProfile.setSurname(surname);
            // set the httpImageLink
            accountProfile.setHttpImageLink(httpImageLink.toURL());

            // store to the database
            accProfileRepo.save(accountProfile);
        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) throws IOException {
        // decode the base64 data
        byte[] imgData = Base64.getDecoder().decode(base64ImageData);

        Path imagePath = Paths.get("picture.png");

        // create a new file
        File imaFile = imagePath.toFile();

        Files.write(imagePath, imgData);

        // return the file
        return imaFile;
    }

    @Override
    public URI createImageLink(File fileImage) throws URISyntaxException {
        String uriString = "http://localhost:8081/" + fileImage.getName();
        URI httpUri;
        httpUri = new URI(uriString);
        return httpUri;

    }

}
