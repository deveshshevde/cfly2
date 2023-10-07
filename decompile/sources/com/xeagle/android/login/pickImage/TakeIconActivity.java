package com.xeagle.android.login.pickImage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.UI;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.newUI.activity.PersonInfoActivity;
import java.io.File;
import java.util.ArrayList;

public class TakeIconActivity extends UI implements View.OnClickListener {
    private static final int AVATAR_TIME_OUT = 30000;
    private static final int PICK_AVATAR_REQUEST = 14;
    private static final String TAG = "takeIcon";
    private TextView tv_take_camera;
    private TextView tv_take_cancel;
    private TextView tv_take_gallery;

    private void initView() {
        this.tv_take_cancel = (TextView) findViewById(R.id.tv_take_cancel);
        this.tv_take_gallery = (TextView) findViewById(R.id.tv_take_gallery);
        TextView textView = (TextView) findViewById(R.id.tv_take_camera);
        this.tv_take_camera = textView;
        textView.setOnClickListener(this);
        this.tv_take_gallery.setOnClickListener(this);
        this.tv_take_cancel.setOnClickListener(this);
    }

    private void onPicked(Intent intent) {
        ArrayList arrayList;
        if (intent != null && (arrayList = (ArrayList) intent.getSerializableExtra(Constants.EXTRA_RESULT_ITEMS)) != null && !arrayList.isEmpty()) {
            Log.i("Listener", "onPicked:----path--- " + ((GLImage) arrayList.get(0)).getPath());
            setResult(-1, intent);
            finish();
        }
    }

    private void updateAvatar(String str) {
        if (!TextUtils.isEmpty(str)) {
            new File(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 14) {
            onPicked(intent);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_take_camera:
                ImagePickerLauncher.takePhoto(this, 14);
                return;
            case R.id.tv_take_cancel:
                startActivity(new Intent(this, PersonInfoActivity.class));
                return;
            case R.id.tv_take_gallery:
                ImagePickerLauncher.selectImageFromAlbum(this, 14);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.take_icon_activity);
        initView();
    }
}
