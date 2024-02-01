package com.towhid.petshopinventory_oct;

public class DataClass {
    private String dataName;
    private String dataType;
    private String dataDesc;
    private String dataCageno;
    private String dataSellerName;
    private String dataSellerAdress;
    private String dataPetPrice;
    private String dataPurchaseDate;
    private String dataImage;
    private String dataSchedule;

    public String getDataSchedule() {
        return dataSchedule;
    }

    public DataClass(String dataSchedule) {
        this.dataSchedule = dataSchedule;
    }

    private String key;

    // Default constructor required for Firebase
    public DataClass() {
    }

    public String getDataName() {
        return dataName;
    }

    public String getDataType() {
        return dataType;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public String getDataCageno() {
        return dataCageno;
    }

    public String getDataSellerName() {
        return dataSellerName;
    }

    public String getDataSellerAdress() {
        return dataSellerAdress;
    }

    public String getDataPetPrice() {
        return dataPetPrice;
    }

    public String getDataPurchaseDate() {
        return dataPurchaseDate;
    }

    public String getDataImage() {
        return dataImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public DataClass(String dataName, String dataType, String dataDesc, String dataCageno, String dataSellerName, String dataSellerAdress, String dataPetPrice, String dataPurchaseDate, String dataImage) {
        this.dataName = dataName;
        this.dataType = dataType;
        this.dataDesc = dataDesc;
        this.dataCageno = dataCageno;
        this.dataSellerName = dataSellerName;
        this.dataSellerAdress = dataSellerAdress;
        this.dataPetPrice = dataPetPrice;
        this.dataPurchaseDate = dataPurchaseDate;
        this.dataImage = dataImage;
    }
}
