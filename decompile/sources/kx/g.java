package kx;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class g {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f30587a = true;

    public static File a(Context context) throws FileNotFoundException {
        File n2 = d.n(context);
        return new File(n2, f.a() + ".tlog.tmp");
    }

    public static FileOutputStream a(Context context, String str) throws FileNotFoundException {
        File file = new File(d.b(context));
        file.mkdirs();
        File file2 = new File(file, str);
        if (file2.exists()) {
            file2.delete();
        }
        return new FileOutputStream(file2);
    }

    public static String a(String str) {
        return str + "-" + f.a() + ".param";
    }

    public static ArrayList<byte[]> a(byte[] bArr, int i2) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        int i3 = 0;
        while (i3 < bArr.length) {
            int i4 = i3 + i2;
            arrayList.add(Arrays.copyOfRange(bArr, i3, i4));
            if (bArr.length - i4 < i2) {
                i2 = bArr.length - i4;
            }
            i3 = i4;
        }
        return arrayList;
    }

    public static void a(File file) {
        String absolutePath = file.getAbsolutePath();
        if (file.exists() && absolutePath.endsWith(".tmp")) {
            file.renameTo(new File(absolutePath.substring(0, absolutePath.length() - 4)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d A[LOOP:0: B:15:0x0046->B:17:0x004d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(android.content.Context r2, en.a r3) throws java.io.IOException {
        /*
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.AssetManager r2 = r2.getAssets()
            java.lang.String r0 = r3.A()
            java.lang.String r1 = "Obtain"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x001b
            java.lang.String r3 = "px4fmu-v4_APM_obtain.bin"
        L_0x0016:
            java.io.InputStream r2 = r2.open(r3)
            goto L_0x002b
        L_0x001b:
            java.lang.String r3 = r3.A()
            java.lang.String r0 = "Dream"
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L_0x002a
            java.lang.String r3 = "dream-v3.6-2018.7.28.bin"
            goto L_0x0016
        L_0x002a:
            r2 = 0
        L_0x002b:
            if (r2 == 0) goto L_0x0034
            java.lang.String r3 = "UPLOAD"
            java.lang.String r0 = "it works!!!"
            android.util.Log.i(r3, r0)
        L_0x0034:
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>()
            boolean r0 = f30587a
            if (r0 != 0) goto L_0x0046
            if (r2 == 0) goto L_0x0040
            goto L_0x0046
        L_0x0040:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x0046:
            int r0 = r2.read()
            r1 = -1
            if (r0 == r1) goto L_0x0051
            r3.write(r0)
            goto L_0x0046
        L_0x0051:
            byte[] r2 = r3.toByteArray()
            r3.close()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kx.g.a(android.content.Context, en.a):byte[]");
    }

    public static FileOutputStream b(Context context, String str) throws FileNotFoundException {
        File file = new File(d.x(context));
        file.mkdirs();
        File file2 = new File(file, f.a() + "_" + str + ".txt");
        if (file2.exists()) {
            file2.delete();
        }
        return new FileOutputStream(file2);
    }

    public static String b(String str) {
        return str + "-" + f.a() + ".txt";
    }

    public static void b(Context context) throws IOException {
        File file = new File(d.v(context));
        file.mkdirs();
        new File(file, ".nomedia").createNewFile();
    }

    public static FileOutputStream c(Context context, String str) throws FileNotFoundException {
        File file = new File(d.c(context));
        file.mkdirs();
        File file2 = new File(file, str);
        if (file2.exists()) {
            file2.delete();
        }
        return new FileOutputStream(file2);
    }

    public static boolean c(String str) {
        File file = new File(str);
        return file.exists() && file.isFile() && file.delete();
    }

    public static boolean d(String str) {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            boolean z2 = true;
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (!listFiles[i2].isFile()) {
                    if (listFiles[i2].isDirectory() && !(z2 = d(listFiles[i2].getAbsolutePath()))) {
                        break;
                    }
                } else {
                    z2 = c(listFiles[i2].getAbsolutePath());
                    if (!z2) {
                        break;
                    }
                }
            }
            if (z2 && file.delete()) {
                return true;
            }
        }
        return false;
    }
}
