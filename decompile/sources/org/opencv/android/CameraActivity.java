package org.opencv.android;

import android.app.Activity;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;

public class CameraActivity extends Activity {
    /* access modifiers changed from: protected */
    public List<? extends CameraBridgeViewBase> a() {
        return new ArrayList();
    }

    /* access modifiers changed from: protected */
    public void b() {
        List<? extends CameraBridgeViewBase> a2 = a();
        if (a2 != null) {
            for (CameraBridgeViewBase cameraBridgeViewBase : a2) {
                if (cameraBridgeViewBase != null) {
                    cameraBridgeViewBase.a();
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 200 && iArr.length > 0 && iArr[0] == 0) {
            b();
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        boolean z2;
        super.onStart();
        if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.CAMERA") == 0) {
            z2 = true;
        } else {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 200);
            z2 = false;
        }
        if (z2) {
            b();
        }
    }
}
