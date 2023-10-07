package lb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.c;
import androidx.fragment.app.s;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import jo.aa;
import jo.ab;
import jo.ak;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class a extends c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f13939a = true;

    /* renamed from: b  reason: collision with root package name */
    private IButton f13940b;

    /* renamed from: c  reason: collision with root package name */
    private IButton f13941c;

    private void a(View view) {
        this.f13940b = (IButton) view.findViewById(R.id.sureBtn);
        this.f13941c = (IButton) view.findViewById(R.id.cancelBtn);
        this.f13940b.setVisibility(8);
        this.f13941c.setVisibility(8);
        this.f13940b.setOnClickListener(this);
        this.f13941c.setOnClickListener(this);
    }

    @l(a = ThreadMode.MAIN)
    public void modelSettingBack(ab abVar) {
        if (abVar.a()) {
            if (this.f13940b.getVisibility() == 0) {
                this.f13940b.setVisibility(8);
            }
            if (this.f13941c.getVisibility() == 0) {
                this.f13941c.setVisibility(8);
            }
            s a2 = getChildFragmentManager().a();
            a2.b(R.id.base_content, new d());
            a2.d();
        }
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 != R.id.cancelBtn) {
            if (id2 == R.id.sureBtn) {
                org.greenrobot.eventbus.c.a().d(new aa(true));
            } else {
                return;
            }
        }
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i2;
        int i3;
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(true);
        Window window = create.getWindow();
        if (f13939a || window != null) {
            window.setGravity(17);
            create.show();
            int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
            int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
            if (width >= height) {
                i3 = width / 2;
                i2 = height * 4;
            } else {
                i3 = (width * 4) / 5;
                i2 = height * 2;
            }
            window.setLayout(i3, i2 / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.base_model_layout, viewGroup, false);
    }

    public void onStart() {
        super.onStart();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public void onStop() {
        super.onStop();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        s a2 = getChildFragmentManager().a();
        if (bundle == null) {
            a2.a((int) R.id.base_content, (Fragment) new d());
            a2.d();
        }
        a(view);
    }

    @l(a = ThreadMode.MAIN)
    public void selectModel(ak akVar) {
        s a2 = getChildFragmentManager().a();
        String a3 = akVar.a();
        a3.hashCode();
        char c2 = 65535;
        switch (a3.hashCode()) {
            case -2027247372:
                if (a3.equals("followMode")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1729768619:
                if (a3.equals("skyRocket")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1711183949:
                if (a3.equals("cometMode")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1111063917:
                if (a3.equals("circleMode")) {
                    c2 = 3;
                    break;
                }
                break;
            case -758156799:
                if (a3.equals("flyAway")) {
                    c2 = 4;
                    break;
                }
                break;
            case -58867007:
                if (a3.equals("spiralFlight")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                c cVar = new c();
                cVar.a(akVar.a());
                a2.b(R.id.base_content, cVar);
                a2.a("recordModel");
                a2.c(4097);
                a2.d();
                this.f13940b.setVisibility(0);
                this.f13941c.setVisibility(0);
                return;
            default:
                return;
        }
    }
}
