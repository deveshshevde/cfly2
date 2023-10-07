package com.xeagle.android.communication.ftp;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.xeagle.android.communication.ftp.FtpBase;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import org.apache.commons.net.b;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.c;
import org.apache.commons.net.ftp.j;

public class a extends FtpBase {

    /* renamed from: a  reason: collision with root package name */
    public c f22451a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22452b = 1;

    /* renamed from: c  reason: collision with root package name */
    private Handler f22453c;

    /* renamed from: d  reason: collision with root package name */
    private String f22454d;

    /* renamed from: e  reason: collision with root package name */
    private String f22455e;

    /* renamed from: f  reason: collision with root package name */
    private String f22456f;

    /* renamed from: g  reason: collision with root package name */
    private String f22457g;

    /* renamed from: h  reason: collision with root package name */
    private Context f22458h;

    public a(Context context, String str, String str2, String str3, String str4) {
        c cVar = new c();
        this.f22451a = cVar;
        this.f22458h = context;
        this.f22454d = str;
        this.f22455e = str2;
        this.f22456f = str3;
        this.f22457g = str4;
        cVar.a((b) new org.apache.commons.net.a(new PrintWriter(System.out)));
    }

    private FtpBase.UploadStatus a(String str, c cVar) throws IOException {
        FtpBase.UploadStatus uploadStatus = FtpBase.UploadStatus.CREATE_DIRECTORY_SUCCESS;
        String substring = str.substring(0, str.lastIndexOf("/") + 1);
        if ("/".equalsIgnoreCase(substring) || cVar.k(new String(substring.getBytes("GBK"), StandardCharsets.ISO_8859_1))) {
            return uploadStatus;
        }
        int startsWith = substring.startsWith("/");
        int indexOf = substring.indexOf("/", startsWith);
        do {
            String str2 = new String(str.substring(startsWith, indexOf).getBytes("GBK"), StandardCharsets.ISO_8859_1);
            if (!cVar.k(str2)) {
                if (cVar.q(str2)) {
                    cVar.k(str2);
                } else {
                    Log.i("FTP", "CreateDirectory: ===创建目录失败");
                    return FtpBase.UploadStatus.CREATE_DIRECTORY_FAIL;
                }
            }
            startsWith = indexOf + 1;
            indexOf = substring.indexOf("/", startsWith);
        } while (indexOf > startsWith);
        return uploadStatus;
    }

    public FtpBase.UploadStatus a(String str, File file, c cVar, long j2) throws IOException {
        long j3;
        long j4;
        String str2 = str;
        long j5 = j2;
        long length = file.length() / 100;
        int i2 = str2.contains("DF") ? 2 : 1;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        OutputStream j6 = cVar.j(new String(str2.getBytes("GBK"), StandardCharsets.ISO_8859_1));
        if (j5 > 0) {
            cVar.b(j2);
            j4 = j5 / length;
            randomAccessFile.seek(j5);
            j3 = j5;
        } else {
            j4 = 0;
            j3 = 0;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = randomAccessFile.read(bArr);
            if (read == -1) {
                break;
            }
            Message message = new Message();
            j6.write(bArr, 0, read);
            byte[] bArr2 = bArr;
            j3 += (long) read;
            long j7 = j3 / length;
            if (j7 != j4) {
                message.obj = Long.valueOf(j7);
                message.arg1 = i2;
                this.f22453c.sendMessage(message);
                j4 = j7;
            }
            bArr = bArr2;
        }
        j6.flush();
        randomAccessFile.close();
        j6.close();
        boolean r2 = cVar.r();
        return j5 > 0 ? r2 ? FtpBase.UploadStatus.UPLOAD_FROM_BREAK_SUCCESS : FtpBase.UploadStatus.UPLOAD_FROM_BREAK_FAIL : r2 ? FtpBase.UploadStatus.UPLOAD_NEW_FILE_SUCCESS : FtpBase.UploadStatus.UPLOAD_NEW_FILE_FAIL;
    }

    public FtpBase.UploadStatus a(String str, String str2) throws IOException {
        this.f22451a.s();
        this.f22451a.c(2);
        this.f22451a.a("GBK");
        if (str2.contains("/")) {
            String substring = str2.substring(str2.lastIndexOf("/") + 1);
            if (a(str2, this.f22451a) == FtpBase.UploadStatus.CREATE_DIRECTORY_FAIL) {
                return FtpBase.UploadStatus.CREATE_DIRECTORY_FAIL;
            }
            str2 = substring;
        }
        return this.f22451a.p(new String(str2.getBytes("GBK"), StandardCharsets.ISO_8859_1)).length == 1 ? this.f22451a.m(str2) ? FtpBase.UploadStatus.DELETE_REMOTE_SUCCESS : FtpBase.UploadStatus.DELETE_REMOTE_FAIL : FtpBase.UploadStatus.REMOTE_FILE_NOEXIST;
    }

    public FtpBase.UploadStatus a(String str, String str2, Handler handler) throws IOException {
        String str3;
        long j2;
        c cVar;
        File file;
        String str4;
        a aVar;
        this.f22453c = handler;
        this.f22451a.s();
        this.f22451a.c(2);
        this.f22451a.a("GBK");
        if (str2.contains("/")) {
            String substring = str2.substring(str2.lastIndexOf("/") + 1);
            if (a(str2, this.f22451a) == FtpBase.UploadStatus.CREATE_DIRECTORY_FAIL) {
                return FtpBase.UploadStatus.CREATE_DIRECTORY_FAIL;
            }
            str3 = substring;
        } else {
            str3 = str2;
        }
        FTPFile[] p2 = this.f22451a.p(new String(str3.getBytes("GBK"), StandardCharsets.ISO_8859_1));
        if (p2.length == 1) {
            long b2 = p2[0].b();
            File file2 = new File(str);
            if (b2 == file2.length()) {
                return FtpBase.UploadStatus.FILE_EXIST;
            }
            if (a(str, str2).name().equals(FtpBase.UploadStatus.DELETE_REMOTE_SUCCESS.name())) {
                a(str, str2, handler);
            }
            FtpBase.UploadStatus a2 = a(str3, file2, this.f22451a, b2);
            if (a2 != FtpBase.UploadStatus.UPLOAD_FROM_BREAK_FAIL) {
                return a2;
            }
            if (!this.f22451a.m(str3)) {
                return FtpBase.UploadStatus.DELETE_REMOTE_FAIL;
            }
            cVar = this.f22451a;
            j2 = 0;
            aVar = this;
            str4 = str3;
            file = file2;
        } else {
            file = new File(str);
            cVar = this.f22451a;
            j2 = 0;
            aVar = this;
            str4 = str3;
        }
        return aVar.a(str4, file, cVar, j2);
    }

    public void a() throws IOException {
        if (this.f22451a.d()) {
            this.f22451a.c();
        }
    }

    public boolean a(String str, int i2, String str2, String str3) throws IOException {
        this.f22451a.a(str, i2);
        this.f22451a.a("GBK");
        if (!j.b(this.f22451a.i()) || !this.f22451a.f(str2, str3)) {
            a();
            return false;
        }
        Log.i("FTP", "ftp connect: =====success");
        return true;
    }
}
