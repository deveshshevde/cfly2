package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;

public class y extends c {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22780b = true;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f22781c = {"rb1", "rb2", "rb3", "rb4"};

    /* renamed from: a  reason: collision with root package name */
    protected a f22782a;

    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f22780b || window != null) {
            window.setGravity(17);
            create.show();
            window.setLayout(getActivity().getWindowManager().getDefaultDisplay().getWidth() / 2, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 3) / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        int i3 = 0;
        View inflate = layoutInflater.inflate(R.layout.dlg_list_common, viewGroup, false);
        Bundle arguments = getArguments();
        String str5 = "";
        if (arguments != null) {
            int i4 = arguments.getInt("flag", 2);
            i3 = arguments.getInt("position", 0);
            String string = arguments.getString("content", "编码方式切换");
            str3 = arguments.getString("rb1", "H.264");
            str2 = arguments.getString("rb2", "H.265");
            str = arguments.getString("rb3", "VGA");
            String str6 = string;
            str4 = arguments.getString("rb4", "4M");
            i2 = i4;
            str5 = str6;
        } else {
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
            i2 = 2;
        }
        ((TextView) inflate.findViewById(R.id.notify_title)).setText(str5);
        inflate.findViewById(R.id.ib_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                y.this.dismiss();
            }
        });
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.list_rg);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.rb1);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.rb2);
        RadioButton radioButton3 = (RadioButton) inflate.findViewById(R.id.rb3);
        RadioButton radioButton4 = (RadioButton) inflate.findViewById(R.id.rb4);
        radioGroup.check(new int[]{R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4}[i3]);
        if (i2 == 2) {
            radioButton.setText(str3);
            radioButton2.setText(str2);
            radioButton3.setVisibility(8);
        } else if (i2 == 3) {
            radioButton.setText(str3);
            radioButton2.setText(str2);
            radioButton3.setText(str);
        } else {
            if (i2 == 4) {
                radioButton.setText(str3);
                radioButton2.setText(str2);
                radioButton3.setText(str);
                radioButton4.setText(str4);
            }
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup radioGroup, int i2) {
                    switch (i2) {
                        case R.id.rb1:
                            y.this.f22782a.a();
                            break;
                        case R.id.rb2:
                            y.this.f22782a.b();
                            break;
                        case R.id.rb3:
                            y.this.f22782a.c();
                            break;
                        case R.id.rb4:
                            y.this.f22782a.d();
                            break;
                        default:
                            return;
                    }
                    y.this.dismiss();
                }
            });
            return inflate;
        }
        radioButton4.setVisibility(8);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i2) {
                switch (i2) {
                    case R.id.rb1:
                        y.this.f22782a.a();
                        break;
                    case R.id.rb2:
                        y.this.f22782a.b();
                        break;
                    case R.id.rb3:
                        y.this.f22782a.c();
                        break;
                    case R.id.rb4:
                        y.this.f22782a.d();
                        break;
                    default:
                        return;
                }
                y.this.dismiss();
            }
        });
        return inflate;
    }
}
