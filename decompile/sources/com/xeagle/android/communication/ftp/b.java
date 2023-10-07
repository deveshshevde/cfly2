package com.xeagle.android.communication.ftp;

import android.util.Log;
import com.hoho.android.usb.ftp.d;
import com.myusb.proxy.proto.Proxy;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.communication.ftp.FtpBase;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import kotlin.jvm.internal.h;
import kotlin.text.f;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class b extends FtpBase {

    /* renamed from: a  reason: collision with root package name */
    public static final a f22459a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private com.hoho.android.usb.rtsp.a f22460b;

    /* renamed from: c  reason: collision with root package name */
    private final d f22461c = new d();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final FtpBase.UploadStatus a(String str, d dVar) {
        String str2 = str;
        d dVar2 = dVar;
        FtpBase.UploadStatus uploadStatus = FtpBase.UploadStatus.CREATE_DIRECTORY_SUCCESS;
        int i2 = 1;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        String substring = str2.substring(0, f.b((CharSequence) str2, "/", 0, false, 6, (Object) null) + 1);
        h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            if (f.a("/", substring, true)) {
                return uploadStatus;
            }
            Charset forName = Charset.forName("GBK");
            h.b(forName, "Charset.forName(charsetName)");
            if (substring != null) {
                byte[] bytes = substring.getBytes(forName);
                h.b(bytes, "(this as java.lang.String).getBytes(charset)");
                Charset charset = StandardCharsets.ISO_8859_1;
                h.b(charset, "StandardCharsets.ISO_8859_1");
                if (dVar2.g(new String(bytes, charset))) {
                    return uploadStatus;
                }
                if (!f.b(substring, "/", false, 2, (Object) null)) {
                    i2 = 0;
                }
                int a2 = f.a((CharSequence) substring, "/", i2, false, 4, (Object) null);
                while (str2 != null) {
                    String substring2 = str2.substring(i2, a2);
                    h.b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Charset forName2 = Charset.forName("GBK");
                    h.b(forName2, "Charset.forName(charsetName)");
                    if (substring2 != null) {
                        byte[] bytes2 = substring2.getBytes(forName2);
                        h.b(bytes2, "(this as java.lang.String).getBytes(charset)");
                        Charset charset2 = StandardCharsets.ISO_8859_1;
                        h.b(charset2, "StandardCharsets.ISO_8859_1");
                        String str3 = new String(bytes2, charset2);
                        if (!dVar2.i(str3)) {
                            dVar2.g(str3);
                            i2 = a2 + 1;
                            a2 = f.a((CharSequence) substring, "/", i2, false, 4, (Object) null);
                            if (a2 <= i2) {
                                return uploadStatus;
                            }
                        } else {
                            Log.i("RTSP", "createDirectory: ===创建目录失败");
                            return FtpBase.UploadStatus.CREATE_DIRECTORY_FAIL;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e2) {
            e2.printStackTrace();
            return FtpBase.UploadStatus.CREATE_DIRECTORY_FAIL;
        }
    }

    public final FtpBase.UploadStatus a(String str) throws Exception {
        h.d(str, "remoteFile");
        this.f22461c.f();
        this.f22461c.b(2);
        this.f22461c.b("GBK");
        CharSequence charSequence = str;
        if (f.a(charSequence, (CharSequence) "/", false, 2, (Object) null)) {
            String substring = str.substring(f.b(charSequence, "/", 0, false, 6, (Object) null) + 1);
            h.b(substring, "(this as java.lang.String).substring(startIndex)");
            if (a(str, this.f22461c) == FtpBase.UploadStatus.CREATE_DIRECTORY_FAIL) {
                return FtpBase.UploadStatus.CREATE_DIRECTORY_FAIL;
            }
            str = substring;
        }
        String j2 = this.f22461c.j(str);
        Log.i("RTSP", "deleteRemoteFile: ====response===" + j2);
        return (j2 == null || !f.b(j2, "213", false, 2, (Object) null)) ? FtpBase.UploadStatus.REMOTE_FILE_NOEXIST : this.f22461c.h(str) ? FtpBase.UploadStatus.DELETE_REMOTE_SUCCESS : FtpBase.UploadStatus.DELETE_REMOTE_FAIL;
    }

    public final void a(XEagleApp xEagleApp) {
        h.d(xEagleApp, "xEagleApp");
        com.hoho.android.usb.usb.data_proxy.d e2 = xEagleApp.e();
        Proxy.ConnType connType = Proxy.ConnType.FTP;
        Proxy.MsgType msgType = Proxy.MsgType.FTP_DOWNLOAD_STOP;
        byte[] bytes = "".getBytes(kotlin.text.d.f30261a);
        h.b(bytes, "(this as java.lang.String).getBytes(charset)");
        e2.a(-1, connType, msgType, "172.50.10.1", 21, 0, 0, "", bytes);
    }

    public final void a(XEagleApp xEagleApp, String str, int i2, com.hoho.android.usb.usb.data_proxy.f fVar) throws Exception {
        h.d(xEagleApp, "xEagleApp");
        h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        h.d(fVar, "param");
        xEagleApp.e().b("DOWN_LOAD");
        xEagleApp.e().a("DOWN_LOAD", fVar);
        com.hoho.android.usb.usb.data_proxy.d e2 = xEagleApp.e();
        Proxy.ConnType connType = Proxy.ConnType.FTP;
        Proxy.MsgType msgType = Proxy.MsgType.FTP_DOWNLOAD_START;
        byte[] bytes = str.getBytes(kotlin.text.d.f30261a);
        h.b(bytes, "(this as java.lang.String).getBytes(charset)");
        e2.a(i2, connType, msgType, "172.50.10.1", 21, 0, 0, str, bytes);
    }

    public final boolean a() {
        com.hoho.android.usb.rtsp.a aVar = this.f22460b;
        if (aVar != null) {
            h.a((Object) aVar);
            if (aVar.a()) {
                return true;
            }
        }
        return false;
    }
}
