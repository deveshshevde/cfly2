package com.xeagle.android.login.beans;

import com.flypro.core.database.ListenerInfoBeans;
import java.util.ArrayList;

public class ListenerDataBean {
    private int currentPage;
    private ArrayList<ListenerInfoBeans> data;
    private int lastPage;
    private int perPage;
    private int totalDegree;
    private float totalFlightTime;
    private float totalMileage;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public ArrayList<ListenerInfoBeans> getData() {
        return this.data;
    }

    public int getLastPage() {
        return this.lastPage;
    }

    public int getPerPage() {
        return this.perPage;
    }

    public int getTotalDegree() {
        return this.totalDegree;
    }

    public float getTotalFlightTime() {
        return this.totalFlightTime;
    }

    public float getTotalMileage() {
        return this.totalMileage;
    }

    public void setCurrentPage(int i2) {
        this.currentPage = i2;
    }

    public void setData(ArrayList<ListenerInfoBeans> arrayList) {
        this.data = arrayList;
    }

    public void setLastPage(int i2) {
        this.lastPage = i2;
    }

    public void setPerPage(int i2) {
        this.perPage = i2;
    }

    public void setTotalDegree(int i2) {
        this.totalDegree = i2;
    }

    public void setTotalFlightTime(float f2) {
        this.totalFlightTime = f2;
    }

    public void setTotalMileage(float f2) {
        this.totalMileage = f2;
    }

    public String toString() {
        return "ListenerDataBean{currentPage=" + this.currentPage + ", perPage=" + this.perPage + ", lastPage=" + this.lastPage + ", data=" + this.data.size() + ", totalDegree=" + this.totalDegree + ", totalMileage=" + this.totalMileage + ", totalFlightTime=" + this.totalFlightTime + '}';
    }
}
