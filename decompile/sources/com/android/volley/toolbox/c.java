package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.a;
import com.android.volley.l;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class c implements com.android.volley.a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f9962a;

    /* renamed from: b  reason: collision with root package name */
    private long f9963b;

    /* renamed from: c  reason: collision with root package name */
    private final File f9964c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9965d;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f9966a;

        /* renamed from: b  reason: collision with root package name */
        public String f9967b;

        /* renamed from: c  reason: collision with root package name */
        public String f9968c;

        /* renamed from: d  reason: collision with root package name */
        public long f9969d;

        /* renamed from: e  reason: collision with root package name */
        public long f9970e;

        /* renamed from: f  reason: collision with root package name */
        public long f9971f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, String> f9972g;

        private a() {
        }

        public a(String str, a.C0077a aVar) {
            this.f9967b = str;
            this.f9966a = (long) aVar.f9887a.length;
            this.f9968c = aVar.f9888b;
            this.f9969d = aVar.f9889c;
            this.f9970e = aVar.f9890d;
            this.f9971f = aVar.f9891e;
            this.f9972g = aVar.f9892f;
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            if (objectInputStream.readByte() == 2) {
                aVar.f9967b = objectInputStream.readUTF();
                String readUTF = objectInputStream.readUTF();
                aVar.f9968c = readUTF;
                if (readUTF.equals("")) {
                    aVar.f9968c = null;
                }
                aVar.f9969d = objectInputStream.readLong();
                aVar.f9970e = objectInputStream.readLong();
                aVar.f9971f = objectInputStream.readLong();
                aVar.f9972g = a(objectInputStream);
                return aVar;
            }
            throw new IOException();
        }

        private static Map<String, String> a(ObjectInputStream objectInputStream) throws IOException {
            int readInt = objectInputStream.readInt();
            Map<String, String> emptyMap = readInt == 0 ? Collections.emptyMap() : new HashMap<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                emptyMap.put(objectInputStream.readUTF().intern(), objectInputStream.readUTF().intern());
            }
            return emptyMap;
        }

        private static void a(Map<String, String> map, ObjectOutputStream objectOutputStream) throws IOException {
            if (map != null) {
                objectOutputStream.writeInt(map.size());
                for (Map.Entry next : map.entrySet()) {
                    objectOutputStream.writeUTF((String) next.getKey());
                    objectOutputStream.writeUTF((String) next.getValue());
                }
                return;
            }
            objectOutputStream.writeInt(0);
        }

        public a.C0077a a(byte[] bArr) {
            a.C0077a aVar = new a.C0077a();
            aVar.f9887a = bArr;
            aVar.f9888b = this.f9968c;
            aVar.f9889c = this.f9969d;
            aVar.f9890d = this.f9970e;
            aVar.f9891e = this.f9971f;
            aVar.f9892f = this.f9972g;
            return aVar;
        }

        public boolean a(OutputStream outputStream) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeByte(2);
                objectOutputStream.writeUTF(this.f9967b);
                String str = this.f9968c;
                if (str == null) {
                    str = "";
                }
                objectOutputStream.writeUTF(str);
                objectOutputStream.writeLong(this.f9969d);
                objectOutputStream.writeLong(this.f9970e);
                objectOutputStream.writeLong(this.f9971f);
                a(this.f9972g, objectOutputStream);
                objectOutputStream.flush();
                return true;
            } catch (IOException e2) {
                l.b("%s", e2.toString());
                return false;
            }
        }
    }

    private static class b extends FilterInputStream {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f9973a;

        private b(InputStream inputStream) {
            super(inputStream);
            this.f9973a = 0;
        }

        /* synthetic */ b(InputStream inputStream, b bVar) {
            this(inputStream);
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f9973a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = super.read(bArr, i2, i3);
            if (read != -1) {
                this.f9973a += read;
            }
            return read;
        }
    }

    public c(File file) {
        this(file, 5242880);
    }

    public c(File file, int i2) {
        this.f9962a = new LinkedHashMap(16, 0.75f, true);
        this.f9963b = 0;
        this.f9964c = file;
        this.f9965d = i2;
    }

    private void a(int i2) {
        long j2;
        long j3 = (long) i2;
        if (this.f9963b + j3 >= ((long) this.f9965d)) {
            if (l.f9936b) {
                l.a("Pruning old cache entries.", new Object[0]);
            }
            long j4 = this.f9963b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, a>> it2 = this.f9962a.entrySet().iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                a aVar = (a) it2.next().getValue();
                if (c(aVar.f9967b).delete()) {
                    j2 = j3;
                    this.f9963b -= aVar.f9966a;
                } else {
                    j2 = j3;
                    l.b("Could not delete cache entry for key=%s, filename=%s", aVar.f9967b, d(aVar.f9967b));
                }
                it2.remove();
                i3++;
                if (((float) (this.f9963b + j2)) < ((float) this.f9965d) * 0.9f) {
                    break;
                }
                j3 = j2;
            }
            if (l.f9936b) {
                l.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.f9963b - j4), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void a(String str, a aVar) {
        if (!this.f9962a.containsKey(str)) {
            this.f9963b += aVar.f9966a;
        } else {
            this.f9963b += aVar.f9966a - this.f9962a.get(str).f9966a;
        }
        this.f9962a.put(str, aVar);
    }

    private static byte[] a(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        if (i3 == i2) {
            return bArr;
        }
        throw new IOException("Expected " + i2 + " bytes, read " + i3 + " bytes");
    }

    private String d(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())) + String.valueOf(str.substring(length).hashCode());
    }

    private void e(String str) {
        a aVar = this.f9962a.get(str);
        if (aVar != null) {
            this.f9963b -= aVar.f9966a;
            this.f9962a.remove(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b A[SYNTHETIC, Splitter:B:29:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0066 A[SYNTHETIC, Splitter:B:38:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.android.volley.a.C0077a a(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Map<java.lang.String, com.android.volley.toolbox.c$a> r0 = r8.f9962a     // Catch:{ all -> 0x006d }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x006d }
            com.android.volley.toolbox.c$a r0 = (com.android.volley.toolbox.c.a) r0     // Catch:{ all -> 0x006d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r8)
            return r1
        L_0x000e:
            java.io.File r2 = r8.c(r9)     // Catch:{ all -> 0x006d }
            com.android.volley.toolbox.c$b r3 = new com.android.volley.toolbox.c$b     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r4.<init>(r2)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r3.<init>(r4, r1)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            com.android.volley.toolbox.c.a.a((java.io.InputStream) r3)     // Catch:{ IOException -> 0x0039 }
            long r4 = r2.length()     // Catch:{ IOException -> 0x0039 }
            int r6 = r3.f9973a     // Catch:{ IOException -> 0x0039 }
            long r6 = (long) r6     // Catch:{ IOException -> 0x0039 }
            long r4 = r4 - r6
            int r5 = (int) r4     // Catch:{ IOException -> 0x0039 }
            byte[] r4 = a((java.io.InputStream) r3, (int) r5)     // Catch:{ IOException -> 0x0039 }
            com.android.volley.a$a r9 = r0.a((byte[]) r4)     // Catch:{ IOException -> 0x0039 }
            r3.close()     // Catch:{ IOException -> 0x0037 }
            monitor-exit(r8)
            return r9
        L_0x0037:
            monitor-exit(r8)
            return r1
        L_0x0039:
            r0 = move-exception
            goto L_0x0040
        L_0x003b:
            r9 = move-exception
            r3 = r1
            goto L_0x0064
        L_0x003e:
            r0 = move-exception
            r3 = r1
        L_0x0040:
            java.lang.String r4 = "%s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0063 }
            r6 = 0
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0063 }
            r5[r6] = r2     // Catch:{ all -> 0x0063 }
            r2 = 1
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0063 }
            r5[r2] = r0     // Catch:{ all -> 0x0063 }
            com.android.volley.l.b(r4, r5)     // Catch:{ all -> 0x0063 }
            r8.b(r9)     // Catch:{ all -> 0x0063 }
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0061
        L_0x005f:
            monitor-exit(r8)
            return r1
        L_0x0061:
            monitor-exit(r8)
            return r1
        L_0x0063:
            r9 = move-exception
        L_0x0064:
            if (r3 == 0) goto L_0x006c
            r3.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006c
        L_0x006a:
            monitor-exit(r8)
            return r1
        L_0x006c:
            throw r9     // Catch:{ all -> 0x006d }
        L_0x006d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.c.a(java.lang.String):com.android.volley.a$a");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:28|29|(2:38|39)|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0061 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0058 A[SYNTHETIC, Splitter:B:35:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0064 A[SYNTHETIC, Splitter:B:43:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0067 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.io.File r0 = r8.f9964c     // Catch:{ all -> 0x006a }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x006a }
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.io.File r0 = r8.f9964c     // Catch:{ all -> 0x006a }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Unable to create cache dir %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x006a }
            java.io.File r3 = r8.f9964c     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006a }
            r2[r1] = r3     // Catch:{ all -> 0x006a }
            com.android.volley.l.c(r0, r2)     // Catch:{ all -> 0x006a }
        L_0x0022:
            monitor-exit(r8)
            return
        L_0x0024:
            java.io.File r0 = r8.f9964c     // Catch:{ all -> 0x006a }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r8)
            return
        L_0x002e:
            int r2 = r0.length     // Catch:{ all -> 0x006a }
        L_0x002f:
            if (r1 < r2) goto L_0x0033
            monitor-exit(r8)
            return
        L_0x0033:
            r3 = r0[r1]     // Catch:{ all -> 0x006a }
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0055 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0055 }
            com.android.volley.toolbox.c$a r4 = com.android.volley.toolbox.c.a.a((java.io.InputStream) r5)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            long r6 = r3.length()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r4.f9966a = r6     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            java.lang.String r6 = r4.f9967b     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r8.a((java.lang.String) r6, (com.android.volley.toolbox.c.a) r4)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r5.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x0067
        L_0x004e:
            r0 = move-exception
            r4 = r5
            goto L_0x005c
        L_0x0051:
            r4 = r5
            goto L_0x0056
        L_0x0053:
            r0 = move-exception
            goto L_0x005c
        L_0x0055:
        L_0x0056:
            if (r3 == 0) goto L_0x0062
            r3.delete()     // Catch:{ all -> 0x0053 }
            goto L_0x0062
        L_0x005c:
            if (r4 == 0) goto L_0x0061
            r4.close()     // Catch:{ IOException -> 0x0061 }
        L_0x0061:
            throw r0     // Catch:{ all -> 0x006a }
        L_0x0062:
            if (r4 == 0) goto L_0x0067
            r4.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0067:
            int r1 = r1 + 1
            goto L_0x002f
        L_0x006a:
            r0 = move-exception
            monitor-exit(r8)
            goto L_0x006e
        L_0x006d:
            throw r0
        L_0x006e:
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.c.a():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|(1:10)|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        com.android.volley.l.b("Could not clean up file %s", r0.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0.delete() == false) goto L_0x002b;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r4, com.android.volley.a.C0077a r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            byte[] r0 = r5.f9887a     // Catch:{ all -> 0x003c }
            int r0 = r0.length     // Catch:{ all -> 0x003c }
            r3.a((int) r0)     // Catch:{ all -> 0x003c }
            java.io.File r0 = r3.c(r4)     // Catch:{ all -> 0x003c }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0025 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0025 }
            com.android.volley.toolbox.c$a r2 = new com.android.volley.toolbox.c$a     // Catch:{ IOException -> 0x0025 }
            r2.<init>(r4, r5)     // Catch:{ IOException -> 0x0025 }
            r2.a((java.io.OutputStream) r1)     // Catch:{ IOException -> 0x0025 }
            byte[] r5 = r5.f9887a     // Catch:{ IOException -> 0x0025 }
            r1.write(r5)     // Catch:{ IOException -> 0x0025 }
            r1.close()     // Catch:{ IOException -> 0x0025 }
            r3.a((java.lang.String) r4, (com.android.volley.toolbox.c.a) r2)     // Catch:{ IOException -> 0x0025 }
            monitor-exit(r3)
            return
        L_0x0025:
            boolean r4 = r0.delete()     // Catch:{ all -> 0x003c }
            if (r4 != 0) goto L_0x003a
            java.lang.String r4 = "Could not clean up file %s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x003c }
            r1 = 0
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x003c }
            r5[r1] = r0     // Catch:{ all -> 0x003c }
            com.android.volley.l.b(r4, r5)     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r3)
            return
        L_0x003c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.c.a(java.lang.String, com.android.volley.a$a):void");
    }

    public synchronized void b(String str) {
        boolean delete = c(str).delete();
        e(str);
        if (!delete) {
            l.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    public File c(String str) {
        return new File(this.f9964c, d(str));
    }
}
