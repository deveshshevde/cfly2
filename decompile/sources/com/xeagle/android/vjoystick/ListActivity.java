package com.xeagle.android.vjoystick;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.utils.permission.PermissionActivity;
import com.xeagle.android.utils.permission.a;
import java.util.ArrayList;

public class ListActivity extends SuperUI {

    /* renamed from: b  reason: collision with root package name */
    static final String[] f24805b = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};

    /* renamed from: a  reason: collision with root package name */
    ArrayList<String> f24806a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private int f24807c = 1;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f24808k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f24809l;

    /* renamed from: m  reason: collision with root package name */
    private ListView f24810m;

    /* renamed from: n  reason: collision with root package name */
    private ProgressDialog f24811n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f24812o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24813p = false;

    /* renamed from: q  reason: collision with root package name */
    private int f24814q = 0;

    /* renamed from: r  reason: collision with root package name */
    private a f24815r;

    /* renamed from: s  reason: collision with root package name */
    private AdapterView.OnItemClickListener f24816s = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        }
    };

    private void a() {
        PermissionActivity.a(this, 0, f24805b);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0 && i3 == 1) {
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(this, SelectActivity.class));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView((int) R.layout.activity_camera_list);
        this.f24815r = new a(this);
        this.f24807c = getIntent().getIntExtra("MediaType", 4);
        this.f24808k = (ImageView) findViewById(R.id.iv_list_top_back);
        this.f24809l = (TextView) findViewById(R.id.tv_list_top_title);
        this.f24810m = (ListView) findViewById(R.id.mMediaList);
        this.f24808k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ListActivity.this.onBackPressed();
            }
        });
        this.f24810m.setOnItemClickListener(this.f24816s);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f24811n = progressDialog;
        progressDialog.setProgressStyle(1);
        this.f24811n.setProgress(0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f24815r.a(f24805b)) {
            a();
        }
    }
}
