package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.n;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class a extends androidx.core.content.b {

    /* renamed from: a  reason: collision with root package name */
    private static b f2813a;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    public interface C0025a {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    public interface b {
        boolean a(Activity activity, String[] strArr, int i2);
    }

    public interface c {
        void validateRequestPermissionsRequestCode(int i2);
    }

    private static class d extends SharedElementCallback {

        /* renamed from: a  reason: collision with root package name */
        private final n f2818a;

        d(n nVar) {
            this.f2818a = nVar;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f2818a.a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f2818a.a(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f2818a.a(list, map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f2818a.a(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f2818a.b(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f2818a.a(list, list2, list3);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f2818a.a(list, list2, (n.a) new n.a() {
                public void a() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, Intent intent, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i2, bundle);
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    public static void a(Activity activity, n nVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(nVar != null ? new d(nVar) : null);
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i2) {
        b bVar = f2813a;
        if (bVar == null || !bVar.a(activity, strArr, i2)) {
            int length = strArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (!TextUtils.isEmpty(strArr[i3])) {
                    i3++;
                } else {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof c) {
                    ((c) activity).validateRequestPermissionsRequestCode(i2);
                }
                activity.requestPermissions(strArr, i2);
            } else if (activity instanceof C0025a) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        int[] iArr = new int[strArr.length];
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                        }
                        ((C0025a) activity).onRequestPermissionsResult(i2, strArr, iArr);
                    }
                });
            }
        }
    }

    public static boolean a(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void b(Activity activity, n nVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(nVar != null ? new d(nVar) : null);
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void e(final Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            if (Build.VERSION.SDK_INT <= 23) {
                new Handler(activity.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (!activity.isFinishing() && !c.a(activity)) {
                            activity.recreate();
                        }
                    }
                });
                return;
            } else if (c.a(activity)) {
                return;
            }
        }
        activity.recreate();
    }
}
