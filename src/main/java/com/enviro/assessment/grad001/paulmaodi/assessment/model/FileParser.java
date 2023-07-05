package com.enviro.assessment.grad001.paulmaodi.assessment.model;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public interface FileParser {
    void parseCSV(File csvFile) throws IOException;
    File convertCSVDataToImage(String base64ImageData) throws IOException;
    URI createImageLink(File fileImage);
}
