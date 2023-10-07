package com.xeagle.android.login.common;

public enum StorageType {
    TYPE_LOG(DirectoryName.LOG_DIRECTORY_NAME),
    TYPE_TEMP(DirectoryName.TEMP_DIRECTORY_NAME),
    TYPE_FILE(DirectoryName.FILE_DIRECTORY_NAME),
    TYPE_AUDIO(DirectoryName.AUDIO_DIRECTORY_NAME),
    TYPE_IMAGE(DirectoryName.IMAGE_DIRECTORY_NAME),
    TYPE_VIDEO(DirectoryName.VIDEO_DIRECTORY_NAME),
    TYPE_THUMB_IMAGE(DirectoryName.THUMB_DIRECTORY_NAME),
    TYPE_THUMB_VIDEO(DirectoryName.THUMB_DIRECTORY_NAME);
    
    private DirectoryName storageDirectoryName;
    private long storageMinSize;

    enum DirectoryName {
        AUDIO_DIRECTORY_NAME("audio/"),
        DATA_DIRECTORY_NAME("data/"),
        FILE_DIRECTORY_NAME("file/"),
        LOG_DIRECTORY_NAME("log/"),
        TEMP_DIRECTORY_NAME("temp/"),
        IMAGE_DIRECTORY_NAME("image/"),
        THUMB_DIRECTORY_NAME("thumb/"),
        VIDEO_DIRECTORY_NAME("video/");
        
        private String path;

        private DirectoryName(String str) {
            this.path = str;
        }

        public String getPath() {
            return this.path;
        }
    }

    private StorageType(DirectoryName directoryName) {
        this(r7, r8, directoryName, 20971520);
    }

    private StorageType(DirectoryName directoryName, long j2) {
        this.storageDirectoryName = directoryName;
        this.storageMinSize = j2;
    }

    public long getStorageMinSize() {
        return this.storageMinSize;
    }

    public String getStoragePath() {
        return this.storageDirectoryName.getPath();
    }
}
