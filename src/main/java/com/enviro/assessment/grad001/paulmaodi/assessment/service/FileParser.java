package com.enviro.assessment.grad001.paulmaodi.assessment.service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Interface to parse the csv file, convert the base64ImageData to image and
 * create the image link.
 */
public interface FileParser {
    /**
     * This method is used to parse the csv file.
     * 
     * @param csvFile The csv file to be parsed.
     * @throws IOException
     * @throws URISyntaxException
     */
    void parseCSV(File csvFile) throws IOException, URISyntaxException;

    /**
     * This method is used to convert the base64ImageData to image.
     * 
     * @param base64ImageData The base64ImageData to be converted to image.
     * @return The image.
     * @throws IOException
     */
    File convertCSVDataToImage(String base64ImageData) throws IOException;

    /**
     * This method is used to create the image link.
     * 
     * @param fileImage The image to be linked.
     * @return The image link.
     * @throws URISyntaxException
     */
    URI createImageLink(File fileImage) throws URISyntaxException;
}
