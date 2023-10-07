package com.huantansheng.easyphotos;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.huantansheng.easyphotos.Builder.AlbumBuilder;
import hv.b;
import java.io.File;

public class a {
    public static AlbumBuilder a(FragmentActivity fragmentActivity, boolean z2, boolean z3, hh.a aVar) {
        return AlbumBuilder.a(fragmentActivity, z2, aVar).a(z3);
    }

    public static void a(Activity activity, String str, String str2, Bitmap bitmap, boolean z2, b bVar) {
        hv.a.a(activity, str, str2, bitmap, z2, bVar);
    }

    public static void a(Context context, File... fileArr) {
        hw.b.a(context, fileArr);
    }

    public static void a(Bitmap bitmap) {
        hv.a.a(bitmap);
    }

    public static void a(hi.a aVar) {
        AlbumBuilder.a(aVar);
    }
}
