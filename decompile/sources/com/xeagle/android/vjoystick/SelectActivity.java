package com.xeagle.android.vjoystick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.activities.helpers.SuperUI;

public class SelectActivity extends SuperUI {
    private void a(Class<?> cls, int i2) {
        finish();
        Intent intent = new Intent(this, cls);
        if (i2 > 0) {
            intent.putExtra("MediaType", i2);
        }
        startActivity(intent);
    }

    public void onBackPressed() {
        super.onBackPressed();
        a(FlightActionActivity.class, 0);
    }

    public void onBackPressed(View view) {
        onBackPressed();
    }

    public void onCardPhotoPressed(View view) {
        a(ListActivity.class, 3);
    }

    public void onCardVideoPressed(View view) {
        a(ListActivity.class, 4);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView((int) R.layout.activity_select);
    }

    public void onPhotoPressed(View view) {
    }

    public void onVideoPressed(View view) {
    }
}
