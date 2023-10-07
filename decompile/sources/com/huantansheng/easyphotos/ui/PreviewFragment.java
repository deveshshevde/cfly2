package com.huantansheng.easyphotos.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huantansheng.easyphotos.R;
import hr.d;

public class PreviewFragment extends Fragment implements d.a {

    /* renamed from: a  reason: collision with root package name */
    private a f20600a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f20601b;

    /* renamed from: c  reason: collision with root package name */
    private d f20602c;

    public interface a {
        void a(int i2);
    }

    public void a() {
        this.f20602c.notifyDataSetChanged();
    }

    public void a(int i2) {
        this.f20600a.a(i2);
    }

    public void b(int i2) {
        this.f20602c.a(i2);
        if (i2 != -1) {
            this.f20601b.c(i2);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.f20600a = (a) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnPreviewFragmentClickListener");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_preview_easy_photos, viewGroup, false);
        this.f20601b = (RecyclerView) inflate.findViewById(R.id.rv_preview_selected_photos);
        this.f20602c = new d(getActivity(), this);
        this.f20601b.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.f20601b.setAdapter(this.f20602c);
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        this.f20600a = null;
    }
}
