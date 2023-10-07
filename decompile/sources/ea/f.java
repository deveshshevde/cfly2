package ea;

import android.content.Context;
import android.util.Log;
import com.flypro.core.drone.variables.SonarData;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class f {
    private static void a(FileOutputStream fileOutputStream) throws IOException {
        fileOutputStream.write(String.format(Locale.ENGLISH, "%s\t%s\t%s\t%s\t%s\t%s\n", new Object[]{"BarAlt", "BarVel", "BarDest", "SonarAlt", "SonarVel", "SonarDest"}).getBytes("gb2312"));
    }

    private static void a(FileOutputStream fileOutputStream, List<SonarData> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            SonarData sonarData = list.get(i2);
            fileOutputStream.write(String.format(Locale.ENGLISH, "%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n", new Object[]{Float.valueOf(sonarData.a()), Float.valueOf(sonarData.b()), Float.valueOf(sonarData.c()), Float.valueOf(sonarData.d()), Float.valueOf(sonarData.e()), Float.valueOf(sonarData.f())}).getBytes("gb2312"));
        }
    }

    public static boolean a(Context context, List<SonarData> list, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            if (!c.a()) {
                return false;
            }
            if (!str.endsWith(".txt")) {
                str = str + ".txt";
            }
            FileOutputStream b2 = d.b(context, str);
            a(b2);
            a(b2, list);
            if (b2 == null) {
                return true;
            }
            try {
                b2.close();
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return true;
            }
        } catch (Exception e3) {
            Log.e("version", "write: error:" + e3.getMessage());
            e3.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0157 A[SYNTHETIC, Splitter:B:24:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0166 A[SYNTHETIC, Splitter:B:33:0x0166] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0171 A[SYNTHETIC, Splitter:B:39:0x0171] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0161=Splitter:B:30:0x0161, B:21:0x0152=Splitter:B:21:0x0152} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r7) {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = ea.c.a()     // Catch:{ FileNotFoundException -> 0x0160, IOException -> 0x0151 }
            if (r2 != 0) goto L_0x0009
            return r0
        L_0x0009:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0160, IOException -> 0x0151 }
            java.lang.String r3 = "rw"
            r2.<init>(r7, r3)     // Catch:{ FileNotFoundException -> 0x0160, IOException -> 0x0151 }
            long r3 = r7.length()     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            java.lang.String r1 = "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n"
            r3 = 47
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            java.lang.String r4 = "mode"
            r3[r0] = r4     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            java.lang.String r4 = "satCount"
            r5 = 1
            r3[r5] = r4     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 2
            java.lang.String r6 = "hdop"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 3
            java.lang.String r6 = "batVol"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 4
            java.lang.String r6 = "pitch"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 5
            java.lang.String r6 = "roll"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 6
            java.lang.String r6 = "yaw"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 7
            java.lang.String r6 = "dLat"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 8
            java.lang.String r6 = "dLng"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 9
            java.lang.String r6 = "locLat"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 10
            java.lang.String r6 = "locLng"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 11
            java.lang.String r6 = "locHdop"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 12
            java.lang.String r6 = "time"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 13
            java.lang.String r6 = "alt"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 14
            java.lang.String r6 = "hs"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 15
            java.lang.String r6 = "vs"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 16
            java.lang.String r6 = "rcIn1"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 17
            java.lang.String r6 = "rcIn2"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 18
            java.lang.String r6 = "rcIn3"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 19
            java.lang.String r6 = "rcIn4"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 20
            java.lang.String r6 = "rcIn5"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 21
            java.lang.String r6 = "rcIn6"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 22
            java.lang.String r6 = "rcIn7"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 23
            java.lang.String r6 = "rcIn8"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 24
            java.lang.String r6 = "rcOut1"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 25
            java.lang.String r6 = "rcOut2"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 26
            java.lang.String r6 = "rcOut3"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 27
            java.lang.String r6 = "rcOut4"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 28
            java.lang.String r6 = "droneMsg"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 29
            java.lang.String r6 = "vibX"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 30
            java.lang.String r6 = "vibY"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 31
            java.lang.String r6 = "vibZ"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 32
            java.lang.String r6 = "xacc"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 33
            java.lang.String r6 = "yacc"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 34
            java.lang.String r6 = "zacc"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 35
            java.lang.String r6 = "xgyro"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 36
            java.lang.String r6 = "ygyro"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 37
            java.lang.String r6 = "zgyro"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 38
            java.lang.String r6 = "xmag"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 39
            java.lang.String r6 = "ymag"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 40
            java.lang.String r6 = "zmag"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 41
            java.lang.String r6 = "pressureRaw"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 42
            java.lang.String r6 = "sonarRaw"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 43
            java.lang.String r6 = "flowState"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 44
            java.lang.String r6 = "errorMsg"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 45
            java.lang.String r6 = "appAction"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r4 = 46
            java.lang.String r6 = "distance"
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            java.lang.String r7 = java.lang.String.format(r7, r1, r3)     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            java.lang.String r1 = "gb2312"
            byte[] r7 = r7.getBytes(r1)     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r2.write(r7)     // Catch:{ FileNotFoundException -> 0x014c, IOException -> 0x0149, all -> 0x0146 }
            r2.close()     // Catch:{ IOException -> 0x0141 }
            goto L_0x0145
        L_0x0141:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0145:
            return r5
        L_0x0146:
            r7 = move-exception
            r1 = r2
            goto L_0x016f
        L_0x0149:
            r7 = move-exception
            r1 = r2
            goto L_0x0152
        L_0x014c:
            r7 = move-exception
            r1 = r2
            goto L_0x0161
        L_0x014f:
            r7 = move-exception
            goto L_0x016f
        L_0x0151:
            r7 = move-exception
        L_0x0152:
            r7.printStackTrace()     // Catch:{ all -> 0x014f }
            if (r1 == 0) goto L_0x015f
            r1.close()     // Catch:{ IOException -> 0x015b }
            goto L_0x015f
        L_0x015b:
            r7 = move-exception
            r7.printStackTrace()
        L_0x015f:
            return r0
        L_0x0160:
            r7 = move-exception
        L_0x0161:
            r7.printStackTrace()     // Catch:{ all -> 0x014f }
            if (r1 == 0) goto L_0x016e
            r1.close()     // Catch:{ IOException -> 0x016a }
            goto L_0x016e
        L_0x016a:
            r7 = move-exception
            r7.printStackTrace()
        L_0x016e:
            return r0
        L_0x016f:
            if (r1 == 0) goto L_0x0179
            r1.close()     // Catch:{ IOException -> 0x0175 }
            goto L_0x0179
        L_0x0175:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0179:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.f.a(java.io.File):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x026d A[SYNTHETIC, Splitter:B:24:0x026d] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x027c A[SYNTHETIC, Splitter:B:33:0x027c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0287 A[SYNTHETIC, Splitter:B:39:0x0287] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0277=Splitter:B:30:0x0277, B:21:0x0268=Splitter:B:21:0x0268} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r8, com.flypro.core.drone.variables.ListenerData r9) {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = ea.c.a()     // Catch:{ FileNotFoundException -> 0x0276, IOException -> 0x0267 }
            if (r2 != 0) goto L_0x0009
            return r0
        L_0x0009:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0276, IOException -> 0x0267 }
            java.lang.String r3 = "rw"
            r2.<init>(r8, r3)     // Catch:{ FileNotFoundException -> 0x0276, IOException -> 0x0267 }
            long r3 = r8.length()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.util.Locale r8 = java.util.Locale.ENGLISH     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.String r1 = "%s\t%d\t%.1f\t%d\t%.1f\t%.1f\t%.1f\t%.7f\t%.7f\t%.7f\t%.7f\t%.1f\t%s\t%.1f\t%.1f\t%.1f\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%s\t%.2f\t%.2f\t%.2f\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%d\t%s\t%s\t%.1f\n"
            r3 = 47
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.String r4 = r9.a()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r0] = r4     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            int r4 = r9.b()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r5 = 1
            r3[r5] = r4     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 2
            double r6 = r9.c()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 3
            int r6 = r9.d()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 4
            double r6 = r9.e()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 5
            double r6 = r9.f()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 6
            double r6 = r9.g()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 7
            ef.a r6 = r9.h()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            double r6 = r6.d()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 8
            ef.a r6 = r9.h()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            double r6 = r6.c()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 9
            ef.a r6 = r9.i()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            double r6 = r6.d()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 10
            ef.a r6 = r9.i()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            double r6 = r6.c()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 11
            double r6 = r9.j()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 12
            java.lang.String r6 = r9.k()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 13
            double r6 = r9.l()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 14
            double r6 = r9.m()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 15
            double r6 = r9.n()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 16
            int r6 = r9.o()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 17
            int r6 = r9.p()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 18
            int r6 = r9.q()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 19
            int r6 = r9.r()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 20
            int r6 = r9.s()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 21
            int r6 = r9.t()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 22
            int r6 = r9.u()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 23
            int r6 = r9.v()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 24
            int r6 = r9.w()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 25
            int r6 = r9.x()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 26
            int r6 = r9.y()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 27
            int r6 = r9.z()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 28
            java.lang.String r6 = r9.A()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 29
            double r6 = r9.B()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 30
            double r6 = r9.C()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 31
            double r6 = r9.D()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 32
            double r6 = r9.E()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 33
            double r6 = r9.F()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 34
            double r6 = r9.G()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 35
            double r6 = r9.H()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 36
            double r6 = r9.I()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 37
            double r6 = r9.J()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 38
            double r6 = r9.K()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 39
            double r6 = r9.L()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 40
            double r6 = r9.M()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 41
            double r6 = r9.N()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 42
            double r6 = r9.O()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 43
            int r6 = r9.P()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 44
            java.lang.String r6 = r9.Q()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 45
            java.lang.String r6 = r9.R()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r4 = 46
            double r6 = r9.S()     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.Double r9 = java.lang.Double.valueOf(r6)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r3[r4] = r9     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.String r8 = java.lang.String.format(r8, r1, r3)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            java.lang.String r9 = "gb2312"
            byte[] r8 = r8.getBytes(r9)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r2.write(r8)     // Catch:{ FileNotFoundException -> 0x0262, IOException -> 0x025f, all -> 0x025c }
            r2.close()     // Catch:{ IOException -> 0x0257 }
            goto L_0x025b
        L_0x0257:
            r8 = move-exception
            r8.printStackTrace()
        L_0x025b:
            return r5
        L_0x025c:
            r8 = move-exception
            r1 = r2
            goto L_0x0285
        L_0x025f:
            r8 = move-exception
            r1 = r2
            goto L_0x0268
        L_0x0262:
            r8 = move-exception
            r1 = r2
            goto L_0x0277
        L_0x0265:
            r8 = move-exception
            goto L_0x0285
        L_0x0267:
            r8 = move-exception
        L_0x0268:
            r8.printStackTrace()     // Catch:{ all -> 0x0265 }
            if (r1 == 0) goto L_0x0275
            r1.close()     // Catch:{ IOException -> 0x0271 }
            goto L_0x0275
        L_0x0271:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0275:
            return r0
        L_0x0276:
            r8 = move-exception
        L_0x0277:
            r8.printStackTrace()     // Catch:{ all -> 0x0265 }
            if (r1 == 0) goto L_0x0284
            r1.close()     // Catch:{ IOException -> 0x0280 }
            goto L_0x0284
        L_0x0280:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0284:
            return r0
        L_0x0285:
            if (r1 == 0) goto L_0x028f
            r1.close()     // Catch:{ IOException -> 0x028b }
            goto L_0x028f
        L_0x028b:
            r9 = move-exception
            r9.printStackTrace()
        L_0x028f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.f.a(java.io.File, com.flypro.core.drone.variables.ListenerData):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095 A[SYNTHETIC, Splitter:B:24:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a4 A[SYNTHETIC, Splitter:B:33:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00af A[SYNTHETIC, Splitter:B:39:0x00af] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0090=Splitter:B:21:0x0090, B:30:0x009f=Splitter:B:30:0x009f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r7, ea.e r8) {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = ea.c.a()     // Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x008f }
            if (r2 != 0) goto L_0x0009
            return r0
        L_0x0009:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x008f }
            java.lang.String r3 = "rw"
            r2.<init>(r7, r3)     // Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x008f }
            long r3 = r7.length()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            java.lang.String r1 = "userId\t%s\tdroneModel\t%s\tappVersion\t%s\tdroneVersion\t%s\timageVersion\t%s\trcVersion\t%s\trepeatVersion\t%s\tsystemModel\t%s\tdeviceBand\t%s\tsystemVersion\t%s\tsystemLanguage\t%s\n"
            r3 = 11
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            java.lang.String r4 = r8.a()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r3[r0] = r4     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            java.lang.String r4 = r8.b()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r5 = 1
            r3[r5] = r4     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r4 = 2
            java.lang.String r6 = r8.c()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r4 = 3
            java.lang.String r6 = r8.d()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r4 = 4
            java.lang.String r6 = r8.e()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r4 = 5
            java.lang.String r6 = r8.f()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r4 = 6
            java.lang.String r6 = r8.g()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r4 = 7
            java.lang.String r6 = r8.h()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r4 = 8
            java.lang.String r6 = r8.i()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r4 = 9
            java.lang.String r6 = r8.j()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r4 = 10
            java.lang.String r8 = r8.k()     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r3[r4] = r8     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            java.lang.String r7 = java.lang.String.format(r7, r1, r3)     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            java.lang.String r8 = "gb2312"
            byte[] r7 = r7.getBytes(r8)     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r2.write(r7)     // Catch:{ FileNotFoundException -> 0x008a, IOException -> 0x0087, all -> 0x0084 }
            r2.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0083:
            return r5
        L_0x0084:
            r7 = move-exception
            r1 = r2
            goto L_0x00ad
        L_0x0087:
            r7 = move-exception
            r1 = r2
            goto L_0x0090
        L_0x008a:
            r7 = move-exception
            r1 = r2
            goto L_0x009f
        L_0x008d:
            r7 = move-exception
            goto L_0x00ad
        L_0x008f:
            r7 = move-exception
        L_0x0090:
            r7.printStackTrace()     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x009d
            r1.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x009d
        L_0x0099:
            r7 = move-exception
            r7.printStackTrace()
        L_0x009d:
            return r0
        L_0x009e:
            r7 = move-exception
        L_0x009f:
            r7.printStackTrace()     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x00ac
            r1.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00ac
        L_0x00a8:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00ac:
            return r0
        L_0x00ad:
            if (r1 == 0) goto L_0x00b7
            r1.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x00b7
        L_0x00b3:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00b7:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.f.a(java.io.File, ea.e):boolean");
    }
}
