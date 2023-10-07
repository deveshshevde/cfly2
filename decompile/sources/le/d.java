package le;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import com.xeagle.android.newUI.beans.b;
import com.xeagle.android.utils.c;
import com.xeagle.android.vjoystick.beans.PdfBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import ok.h;
import okhttp3.ac;
import okhttp3.u;
import okhttp3.x;
import on.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import os.a;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private Retrofit f30789a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f30790b;

    /* renamed from: c  reason: collision with root package name */
    private String f30791c;

    public d(String str) {
        this.f30791c = str;
        x a2 = new x.a().a(true).a((HostnameVerifier) new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        }).a(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).a();
        this.f30789a = new Retrofit.Builder().baseUrl(str).client(a2).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).callbackExecutor(Executors.newFixedThreadPool(1)).build();
    }

    public d(String str, b bVar) {
        this.f30791c = str;
        this.f30790b = bVar;
        x a2 = new x.a().a((u) new a(bVar)).a(true).a((HostnameVerifier) new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        }).a(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).a();
        this.f30789a = new Retrofit.Builder().baseUrl(str).client(a2).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).callbackExecutor(Executors.newFixedThreadPool(1)).build();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x004a A[SYNTHETIC, Splitter:B:37:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0054 A[SYNTHETIC, Splitter:B:42:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x005f A[SYNTHETIC, Splitter:B:49:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0069 A[SYNTHETIC, Splitter:B:54:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0075 A[SYNTHETIC, Splitter:B:60:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x007f A[SYNTHETIC, Splitter:B:65:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0045=Splitter:B:34:0x0045, B:46:0x005a=Splitter:B:46:0x005a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(byte[] r3, java.lang.String r4) {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = r0.exists()
            if (r4 == 0) goto L_0x0011
            r0.delete()
        L_0x0011:
            r4 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0043, all -> 0x0040 }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0043, all -> 0x0040 }
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0038, all -> 0x0034 }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0038, all -> 0x0034 }
            r0.write(r3)     // Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x0030, all -> 0x002e }
            r0.flush()     // Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x0030, all -> 0x002e }
            r1.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002a:
            r0.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x002e:
            r3 = move-exception
            goto L_0x0036
        L_0x0030:
            r3 = move-exception
            goto L_0x003a
        L_0x0032:
            r3 = move-exception
            goto L_0x003e
        L_0x0034:
            r3 = move-exception
            r0 = r4
        L_0x0036:
            r4 = r1
            goto L_0x0073
        L_0x0038:
            r3 = move-exception
            r0 = r4
        L_0x003a:
            r4 = r1
            goto L_0x0045
        L_0x003c:
            r3 = move-exception
            r0 = r4
        L_0x003e:
            r4 = r1
            goto L_0x005a
        L_0x0040:
            r3 = move-exception
            r0 = r4
            goto L_0x0073
        L_0x0043:
            r3 = move-exception
            r0 = r4
        L_0x0045:
            r3.printStackTrace()     // Catch:{ all -> 0x0072 }
            if (r4 == 0) goto L_0x0052
            r4.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0052:
            if (r0 == 0) goto L_0x0071
            r0.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x0058:
            r3 = move-exception
            r0 = r4
        L_0x005a:
            r3.printStackTrace()     // Catch:{ all -> 0x0072 }
            if (r4 == 0) goto L_0x0067
            r4.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0067:
            if (r0 == 0) goto L_0x0071
            r0.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0071:
            return
        L_0x0072:
            r3 = move-exception
        L_0x0073:
            if (r4 == 0) goto L_0x007d
            r4.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r4 = move-exception
            r4.printStackTrace()
        L_0x007d:
            if (r0 == 0) goto L_0x0087
            r0.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x0087
        L_0x0083:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0087:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: le.d.a(byte[], java.lang.String):void");
    }

    public void a(String str, final ImageView imageView) {
        b bVar = this.f30790b;
        if (bVar != null) {
            bVar.onStartDownload();
        }
        ((e) this.f30789a.create(e.class)).a(str).a(new c<ac, byte[]>() {
            /* renamed from: a */
            public byte[] call(ac acVar) {
                try {
                    return acVar.bytes();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }).b(a.b()).a(om.a.a()).b(new h<byte[]>() {
            /* renamed from: a */
            public void onNext(byte[] bArr) {
                if (bArr != null) {
                    imageView.setImageBitmap(com.xeagle.android.utils.c.a(bArr, 1920, 1080));
                }
            }

            public void onCompleted() {
                d.this.f30790b.onFinishDownload();
            }

            public void onError(Throwable th) {
                d.this.f30790b.onFail(th.getMessage());
            }
        });
    }

    public void a(String str, ImageView imageView, int i2, int i3, String str2) {
        Log.i("LiteHelper", "parseImageCover:---- " + str);
        b bVar = this.f30790b;
        if (bVar != null) {
            bVar.onStartDownload();
        }
        final ImageView imageView2 = imageView;
        final int i4 = i2;
        final int i5 = i3;
        final String str3 = str2;
        ((e) this.f30789a.create(e.class)).a(str).b(a.b()).a(new c<ac, byte[]>() {
            /* renamed from: a */
            public byte[] call(ac acVar) {
                try {
                    return acVar.bytes();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    d.this.f30790b.onFail(e2.getMessage());
                    return null;
                }
            }
        }).a(om.a.a()).b(new h<byte[]>() {
            /* renamed from: a */
            public void onNext(final byte[] bArr) {
                ImageView imageView = imageView2;
                if (!(imageView == null || bArr == null)) {
                    imageView.post(new Runnable() {
                        public void run() {
                            Bitmap b2 = com.xeagle.android.utils.c.b(bArr, i4, i5);
                            if (b2 != null && !b2.isRecycled()) {
                                imageView2.setImageBitmap(b2);
                            }
                        }
                    });
                }
                d.this.a(bArr, str3);
            }

            public void onCompleted() {
                Log.i("Listener", "onCompleted: ---download image");
                d.this.f30790b.onFinishDownload();
            }

            public void onError(Throwable th) {
                d.this.f30790b.onFail(th.getMessage());
            }
        });
    }

    public void a(String str, final String str2) {
        b bVar = this.f30790b;
        if (bVar != null) {
            bVar.onStartDownload();
        }
        ((e) this.f30789a.create(e.class)).a(str).b(a.b()).a(new c<ac, byte[]>() {
            /* renamed from: a */
            public byte[] call(ac acVar) {
                try {
                    return acVar.bytes();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    d.this.f30790b.onFail(e2.getMessage());
                    return null;
                }
            }
        }).a(om.a.a()).b(new h<byte[]>() {
            /* renamed from: a */
            public void onNext(byte[] bArr) {
                if (bArr != null) {
                    d.this.a(bArr, str2);
                }
            }

            public void onCompleted() {
                d.this.f30790b.onFinishDownload();
            }

            public void onError(Throwable th) {
                d.this.f30790b.onFail(th.getMessage());
            }
        });
    }

    public void a(String str, final String str2, final c.C0151c cVar) {
        b bVar = this.f30790b;
        if (bVar != null) {
            bVar.onStartDownload();
        }
        ((e) this.f30789a.create(e.class)).a(str).b(a.b()).a(new on.c<ac, byte[]>() {
            /* renamed from: a */
            public byte[] call(ac acVar) {
                try {
                    return acVar.bytes();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    d.this.f30790b.onFail(e2.getMessage());
                    return null;
                }
            }
        }).a(om.a.a()).b(new h<byte[]>() {
            /* renamed from: a */
            public void onNext(byte[] bArr) {
                if (bArr != null) {
                    com.xeagle.android.utils.c.a(bArr, str2, cVar);
                }
            }

            public void onCompleted() {
                d.this.f30790b.onFinishDownload();
            }

            public void onError(Throwable th) {
                d.this.f30790b.onFail(th.getMessage());
            }
        });
    }

    public void a(String str, h<ArrayList<b>> hVar) {
        ((e) this.f30789a.create(e.class)).a(str).b(a.b()).a(new on.c<ac, ArrayList<b>>() {
            /* renamed from: a */
            public ArrayList<b> call(ac acVar) {
                ArrayList<b> arrayList = new ArrayList<>();
                try {
                    JSONArray jSONArray = new JSONObject(acVar.string()).getJSONArray("list");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        b bVar = new b();
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        bVar.e(jSONObject.getString("title"));
                        bVar.d(jSONObject.getString("duration"));
                        bVar.c(jSONObject.getString("cover_url"));
                        bVar.b(jSONObject.getString("video_url"));
                        bVar.a(jSONObject.getString("flag"));
                        arrayList.add(bVar);
                        Log.i("LiteHelper", "call: --->>>" + bVar.toString());
                    }
                    return arrayList;
                } catch (IOException | JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }).a(om.a.a()).b(hVar);
    }

    public void b(String str, h<PdfBean> hVar) {
        ((e) this.f30789a.create(e.class)).b(str).b(a.b()).a(om.a.a()).b(hVar);
    }
}
