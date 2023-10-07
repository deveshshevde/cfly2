package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.customview.view.AbsSavedState;
import t.a;
import t.ac;
import u.c;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f19180a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private boolean f19181b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19182c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19183d;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f19185a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel) {
            boolean z2 = true;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f19185a = z2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f19185a ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19182c = true;
        this.f19183d = true;
        ac.a((View) this, (a) new a() {
            public void a(View view, c cVar) {
                super.a(view, cVar);
                cVar.a(CheckableImageButton.this.a());
                cVar.b(CheckableImageButton.this.isChecked());
            }

            public void d(View view, AccessibilityEvent accessibilityEvent) {
                super.d(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }
        });
    }

    public boolean a() {
        return this.f19182c;
    }

    public boolean isChecked() {
        return this.f19181b;
    }

    public int[] onCreateDrawableState(int i2) {
        if (!this.f19181b) {
            return super.onCreateDrawableState(i2);
        }
        int[] iArr = f19180a;
        return mergeDrawableStates(super.onCreateDrawableState(i2 + iArr.length), iArr);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f19185a);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19185a = this.f19181b;
        return savedState;
    }

    public void setCheckable(boolean z2) {
        if (this.f19182c != z2) {
            this.f19182c = z2;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z2) {
        if (this.f19182c && this.f19181b != z2) {
            this.f19181b = z2;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z2) {
        this.f19183d = z2;
    }

    public void setPressed(boolean z2) {
        if (this.f19183d) {
            super.setPressed(z2);
        }
    }

    public void toggle() {
        setChecked(!this.f19181b);
    }
}
