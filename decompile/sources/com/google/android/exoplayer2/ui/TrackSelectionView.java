package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class TrackSelectionView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final int f11714a;

    /* renamed from: b  reason: collision with root package name */
    private final LayoutInflater f11715b;

    /* renamed from: c  reason: collision with root package name */
    private final CheckedTextView f11716c;

    /* renamed from: d  reason: collision with root package name */
    private final CheckedTextView f11717d;

    /* renamed from: e  reason: collision with root package name */
    private final a f11718e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<DefaultTrackSelector.SelectionOverride> f11719f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11720g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11721h;

    /* renamed from: i  reason: collision with root package name */
    private d f11722i;

    /* renamed from: j  reason: collision with root package name */
    private CheckedTextView[][] f11723j;

    /* renamed from: k  reason: collision with root package name */
    private d.a f11724k;

    /* renamed from: l  reason: collision with root package name */
    private int f11725l;

    /* renamed from: m  reason: collision with root package name */
    private TrackGroupArray f11726m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f11727n;

    /* renamed from: o  reason: collision with root package name */
    private b f11728o;

    private class a implements View.OnClickListener {
        private a() {
        }

        public void onClick(View view) {
            TrackSelectionView.this.a(view);
        }
    }

    public interface b {
        void a(boolean z2, List<DefaultTrackSelector.SelectionOverride> list);
    }

    public TrackSelectionView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOrientation(1);
        this.f11719f = new SparseArray<>();
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f11714a = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f11715b = from;
        a aVar = new a();
        this.f11718e = aVar;
        this.f11722i = new a(getResources());
        this.f11726m = TrackGroupArray.f16008a;
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, this, false);
        this.f11716c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R.string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(aVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R.layout.exo_list_divider, this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, this, false);
        this.f11717d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R.string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(aVar);
        addView(checkedTextView2);
    }

    private void a() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f11724k == null) {
            this.f11716c.setEnabled(false);
            this.f11717d.setEnabled(false);
            return;
        }
        this.f11716c.setEnabled(true);
        this.f11717d.setEnabled(true);
        TrackGroupArray b2 = this.f11724k.b(this.f11725l);
        this.f11726m = b2;
        this.f11723j = new CheckedTextView[b2.f16009b][];
        boolean e2 = e();
        for (int i2 = 0; i2 < this.f11726m.f16009b; i2++) {
            TrackGroup a2 = this.f11726m.a(i2);
            boolean a3 = a(i2);
            this.f11723j[i2] = new CheckedTextView[a2.f16005a];
            for (int i3 = 0; i3 < a2.f16005a; i3++) {
                if (i3 == 0) {
                    addView(this.f11715b.inflate(R.layout.exo_list_divider, this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f11715b.inflate((a3 || e2) ? 17367056 : 17367055, this, false);
                checkedTextView.setBackgroundResource(this.f11714a);
                checkedTextView.setText(this.f11722i.a(a2.a(i3)));
                if (this.f11724k.a(this.f11725l, i2, i3) == 4) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setTag(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)));
                    checkedTextView.setOnClickListener(this.f11718e);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f11723j[i2][i3] = checkedTextView;
                addView(checkedTextView);
            }
        }
        b();
    }

    /* access modifiers changed from: private */
    public void a(View view) {
        if (view == this.f11716c) {
            c();
        } else if (view == this.f11717d) {
            d();
        } else {
            b(view);
        }
        b();
        b bVar = this.f11728o;
        if (bVar != null) {
            bVar.a(getIsDisabled(), getOverrides());
        }
    }

    @RequiresNonNull({"mappedTrackInfo"})
    private boolean a(int i2) {
        return this.f11720g && this.f11726m.a(i2).f16005a > 1 && this.f11724k.a(this.f11725l, i2, false) != 0;
    }

    private static int[] a(int[] iArr, int i2) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[copyOf.length - 1] = i2;
        return copyOf;
    }

    private void b() {
        this.f11716c.setChecked(this.f11727n);
        this.f11717d.setChecked(!this.f11727n && this.f11719f.size() == 0);
        for (int i2 = 0; i2 < this.f11723j.length; i2++) {
            DefaultTrackSelector.SelectionOverride selectionOverride = this.f11719f.get(i2);
            int i3 = 0;
            while (true) {
                CheckedTextView[][] checkedTextViewArr = this.f11723j;
                if (i3 >= checkedTextViewArr[i2].length) {
                    break;
                }
                checkedTextViewArr[i2][i3].setChecked(selectionOverride != null && selectionOverride.a(i3));
                i3++;
            }
        }
    }

    private void b(View view) {
        DefaultTrackSelector.SelectionOverride selectionOverride;
        SparseArray<DefaultTrackSelector.SelectionOverride> sparseArray;
        SparseArray<DefaultTrackSelector.SelectionOverride> sparseArray2;
        DefaultTrackSelector.SelectionOverride selectionOverride2;
        this.f11727n = false;
        Pair pair = (Pair) view.getTag();
        int intValue = ((Integer) pair.first).intValue();
        int intValue2 = ((Integer) pair.second).intValue();
        DefaultTrackSelector.SelectionOverride selectionOverride3 = this.f11719f.get(intValue);
        com.google.android.exoplayer2.util.a.b(this.f11724k);
        if (selectionOverride3 == null) {
            if (!this.f11721h && this.f11719f.size() > 0) {
                this.f11719f.clear();
            }
            sparseArray2 = this.f11719f;
            selectionOverride2 = new DefaultTrackSelector.SelectionOverride(intValue, intValue2);
        } else {
            int i2 = selectionOverride3.f16649c;
            int[] iArr = selectionOverride3.f16648b;
            boolean isChecked = ((CheckedTextView) view).isChecked();
            boolean a2 = a(intValue);
            boolean z2 = a2 || e();
            if (!isChecked || !z2) {
                if (isChecked) {
                    return;
                }
                if (a2) {
                    int[] a3 = a(iArr, intValue2);
                    sparseArray = this.f11719f;
                    selectionOverride = new DefaultTrackSelector.SelectionOverride(intValue, a3);
                } else {
                    sparseArray2 = this.f11719f;
                    selectionOverride2 = new DefaultTrackSelector.SelectionOverride(intValue, intValue2);
                }
            } else if (i2 == 1) {
                this.f11719f.remove(intValue);
                return;
            } else {
                int[] b2 = b(iArr, intValue2);
                sparseArray = this.f11719f;
                selectionOverride = new DefaultTrackSelector.SelectionOverride(intValue, b2);
            }
            sparseArray.put(intValue, selectionOverride);
            return;
        }
        sparseArray2.put(intValue, selectionOverride2);
    }

    private static int[] b(int[] iArr, int i2) {
        int[] iArr2 = new int[(iArr.length - 1)];
        int i3 = 0;
        for (int i4 : iArr) {
            if (i4 != i2) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return iArr2;
    }

    private void c() {
        this.f11727n = true;
        this.f11719f.clear();
    }

    private void d() {
        this.f11727n = false;
        this.f11719f.clear();
    }

    private boolean e() {
        return this.f11721h && this.f11726m.f16009b > 1;
    }

    public boolean getIsDisabled() {
        return this.f11727n;
    }

    public List<DefaultTrackSelector.SelectionOverride> getOverrides() {
        ArrayList arrayList = new ArrayList(this.f11719f.size());
        for (int i2 = 0; i2 < this.f11719f.size(); i2++) {
            arrayList.add(this.f11719f.valueAt(i2));
        }
        return arrayList;
    }

    public void setAllowAdaptiveSelections(boolean z2) {
        if (this.f11720g != z2) {
            this.f11720g = z2;
            a();
        }
    }

    public void setAllowMultipleOverrides(boolean z2) {
        if (this.f11721h != z2) {
            this.f11721h = z2;
            if (!z2 && this.f11719f.size() > 1) {
                for (int size = this.f11719f.size() - 1; size > 0; size--) {
                    this.f11719f.remove(size);
                }
            }
            a();
        }
    }

    public void setShowDisableOption(boolean z2) {
        this.f11716c.setVisibility(z2 ? 0 : 8);
    }

    public void setTrackNameProvider(d dVar) {
        this.f11722i = (d) com.google.android.exoplayer2.util.a.b(dVar);
        a();
    }
}
