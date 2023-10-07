package com.xeagle.android.login.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;

public class AcademyVideoFragment extends Fragment {
    private RecyclerView listView;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.video_academy_layout, viewGroup, false);
        inflate.findViewById(R.id.title_layout).setVisibility(8);
        return inflate;
    }
}
