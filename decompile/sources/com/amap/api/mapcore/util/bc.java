package com.amap.api.mapcore.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

final class bc {

    /* renamed from: a  reason: collision with root package name */
    RandomAccessFile f8050a;

    public bc() throws IOException {
        this("", 0);
    }

    public bc(String str, long j2) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e2) {
                fz.c(e2, "FileAccessI", "create");
                e2.printStackTrace();
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        this.f8050a = randomAccessFile;
        randomAccessFile.seek(j2);
    }

    public final synchronized int a(byte[] bArr) throws IOException {
        this.f8050a.write(bArr);
        return bArr.length;
    }

    public final void a() {
        RandomAccessFile randomAccessFile = this.f8050a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f8050a = null;
        }
    }
}
