package js;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f29744a = true;

    /* renamed from: b  reason: collision with root package name */
    private IButton f29745b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.xeagle.android.utils.prefs.a f29746c;

    /* access modifiers changed from: private */
    public void a(final String str, TextView textView) {
        AlertDialog.Builder builder;
        try {
            builder = new AlertDialog.Builder(getActivity(), R.style.dialog);
        } catch (NoSuchMethodError unused) {
            Log.e("TEST", "Older SDK, using old Builder");
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setView(R.layout.editor_common_dialog);
        final AlertDialog create = builder.create();
        create.show();
        Window window = create.getWindow();
        if (window != null) {
            window.setLayout(window.getWindowManager().getDefaultDisplay().getWidth() / 2, (window.getWindowManager().getDefaultDisplay().getHeight() * 2) / 5);
            window.setContentView(R.layout.editor_common_dialog);
            final EditText editText = (EditText) window.findViewById(R.id.editor_set);
            editText.setImeOptions(301989888);
            editText.setSingleLine();
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            final TextView textView2 = (TextView) window.findViewById(R.id.notify_title);
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        TextView textView;
                        String str;
                        if (str.equalsIgnoreCase("drone")) {
                            textView = textView2;
                            str = "修改飞控版本";
                        } else if (str.equalsIgnoreCase("repeater")) {
                            textView = textView2;
                            str = "修改中继版本";
                        } else if (str.equalsIgnoreCase("rc")) {
                            textView = textView2;
                            str = "修改遥控版本";
                        } else if (str.equalsIgnoreCase("img")) {
                            textView = textView2;
                            str = "修改影像版本";
                        } else if (str.equalsIgnoreCase("rssi")) {
                            textView = textView2;
                            str = "修改信号强度标准";
                        } else {
                            return;
                        }
                        textView.setText(str);
                    }
                });
            }
            TextView textView3 = (TextView) window.findViewById(R.id.editor_warn);
            textView3.setText(getActivity().getString(R.string.change_last_str));
            textView3.setVisibility(8);
            ((IButton) window.findViewById(R.id.ib_cancel)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    create.dismiss();
                }
            });
            final String str2 = str;
            final TextView textView4 = textView;
            final AlertDialog alertDialog = create;
            ((IButton) window.findViewById(R.id.ib_ok)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (a.this.getActivity() != null) {
                        a.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                TextView textView;
                                String aA;
                                if (editText.getText().toString().equals("")) {
                                    Toast.makeText(a.this.getActivity(), "请输入版本内容", 0).show();
                                    return;
                                }
                                if (str2.equalsIgnoreCase("drone")) {
                                    a.this.f29746c.G(editText.getText().toString());
                                    textView = textView4;
                                    aA = a.this.f29746c.ax();
                                } else if (str2.equalsIgnoreCase("repeater")) {
                                    a.this.f29746c.H(editText.getText().toString());
                                    textView = textView4;
                                    aA = a.this.f29746c.ay();
                                } else if (str2.equalsIgnoreCase("rc")) {
                                    a.this.f29746c.I(editText.getText().toString());
                                    textView = textView4;
                                    aA = a.this.f29746c.az();
                                } else if (str2.equalsIgnoreCase("img")) {
                                    a.this.f29746c.J(editText.getText().toString());
                                    textView = textView4;
                                    aA = a.this.f29746c.aA();
                                } else if (str2.equalsIgnoreCase("rssi")) {
                                    try {
                                        a.this.f29746c.n(Integer.parseInt(editText.getText().toString()));
                                        TextView textView2 = textView4;
                                        textView2.setText(a.this.f29746c.aB() + "");
                                        return;
                                    } catch (NumberFormatException e2) {
                                        Toast.makeText(a.this.getActivity(), "请输入数字！！！", 0).show();
                                        e2.printStackTrace();
                                        return;
                                    }
                                } else {
                                    return;
                                }
                                textView.setText(aA);
                            }
                        });
                    }
                    alertDialog.dismiss();
                }
            });
            create.show();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f29744a || window != null) {
            window.setGravity(17);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 4) / 5, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 4) / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        View inflate = layoutInflater.inflate(R.layout.check_version_layout, viewGroup, false);
        this.f29746c = ((XEagleApp) getActivity().getApplication()).j();
        Bundle arguments = getArguments();
        if (arguments != null) {
            str5 = arguments.getString("extra_title", "");
            str4 = arguments.getString("extra_drone", "");
            str3 = arguments.getString("extra_wifi", "");
            str2 = arguments.getString("extra_rc", "");
            str = arguments.getString("extra_camera", "");
            i2 = arguments.getInt("extra_rssi", 0);
        } else {
            str5 = "";
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
            i2 = 0;
        }
        ((TextView) inflate.findViewById(R.id.notify_title)).setText(str5);
        final TextView textView = (TextView) inflate.findViewById(R.id.version_drone_firmware_txt);
        textView.setText(str4);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.a("drone", textView);
            }
        });
        final TextView textView2 = (TextView) inflate.findViewById(R.id.version_wifi_firmware_txt);
        TextView textView3 = (TextView) inflate.findViewById(R.id.version_wifi_firmware);
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.a("repeater", textView2);
            }
        });
        if (str3.equalsIgnoreCase("")) {
            textView3.setVisibility(8);
            textView2.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView2.setVisibility(0);
        }
        textView2.setText(str3);
        final TextView textView4 = (TextView) inflate.findViewById(R.id.version_rc_firmware_txt);
        TextView textView5 = (TextView) inflate.findViewById(R.id.version_rc_firmware);
        textView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.a("rc", textView4);
            }
        });
        if (str2.equalsIgnoreCase("")) {
            textView4.setVisibility(8);
            textView5.setVisibility(8);
        } else {
            textView4.setVisibility(0);
            textView5.setVisibility(0);
        }
        textView4.setText(str2);
        final TextView textView6 = (TextView) inflate.findViewById(R.id.version_camera_firmware_txt);
        textView6.setText(str);
        textView6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.a("img", textView6);
            }
        });
        final TextView textView7 = (TextView) inflate.findViewById(R.id.wifi_rssi_txt);
        textView7.setText(i2 + "");
        textView7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.a("rssi", textView7);
            }
        });
        IButton iButton = (IButton) inflate.findViewById(R.id.ib_ok);
        this.f29745b = iButton;
        iButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.dismiss();
            }
        });
        return inflate;
    }
}
