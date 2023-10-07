package com.huantansheng.easyphotos.models.sticker.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import com.huantansheng.easyphotos.R;

public class a extends c implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextView f20524a;

    /* renamed from: b  reason: collision with root package name */
    private EditText f20525b;

    /* renamed from: c  reason: collision with root package name */
    private SeekBar f20526c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextSticker f20527d = null;

    /* renamed from: e  reason: collision with root package name */
    private InputMethodManager f20528e;

    public static a a(FragmentManager fragmentManager, TextSticker textSticker) {
        a aVar = new a();
        aVar.f20527d = textSticker;
        aVar.show(fragmentManager, "edit");
        return aVar;
    }

    private void a(int i2) {
        this.f20524a.setTextColor(i2);
        this.f20527d.setTextColor(i2);
    }

    private void a(View view, int... iArr) {
        for (int findViewById : iArr) {
            view.findViewById(findViewById).setOnClickListener(this);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        this.f20524a.setAlpha(((float) i2) / 225.0f);
        this.f20527d.setTextAlpha(i2);
    }

    public void a() {
        String text = this.f20527d.getText();
        this.f20524a.setText(text);
        this.f20525b.setText(text);
        this.f20525b.setSelection(text.length());
        int textAlpha = this.f20527d.getTextAlpha();
        this.f20526c.setProgress(textAlpha);
        this.f20524a.setTextColor(this.f20527d.getTextColor());
        this.f20524a.setAlpha(((float) textAlpha) / 255.0f);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        this.f20528e = inputMethodManager;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.f20525b, 0);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 1024;
            window.setAttributes(attributes);
            window.requestFeature(1);
        }
        super.onActivityCreated(bundle);
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setSoftInputMode(16);
        }
    }

    public void onClick(View view) {
        Context context;
        int i2;
        int id2 = view.getId();
        if (R.id.iv_red == id2) {
            context = getContext();
            i2 = R.color.text_sticker_red_easy_photos;
        } else if (R.id.iv_orange == id2) {
            context = getContext();
            i2 = R.color.text_sticker_orange_easy_photos;
        } else if (R.id.iv_yellow == id2) {
            context = getContext();
            i2 = R.color.text_sticker_yellow_easy_photos;
        } else if (R.id.iv_green == id2) {
            context = getContext();
            i2 = R.color.text_sticker_green_easy_photos;
        } else if (R.id.iv_cyan == id2) {
            context = getContext();
            i2 = R.color.text_sticker_cyan_easy_photos;
        } else if (R.id.iv_blue == id2) {
            context = getContext();
            i2 = R.color.text_sticker_blue_easy_photos;
        } else if (R.id.iv_purple == id2) {
            context = getContext();
            i2 = R.color.text_sticker_purple_easy_photos;
        } else if (R.id.iv_black == id2) {
            context = getContext();
            i2 = R.color.text_sticker_black_easy_photos;
        } else if (R.id.iv_gray == id2) {
            context = getContext();
            i2 = R.color.text_sticker_gray_easy_photos;
        } else if (R.id.iv_white == id2) {
            context = getContext();
            i2 = R.color.text_sticker_white_easy_photos;
        } else if (R.id.tv_done == id2) {
            dismiss();
            return;
        } else if (R.id.iv_clear == id2) {
            this.f20525b.setText((CharSequence) null);
            return;
        } else {
            return;
        }
        a(b.c(context, i2));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_text_sticker_easy_photos, viewGroup);
        this.f20524a = (TextView) inflate.findViewById(R.id.tv_sample);
        this.f20525b = (EditText) inflate.findViewById(R.id.f20298et);
        this.f20526c = (SeekBar) inflate.findViewById(R.id.m_seek_bar);
        a(inflate, R.id.iv_red, R.id.iv_orange, R.id.iv_yellow, R.id.iv_green, R.id.iv_cyan, R.id.iv_blue, R.id.iv_purple, R.id.iv_black, R.id.iv_gray, R.id.iv_white, R.id.tv_done, R.id.iv_clear);
        this.f20526c.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
                if (z2) {
                    a.this.b(i2);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.f20525b.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                a.this.f20524a.setText(editable.toString());
                if (a.this.f20527d != null) {
                    a.this.f20527d.a(editable.toString());
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        return inflate;
    }

    public void onResume() {
        super.onResume();
        a();
    }
}
