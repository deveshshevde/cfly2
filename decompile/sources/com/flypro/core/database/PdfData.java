package com.flypro.core.database;

import org.litepal.crud.LitePalSupport;

public class PdfData extends LitePalSupport {
    private String file_size;
    private String flag;
    private String image_url;
    private boolean isUpdate;
    private String name;
    private String pdf_url;
    private String version;

    public String getFile_size() {
        return this.file_size;
    }

    public String getFlag() {
        return this.flag;
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

    public boolean isUpdate() {
        return this.isUpdate;
    }

    public void setFile_size(String str) {
        this.file_size = str;
    }

    public void setFlag(String str) {
        this.flag = str;
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

    public void setUpdate(boolean z2) {
        this.isUpdate = z2;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return this.name + ":" + this.pdf_url + ":" + this.file_size + ":" + this.image_url + ":" + this.version + ":" + this.isUpdate + ":" + this.flag;
    }
}
