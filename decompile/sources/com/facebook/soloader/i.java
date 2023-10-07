package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Map;

public abstract class i extends b {

    /* renamed from: c  reason: collision with root package name */
    protected String f11402c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f11403d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f11410a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11411b;

        public a(String str, String str2) {
            this.f11410a = str;
            this.f11411b = str2;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final a[] f11412a;

        public b(a[] aVarArr) {
            this.f11412a = aVarArr;
        }

        static final b a(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    a[] aVarArr = new a[readInt];
                    for (int i2 = 0; i2 < readInt; i2++) {
                        aVarArr[i2] = new a(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new b(aVarArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void a(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.f11412a.length);
            int i2 = 0;
            while (true) {
                a[] aVarArr = this.f11412a;
                if (i2 < aVarArr.length) {
                    dataOutput.writeUTF(aVarArr[i2].f11410a);
                    dataOutput.writeUTF(this.f11412a[i2].f11411b);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    protected static final class c implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public final a f11413a;

        /* renamed from: b  reason: collision with root package name */
        public final InputStream f11414b;

        public void close() throws IOException {
            this.f11414b.close();
        }
    }

    protected static abstract class d implements Closeable {
        public abstract boolean a();

        public abstract c b() throws IOException;

        public void close() throws IOException {
        }
    }

    protected static abstract class e implements Closeable {
        /* access modifiers changed from: protected */
        public abstract b a() throws IOException;

        /* access modifiers changed from: protected */
        public abstract d b() throws IOException;

        public void close() throws IOException {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043 A[Catch:{ all -> 0x009b, all -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a A[Catch:{ all -> 0x009b, all -> 0x00c7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(byte r10, com.facebook.soloader.i.b r11, com.facebook.soloader.i.d r12) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "regenerating DSO store "
            r0.append(r1)
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "fb-UnpackingSoSource"
            android.util.Log.v(r1, r0)
            java.io.File r0 = new java.io.File
            java.io.File r2 = r9.f11398a
            java.lang.String r3 = "dso_manifest"
            r0.<init>(r2, r3)
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile
            java.lang.String r3 = "rw"
            r2.<init>(r0, r3)
            r0 = 1
            if (r10 != r0) goto L_0x003f
            com.facebook.soloader.i$b r10 = com.facebook.soloader.i.b.a((java.io.DataInput) r2)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0040
        L_0x0036:
            r10 = move-exception
            goto L_0x00c6
        L_0x0039:
            r10 = move-exception
            java.lang.String r3 = "error reading existing DSO manifest"
            android.util.Log.i(r1, r3, r10)     // Catch:{ all -> 0x0036 }
        L_0x003f:
            r10 = 0
        L_0x0040:
            r3 = 0
            if (r10 != 0) goto L_0x004a
            com.facebook.soloader.i$b r10 = new com.facebook.soloader.i$b     // Catch:{ all -> 0x0036 }
            com.facebook.soloader.i$a[] r4 = new com.facebook.soloader.i.a[r3]     // Catch:{ all -> 0x0036 }
            r10.<init>(r4)     // Catch:{ all -> 0x0036 }
        L_0x004a:
            com.facebook.soloader.i$a[] r11 = r11.f11412a     // Catch:{ all -> 0x0036 }
            r9.a((com.facebook.soloader.i.a[]) r11)     // Catch:{ all -> 0x0036 }
            r11 = 32768(0x8000, float:4.5918E-41)
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0036 }
        L_0x0054:
            boolean r4 = r12.a()     // Catch:{ all -> 0x0036 }
            if (r4 == 0) goto L_0x00a6
            com.facebook.soloader.i$c r4 = r12.b()     // Catch:{ all -> 0x0036 }
            r5 = 1
            r6 = 0
        L_0x0060:
            if (r5 == 0) goto L_0x008d
            com.facebook.soloader.i$a[] r7 = r10.f11412a     // Catch:{ all -> 0x008b }
            int r7 = r7.length     // Catch:{ all -> 0x008b }
            if (r6 >= r7) goto L_0x008d
            com.facebook.soloader.i$a[] r7 = r10.f11412a     // Catch:{ all -> 0x008b }
            r7 = r7[r6]     // Catch:{ all -> 0x008b }
            java.lang.String r7 = r7.f11410a     // Catch:{ all -> 0x008b }
            com.facebook.soloader.i$a r8 = r4.f11413a     // Catch:{ all -> 0x008b }
            java.lang.String r8 = r8.f11410a     // Catch:{ all -> 0x008b }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x008b }
            if (r7 == 0) goto L_0x0088
            com.facebook.soloader.i$a[] r7 = r10.f11412a     // Catch:{ all -> 0x008b }
            r7 = r7[r6]     // Catch:{ all -> 0x008b }
            java.lang.String r7 = r7.f11411b     // Catch:{ all -> 0x008b }
            com.facebook.soloader.i$a r8 = r4.f11413a     // Catch:{ all -> 0x008b }
            java.lang.String r8 = r8.f11411b     // Catch:{ all -> 0x008b }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x008b }
            if (r7 == 0) goto L_0x0088
            r5 = 0
        L_0x0088:
            int r6 = r6 + 1
            goto L_0x0060
        L_0x008b:
            r10 = move-exception
            goto L_0x0093
        L_0x008d:
            if (r5 == 0) goto L_0x00a0
            r9.a((com.facebook.soloader.i.c) r4, (byte[]) r11)     // Catch:{ all -> 0x008b }
            goto L_0x00a0
        L_0x0093:
            throw r10     // Catch:{ all -> 0x0094 }
        L_0x0094:
            r11 = move-exception
            if (r4 == 0) goto L_0x009f
            r4.close()     // Catch:{ all -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r12 = move-exception
            r10.addSuppressed(r12)     // Catch:{ all -> 0x0036 }
        L_0x009f:
            throw r11     // Catch:{ all -> 0x0036 }
        L_0x00a0:
            if (r4 == 0) goto L_0x0054
            r4.close()     // Catch:{ all -> 0x0036 }
            goto L_0x0054
        L_0x00a6:
            r2.close()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Finished regenerating DSO store "
            r10.append(r11)
            java.lang.Class r11 = r9.getClass()
            java.lang.String r11 = r11.getName()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.v(r1, r10)
            return
        L_0x00c6:
            throw r10     // Catch:{ all -> 0x00c7 }
        L_0x00c7:
            r11 = move-exception
            r2.close()     // Catch:{ all -> 0x00cc }
            goto L_0x00d0
        L_0x00cc:
            r12 = move-exception
            r10.addSuppressed(r12)
        L_0x00d0:
            goto L_0x00d2
        L_0x00d1:
            throw r11
        L_0x00d2:
            goto L_0x00d1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.i.a(byte, com.facebook.soloader.i$b, com.facebook.soloader.i$d):void");
    }

    private void a(c cVar, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        Log.i("fb-UnpackingSoSource", "extracting DSO " + cVar.f11413a.f11410a);
        if (this.f11398a.setWritable(true, true)) {
            File file = new File(this.f11398a, cVar.f11413a.f11410a);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e2) {
                Log.w("fb-UnpackingSoSource", "error overwriting " + file + " trying to delete and start over", e2);
                SysUtil.a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            try {
                int available = cVar.f11414b.available();
                if (available > 1) {
                    SysUtil.a(randomAccessFile.getFD(), (long) available);
                }
                SysUtil.a(randomAccessFile, cVar.f11414b, SubsamplingScaleImageView.TILE_SIZE_AUTO, bArr);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (file.setExecutable(true, false)) {
                    randomAccessFile.close();
                    return;
                }
                throw new IOException("cannot make file executable: " + file);
            } catch (IOException e3) {
                SysUtil.a(file);
                throw e3;
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } else {
            throw new IOException("cannot make directory writable for us: " + this.f11398a);
        }
    }

    private void a(a[] aVarArr) throws IOException {
        String[] list = this.f11398a.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                    boolean z2 = false;
                    int i2 = 0;
                    while (!z2 && i2 < aVarArr.length) {
                        if (aVarArr[i2].f11410a.equals(str)) {
                            z2 = true;
                        }
                        i2++;
                    }
                    if (!z2) {
                        File file = new File(this.f11398a, str);
                        Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + file);
                        SysUtil.a(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.f11398a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        r12.addSuppressed(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00da, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00db, code lost:
        if (r2 != null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e1, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r12.addSuppressed(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e5, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e8, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e9, code lost:
        if (r0 != null) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ef, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r12.addSuppressed(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00f3, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f6, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00fb, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00fc, code lost:
        r12.addSuppressed(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0100, code lost:
        throw r13;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.facebook.soloader.d r12, int r13, byte[] r14) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "fb-UnpackingSoSource"
            java.io.File r6 = new java.io.File
            java.io.File r1 = r11.f11398a
            java.lang.String r2 = "dso_state"
            r6.<init>(r1, r2)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "rw"
            r1.<init>(r6, r2)
            r8 = 1
            r3 = 0
            byte r4 = r1.readByte()     // Catch:{ EOFException -> 0x0035, all -> 0x0037 }
            if (r4 == r8) goto L_0x0043
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0035, all -> 0x0037 }
            r4.<init>()     // Catch:{ EOFException -> 0x0035, all -> 0x0037 }
            java.lang.String r5 = "dso store "
            r4.append(r5)     // Catch:{ EOFException -> 0x0035, all -> 0x0037 }
            java.io.File r5 = r11.f11398a     // Catch:{ EOFException -> 0x0035, all -> 0x0037 }
            r4.append(r5)     // Catch:{ EOFException -> 0x0035, all -> 0x0037 }
            java.lang.String r5 = " regeneration interrupted: wiping clean"
            r4.append(r5)     // Catch:{ EOFException -> 0x0035, all -> 0x0037 }
            java.lang.String r4 = r4.toString()     // Catch:{ EOFException -> 0x0035, all -> 0x0037 }
            android.util.Log.v(r0, r4)     // Catch:{ EOFException -> 0x0035, all -> 0x0037 }
        L_0x0035:
            r4 = 0
            goto L_0x0043
        L_0x0037:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r13 = move-exception
            r1.close()     // Catch:{ all -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r14 = move-exception
            r12.addSuppressed(r14)
        L_0x0042:
            throw r13
        L_0x0043:
            r1.close()
            java.io.File r5 = new java.io.File
            java.io.File r1 = r11.f11398a
            java.lang.String r7 = "dso_deps"
            r5.<init>(r1, r7)
            r1 = 0
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile
            r7.<init>(r5, r2)
            long r9 = r7.length()     // Catch:{ all -> 0x00f4 }
            int r2 = (int) r9     // Catch:{ all -> 0x00f4 }
            byte[] r9 = new byte[r2]     // Catch:{ all -> 0x00f4 }
            int r10 = r7.read(r9)     // Catch:{ all -> 0x00f4 }
            if (r10 == r2) goto L_0x0068
            java.lang.String r2 = "short read of so store deps file: marking unclean"
            android.util.Log.v(r0, r2)     // Catch:{ all -> 0x00f4 }
            r4 = 0
        L_0x0068:
            boolean r2 = java.util.Arrays.equals(r9, r14)     // Catch:{ all -> 0x00f4 }
            if (r2 != 0) goto L_0x0074
            java.lang.String r2 = "deps mismatch on deps store: regenerating"
            android.util.Log.v(r0, r2)     // Catch:{ all -> 0x00f4 }
            r4 = 0
        L_0x0074:
            if (r4 == 0) goto L_0x007d
            r2 = r13 & 2
            if (r2 == 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r0 = r1
            goto L_0x009f
        L_0x007d:
            java.lang.String r1 = "so store dirty: regenerating"
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x00f4 }
            b(r6, r3)     // Catch:{ all -> 0x00f4 }
            com.facebook.soloader.i$e r0 = r11.a()     // Catch:{ all -> 0x00f4 }
            com.facebook.soloader.i$b r1 = r0.a()     // Catch:{ all -> 0x00e6 }
            com.facebook.soloader.i$d r2 = r0.b()     // Catch:{ all -> 0x00e6 }
            r11.a((byte) r4, (com.facebook.soloader.i.b) r1, (com.facebook.soloader.i.d) r2)     // Catch:{ all -> 0x00d8 }
            if (r2 == 0) goto L_0x0099
            r2.close()     // Catch:{ all -> 0x00e6 }
        L_0x0099:
            if (r0 == 0) goto L_0x007b
            r0.close()     // Catch:{ all -> 0x00f4 }
            goto L_0x007b
        L_0x009f:
            r7.close()
            if (r0 != 0) goto L_0x00a5
            return r3
        L_0x00a5:
            com.facebook.soloader.i$1 r9 = new com.facebook.soloader.i$1
            r1 = r9
            r2 = r11
            r3 = r5
            r4 = r14
            r5 = r0
            r7 = r12
            r1.<init>(r3, r4, r5, r6, r7)
            r12 = r13 & 1
            if (r12 == 0) goto L_0x00d4
            java.lang.Thread r12 = new java.lang.Thread
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "SoSync:"
            r13.append(r14)
            java.io.File r14 = r11.f11398a
            java.lang.String r14 = r14.getName()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.<init>(r9, r13)
            r12.start()
            goto L_0x00d7
        L_0x00d4:
            r9.run()
        L_0x00d7:
            return r8
        L_0x00d8:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x00da }
        L_0x00da:
            r13 = move-exception
            if (r2 == 0) goto L_0x00e5
            r2.close()     // Catch:{ all -> 0x00e1 }
            goto L_0x00e5
        L_0x00e1:
            r14 = move-exception
            r12.addSuppressed(r14)     // Catch:{ all -> 0x00e6 }
        L_0x00e5:
            throw r13     // Catch:{ all -> 0x00e6 }
        L_0x00e6:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x00e8 }
        L_0x00e8:
            r13 = move-exception
            if (r0 == 0) goto L_0x00f3
            r0.close()     // Catch:{ all -> 0x00ef }
            goto L_0x00f3
        L_0x00ef:
            r14 = move-exception
            r12.addSuppressed(r14)     // Catch:{ all -> 0x00f4 }
        L_0x00f3:
            throw r13     // Catch:{ all -> 0x00f4 }
        L_0x00f4:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x00f6 }
        L_0x00f6:
            r13 = move-exception
            r7.close()     // Catch:{ all -> 0x00fb }
            goto L_0x00ff
        L_0x00fb:
            r14 = move-exception
            r12.addSuppressed(r14)
        L_0x00ff:
            goto L_0x0101
        L_0x0100:
            throw r13
        L_0x0101:
            goto L_0x0100
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.i.a(com.facebook.soloader.d, int, byte[]):boolean");
    }

    private Object b(String str) {
        Object obj;
        synchronized (this.f11403d) {
            obj = this.f11403d.get(str);
            if (obj == null) {
                obj = new Object();
                this.f11403d.put(str, obj);
            }
        }
        return obj;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r4 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.io.File r3, byte r4) throws java.io.IOException {
        /*
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "rw"
            r0.<init>(r3, r1)
            r1 = 0
            r0.seek(r1)     // Catch:{ all -> 0x0021 }
            r0.write(r4)     // Catch:{ all -> 0x0021 }
            long r3 = r0.getFilePointer()     // Catch:{ all -> 0x0021 }
            r0.setLength(r3)     // Catch:{ all -> 0x0021 }
            java.io.FileDescriptor r3 = r0.getFD()     // Catch:{ all -> 0x0021 }
            r3.sync()     // Catch:{ all -> 0x0021 }
            r0.close()
            return
        L_0x0021:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x002c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.i.b(java.io.File, byte):void");
    }

    public int a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int a2;
        synchronized (b(str)) {
            a2 = a(str, i2, this.f11398a, threadPolicy);
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public abstract e a() throws IOException;

    /* access modifiers changed from: protected */
    public void a(int i2) throws IOException {
        SysUtil.b(this.f11398a);
        d a2 = d.a(new File(this.f11398a, "dso_lock"));
        try {
            Log.v("fb-UnpackingSoSource", "locked dso store " + this.f11398a);
            if (a(a2, i2, b())) {
                a2 = null;
            } else {
                Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.f11398a);
            }
            if (a2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("not releasing dso store lock for ");
                sb.append(this.f11398a);
                sb.append(" (syncer thread started)");
                Log.v("fb-UnpackingSoSource", sb.toString());
            }
        } finally {
            if (a2 != null) {
                Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.f11398a);
                a2.close();
            } else {
                Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.f11398a + " (syncer thread started)");
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void a(String str) throws IOException {
        synchronized (b(str)) {
            this.f11402c = str;
            a(2);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (r1 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] b() throws java.io.IOException {
        /*
            r5 = this;
            android.os.Parcel r0 = android.os.Parcel.obtain()
            com.facebook.soloader.i$e r1 = r5.a()
            com.facebook.soloader.i$b r2 = r1.a()     // Catch:{ all -> 0x0038 }
            com.facebook.soloader.i$a[] r2 = r2.f11412a     // Catch:{ all -> 0x0038 }
            r3 = 1
            r0.writeByte(r3)     // Catch:{ all -> 0x0038 }
            int r3 = r2.length     // Catch:{ all -> 0x0038 }
            r0.writeInt(r3)     // Catch:{ all -> 0x0038 }
            r3 = 0
        L_0x0017:
            int r4 = r2.length     // Catch:{ all -> 0x0038 }
            if (r3 >= r4) goto L_0x002b
            r4 = r2[r3]     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = r4.f11410a     // Catch:{ all -> 0x0038 }
            r0.writeString(r4)     // Catch:{ all -> 0x0038 }
            r4 = r2[r3]     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = r4.f11411b     // Catch:{ all -> 0x0038 }
            r0.writeString(r4)     // Catch:{ all -> 0x0038 }
            int r3 = r3 + 1
            goto L_0x0017
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            byte[] r1 = r0.marshall()
            r0.recycle()
            return r1
        L_0x0038:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003a }
        L_0x003a:
            r2 = move-exception
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x0045:
            goto L_0x0047
        L_0x0046:
            throw r2
        L_0x0047:
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.i.b():byte[]");
    }
}
