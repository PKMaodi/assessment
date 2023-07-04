package com.enviro.assessment.grad001.paulmaodi.assessment.model;

import java.io.File;
import java.net.URI;

public interface FileParser {
    void parseCSV(File csvFile);
    File convertCSVDataToImage(String base64ImageData);
    URI createImageLink(File fileImage);
}
