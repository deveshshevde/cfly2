package me.yokeyword.fragmentation.debug;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import me.yokeyword.fragmentation.R;

public class DebugHierarchyViewContainer extends ScrollView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f31114a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f31115b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f31116c;

    /* renamed from: d  reason: collision with root package name */
    private int f31117d;

    /* renamed from: e  reason: collision with root package name */
    private int f31118e;

    public DebugHierarchyViewContainer(Context context) {
        super(context);
        a(context);
    }

    public DebugHierarchyViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DebugHierarchyViewContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private int a(float f2) {
        return (int) ((f2 * this.f31114a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private TextView a(a aVar, int i2) {
        TextView textView = new TextView(this.f31114a);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f31117d));
        if (i2 == 0) {
            textView.setTextColor(Color.parseColor("#333333"));
            textView.setTextSize(16.0f);
        }
        textView.setGravity(16);
        int i3 = this.f31118e;
        double d2 = (double) i3;
        double d3 = (double) (i2 * i3);
        Double.isNaN(d3);
        Double.isNaN(d2);
        textView.setPadding((int) (d2 + (d3 * 1.5d)), 0, i3, 0);
        textView.setCompoundDrawablePadding(this.f31118e / 2);
        TypedArray obtainStyledAttributes = this.f31114a.obtainStyledAttributes(new int[]{16843534});
        textView.setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        obtainStyledAttributes.recycle();
        textView.setText(aVar.f31124a);
        return textView;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        for (int childCount = this.f31115b.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f31115b.getChildAt(childCount);
            if (childAt.getTag(R.id.hierarchy) != null && ((Integer) childAt.getTag(R.id.hierarchy)).intValue() >= i2) {
                this.f31115b.removeView(childAt);
            }
        }
    }

    private void a(Context context) {
        this.f31114a = context;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f31115b = linearLayout;
        linearLayout.setOrientation(1);
        horizontalScrollView.addView(this.f31115b);
        addView(horizontalScrollView);
        this.f31117d = a(50.0f);
        this.f31118e = a(16.0f);
    }

    private void a(List<a> list, int i2, TextView textView) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            final TextView a2 = a(aVar, i2);
            a2.setTag(R.id.hierarchy, Integer.valueOf(i2));
            final List<a> list2 = aVar.f31125b;
            if (list2 == null || list2.size() <= 0) {
                int paddingLeft = a2.getPaddingLeft();
                int i3 = this.f31118e;
                a2.setPadding(paddingLeft + i3, 0, i3, 0);
            } else {
                final int i4 = i2 + 1;
                a2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.fragmentation_ic_right, 0, 0, 0);
                a2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (view.getTag(R.id.isexpand) != null) {
                            boolean booleanValue = ((Boolean) view.getTag(R.id.isexpand)).booleanValue();
                            if (booleanValue) {
                                a2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.fragmentation_ic_right, 0, 0, 0);
                                DebugHierarchyViewContainer.this.a(i4);
                            } else {
                                DebugHierarchyViewContainer.this.b(list2, i4, a2);
                            }
                            view.setTag(R.id.isexpand, Boolean.valueOf(!booleanValue));
                            return;
                        }
                        a2.setTag(R.id.isexpand, true);
                        DebugHierarchyViewContainer.this.b(list2, i4, a2);
                    }
                });
            }
            LinearLayout linearLayout = this.f31115b;
            if (textView == null) {
                linearLayout.addView(a2);
            } else {
                linearLayout.addView(a2, linearLayout.indexOfChild(textView) + 1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(List<a> list, int i2, TextView textView) {
        a(list, i2, textView);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.fragmentation_ic_expandable, 0, 0, 0);
    }

    private LinearLayout getTitleLayout() {
        LinearLayout linearLayout = this.f31116c;
        if (linearLayout != null) {
            return linearLayout;
        }
        LinearLayout linearLayout2 = new LinearLayout(this.f31114a);
        this.f31116c = linearLayout2;
        linearLayout2.setPadding(a(24.0f), a(24.0f), 0, a(8.0f));
        this.f31116c.setOrientation(0);
        this.f31116c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        TextView textView = new TextView(this.f31114a);
        textView.setText(R.string.fragmentation_stack_view);
        textView.setTextSize(20.0f);
        textView.setTextColor(-16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        textView.setLayoutParams(layoutParams);
        this.f31116c.addView(textView);
        ImageView imageView = new ImageView(this.f31114a);
        imageView.setImageResource(R.drawable.fragmentation_help);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = a(16.0f);
        layoutParams2.gravity = 16;
        imageView.setLayoutParams(layoutParams2);
        this.f31116c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(DebugHierarchyViewContainer.this.f31114a, R.string.fragmentation_stack_help, 1).show();
            }
        });
        this.f31116c.addView(imageView);
        return this.f31116c;
    }

    public void a(List<a> list) {
        this.f31115b.removeAllViews();
        this.f31115b.addView(getTitleLayout());
        if (list != null) {
            a(list, 0, (TextView) null);
        }
    }
}
