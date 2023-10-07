package com.xeagle.android.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.fragment.EmailRegisterFragment;
import com.xeagle.android.login.fragment.PhoneRegisterFragment;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import java.util.Locale;

public class RegisterActivity extends BaseWifiActivity implements View.OnClickListener {
    private IButton bt_email;
    private IButton bt_phone;
    private EmailRegisterFragment erf;

    /* renamed from: fm  reason: collision with root package name */
    private FragmentManager f23790fm;
    private PhoneRegisterFragment prf;

    public void onClick(View view) {
        s sVar;
        s sVar2;
        int id2 = view.getId();
        if (id2 == R.id.bt_email) {
            if (!this.erf.isAdded()) {
                this.f23790fm.a().a((Fragment) this.prf).d();
                this.f23790fm.a().a((int) R.id.fragment_view_content, (Fragment) this.erf).d();
                this.f23790fm.a().c(4097).d();
                sVar = this.f23790fm.a().a("register");
            } else {
                sVar = this.f23790fm.a().c((Fragment) this.prf);
            }
            sVar.d();
            this.bt_email.setBackgroundColor(-1);
            this.bt_phone.setBackgroundColor(Color.parseColor("#609E9E9E"));
        } else if (id2 == R.id.bt_phone) {
            if (!this.prf.isAdded()) {
                this.f23790fm.a().a((Fragment) this.erf).d();
                this.f23790fm.a().a((int) R.id.fragment_view_content, (Fragment) this.prf).d();
                this.f23790fm.a().c(4097).d();
                sVar2 = this.f23790fm.a().a("register");
            } else {
                sVar2 = this.f23790fm.a().c((Fragment) this.prf);
            }
            sVar2.d();
            this.bt_email.setBackgroundColor(Color.parseColor("#609E9E9E"));
            this.bt_phone.setBackgroundColor(-1);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IButton iButton;
        int i2;
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView((int) R.layout.register_activity_layout);
        this.bt_email = (IButton) findViewById(R.id.bt_email);
        this.bt_phone = (IButton) findViewById(R.id.bt_phone);
        if (Locale.getDefault().getCountry().equals(Locale.CHINA.getCountry())) {
            iButton = this.bt_phone;
            i2 = 0;
        } else {
            iButton = this.bt_phone;
            i2 = 8;
        }
        iButton.setVisibility(i2);
        this.bt_email.setOnClickListener(this);
        this.bt_phone.setOnClickListener(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f23790fm = supportFragmentManager;
        s a2 = supportFragmentManager.a();
        this.prf = new PhoneRegisterFragment();
        EmailRegisterFragment emailRegisterFragment = new EmailRegisterFragment();
        this.erf = emailRegisterFragment;
        if (!emailRegisterFragment.isAdded()) {
            a2.a((Fragment) this.erf);
            a2.a((int) R.id.fragment_view_content, (Fragment) this.erf);
            a2.c(4097);
            a2.a("register");
        } else {
            a2 = a2.c((Fragment) this.erf);
        }
        a2.d();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            finish();
            startActivity(new Intent(this, WelcomeActivity.class));
            return true;
        } else if (i2 == 3) {
            return false;
        } else {
            return super.onKeyDown(i2, keyEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }
}
