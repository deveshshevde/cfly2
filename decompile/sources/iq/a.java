package iq;

public class a {
    public static void a() {
        a("request pause all tasks in the download service", new Object[0]);
    }

    private static void a(String str, Object... objArr) {
        d.d(a.class, str + ", but the download service isn't connected yet." + "\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your code invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    public static void a(boolean z2) {
        a("request cancel the foreground status[%B] for the download service", Boolean.valueOf(z2));
    }

    public static boolean a(int i2) {
        a("request pause the task[%d] in the download service", Integer.valueOf(i2));
        return false;
    }

    public static boolean a(String str, String str2, boolean z2) {
        a("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z2));
        return false;
    }

    public static byte b(int i2) {
        a("request get the status for the task[%d] in the download service", Integer.valueOf(i2));
        return 0;
    }

    public static boolean b() {
        a("request clear all tasks data in the database", new Object[0]);
        return false;
    }

    public static boolean c(int i2) {
        a("request set the max network thread count[%d] in the download service", Integer.valueOf(i2));
        return false;
    }
}
