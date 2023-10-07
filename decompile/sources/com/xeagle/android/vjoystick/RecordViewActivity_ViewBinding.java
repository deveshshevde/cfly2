package com.xeagle.android.vjoystick;

import android.opengl.GLSurfaceView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;

public class RecordViewActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RecordViewActivity f24842a;

    /* renamed from: b  reason: collision with root package name */
    private View f24843b;

    /* renamed from: c  reason: collision with root package name */
    private View f24844c;

    public RecordViewActivity_ViewBinding(final RecordViewActivity recordViewActivity, View view) {
        this.f24842a = recordViewActivity;
        recordViewActivity.tvGps = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_gps, "field 'tvGps'", TextView.class);
        recordViewActivity.tvBattery = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_battery, "field 'tvBattery'", TextView.class);
        recordViewActivity.altRc = (TextView) Utils.findRequiredViewAsType(view, R.id.alt_rc, "field 'altRc'", TextView.class);
        recordViewActivity.failSafeTv = (TextView) Utils.findRequiredViewAsType(view, R.id.fail_safe_tv, "field 'failSafeTv'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.record_view_start, "field 'recordViewStart' and method 'onClick'");
        recordViewActivity.recordViewStart = (IImageButton) Utils.castView(findRequiredView, R.id.record_view_start, "field 'recordViewStart'", IImageButton.class);
        this.f24843b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                recordViewActivity.onClick(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.record_view_back, "field 'recordViewBack' and method 'onClick'");
        recordViewActivity.recordViewBack = (IImageButton) Utils.castView(findRequiredView2, R.id.record_view_back, "field 'recordViewBack'", IImageButton.class);
        this.f24844c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                recordViewActivity.onClick(view);
            }
        });
        recordViewActivity.recordViewProgress = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.record_view_progress, "field 'recordViewProgress'", ProgressBar.class);
        recordViewActivity.recordProgressTv = (TextView) Utils.findRequiredViewAsType(view, R.id.record_progress_tv, "field 'recordProgressTv'", TextView.class);
        recordViewActivity.distanceRc = (TextView) Utils.findRequiredViewAsType(view, R.id.distance_rc, "field 'distanceRc'", TextView.class);
        recordViewActivity.surface = (GLSurfaceView) Utils.findRequiredViewAsType(view, R.id.surface, "field 'surface'", GLSurfaceView.class);
    }

    public void unbind() {
        RecordViewActivity recordViewActivity = this.f24842a;
        if (recordViewActivity != null) {
            this.f24842a = null;
            recordViewActivity.tvGps = null;
            recordViewActivity.tvBattery = null;
            recordViewActivity.altRc = null;
            recordViewActivity.failSafeTv = null;
            recordViewActivity.recordViewStart = null;
            recordViewActivity.recordViewBack = null;
            recordViewActivity.recordViewProgress = null;
            recordViewActivity.recordProgressTv = null;
            recordViewActivity.distanceRc = null;
            recordViewActivity.surface = null;
            this.f24843b.setOnClickListener((View.OnClickListener) null);
            this.f24843b = null;
            this.f24844c.setOnClickListener((View.OnClickListener) null);
            this.f24844c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
