package com.enviro.assessment.grad001.paulmaodi.assessment.account;

import com.opencsv.bean.CsvBindByName;

/**
 * A Java bean to bind data from 1672815113084-GraduateDev_AssessmentCsv_Ref003
 * to a Java object using the OpenCSV library.
 */
public class FileBinder {
    /**
     * Account holder name mapped to the name column in the csv file.
     */
    @CsvBindByName(column = "name")
    private String name;

    /**
     * Account holder surname mapped to the surname column in the csv file.
     */
    @CsvBindByName(column = "surname")
    private String surname;

    /**
     * The image format mapped to the Image Format column in the csv file.
     */
    @CsvBindByName(column = "imageFormat")
    private String imageFormat;

    /**
     * Base64 Image Data name mapped to the Image Data column in the csv file.
     */
    @CsvBindByName(column = "imageData")
    private String imageData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

}
