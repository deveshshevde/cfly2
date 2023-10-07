package com.xeagle.android.login.beans;

public class RegAcceptBeans {
    private static final int REG_CODE_ERROR = 4009;
    private static final int REG_CODE_NULL = 4008;
    private static final int REG_EMAIL_CODE_ERROR = 4005;
    private static final int REG_EMAIL_ERROR = 4003;
    private static final int REG_EMAIL_EXIST = 4004;
    private static final int REG_PHONE_ERROR = 4001;
    private static final int REG_PHONE_EXIST = 4002;
    private static final int REG_PWD_NULL = 4006;
    private static final int REG_PWD_SHORT = 4007;
    private static final int REG_SUCCESS = 200;
    private int code;
    private String message;
    private boolean status;

    public RegAcceptBeans(boolean z2, int i2, String str) {
        this.status = z2;
        this.code = i2;
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        return "RegAcceptBeans{status=" + this.status + ", code=" + this.code + ", data='" + this.message + '\'' + '}';
    }
}
