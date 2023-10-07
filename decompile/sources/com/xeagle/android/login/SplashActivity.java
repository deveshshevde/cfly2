package com.xeagle.android.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.n;
import androidx.viewpager.widget.ViewPager;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.fragment.PicGuideFragment;
import com.xeagle.android.utils.permission.a;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
    static final String[] PERMISSIONS = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"};
    private static final int REQUEST_CODE = 0;
    private Button bt_start;
    /* access modifiers changed from: private */
    public List<Fragment> fragments;
    /* access modifiers changed from: private */
    public ImageView iv1;
    /* access modifiers changed from: private */
    public ImageView iv2;
    /* access modifiers changed from: private */
    public ImageView iv3;
    private IButton loginBt;
    private a permissionChecker;
    private com.xeagle.android.utils.prefs.a prefs;
    private IButton registerBt;
    private ViewPager vp;

    private class MyPageAdapter extends n {
        public MyPageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return SplashActivity.this.fragments.size();
        }

        public Fragment getItem(int i2) {
            return (Fragment) SplashActivity.this.fragments.get(i2);
        }
    }

    private class MyPageChangeListener implements ViewPager.e {
        private MyPageChangeListener() {
        }

        public void onPageScrollStateChanged(int i2) {
        }

        public void onPageScrolled(int i2, float f2, int i3) {
        }

        public void onPageSelected(int i2) {
            SplashActivity.this.iv1.setImageResource(R.drawable.dot_unselected);
            SplashActivity.this.iv2.setImageResource(R.drawable.dot_unselected);
            SplashActivity.this.iv3.setImageResource(R.drawable.dot_unselected);
            (i2 == 0 ? SplashActivity.this.iv1 : i2 == 1 ? SplashActivity.this.iv2 : SplashActivity.this.iv3).setImageResource(R.drawable.dot_selected);
        }
    }

    private void assignViews() {
        this.vp = (ViewPager) findViewById(R.id.vp);
        this.iv1 = (ImageView) findViewById(R.id.iv1);
        this.iv2 = (ImageView) findViewById(R.id.iv2);
        this.iv3 = (ImageView) findViewById(R.id.iv3);
        this.bt_start = (Button) findViewById(R.id.bt_start);
        this.loginBt = (IButton) findViewById(R.id.bt_login);
        this.registerBt = (IButton) findViewById(R.id.bt_register);
        this.loginBt.setOnClickListener(this);
        this.registerBt.setOnClickListener(this);
    }

    private void initData() {
        this.fragments = new ArrayList();
        PicGuideFragment picGuideFragment = new PicGuideFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", 1);
        picGuideFragment.setArguments(bundle);
        this.fragments.add(picGuideFragment);
    }

    private void initView() {
        this.vp.setOffscreenPageLimit(3);
        this.vp.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        this.vp.addOnPageChangeListener(new MyPageChangeListener());
    }

    public void onClick(View view) {
        Intent intent;
        int id2 = view.getId();
        if (id2 == R.id.bt_login) {
            finish();
            intent = new Intent(this, LoginActivity.class);
        } else if (id2 == R.id.bt_register) {
            finish();
            intent = new Intent(this, RegisterActivity.class);
        } else {
            return;
        }
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView((int) R.layout.splash_activity_layout);
        this.prefs = ((XEagleApp) getApplicationContext()).j();
        assignViews();
        initData();
        initView();
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }
}
