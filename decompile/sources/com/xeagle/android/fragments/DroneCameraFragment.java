package com.xeagle.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.button.SwitchButton;
import en.a;

public class DroneCameraFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private a f23171a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.xeagle.android.utils.prefs.a f23172b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f23173c;
    @BindView(2131296746)
    SwitchButton camera_continuous;
    @BindView(2131296766)
    SeekBar camera_seek;
    @BindView(2131296767)
    SwitchButton camera_selfie;

    private void a() {
        this.f23173c = this.f23172b.k();
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    DroneCameraFragment.this.camera_selfie.setChecked(DroneCameraFragment.this.f23173c);
                }
            });
        }
    }

    private void b() {
    }

    private void c() {
        this.camera_selfie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z2) {
                new Thread(new Runnable() {
                    public void run() {
                        DroneCameraFragment.this.f23172b.d(z2);
                    }
                }).start();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.drone_camera_setting, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        this.f23171a = ((XEagleApp) getActivity().getApplication()).k();
        this.f23172b = new com.xeagle.android.utils.prefs.a(getActivity().getApplicationContext());
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        a();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        b();
        c();
    }
}
