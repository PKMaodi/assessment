package com.enviro.assessment.grad001.paulmaodi.assessment.service.File;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public interface FileParser {
    void parseCSV(File csvFile) throws IOException;

    File convertCSVDataToImage(String base64ImageData) throws IOException;

    URL createImageLink(File fileImage);
}
