package com.xeagle.android.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.cfly.uav_pro.R;
import java.util.Locale;

public class ForgetPwActivity extends AppCompatActivity implements View.OnClickListener {
    private void initView() {
        int i2;
        TextView textView = (TextView) findViewById(R.id.tv_find_byPhone);
        TextView textView2 = (TextView) findViewById(R.id.tv_find_byEmail);
        TextView textView3 = (TextView) findViewById(R.id.tv_forget_cancel);
        View findViewById = findViewById(R.id.find_divide);
        if (Locale.getDefault().getCountry().equals(Locale.CHINA.getCountry())) {
            i2 = 0;
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            i2 = 4;
        }
        findViewById.setVisibility(i2);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.tv_find_byEmail:
                intent = new Intent(this, FindByEmailActivity.class);
                break;
            case R.id.tv_find_byPhone:
                intent = new Intent(this, FindByPhoneActivity.class);
                break;
            case R.id.tv_forget_cancel:
                intent = new Intent(this, LoginActivity.class);
                break;
            default:
                return;
        }
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setFinishOnTouchOutside(false);
        setContentView((int) R.layout.forget_pw_layout);
        initView();
    }
}
