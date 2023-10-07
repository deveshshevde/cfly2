package com.xeagle.android.fragments.helpers;

import android.app.Activity;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.cfly.uav_pro.R;
import com.xeagle.android.fragments.EditorMapFragment;
import ef.a;
import eg.g;
import java.util.ArrayList;
import java.util.List;
import jo.af;
import org.greenrobot.eventbus.c;

public class GestureMapFragment extends Fragment implements GestureOverlayView.OnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    private double f23386a;

    /* renamed from: b  reason: collision with root package name */
    private GestureOverlayView f23387b;

    /* renamed from: c  reason: collision with root package name */
    private EditorMapFragment f23388c;

    private int a(double d2) {
        double d3 = (double) getResources().getDisplayMetrics().density;
        Double.isNaN(d3);
        return (int) Math.round(d2 * d3);
    }

    private void a(List<a> list) {
        float[] fArr = this.f23387b.getGesture().getStrokes().get(0).points;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            list.add(new a((double) ((int) fArr[i2]), (double) ((int) fArr[i2 + 1])));
        }
    }

    private void d() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        EditorMapFragment editorMapFragment = (EditorMapFragment) childFragmentManager.d((int) R.id.gesture_map_fragment);
        this.f23388c = editorMapFragment;
        if (editorMapFragment == null) {
            this.f23388c = new EditorMapFragment();
            childFragmentManager.a().b(R.id.gesture_map_fragment, this.f23388c).c();
        }
    }

    private List<a> e() {
        ArrayList arrayList = new ArrayList();
        a((List<a>) arrayList);
        return arrayList;
    }

    public void a() {
        this.f23387b.setEnabled(true);
    }

    public void b() {
        this.f23387b.setEnabled(false);
    }

    public EditorMapFragment c() {
        return this.f23388c;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_gesture_map, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onGesture(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
    }

    public void onGestureCancelled(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
    }

    public void onGestureEnded(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        this.f23387b.setEnabled(false);
        List<a> e2 = e();
        if (e2.size() > 1) {
            e2 = g.a(e2, this.f23386a);
        }
        c.a().d(new af(e2));
    }

    public void onGestureStarted(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        GestureOverlayView gestureOverlayView = (GestureOverlayView) view.findViewById(R.id.overlay1);
        this.f23387b = gestureOverlayView;
        gestureOverlayView.addOnGestureListener(this);
        this.f23387b.setEnabled(false);
        this.f23387b.setGestureStrokeWidth((float) a(3.0d));
        this.f23386a = (double) a(15.0d);
        d();
    }
}
