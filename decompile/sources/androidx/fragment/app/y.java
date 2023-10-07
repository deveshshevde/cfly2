package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class y extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    ListAdapter f3528a;

    /* renamed from: b  reason: collision with root package name */
    ListView f3529b;

    /* renamed from: c  reason: collision with root package name */
    View f3530c;

    /* renamed from: d  reason: collision with root package name */
    TextView f3531d;

    /* renamed from: e  reason: collision with root package name */
    View f3532e;

    /* renamed from: f  reason: collision with root package name */
    View f3533f;

    /* renamed from: g  reason: collision with root package name */
    CharSequence f3534g;

    /* renamed from: h  reason: collision with root package name */
    boolean f3535h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f3536i = new Handler();

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f3537j = new Runnable() {
        public void run() {
            y.this.f3529b.focusableViewAvailable(y.this.f3529b);
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f3538k = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            y.this.a((ListView) adapterView, view, i2, j2);
        }
    };

    private void a() {
        if (this.f3529b == null) {
            View view = getView();
            if (view != null) {
                if (view instanceof ListView) {
                    this.f3529b = (ListView) view;
                } else {
                    TextView textView = (TextView) view.findViewById(16711681);
                    this.f3531d = textView;
                    if (textView == null) {
                        this.f3530c = view.findViewById(16908292);
                    } else {
                        textView.setVisibility(8);
                    }
                    this.f3532e = view.findViewById(16711682);
                    this.f3533f = view.findViewById(16711683);
                    View findViewById = view.findViewById(16908298);
                    if (findViewById instanceof ListView) {
                        ListView listView = (ListView) findViewById;
                        this.f3529b = listView;
                        View view2 = this.f3530c;
                        if (view2 == null) {
                            CharSequence charSequence = this.f3534g;
                            if (charSequence != null) {
                                this.f3531d.setText(charSequence);
                                listView = this.f3529b;
                                view2 = this.f3531d;
                            }
                        }
                        listView.setEmptyView(view2);
                    } else if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    } else {
                        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                    }
                }
                this.f3535h = true;
                this.f3529b.setOnItemClickListener(this.f3538k);
                ListAdapter listAdapter = this.f3528a;
                if (listAdapter != null) {
                    this.f3528a = null;
                    a(listAdapter);
                } else if (this.f3532e != null) {
                    a(false, false);
                }
                this.f3536i.post(this.f3537j);
                return;
            }
            throw new IllegalStateException("Content view not yet created");
        }
    }

    private void a(boolean z2, boolean z3) {
        a();
        View view = this.f3532e;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.f3535h != z2) {
            this.f3535h = z2;
            if (z2) {
                if (z3) {
                    view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.f3533f.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                } else {
                    view.clearAnimation();
                    this.f3533f.clearAnimation();
                }
                this.f3532e.setVisibility(8);
                this.f3533f.setVisibility(0);
                return;
            }
            if (z3) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.f3533f.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            } else {
                view.clearAnimation();
                this.f3533f.clearAnimation();
            }
            this.f3532e.setVisibility(0);
            this.f3533f.setVisibility(8);
        }
    }

    public void a(ListAdapter listAdapter) {
        boolean z2 = false;
        boolean z3 = this.f3528a != null;
        this.f3528a = listAdapter;
        ListView listView = this.f3529b;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (!this.f3535h && !z3) {
                if (requireView().getWindowToken() != null) {
                    z2 = true;
                }
                a(true, z2);
            }
        }
    }

    public void a(ListView listView, View view, int i2, long j2) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, (AttributeSet) null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onDestroyView() {
        this.f3536i.removeCallbacks(this.f3537j);
        this.f3529b = null;
        this.f3535h = false;
        this.f3533f = null;
        this.f3532e = null;
        this.f3530c = null;
        this.f3531d = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a();
    }
}
