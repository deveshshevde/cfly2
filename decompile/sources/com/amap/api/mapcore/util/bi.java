package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class bi {

    /* renamed from: a  reason: collision with root package name */
    private b f8071a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f8073a = false;
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f8074a;

        /* renamed from: b  reason: collision with root package name */
        private String f8075b;

        /* renamed from: c  reason: collision with root package name */
        private be f8076c = null;

        /* renamed from: d  reason: collision with root package name */
        private a f8077d = new a();

        /* renamed from: e  reason: collision with root package name */
        private String f8078e;

        public b(bf bfVar, be beVar) {
            this.f8074a = bfVar.x();
            this.f8075b = bfVar.y();
            this.f8076c = beVar;
        }

        public final String a() {
            return this.f8074a;
        }

        public final void a(String str) {
            if (str.length() > 1) {
                this.f8078e = str;
            }
        }

        public final String b() {
            return this.f8075b;
        }

        public final String c() {
            return this.f8078e;
        }

        public final be d() {
            return this.f8076c;
        }

        public final a e() {
            return this.f8077d;
        }

        public final void f() {
            this.f8077d.f8073a = true;
        }
    }

    public interface c {
        void a();

        void a(long j2);
    }

    public bi(bf bfVar, be beVar) {
        this.f8071a = new b(bfVar, beVar);
    }

    private static int a(File file, ZipInputStream zipInputStream, long j2, long j3, c cVar, a aVar) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i2 = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i2;
            } else if (aVar == null || !aVar.f8073a) {
                bufferedOutputStream.write(bArr, 0, read);
                i2 += read;
                if (j3 > 0 && cVar != null) {
                    long j4 = ((((long) i2) + j2) * 100) / j3;
                    if (aVar == null || !aVar.f8073a) {
                        cVar.a(j4);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i2;
            }
        }
    }

    private static void a(b bVar) {
        if (bVar != null) {
            final be d2 = bVar.d();
            if (d2 != null) {
                d2.p();
            }
            String a2 = bVar.a();
            String b2 = bVar.b();
            if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(b2)) {
                File file = new File(a2);
                if (file.exists()) {
                    File file2 = new File(b2);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    AnonymousClass1 r2 = new c() {
                        public final void a() {
                            be beVar = d2;
                            if (beVar != null) {
                                beVar.q();
                            }
                        }

                        public final void a(long j2) {
                            try {
                                be beVar = d2;
                                if (beVar != null) {
                                    beVar.a(j2);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    };
                    try {
                        if (bVar.e().f8073a && d2 != null) {
                            d2.r();
                        }
                        a(file, file2, r2, bVar);
                        if (bVar.e().f8073a) {
                            if (d2 != null) {
                                d2.r();
                            }
                        } else if (d2 != null) {
                            d2.b(bVar.c());
                        }
                    } catch (Throwable unused) {
                        if (bVar.e().f8073a) {
                            if (d2 != null) {
                                d2.r();
                            }
                        } else if (d2 != null) {
                            d2.q();
                        }
                    }
                } else if (bVar.e().f8073a) {
                    if (d2 != null) {
                        d2.r();
                    }
                } else if (d2 != null) {
                    d2.q();
                }
            } else if (bVar.e().f8073a) {
                if (d2 != null) {
                    d2.r();
                }
            } else if (d2 != null) {
                d2.q();
            }
        }
    }

    private static void a(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            a(parentFile);
            parentFile.mkdir();
        }
    }

    private static void a(File file, File file2, c cVar, b bVar) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        a e2 = bVar.e();
        long j2 = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
            ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (e2 != null && e2.f8073a) {
                        zipInputStream.closeEntry();
                        zipInputStream.close();
                        checkedInputStream.close();
                        fileInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        if (!a(nextEntry.getName())) {
                            cVar.a();
                            break;
                        } else {
                            stringBuffer.append(nextEntry.getName());
                            stringBuffer.append(";");
                        }
                    }
                    j2 += nextEntry.getSize();
                    zipInputStream.closeEntry();
                } else {
                    break;
                }
            }
            bVar.a(stringBuffer.toString());
            zipInputStream.close();
            checkedInputStream.close();
            fileInputStream.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        a(file2, zipInputStream2, j2, cVar, e2);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    private static void a(File file, ZipInputStream zipInputStream, long j2, c cVar, a aVar) throws Exception {
        int i2 = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (aVar == null || !aVar.f8073a) {
                String str = file.getPath() + File.separator + nextEntry.getName();
                if (a(nextEntry.getName())) {
                    File file2 = new File(str);
                    a(file2);
                    if (nextEntry.isDirectory()) {
                        file2.mkdirs();
                    } else {
                        i2 += a(file2, zipInputStream, (long) i2, j2, cVar, aVar);
                    }
                    zipInputStream.closeEntry();
                } else if (cVar != null) {
                    cVar.a();
                    return;
                } else {
                    return;
                }
            } else {
                zipInputStream.closeEntry();
                return;
            }
        }
    }

    private static boolean a(String str) {
        return !str.contains("..") && !str.contains("/") && !str.contains("\\") && !str.contains("%");
    }

    public final void a() {
        b bVar = this.f8071a;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void b() {
        b bVar = this.f8071a;
        if (bVar != null) {
            a(bVar);
        }
    }
}
