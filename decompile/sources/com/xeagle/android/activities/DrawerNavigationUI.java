package com.xeagle.android.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.helpers.SuperUI;

public abstract class DrawerNavigationUI extends SuperUI {

    /* renamed from: a  reason: collision with root package name */
    private ab.a f22097a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public DrawerLayout f22098b;

    /* renamed from: c  reason: collision with root package name */
    private a f22099c;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Intent f22100k;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final TextView f22105a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f22106b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f22107c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f22108d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f22109e;

        private a(View view) {
            this.f22105a = (TextView) view.findViewById(R.id.navigation_flight_data);
            this.f22106b = (TextView) view.findViewById(R.id.navigation_editor);
            this.f22107c = (TextView) view.findViewById(R.id.navigation_settings);
            this.f22108d = (TextView) view.findViewById(R.id.navigation_params);
            this.f22109e = (TextView) view.findViewById(R.id.navigation_calibration);
        }
    }

    private void a(int i2, TextView textView, final Intent intent) {
        View.OnClickListener onClickListener;
        if (textView != null) {
            if (i2 == textView.getId()) {
                textView.setTypeface((Typeface) null, 1);
                onClickListener = new View.OnClickListener() {
                    public void onClick(View view) {
                        DrawerNavigationUI.this.f22098b.f(8388611);
                    }
                };
            } else {
                textView.setTypeface((Typeface) null, 0);
                onClickListener = new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = intent;
                        if (intent != null) {
                            Intent unused = DrawerNavigationUI.this.f22100k = intent;
                        }
                        DrawerNavigationUI.this.f22098b.f(8388611);
                    }
                };
            }
            textView.setOnClickListener(onClickListener);
        }
    }

    private void b() {
        View findViewById = findViewById(R.id.nav_drawer_container);
        if (findViewById != null) {
            this.f22099c = new a(findViewById);
        }
    }

    private void d() {
        if (this.f22099c != null) {
            Context applicationContext = getApplicationContext();
            int a2 = a();
            a(a2, this.f22099c.f22105a, new Intent(applicationContext, FlightActivity.class));
            a(a2, this.f22099c.f22106b, new Intent(applicationContext, EditorActivity.class));
            a(a2, this.f22099c.f22107c, new Intent(applicationContext, SettingsActivity.class));
            a(a2, this.f22099c.f22109e, new Intent(applicationContext, ConfigurationActivity.class).putExtra(ConfigurationActivity.f22094a, R.id.navigation_calibration));
            a(a2, this.f22099c.f22108d, new Intent(applicationContext, ConfigurationActivity.class).putExtra(ConfigurationActivity.f22094a, R.id.navigation_params));
        }
    }

    public void OpenRightMenu(View view) {
        if (this.f22098b.g(5)) {
            this.f22098b.f(5);
        } else if (!this.f22098b.g(5)) {
            this.f22098b.e(5);
        }
        this.f22098b.a(0, 5);
    }

    /* access modifiers changed from: protected */
    public abstract int a();

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ab.a aVar = this.f22097a;
        if (aVar != null) {
            aVar.a(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        DrawerLayout drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_navigation_ui, (ViewGroup) null);
        this.f22098b = drawerLayout;
        this.f22097a = new ab.a(this, drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
            public void a(View view, float f2) {
                View childAt = DrawerNavigationUI.this.f22098b.getChildAt(0);
                float f3 = ((1.0f - f2) * 0.2f) + 0.8f;
                if (view.getTag().equals("Right")) {
                    it.a.i(childAt, ((float) (-view.getMeasuredWidth())) * f2);
                    childAt.invalidate();
                    it.a.g(childAt, f3);
                    it.a.h(childAt, f3);
                    DrawerNavigationUI.this.f22098b.setBackground(DrawerNavigationUI.this.getResources().getDrawable(R.drawable.avchat_call_bg));
                }
            }

            public void b(View view) {
                if (DrawerNavigationUI.this.f22100k != null) {
                    DrawerNavigationUI drawerNavigationUI = DrawerNavigationUI.this;
                    drawerNavigationUI.startActivity(drawerNavigationUI.f22100k);
                    Intent unused = DrawerNavigationUI.this.f22100k = null;
                }
                DrawerNavigationUI.this.f22098b.a(1, 5);
            }
        };
        this.f22098b.a(1, 5);
        this.f22098b.setDrawerListener(this.f22097a);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f22097a.a(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ab.a aVar = this.f22097a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void onResume() {
        super.onResume();
        d();
    }

    public void setContentView(int i2) {
        this.f22098b.addView(getLayoutInflater().inflate(i2, this.f22098b, false), 0);
        setContentView((View) this.f22098b);
        b();
    }
}
