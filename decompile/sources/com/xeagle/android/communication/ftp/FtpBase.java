package com.xeagle.android.communication.ftp;

public class FtpBase {

    public enum UploadStatus {
        CREATE_DIRECTORY_FAIL,
        CREATE_DIRECTORY_SUCCESS,
        UPLOAD_NEW_FILE_SUCCESS,
        UPLOAD_NEW_FILE_FAIL,
        FILE_EXIST,
        REMOTE_BIGGER_LOCAL,
        UPLOAD_FROM_BREAK_SUCCESS,
        UPLOAD_FROM_BREAK_FAIL,
        DELETE_REMOTE_FAIL,
        DELETE_REMOTE_SUCCESS,
        REMOTE_FILE_NOEXIST
    }
}
