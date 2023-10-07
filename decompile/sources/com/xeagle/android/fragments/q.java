package com.xeagle.android.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.n;
import androidx.viewpager.widget.ViewPager;
import com.cfly.uav_pro.R;
import com.xeagle.android.fragments.calibration.imu.FragmentSetupIMU;
import com.xeagle.android.fragments.calibration.mag.FragmentSetupMAG;
import com.xeagle.android.widgets.viewPager.TabPageIndicator;

public class q extends Fragment {

    private static class a extends n {

        /* renamed from: a  reason: collision with root package name */
        private final Context f23474a;

        public a(Context context, FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f23474a = context;
        }

        public int getCount() {
            return 2;
        }

        public Fragment getItem(int i2) {
            return i2 != 1 ? new FragmentSetupIMU() : new FragmentSetupMAG();
        }

        public CharSequence getPageTitle(int i2) {
            return i2 != 1 ? FragmentSetupIMU.getTitle(this.f23474a) : FragmentSetupMAG.getTitle(this.f23474a);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_sensor_setup, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a aVar = new a(getActivity().getApplicationContext(), getChildFragmentManager());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.configuration_pager);
        viewPager.setAdapter(aVar);
        ((TabPageIndicator) view.findViewById(R.id.configuration_tab_strip)).setViewPager(viewPager);
    }
}
