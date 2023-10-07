package androidx.room;

import af.a;
import af.d;
import ag.b;
import ag.c;
import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

class l implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4462a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4463b;

    /* renamed from: c  reason: collision with root package name */
    private final File f4464c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4465d;

    /* renamed from: e  reason: collision with root package name */
    private final c f4466e;

    /* renamed from: f  reason: collision with root package name */
    private a f4467f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4468g;

    l(Context context, String str, File file, int i2, c cVar) {
        this.f4462a = context;
        this.f4463b = str;
        this.f4464c = file;
        this.f4465d = i2;
        this.f4466e = cVar;
    }

    private void a(File file) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.f4463b != null) {
            readableByteChannel = Channels.newChannel(this.f4462a.getAssets().open(this.f4463b));
        } else if (this.f4464c != null) {
            readableByteChannel = new FileInputStream(this.f4464c).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f4462a.getCacheDir());
        createTempFile.deleteOnExit();
        d.a(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        } else if (!createTempFile.renameTo(file)) {
            throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
        }
    }

    private void c() {
        String a2 = a();
        File databasePath = this.f4462a.getDatabasePath(a2);
        a aVar = this.f4467f;
        a aVar2 = new a(a2, this.f4462a.getFilesDir(), aVar == null || aVar.f4391j);
        try {
            aVar2.a();
            if (!databasePath.exists()) {
                a(databasePath);
                aVar2.b();
            } else if (this.f4467f == null) {
                aVar2.b();
            } else {
                try {
                    int a3 = af.c.a(databasePath);
                    int i2 = this.f4465d;
                    if (a3 == i2) {
                        aVar2.b();
                    } else if (this.f4467f.a(a3, i2)) {
                        aVar2.b();
                    } else {
                        if (this.f4462a.deleteDatabase(a2)) {
                            try {
                                a(databasePath);
                            } catch (IOException e2) {
                                Log.w("ROOM", "Unable to copy database file.", e2);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + a2 + ") for a copy destructive migration.");
                        }
                        aVar2.b();
                    }
                } catch (IOException e3) {
                    Log.w("ROOM", "Unable to read database version.", e3);
                    aVar2.b();
                }
            }
        } catch (IOException e4) {
            throw new RuntimeException("Unable to copy database file.", e4);
        } catch (Throwable th) {
            aVar2.b();
            throw th;
        }
    }

    public String a() {
        return this.f4466e.a();
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f4467f = aVar;
    }

    public void a(boolean z2) {
        this.f4466e.a(z2);
    }

    public synchronized b b() {
        if (!this.f4468g) {
            c();
            this.f4468g = true;
        }
        return this.f4466e.b();
    }

    public synchronized void close() {
        this.f4466e.close();
        this.f4468g = false;
    }
}
