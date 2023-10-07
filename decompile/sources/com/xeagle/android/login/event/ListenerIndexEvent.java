package com.xeagle.android.login.event;

public class ListenerIndexEvent {
    private int index;

    public ListenerIndexEvent(int i2) {
        this.index = i2;
    }

    public int getIndex() {
        return this.index;
    }

    public String toString() {
        return "ListenerIndexEvent{index=" + this.index + '}';
    }
}
