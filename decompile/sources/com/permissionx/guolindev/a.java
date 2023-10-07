package com.permissionx.guolindev;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import iy.f;
import java.util.HashSet;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private FragmentActivity f21500a;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f21501b;

    public a(FragmentActivity fragmentActivity) {
        this.f21500a = fragmentActivity;
    }

    public f a(List<String> list) {
        boolean z2;
        HashSet hashSet = new HashSet(list);
        HashSet hashSet2 = new HashSet();
        if (hashSet.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            int i2 = Build.VERSION.SDK_INT;
            Fragment fragment = this.f21501b;
            int i3 = ((fragment == null || fragment.getContext() == null) ? this.f21500a.getApplicationInfo() : this.f21501b.getContext().getApplicationInfo()).targetSdkVersion;
            if (i2 >= 30 && i3 >= 30) {
                hashSet.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                z2 = true;
                return new f(this.f21500a, this.f21501b, hashSet, z2, hashSet2);
            } else if (i2 < 29) {
                hashSet.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                hashSet2.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            }
        }
        z2 = false;
        return new f(this.f21500a, this.f21501b, hashSet, z2, hashSet2);
    }
}
