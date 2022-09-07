package com.example.springWeb;



public class Car {
    private String brand;
    private String model;

//    public Car(String brand, String model) {
//        this.brand = brand;
//        this.model = model;
//    } NẾU ĐỂ CONSTRUCTOR NTN THÌ TYPEREFERENCE CHIẾU DỮ LIỆU TỪ FILE VÀO
    // VÀ KHÔNG CÓ THAM SỐ (CONSTRUCTOR NÀY CẦN 2 TS LÀ 2 STRING) THÌ SẼ BỊ LỖI


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
