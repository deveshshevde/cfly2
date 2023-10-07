package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

public final class fv {

    /* renamed from: a  reason: collision with root package name */
    public static String f8845a = "9aj&#k81";

    /* renamed from: b  reason: collision with root package name */
    public static String f8846b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";

    /* renamed from: c  reason: collision with root package name */
    static byte[] f8847c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f8848d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f8849e = false;

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f8850f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final Integer f8851g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final Integer f8852h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static final Integer f8853i = 4;

    /* renamed from: j  reason: collision with root package name */
    public static final Integer f8854j = 5;

    /* renamed from: k  reason: collision with root package name */
    private static String f8855k = "ADgAIwBbAA8AagAIAHIAEwCFAD8AxABDAQcAIQEoADgBYAA8AZwAnwI7APADKwAHAzIADAM+AA9LWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZ1FaMlYwVTJWeWRtbGpaUUljR2h2Ym1VVWFYQm9iMjVsYzNWaWFXNW1id01ZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5ra1UzUjFZZ1FZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWdHVkZKQlRsTkJRMVJKVDA1ZloyVjBSR1YyYVdObFNXUT1FWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua0lZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOEVJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSndhMmNpT2lJbGN5SXNJbTF2WkdWc0lqb2lKWE1pTENKaGNIQnVZVzFsSWpvaUpYTWlMQ0poY0hCMlpYSnphVzl1SWpvaUpYTWlMQ0p6ZVhOMlpYSnphVzl1SWpvaUpYTWlMQUdJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklnPUlZV2xrUFFNZkhObGNtbGhiRDBRWVc1a2NtOXBaRjlwWkE=";

    /* renamed from: l  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f8856l = new ConcurrentHashMap<>(8);

    public static String a(String str) {
        String str2 = "";
        try {
            synchronized (f8856l) {
                if (f8856l != null && f8856l.containsKey(str)) {
                    str2 = f8856l.get(str);
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }

    public static void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                synchronized (f8856l) {
                    if (f8856l == null) {
                        f8856l = new ConcurrentHashMap<>(8);
                    }
                    if (!f8856l.containsKey(str)) {
                        f8856l.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static byte[] a(int i2) {
        if (f8847c == null) {
            f8847c = fa.b(f8855k);
        }
        byte[] bArr = new byte[4];
        System.arraycopy(f8847c, i2 * 4, bArr, 0, 4);
        int i3 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        int i4 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i4];
        System.arraycopy(f8847c, i3, bArr2, 0, i4);
        return bArr2;
    }
}
