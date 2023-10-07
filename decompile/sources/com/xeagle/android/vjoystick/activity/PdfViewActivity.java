package com.xeagle.android.vjoystick.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cfly.uav_pro.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.a;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.newUI.activity.BaseActivity;
import java.io.File;
import kx.d;

public class PdfViewActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private PDFView f24979a;

    /* renamed from: b  reason: collision with root package name */
    private String f24980b;

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HostManagerActivity.class));
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.pdf_view_activity);
        this.f24980b = getIntent().getStringExtra("pdf_name");
        this.f24979a = (PDFView) findViewById(R.id.pdf_view);
        findViewById(R.id.tv_go_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PdfViewActivity.this.startActivity(new Intent(PdfViewActivity.this, HostManagerActivity.class));
                PdfViewActivity.this.finish();
            }
        });
        PDFView pDFView = this.f24979a;
        pDFView.a(new File(d.m(getApplicationContext()) + this.f24980b + ".pdf")).a(true).d(false).b(true).a(0).c(false).a((String) null).a((a) null).e(true).b(0).f(true).g(true).h(true).i(false).a();
    }
}
