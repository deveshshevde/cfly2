package com.xeagle.android.vjoystick.fragment;

import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.cfly.uav_pro.R;
import com.recyclerview.swipe.SwipeMenuRecyclerView;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;

public class RecordDroneFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RecordDroneFragment f25014a;

    /* renamed from: b  reason: collision with root package name */
    private View f25015b;

    /* renamed from: c  reason: collision with root package name */
    private View f25016c;

    /* renamed from: d  reason: collision with root package name */
    private View f25017d;

    /* renamed from: e  reason: collision with root package name */
    private View f25018e;

    /* renamed from: f  reason: collision with root package name */
    private View f25019f;

    public RecordDroneFragment_ViewBinding(final RecordDroneFragment recordDroneFragment, View view) {
        this.f25014a = recordDroneFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.waypoint_set, "field 'waypointSet' and method 'onClick'");
        recordDroneFragment.waypointSet = (IImageButton) Utils.castView(findRequiredView, R.id.waypoint_set, "field 'waypointSet'", IImageButton.class);
        this.f25015b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                recordDroneFragment.onClick(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.record_make, "field 'recordMake' and method 'onClick'");
        recordDroneFragment.recordMake = (IImageButton) Utils.castView(findRequiredView2, R.id.record_make, "field 'recordMake'", IImageButton.class);
        this.f25016c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                recordDroneFragment.onClick(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.record_start, "field 'recordStart' and method 'onClick'");
        recordDroneFragment.recordStart = (IImageButton) Utils.castView(findRequiredView3, R.id.record_start, "field 'recordStart'", IImageButton.class);
        this.f25017d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                recordDroneFragment.onClick(view);
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.record_stop, "field 'recordStop' and method 'onClick'");
        recordDroneFragment.recordStop = (IImageButton) Utils.castView(findRequiredView4, R.id.record_stop, "field 'recordStop'", IImageButton.class);
        this.f25018e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                recordDroneFragment.onClick(view);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.record_list, "field 'recordList' and method 'onClick'");
        recordDroneFragment.recordList = (IImageButton) Utils.castView(findRequiredView5, R.id.record_list, "field 'recordList'", IImageButton.class);
        this.f25019f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                recordDroneFragment.onClick(view);
            }
        });
        recordDroneFragment.recordRl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.record_rl, "field 'recordRl'", RelativeLayout.class);
        recordDroneFragment.record_recycler = (SwipeMenuRecyclerView) Utils.findRequiredViewAsType(view, R.id.record_list_content, "field 'record_recycler'", SwipeMenuRecyclerView.class);
        recordDroneFragment.red_point = (ImageView) Utils.findRequiredViewAsType(view, R.id.red_v_point, "field 'red_point'", ImageView.class);
        recordDroneFragment.record_time = (Chronometer) Utils.findRequiredViewAsType(view, R.id.record_v_time, "field 'record_time'", Chronometer.class);
    }

    public void unbind() {
        RecordDroneFragment recordDroneFragment = this.f25014a;
        if (recordDroneFragment != null) {
            this.f25014a = null;
            recordDroneFragment.waypointSet = null;
            recordDroneFragment.recordMake = null;
            recordDroneFragment.recordStart = null;
            recordDroneFragment.recordStop = null;
            recordDroneFragment.recordList = null;
            recordDroneFragment.recordRl = null;
            recordDroneFragment.record_recycler = null;
            recordDroneFragment.red_point = null;
            recordDroneFragment.record_time = null;
            this.f25015b.setOnClickListener((View.OnClickListener) null);
            this.f25015b = null;
            this.f25016c.setOnClickListener((View.OnClickListener) null);
            this.f25016c = null;
            this.f25017d.setOnClickListener((View.OnClickListener) null);
            this.f25017d = null;
            this.f25018e.setOnClickListener((View.OnClickListener) null);
            this.f25018e = null;
            this.f25019f.setOnClickListener((View.OnClickListener) null);
            this.f25019f = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
