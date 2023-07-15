package com.enviro.assessment.grad001.paulmaodi.assessment.account;

import com.opencsv.bean.CsvBindByName;

public class FileBinder {
    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "surname")
    private String surname;

    @CsvBindByName(column = "imageFormat")
    private String imageFormat;

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
