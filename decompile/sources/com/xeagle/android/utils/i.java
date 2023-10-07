package com.xeagle.android.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.Matrix;
import java.util.ArrayList;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.a;
import jp.co.cyberagent.android.gpuimage.b;
import jp.co.cyberagent.android.gpuimage.c;
import jp.co.cyberagent.android.gpuimage.e;

public class i {
    public static Bitmap a(Context context, Bitmap bitmap, int i2, float f2) {
        ArrayList arrayList = new ArrayList();
        float f3 = (float) i2;
        if (f3 != 0.0f) {
            e eVar = new e();
            float[] fArr = new float[16];
            Matrix.setRotateM(fArr, 0, f3, 0.0f, 0.0f, 1.0f);
            eVar.a(fArr);
            arrayList.add(eVar);
        }
        if (f2 != 0.0f) {
            c cVar = new c();
            cVar.b(f2);
            cVar.a(0.9f);
            arrayList.add(cVar);
        }
        b bVar = new b(arrayList);
        GPUImage gPUImage = new GPUImage(context);
        gPUImage.a(bitmap);
        gPUImage.a((a) bVar);
        return gPUImage.c();
    }
}
