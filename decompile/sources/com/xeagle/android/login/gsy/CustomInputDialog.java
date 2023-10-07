package com.xeagle.android.login.gsy;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.cfly.uav_pro.R;

public class CustomInputDialog extends Dialog {
    private TextView btnNegative;
    private TextView btnPostive;
    private boolean cache = false;
    /* access modifiers changed from: private */
    public CheckBox cacheCheck;
    private Context context;
    /* access modifiers changed from: private */
    public EditText editMessage;
    private String hintInput;
    /* access modifiers changed from: private */
    public String input;
    private int maxLength = 500;
    /* access modifiers changed from: private */
    public boolean needDismissOnClick = true;
    private boolean negativeButtonVisiable = false;
    private String negativeText;
    /* access modifiers changed from: private */
    public OnClickListener onNegativeClickListener;
    /* access modifiers changed from: private */
    public OnClickListener onPostiveClickListener;
    private boolean postiveButtonVisiable = false;
    private String postiveText;
    private String title;
    private TextView txtTitle;

    private class OnButtonClickListener implements View.OnClickListener {
        private OnButtonClickListener() {
        }

        public void onClick(View view) {
            if (R.id.dialog_input_dialog_postive == view.getId()) {
                if (CustomInputDialog.this.onPostiveClickListener != null) {
                    CustomInputDialog.this.onPostiveClickListener.onClick(CustomInputDialog.this, -1);
                    String obj = CustomInputDialog.this.editMessage.getText().toString();
                    if (!obj.equals(CustomInputDialog.this.input)) {
                        String unused = CustomInputDialog.this.input = obj;
                        CustomInputDialog.this.onPostiveClickListener.onInputChanged(CustomInputDialog.this.input, CustomInputDialog.this.cacheCheck.isChecked());
                    }
                }
            } else if (R.id.dialog_input_dialog_negative == view.getId() && CustomInputDialog.this.onNegativeClickListener != null) {
                CustomInputDialog.this.onNegativeClickListener.onClick(CustomInputDialog.this, -2);
            }
            if (CustomInputDialog.this.needDismissOnClick) {
                CustomInputDialog.this.dismiss();
            }
        }
    }

    public interface OnClickListener extends DialogInterface.OnClickListener {
        void onInputChanged(String str, boolean z2);
    }

    public CustomInputDialog(Context context2) {
        super(context2, R.style.dialog);
        this.context = context2;
    }

    public void collapseSoftInputMethod() {
        Context context2 = getContext();
        getContext();
        InputMethodManager inputMethodManager = (InputMethodManager) context2.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void dismiss() {
        collapseSoftInputMethod();
        super.dismiss();
    }

    public EditText getEditMessage() {
        return this.editMessage;
    }

    public void init() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.layout_custom_dialog, (ViewGroup) null);
        setContentView(inflate);
        this.txtTitle = (TextView) inflate.findViewById(R.id.dialog_input_title);
        this.editMessage = (EditText) inflate.findViewById(R.id.dialog_input_dialog_edit);
        this.btnPostive = (TextView) inflate.findViewById(R.id.dialog_input_dialog_postive);
        this.btnNegative = (TextView) inflate.findViewById(R.id.dialog_input_dialog_negative);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.dialog_input_check);
        this.cacheCheck = checkBox;
        checkBox.setChecked(this.cache);
        if (this.postiveButtonVisiable) {
            this.btnPostive.setVisibility(0);
        } else {
            this.btnPostive.setVisibility(8);
        }
        if (this.negativeButtonVisiable) {
            this.btnNegative.setVisibility(0);
        } else {
            this.btnNegative.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.title)) {
            this.txtTitle.setVisibility(8);
        } else {
            this.txtTitle.setVisibility(0);
            this.txtTitle.setText(this.title);
        }
        this.editMessage.setText(this.input);
        String str = this.input;
        if (str != null) {
            this.editMessage.setSelection(str.length());
        }
        if (!TextUtils.isEmpty(this.hintInput)) {
            this.editMessage.setHint(this.hintInput);
        }
        this.btnPostive.setText(this.postiveText);
        this.btnNegative.setText(this.negativeText);
        this.btnPostive.setOnClickListener(new OnButtonClickListener());
        this.btnNegative.setOnClickListener(new OnButtonClickListener());
        this.editMessage.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.maxLength)});
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        double d2 = (double) this.context.getResources().getDisplayMetrics().widthPixels;
        Double.isNaN(d2);
        attributes.width = (int) (d2 * 0.8d);
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    public void setButton(int i2, String str, OnClickListener onClickListener) {
        if (i2 == -2) {
            this.negativeButtonVisiable = true;
            this.negativeText = str;
            setOnNegativeClickListener(onClickListener);
        } else if (i2 == -1) {
            this.postiveButtonVisiable = true;
            this.postiveText = str;
            setOnPostiveClickListener(onClickListener);
        }
    }

    public void setCache(boolean z2) {
        this.cache = z2;
    }

    public void setEditMessage(EditText editText) {
        this.editMessage = editText;
    }

    public void setHintInput(String str) {
        this.hintInput = str;
    }

    public void setInput(int i2) {
        this.input = this.context.getString(i2);
    }

    public void setInput(String str) {
        this.input = str;
    }

    public void setMaxLength(int i2) {
        this.maxLength = i2;
    }

    public void setNeedDismissOnClick(boolean z2) {
        this.needDismissOnClick = z2;
    }

    public void setOnNegativeClickListener(OnClickListener onClickListener) {
        this.onNegativeClickListener = onClickListener;
    }

    public void setOnPostiveClickListener(OnClickListener onClickListener) {
        this.onPostiveClickListener = onClickListener;
    }

    public void setTitle(int i2) {
        this.title = this.context.getString(i2);
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
