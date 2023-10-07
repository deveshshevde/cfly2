package com.xeagle.android.login.ijkplayer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

public class FileMediaDataSource implements IMediaDataSource {
    private RandomAccessFile mFile;
    private long mFileSize;

    public FileMediaDataSource(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.mFile = randomAccessFile;
        this.mFileSize = randomAccessFile.length();
    }

    public void close() throws IOException {
        this.mFileSize = 0;
        this.mFile.close();
        this.mFile = null;
    }

    public long getSize() throws IOException {
        return this.mFileSize;
    }

    public int readAt(long j2, byte[] bArr, int i2, int i3) throws IOException {
        if (this.mFile.getFilePointer() != j2) {
            this.mFile.seek(j2);
        }
        if (i3 == 0) {
            return 0;
        }
        return this.mFile.read(bArr, 0, i3);
    }
}
