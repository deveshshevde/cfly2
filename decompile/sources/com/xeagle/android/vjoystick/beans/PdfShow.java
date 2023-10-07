package com.xeagle.android.vjoystick.beans;

public class PdfShow {
    private String file_size;
    private String image_url;
    private String name;
    private String pdf_url;
    private String version;

    public PdfShow(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.pdf_url = str2;
        this.file_size = str3;
        this.image_url = str4;
        this.version = str5;
    }

    public String getFile_size() {
        return this.file_size;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public String getName() {
        return this.name;
    }

    public String getPdf_url() {
        return this.pdf_url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setFile_size(String str) {
        this.file_size = str;
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPdf_url(String str) {
        this.pdf_url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
