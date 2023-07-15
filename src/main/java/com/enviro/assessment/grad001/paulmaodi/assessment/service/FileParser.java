package com.enviro.assessment.grad001.paulmaodi.assessment.service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public interface FileParser {
    void parseCSV(File csvFile) throws IOException, URISyntaxException;

    File convertCSVDataToImage(String base64ImageData) throws IOException;

    URI createImageLink(File fileImage) throws URISyntaxException;
}
