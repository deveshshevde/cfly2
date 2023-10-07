package com.xeagle.android.newUI.fragment.remindFragment;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.cfly.uav_pro.R;

public class c extends com.xeagle.android.dialogs.a {

    /* renamed from: b  reason: collision with root package name */
    public a f24035b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f24036c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f24037d;

    public interface a {
        void a();

        void a(String str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.f24035b != null) {
            dismiss();
            this.f24035b.a(this.f24036c.getText().toString());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.f24035b != null) {
            dismiss();
            this.f24035b.a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_insurance_guide, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f24036c = (EditText) view.findViewById(R.id.et_guide_insurance);
        this.f24037d = (TextView) view.findViewById(R.id.tv_more_insurance);
        String string = getString(R.string.guide_insurance_3);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
            }
        }, 0, string.length(), 17);
        this.f24037d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f24037d.setText(spannableString);
        view.findViewById(R.id.bt_skip).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.b(view);
            }
        });
        view.findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.a(view);
            }
        });
    }
}
