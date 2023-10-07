package com.xeagle.android.utils.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.a;
import com.cfly.uav_pro.R;

public class PermissionActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private a f24503a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24504b;

    public static void a(Activity activity, int i2, String... strArr) {
        Intent intent = new Intent(activity, PermissionActivity.class);
        intent.putExtra("com.flypro.permission.extra_permission", strArr);
        a.a(activity, intent, i2, (Bundle) null);
    }

    private void a(String... strArr) {
        a.a(this, strArr, 0);
    }

    private boolean a(int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == -1) {
                return false;
            }
        }
        return true;
    }

    private String[] a() {
        return getIntent().getStringArrayExtra("com.flypro.permission.extra_permission");
    }

    private void b() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null || !getIntent().hasExtra("com.flypro.permission.extra_permission")) {
            throw new RuntimeException("PermissionActivity 需要使用静态startActivityForResult启动");
        }
        setContentView((int) R.layout.activity_permission);
        this.f24503a = new a(this);
        this.f24504b = true;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 0 || !a(iArr)) {
            this.f24504b = false;
            setResult(1);
            finish();
            return;
        }
        this.f24504b = true;
        b();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f24504b) {
            String[] a2 = a();
            if (this.f24503a.a(a2)) {
                a(a2);
            } else {
                b();
            }
        } else {
            this.f24504b = true;
        }
    }
}
