package bh;

import android.text.TextUtils;
import android.util.Log;

public class a implements be.a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5642a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5643b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f5644c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f5645d = "ARouter";

    public a() {
    }

    public a(String str) {
        this.f5645d = str;
    }

    public static String a(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder("[");
        if (f5643b) {
            String name = Thread.currentThread().getName();
            String fileName = stackTraceElement.getFileName();
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            long id2 = Thread.currentThread().getId();
            int lineNumber = stackTraceElement.getLineNumber();
            sb.append("ThreadId=");
            sb.append(id2);
            sb.append(" & ");
            sb.append("ThreadName=");
            sb.append(name);
            sb.append(" & ");
            sb.append("FileName=");
            sb.append(fileName);
            sb.append(" & ");
            sb.append("ClassName=");
            sb.append(className);
            sb.append(" & ");
            sb.append("MethodName=");
            sb.append(methodName);
            sb.append(" & ");
            sb.append("LineNumber=");
            sb.append(lineNumber);
        }
        sb.append(" ] ");
        return sb.toString();
    }

    public String a() {
        return this.f5645d;
    }

    public void a(String str, String str2) {
        if (f5642a) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = a();
            }
            Log.d(str, str2 + a(stackTraceElement));
        }
    }

    public void b(String str, String str2) {
        if (f5642a) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = a();
            }
            Log.i(str, str2 + a(stackTraceElement));
        }
    }

    public void c(String str, String str2) {
        if (f5642a) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = a();
            }
            Log.w(str, str2 + a(stackTraceElement));
        }
    }

    public void d(String str, String str2) {
        if (f5642a) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = a();
            }
            Log.e(str, str2 + a(stackTraceElement));
        }
    }
}
