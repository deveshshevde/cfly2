package org.opencv.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.io.File;
import java.util.StringTokenizer;
import oi.a;
import org.opencv.core.Core;

class a {

    /* renamed from: e  reason: collision with root package name */
    protected static boolean f33988e = false;

    /* renamed from: f  reason: collision with root package name */
    protected static boolean f33989f = false;

    /* renamed from: a  reason: collision with root package name */
    protected oi.a f33990a;

    /* renamed from: b  reason: collision with root package name */
    protected g f33991b;

    /* renamed from: c  reason: collision with root package name */
    protected String f33992c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f33993d;

    /* renamed from: g  reason: collision with root package name */
    protected ServiceConnection f33994g = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("OpenCVManager/Helper", "Service connection created");
            a.this.f33990a = a.C0232a.a(iBinder);
            if (a.this.f33990a == null) {
                Log.d("OpenCVManager/Helper", "OpenCV Manager Service connection fails. May be service was not installed?");
                a.a(a.this.f33993d, a.this.f33991b);
                return;
            }
            int i2 = 0;
            a.f33988e = false;
            try {
                if (a.this.f33990a.a() < 2) {
                    Log.d("OpenCVManager/Helper", "Init finished with status 4");
                    Log.d("OpenCVManager/Helper", "Unbind from service");
                    a.this.f33993d.unbindService(a.this.f33994g);
                    Log.d("OpenCVManager/Helper", "Calling using callback");
                    a.this.f33991b.a(4);
                    return;
                }
                Log.d("OpenCVManager/Helper", "Trying to get library path");
                String a2 = a.this.f33990a.a(a.this.f33992c);
                if (a2 != null) {
                    if (a2.length() != 0) {
                        Log.d("OpenCVManager/Helper", "Trying to get library list");
                        a.f33989f = false;
                        String c2 = a.this.f33990a.c(a.this.f33992c);
                        Log.d("OpenCVManager/Helper", "Library list: \"" + c2 + "\"");
                        Log.d("OpenCVManager/Helper", "First attempt to load libs");
                        if (a.this.a(a2, c2)) {
                            Log.d("OpenCVManager/Helper", "First attempt to load libs is OK");
                            for (String i3 : Core.a().split(System.getProperty("line.separator"))) {
                                Log.i("OpenCVManager/Helper", i3);
                            }
                        } else {
                            Log.d("OpenCVManager/Helper", "First attempt to load libs fails");
                            i2 = 255;
                        }
                        Log.d("OpenCVManager/Helper", "Init finished with status " + i2);
                        Log.d("OpenCVManager/Helper", "Unbind from service");
                        a.this.f33993d.unbindService(a.this.f33994g);
                        Log.d("OpenCVManager/Helper", "Calling using callback");
                        a.this.f33991b.a(i2);
                        return;
                    }
                }
                if (!a.f33989f) {
                    a.this.f33991b.a(0, new f() {
                    });
                    return;
                }
                a.this.f33991b.a(1, new f() {
                });
            } catch (RemoteException e2) {
                e2.printStackTrace();
                Log.d("OpenCVManager/Helper", "Init finished with status 255");
                Log.d("OpenCVManager/Helper", "Unbind from service");
                a.this.f33993d.unbindService(a.this.f33994g);
                Log.d("OpenCVManager/Helper", "Calling using callback");
                a.this.f33991b.a(255);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            a.this.f33990a = null;
        }
    };

    protected a(String str, Context context, g gVar) {
        this.f33992c = str;
        this.f33991b = gVar;
        this.f33993d = context;
    }

    protected static void a(Context context, g gVar) {
        int i2;
        f fVar;
        if (!f33988e) {
            Log.d("OpenCVManager/Helper", "Request new service installation");
            fVar = new f(context) {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Context f33996b;

                /* renamed from: c  reason: collision with root package name */
                private g f33997c;

                {
                    this.f33996b = r2;
                    this.f33997c = g.this;
                }
            };
            i2 = 0;
        } else {
            Log.d("OpenCVManager/Helper", "Waiting current installation process");
            fVar = new f(context) {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Context f33999b;

                /* renamed from: c  reason: collision with root package name */
                private g f34000c;

                {
                    this.f33999b = r2;
                    this.f34000c = g.this;
                }
            };
            i2 = 1;
        }
        gVar.a(i2, fVar);
    }

    private boolean a(String str) {
        Log.d("OpenCVManager/Helper", "Trying to load library " + str);
        try {
            System.load(str);
            Log.d("OpenCVManager/Helper", "OpenCV libs init was ok!");
            return true;
        } catch (UnsatisfiedLinkError e2) {
            Log.d("OpenCVManager/Helper", "Cannot load library \"" + str + "\"");
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(String str, Context context, g gVar) {
        a aVar = new a(str, context, gVar);
        Intent intent = new Intent("org.opencv.engine.BIND");
        intent.setPackage("org.opencv.engine");
        if (context.bindService(intent, aVar.f33994g, 1)) {
            return true;
        }
        context.unbindService(aVar.f33994g);
        a(context, gVar);
        return false;
    }

    /* access modifiers changed from: private */
    public boolean a(String str, String str2) {
        Log.d("OpenCVManager/Helper", "Trying to init OpenCV libs");
        if (str == null || str.length() == 0) {
            Log.d("OpenCVManager/Helper", "Library path \"" + str + "\" is empty");
            return false;
        }
        boolean z2 = true;
        if (str2 == null || str2.length() == 0) {
            return a(str + File.separator + "libopencv_java4.so");
        }
        Log.d("OpenCVManager/Helper", "Trying to load libs by dependency list");
        StringTokenizer stringTokenizer = new StringTokenizer(str2, ";");
        while (stringTokenizer.hasMoreTokens()) {
            z2 &= a(str + File.separator + stringTokenizer.nextToken());
        }
        return z2;
    }
}
