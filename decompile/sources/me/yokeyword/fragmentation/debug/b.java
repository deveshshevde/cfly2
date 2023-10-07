package me.yokeyword.fragmentation.debug;

import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.x;
import java.util.ArrayList;
import java.util.List;
import me.yokeyword.fragmentation.R;
import me.yokeyword.fragmentation.c;

public class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private FragmentActivity f31126a;

    /* renamed from: b  reason: collision with root package name */
    private SensorManager f31127b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.appcompat.app.b f31128c;

    private class a implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        private View f31131b;

        /* renamed from: c  reason: collision with root package name */
        private float f31132c;

        /* renamed from: d  reason: collision with root package name */
        private float f31133d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        private float f31134e;

        /* renamed from: f  reason: collision with root package name */
        private float f31135f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f31136g;

        /* renamed from: h  reason: collision with root package name */
        private int f31137h;

        a(View view, int i2) {
            this.f31131b = view;
            this.f31137h = i2;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else if (Math.abs(rawX - this.f31134e) >= ((float) this.f31137h) || Math.abs(rawY - this.f31135f) >= ((float) this.f31137h) || !this.f31136g) {
                        this.f31136g = false;
                        this.f31131b.setX(motionEvent.getRawX() + this.f31132c);
                        this.f31131b.setY(motionEvent.getRawY() + this.f31133d);
                    } else {
                        this.f31136g = true;
                    }
                }
                if (rawX - this.f31134e < ((float) this.f31137h) && this.f31136g) {
                    this.f31131b.performClick();
                }
            } else {
                this.f31136g = true;
                this.f31134e = rawX;
                this.f31135f = rawY;
                this.f31132c = this.f31131b.getX() - motionEvent.getRawX();
                this.f31133d = this.f31131b.getY() - motionEvent.getRawY();
            }
            return true;
        }
    }

    public b(FragmentActivity fragmentActivity) {
        this.f31126a = fragmentActivity;
    }

    private CharSequence a(CharSequence charSequence, String str) {
        return charSequence + str;
    }

    private List<a> a(Fragment fragment) {
        ArrayList arrayList = new ArrayList();
        List<Fragment> c2 = x.c(fragment.getChildFragmentManager());
        if (c2 == null || c2.size() < 1) {
            return null;
        }
        for (int size = c2.size() - 1; size >= 0; size--) {
            a((List<a>) arrayList, c2.get(size));
        }
        return arrayList;
    }

    private void a(List<a> list, Fragment fragment) {
        CharSequence charSequence;
        if (fragment != null) {
            int f2 = fragment.getFragmentManager().f();
            CharSequence simpleName = fragment.getClass().getSimpleName();
            if (f2 == 0) {
                charSequence = a(simpleName, " *");
            } else {
                for (int i2 = 0; i2 < f2; i2++) {
                    FragmentManager.a b2 = fragment.getFragmentManager().b(i2);
                    if ((b2.i() != null && b2.i().equals(fragment.getTag())) || (b2.i() == null && fragment.getTag() == null)) {
                        break;
                    }
                    if (i2 == f2 - 1) {
                        simpleName = a(simpleName, " *");
                    }
                }
                charSequence = simpleName;
            }
            if ((fragment instanceof c) && ((c) fragment).j()) {
                charSequence = a(charSequence, " ☀");
            }
            list.add(new a(charSequence, a(fragment)));
        }
    }

    private List<a> c() {
        ArrayList arrayList = new ArrayList();
        List<Fragment> c2 = x.c(this.f31126a.getSupportFragmentManager());
        if (c2 == null || c2.size() < 1) {
            return null;
        }
        for (Fragment a2 : c2) {
            a((List<a>) arrayList, a2);
        }
        return arrayList;
    }

    public void a() {
        SensorManager sensorManager = this.f31127b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public void a(int i2) {
        if (i2 == 1) {
            SensorManager sensorManager = (SensorManager) this.f31126a.getSystemService("sensor");
            this.f31127b = sensorManager;
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 3);
        }
    }

    public void b() {
        androidx.appcompat.app.b bVar = this.f31128c;
        if (bVar == null || !bVar.isShowing()) {
            DebugHierarchyViewContainer debugHierarchyViewContainer = new DebugHierarchyViewContainer(this.f31126a);
            debugHierarchyViewContainer.a(c());
            debugHierarchyViewContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            androidx.appcompat.app.b b2 = new b.a(this.f31126a).b((View) debugHierarchyViewContainer).a(17039360, (DialogInterface.OnClickListener) null).a(true).b();
            this.f31128c = b2;
            b2.show();
        }
    }

    public void b(int i2) {
        if (i2 == 2) {
            View findViewById = this.f31126a.findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                ImageView imageView = new ImageView(this.f31126a);
                imageView.setImageResource(R.drawable.fragmentation_ic_stack);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 8388613;
                int applyDimension = (int) TypedValue.applyDimension(1, 18.0f, this.f31126a.getResources().getDisplayMetrics());
                layoutParams.topMargin = applyDimension * 7;
                layoutParams.rightMargin = applyDimension;
                imageView.setLayoutParams(layoutParams);
                ((FrameLayout) findViewById).addView(imageView);
                imageView.setOnTouchListener(new a(imageView, applyDimension / 4));
                imageView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        b.this.b();
                    }
                });
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        if (type == 1) {
            float f2 = (float) 12;
            if (Math.abs(fArr[0]) >= f2 || Math.abs(fArr[1]) >= f2 || Math.abs(fArr[2]) >= f2) {
                b();
            }
        }
    }
}
