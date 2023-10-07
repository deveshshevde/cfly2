package com.xeagle.android.widgets.scViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.cfly.uav_pro.R;
import java.util.ArrayList;

public class c extends q {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<a> f25973a;

    /* renamed from: b  reason: collision with root package name */
    private int f25974b;

    /* renamed from: c  reason: collision with root package name */
    private int f25975c;

    public static class a extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        private int f25976a = R.color.white;

        public void a(int i2) {
            this.f25976a = i2;
        }

        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(getResources().getColor(this.f25976a));
            return linearLayout;
        }
    }

    public Fragment a(int i2) {
        a aVar = this.f25973a.size() + -1 >= i2 ? this.f25973a.get(i2) : null;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        aVar2.a(this.f25975c);
        return aVar2;
    }

    public int getCount() {
        return this.f25974b;
    }
}
