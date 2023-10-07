package com.xeagle.android.widgets.CarouselView;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;
import java.util.Collections;

public abstract class CarouselSpinner extends CarouselAdapter<SpinnerAdapter> {
    int A;
    int B;
    int C;
    final Rect D;
    final a E;
    private DataSetObserver F;

    /* renamed from: v  reason: collision with root package name */
    SpinnerAdapter f25523v;

    /* renamed from: w  reason: collision with root package name */
    int f25524w;

    /* renamed from: x  reason: collision with root package name */
    int f25525x;

    /* renamed from: y  reason: collision with root package name */
    boolean f25526y;

    /* renamed from: z  reason: collision with root package name */
    int f25527z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        long f25528a;

        /* renamed from: b  reason: collision with root package name */
        int f25529b;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f25528a = parcel.readLong();
            this.f25529b = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f25528a + " position=" + this.f25529b + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f25528a);
            parcel.writeInt(this.f25529b);
        }
    }

    class a {

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<View> f25531b = new SparseArray<>();

        a() {
        }

        /* access modifiers changed from: package-private */
        public View a(int i2) {
            View view = this.f25531b.get(i2);
            if (view != null) {
                this.f25531b.delete(i2);
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SparseArray<View> sparseArray = this.f25531b;
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                View valueAt = sparseArray.valueAt(i2);
                if (valueAt != null) {
                    CarouselSpinner.this.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }

        public void a(int i2, View view) {
            this.f25531b.put(i2, view);
        }
    }

    public CarouselSpinner(Context context) {
        super(context);
        this.f25527z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = new Rect();
        this.E = new a();
        h();
    }

    public CarouselSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarouselSpinner(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25527z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = new Rect();
        this.E = new a();
        h();
    }

    private void h() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    public int a(int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f25523v.getCount(); i4++) {
            CarouselItemImage carouselItemImage = (CarouselItemImage) getChildAt(i4);
            Matrix cIMatrix = carouselItemImage.getCIMatrix();
            boolean z2 = true;
            float[] fArr = {(float) carouselItemImage.getLeft(), (float) carouselItemImage.getTop(), 0.0f};
            cIMatrix.mapPoints(fArr);
            int i5 = (int) fArr[0];
            int i6 = (int) fArr[1];
            fArr[0] = (float) carouselItemImage.getRight();
            fArr[1] = (float) carouselItemImage.getBottom();
            fArr[2] = 0.0f;
            cIMatrix.mapPoints(fArr);
            int i7 = (int) fArr[0];
            int i8 = (int) fArr[1];
            if (i5 < i2) {
                boolean z3 = i7 > i2;
                if (i6 >= i3) {
                    z2 = false;
                }
                if ((z3 && z2) && i8 > i3) {
                    arrayList.add(carouselItemImage);
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList.size() != 0 ? ((CarouselItemImage) arrayList.get(0)).getIndex() : this.f25480o;
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public abstract void b(int i2, boolean z2);

    /* access modifiers changed from: package-private */
    public int c(View view) {
        return view.getMeasuredWidth();
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, boolean z2) {
        if (i2 != this.f25484s) {
            this.f25526y = true;
            setNextSelectedPositionInt(i2);
            b(i2 - this.f25480o, z2);
            this.f25526y = false;
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public SpinnerAdapter getAdapter() {
        return this.f25523v;
    }

    public int getCount() {
        return this.f25482q;
    }

    public View getSelectedView() {
        if (this.f25482q <= 0 || this.f25480o < 0) {
            return null;
        }
        return getChildAt(this.f25480o - this.f25466a);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f25477l = false;
        this.f25471f = false;
        removeAllViewsInLayout();
        this.f25484s = -1;
        this.f25485t = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        int childCount = getChildCount();
        a aVar = this.E;
        int i2 = this.f25466a;
        for (int i3 = 0; i3 < childCount; i3++) {
            aVar.a(i2 + i3, getChildAt(i3));
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r7)
            android.graphics.Rect r1 = r6.D
            int r2 = r6.getPaddingLeft()
            int r3 = r6.f25527z
            if (r2 <= r3) goto L_0x0012
            int r3 = r6.getPaddingLeft()
        L_0x0012:
            r1.left = r3
            android.graphics.Rect r1 = r6.D
            int r2 = r6.getPaddingTop()
            int r3 = r6.A
            if (r2 <= r3) goto L_0x0022
            int r3 = r6.getPaddingTop()
        L_0x0022:
            r1.top = r3
            android.graphics.Rect r1 = r6.D
            int r2 = r6.getPaddingRight()
            int r3 = r6.B
            if (r2 <= r3) goto L_0x0032
            int r3 = r6.getPaddingRight()
        L_0x0032:
            r1.right = r3
            android.graphics.Rect r1 = r6.D
            int r2 = r6.getPaddingBottom()
            int r3 = r6.C
            if (r2 <= r3) goto L_0x0042
            int r3 = r6.getPaddingBottom()
        L_0x0042:
            r1.bottom = r3
            boolean r1 = r6.f25477l
            if (r1 == 0) goto L_0x004b
            r6.d()
        L_0x004b:
            int r1 = r6.getSelectedItemPosition()
            r2 = 1
            r3 = 0
            if (r1 < 0) goto L_0x00a9
            android.widget.SpinnerAdapter r4 = r6.f25523v
            if (r4 == 0) goto L_0x00a9
            int r4 = r4.getCount()
            if (r1 >= r4) goto L_0x00a9
            com.xeagle.android.widgets.CarouselView.CarouselSpinner$a r4 = r6.E
            android.view.View r4 = r4.a(r1)
            if (r4 != 0) goto L_0x006c
            android.widget.SpinnerAdapter r4 = r6.f25523v
            r5 = 0
            android.view.View r4 = r4.getView(r1, r5, r6)
        L_0x006c:
            if (r4 == 0) goto L_0x0073
            com.xeagle.android.widgets.CarouselView.CarouselSpinner$a r5 = r6.E
            r5.a(r1, r4)
        L_0x0073:
            if (r4 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            if (r1 != 0) goto L_0x0086
            r6.f25526y = r2
            android.view.ViewGroup$LayoutParams r1 = r6.generateDefaultLayoutParams()
            r4.setLayoutParams(r1)
            r6.f25526y = r3
        L_0x0086:
            r6.measureChild(r4, r7, r8)
            int r1 = r6.b(r4)
            android.graphics.Rect r2 = r6.D
            int r2 = r2.top
            int r1 = r1 + r2
            android.graphics.Rect r2 = r6.D
            int r2 = r2.bottom
            int r1 = r1 + r2
            int r2 = r6.c(r4)
            android.graphics.Rect r4 = r6.D
            int r4 = r4.left
            int r2 = r2 + r4
            android.graphics.Rect r4 = r6.D
            int r4 = r4.right
            int r2 = r2 + r4
            r3 = r1
            r1 = r2
            r2 = 0
            goto L_0x00aa
        L_0x00a9:
            r1 = 0
        L_0x00aa:
            if (r2 == 0) goto L_0x00c0
            android.graphics.Rect r2 = r6.D
            int r2 = r2.top
            android.graphics.Rect r3 = r6.D
            int r3 = r3.bottom
            int r3 = r3 + r2
            if (r0 != 0) goto L_0x00c0
            android.graphics.Rect r0 = r6.D
            int r0 = r0.left
            android.graphics.Rect r1 = r6.D
            int r1 = r1.right
            int r1 = r1 + r0
        L_0x00c0:
            int r0 = r6.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r3, r0)
            int r2 = r6.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r1, r2)
            int r0 = resolveSize(r0, r8)
            int r1 = resolveSize(r1, r7)
            r6.setMeasuredDimension(r1, r0)
            r6.f25524w = r8
            r6.f25525x = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.widgets.CarouselView.CarouselSpinner.onMeasure(int, int):void");
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f25528a >= 0) {
            this.f25477l = true;
            this.f25471f = true;
            this.f25469d = savedState.f25528a;
            this.f25468c = savedState.f25529b;
            this.f25472g = 0;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f25528a = getSelectedItemId();
        savedState.f25529b = savedState.f25528a >= 0 ? getSelectedItemPosition() : -1;
        return savedState;
    }

    public void requestLayout() {
        if (!this.f25526y) {
            super.requestLayout();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        if (r2.f25482q == 0) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAdapter(android.widget.SpinnerAdapter r3) {
        /*
            r2 = this;
            android.widget.SpinnerAdapter r0 = r2.f25523v
            if (r0 == 0) goto L_0x000c
            android.database.DataSetObserver r1 = r2.F
            r0.unregisterDataSetObserver(r1)
            r2.j()
        L_0x000c:
            r2.f25523v = r3
            r3 = -1
            r2.f25484s = r3
            r0 = -9223372036854775808
            r2.f25485t = r0
            android.widget.SpinnerAdapter r0 = r2.f25523v
            if (r0 == 0) goto L_0x0044
            int r0 = r2.f25482q
            r2.f25483r = r0
            android.widget.SpinnerAdapter r0 = r2.f25523v
            int r0 = r0.getCount()
            r2.f25482q = r0
            r2.b()
            com.xeagle.android.widgets.CarouselView.CarouselAdapter$b r0 = new com.xeagle.android.widgets.CarouselView.CarouselAdapter$b
            r0.<init>()
            r2.F = r0
            android.widget.SpinnerAdapter r1 = r2.f25523v
            r1.registerDataSetObserver(r0)
            int r0 = r2.f25482q
            if (r0 <= 0) goto L_0x0039
            r3 = 0
        L_0x0039:
            r2.setSelectedPositionInt(r3)
            r2.setNextSelectedPositionInt(r3)
            int r3 = r2.f25482q
            if (r3 != 0) goto L_0x004d
            goto L_0x004a
        L_0x0044:
            r2.b()
            r2.j()
        L_0x004a:
            r2.e()
        L_0x004d:
            r2.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.widgets.CarouselView.CarouselSpinner.setAdapter(android.widget.SpinnerAdapter):void");
    }

    public void setSelection(int i2) {
        c(i2, false);
    }
}
