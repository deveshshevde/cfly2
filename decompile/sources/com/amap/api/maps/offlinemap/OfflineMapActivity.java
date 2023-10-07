package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.mapcore.util.ei;
import com.amap.api.mapcore.util.ej;
import com.amap.api.mapcore.util.el;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.a;

public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static int f9792a;

    /* renamed from: b  reason: collision with root package name */
    private a f9793b;

    /* renamed from: c  reason: collision with root package name */
    private ei f9794c;

    /* renamed from: d  reason: collision with root package name */
    private ei[] f9795d = new ei[32];

    /* renamed from: e  reason: collision with root package name */
    private int f9796e = -1;

    /* renamed from: f  reason: collision with root package name */
    private ej f9797f;

    private void a(ei eiVar) {
        try {
            a aVar = this.f9793b;
            if (aVar != null) {
                aVar.e();
                this.f9793b = null;
            }
            a c2 = c(eiVar);
            this.f9793b = c2;
            if (c2 != null) {
                this.f9794c = eiVar;
                c2.a(this);
                this.f9793b.a();
                this.f9793b.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            int i2 = f9792a;
            if ((i2 != 1 || this.f9793b == null) && i2 > 1) {
                f9792a = i2 - 1;
                int i3 = ((this.f9796e - 1) + 32) % 32;
                this.f9796e = i3;
                ei eiVar = this.f9795d[i3];
                eiVar.f8481b = bundle;
                a(eiVar);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private void b(ei eiVar) {
        try {
            f9792a++;
            a(eiVar);
            int i2 = (this.f9796e + 1) % 32;
            this.f9796e = i2;
            this.f9795d[i2] = eiVar;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private a c(ei eiVar) {
        try {
            if (eiVar.f8480a != 1) {
                return null;
            }
            if (this.f9797f == null) {
                this.f9797f = new ej();
            }
            return this.f9797f;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void closeScr() {
        try {
            if (!a((Bundle) null)) {
                a aVar = this.f9793b;
                if (aVar != null) {
                    aVar.e();
                }
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (!a(bundle)) {
                a aVar = this.f9793b;
                if (aVar != null) {
                    aVar.e();
                }
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onClick(View view) {
        try {
            a aVar = this.f9793b;
            if (aVar != null) {
                aVar.a(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            el.a(getApplicationContext());
            this.f9796e = -1;
            f9792a = 0;
            b(new ei());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            super.onDestroy();
            a aVar = this.f9793b;
            if (aVar != null) {
                aVar.e();
                this.f9793b = null;
            }
            this.f9794c = null;
            this.f9795d = null;
            ej ejVar = this.f9797f;
            if (ejVar != null) {
                ejVar.e();
                this.f9797f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            try {
                a aVar = this.f9793b;
                if (aVar != null && !aVar.c()) {
                    return true;
                }
                if (a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (f9792a == 1) {
                        finish();
                    }
                    return false;
                }
                this.f9796e = -1;
                f9792a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            super.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        try {
            super.onStart();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            super.onStop();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.f9793b.d());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
