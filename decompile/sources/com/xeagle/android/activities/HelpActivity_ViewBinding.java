package com.xeagle.android.activities;

import android.view.View;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.cfly.uav_pro.R;
import com.xeagle.android.widgets.HackyViewPager;

public class HelpActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private HelpActivity f22178a;

    /* renamed from: b  reason: collision with root package name */
    private View f22179b;

    /* renamed from: c  reason: collision with root package name */
    private View f22180c;

    /* renamed from: d  reason: collision with root package name */
    private View f22181d;

    public HelpActivity_ViewBinding(final HelpActivity helpActivity, View view) {
        this.f22178a = helpActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.go_back, "field 'goBack' and method 'onClick'");
        helpActivity.goBack = (ImageButton) Utils.castView(findRequiredView, R.id.go_back, "field 'goBack'", ImageButton.class);
        this.f22179b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                helpActivity.onClick(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.indicator_left, "field 'indicatorLeft' and method 'onClick'");
        helpActivity.indicatorLeft = (ImageButton) Utils.castView(findRequiredView2, R.id.indicator_left, "field 'indicatorLeft'", ImageButton.class);
        this.f22180c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                helpActivity.onClick(view);
            }
        });
        helpActivity.viewPager = (HackyViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'viewPager'", HackyViewPager.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.indicator_right, "field 'indicatorRight' and method 'onClick'");
        helpActivity.indicatorRight = (ImageButton) Utils.castView(findRequiredView3, R.id.indicator_right, "field 'indicatorRight'", ImageButton.class);
        this.f22181d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                helpActivity.onClick(view);
            }
        });
    }

    public void unbind() {
        HelpActivity helpActivity = this.f22178a;
        if (helpActivity != null) {
            this.f22178a = null;
            helpActivity.goBack = null;
            helpActivity.indicatorLeft = null;
            helpActivity.viewPager = null;
            helpActivity.indicatorRight = null;
            this.f22179b.setOnClickListener((View.OnClickListener) null);
            this.f22179b = null;
            this.f22180c.setOnClickListener((View.OnClickListener) null);
            this.f22180c = null;
            this.f22181d.setOnClickListener((View.OnClickListener) null);
            this.f22181d = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
