package com.huawei.android.multiscreen.mirror.sdk.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.huawei.android.multiscreen.mirror.sdk.api.b;

public abstract class MRBaseLayoutActivity extends Activity implements b.a {
    public static final int MSG_FINISH = 33;
    private static int globalIndex;
    /* access modifiers changed from: private */
    public String TAG = "MIRROR_SDK ";
    /* access modifiers changed from: private */
    public ServiceConnection conn = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(MRBaseLayoutActivity.this.TAG, "LayoutActivity onServiceConnected()");
            MRBaseLayoutActivity.this.mBinder = (b.C0137b) iBinder;
            MRBaseLayoutActivity.this.mBinder.a((b.a) MRBaseLayoutActivity.this.context);
            if (!MRBaseLayoutActivity.this.isActivityAlive) {
                MRBaseLayoutActivity.this.mBinder.a();
                MRBaseLayoutActivity mRBaseLayoutActivity = MRBaseLayoutActivity.this;
                mRBaseLayoutActivity.unbindService(mRBaseLayoutActivity.conn);
            } else if (MRBaseLayoutActivity.this.mBinder.a(MRBaseLayoutActivity.this.surface)) {
                MRBaseLayoutActivity.this.mBinder.b();
            } else {
                MRBaseLayoutActivity.this.context.finish();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            MRBaseLayoutActivity.this.mBinder = null;
        }
    };
    /* access modifiers changed from: private */
    public MRBaseLayoutActivity context;
    private int index;
    /* access modifiers changed from: private */
    public boolean isActivityAlive;
    /* access modifiers changed from: private */
    public boolean isFirstSurfaceCreated;
    /* access modifiers changed from: private */
    public b.C0137b mBinder;
    /* access modifiers changed from: private */
    public Surface surface;

    /* access modifiers changed from: private */
    public void finishActivity() {
        if (this.isActivityAlive) {
            this.isActivityAlive = false;
            b.C0137b bVar = this.mBinder;
            if (bVar != null) {
                bVar.c();
                this.mBinder.d();
                unbindService(this.conn);
            }
        }
    }

    public void connected() {
        Log.d(this.TAG, "ISinkCallback connected in");
        Log.d(this.TAG, "ISinkCallback connected out");
    }

    public void disconnected() {
        Log.d(this.TAG, "ISinkCallback disconnected in");
        this.context.finish();
        Log.d(this.TAG, "ISinkCallback disconnected out");
    }

    public abstract Class<?> getServiceClass();

    public abstract SurfaceHolder getSurfaceHolder();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i2 = globalIndex;
        globalIndex = i2 + 1;
        this.index = i2;
        String str = String.valueOf(this.TAG) + this.index;
        this.TAG = str;
        Log.d(str, "LayoutActivity onCreate()");
        super.onCreate(bundle);
        this.context = this;
        this.isActivityAlive = true;
        this.isFirstSurfaceCreated = false;
        SurfaceHolder surfaceHolder = getSurfaceHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                Log.d(MRBaseLayoutActivity.this.TAG, "LayoutActivity surfaceChanged in");
                Log.d(MRBaseLayoutActivity.this.TAG, "LayoutActivity surfaceChanged out");
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Log.d(MRBaseLayoutActivity.this.TAG, "LayoutActivity surfaceCreated in");
                if (!MRBaseLayoutActivity.this.isFirstSurfaceCreated) {
                    MRBaseLayoutActivity.this.isFirstSurfaceCreated = true;
                    Intent intent = new Intent();
                    intent.setClass(MRBaseLayoutActivity.this.context, MRBaseLayoutActivity.this.getServiceClass());
                    MRBaseLayoutActivity mRBaseLayoutActivity = MRBaseLayoutActivity.this;
                    mRBaseLayoutActivity.bindService(intent, mRBaseLayoutActivity.conn, 1);
                }
                Log.d(MRBaseLayoutActivity.this.TAG, "LayoutActivity surfaceCreated out");
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                Log.d(MRBaseLayoutActivity.this.TAG, "LayoutActivity surfaceDestroyed in");
                MRBaseLayoutActivity.this.finishActivity();
                Log.d(MRBaseLayoutActivity.this.TAG, "LayoutActivity surfaceDestroyed out");
            }
        });
        this.surface = surfaceHolder.getSurface();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.d(this.TAG, "LayoutActivity onDestroy()");
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Log.d(this.TAG, "LayoutActivity onPause()");
        finishActivity();
        finish();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Log.d(this.TAG, "LayoutActivity onResume()");
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        Log.d(this.TAG, "LayoutActivity onStop()");
        finish();
        super.onStop();
    }
}
