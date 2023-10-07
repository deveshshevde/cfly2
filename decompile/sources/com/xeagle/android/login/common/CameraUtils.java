package com.xeagle.android.login.common;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.os.Environment;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.util.List;

public class CameraUtils {
    private static float DEFAULT_IMAGE_SIZE = 2073600.0f;
    private static final String TAG = "CameraUtils";

    public static class Size {
        public int height;
        public int width;

        public Size(int i2, int i3) {
            this.width = i2;
            this.height = i3;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }
    }

    public static Size choosePictureSize(List<Camera.Size> list) {
        float f2 = Float.MAX_VALUE;
        Size size = null;
        for (Camera.Size next : list) {
            float abs = Math.abs(((((float) next.width) * ((float) next.height)) / DEFAULT_IMAGE_SIZE) - 1.0f);
            if (abs < f2) {
                size = new Size(next.width, next.height);
                f2 = abs;
            }
        }
        String str = TAG;
        Log.i(str, "Select size:" + size);
        return size;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [java.util.List, java.util.List<android.hardware.Camera$Size>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.hardware.Camera.Size choosePreviewSize(java.util.List<android.hardware.Camera.Size> r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L_0x006e
            int r0 = r8.size()
            if (r0 != 0) goto L_0x0009
            goto L_0x006e
        L_0x0009:
            r0 = 0
            if (r9 == 0) goto L_0x0057
            if (r10 != 0) goto L_0x000f
            goto L_0x0057
        L_0x000f:
            float r1 = (float) r9
            float r2 = (float) r10
            float r1 = r1 / r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r4 = r8.iterator()
        L_0x0020:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0046
            java.lang.Object r5 = r4.next()
            android.hardware.Camera$Size r5 = (android.hardware.Camera.Size) r5
            int r6 = r5.width
            float r6 = (float) r6
            int r7 = r5.height
            float r7 = (float) r7
            float r6 = r6 / r7
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 != 0) goto L_0x0020
            r3.add(r5)
            int r6 = r5.width
            if (r6 < r9) goto L_0x0020
            int r6 = r5.height
            if (r6 < r10) goto L_0x0020
            r2.add(r5)
            goto L_0x0020
        L_0x0046:
            com.xeagle.android.login.common.CameraUtils$1 r9 = new com.xeagle.android.login.common.CameraUtils$1
            r9.<init>()
            int r10 = r2.size()
            if (r10 != 0) goto L_0x005e
            int r10 = r3.size()
            if (r10 != 0) goto L_0x005e
        L_0x0057:
            java.lang.Object r8 = r8.get(r0)
        L_0x005b:
            android.hardware.Camera$Size r8 = (android.hardware.Camera.Size) r8
            return r8
        L_0x005e:
            int r8 = r2.size()
            if (r8 <= 0) goto L_0x0069
            java.lang.Object r8 = java.util.Collections.max(r3, r9)
            goto L_0x005b
        L_0x0069:
            java.lang.Object r8 = java.util.Collections.min(r2, r9)
            goto L_0x005b
        L_0x006e:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.CameraUtils.choosePreviewSize(java.util.List, int, int):android.hardware.Camera$Size");
    }

    public static Pair<Camera, Integer> getCameraInstance(boolean z2) {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (z2 && cameraInfo.facing == 1) {
                    return new Pair<>(Camera.open(i2), Integer.valueOf(i2));
                }
                if (!z2 && cameraInfo.facing == 0) {
                    return new Pair<>(Camera.open(i2), Integer.valueOf(i2));
                }
            }
        } catch (Exception unused) {
        }
        return new Pair<>((Object) null, 0);
    }

    public static int getDisplayOrientation(Activity activity, int i2, Camera camera, boolean z2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i3 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i3 = 90;
            } else if (rotation == 2) {
                i3 = 180;
            } else if (rotation == 3) {
                i3 = SubsamplingScaleImageView.ORIENTATION_270;
            }
        }
        return ((z2 || cameraInfo.facing != 1) ? (cameraInfo.orientation - i3) + SpatialRelationUtil.A_CIRCLE_DEGREE : 360 - ((cameraInfo.orientation + i3) % SpatialRelationUtil.A_CIRCLE_DEGREE)) % SpatialRelationUtil.A_CIRCLE_DEGREE;
    }

    public static File getOutputMediaFile(Context context, int i2, String str) {
        StringBuilder sb;
        String str2;
        if (i2 == 1) {
            String absolutePath = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            sb = new StringBuilder();
            sb.append(absolutePath);
            sb.append("/IMG_");
            sb.append(str);
            str2 = ".jpg";
        } else if (i2 == 3) {
            String absolutePath2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath();
            sb = new StringBuilder();
            sb.append(absolutePath2);
            sb.append("/VID_");
            sb.append(str);
            str2 = ".mp4";
        } else {
            String absolutePath3 = context.getExternalCacheDir().getAbsolutePath();
            sb = new StringBuilder();
            sb.append(absolutePath3);
            sb.append("/");
            sb.append(str);
            return new File(sb.toString());
        }
        sb.append(str2);
        return new File(sb.toString());
    }

    public static int getPictureRotation(Context context, int i2) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        int rotation = windowManager != null ? windowManager.getDefaultDisplay().getRotation() : 0;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        int i3 = ((rotation + 45) / 90) * 90;
        return (cameraInfo.facing == 1 ? (cameraInfo.orientation - i3) + SpatialRelationUtil.A_CIRCLE_DEGREE : cameraInfo.orientation + i3) % SpatialRelationUtil.A_CIRCLE_DEGREE;
    }
}
