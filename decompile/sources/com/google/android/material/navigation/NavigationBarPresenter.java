package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;
import com.google.android.material.badge.a;
import com.google.android.material.internal.ParcelableSparseArray;

public class NavigationBarPresenter implements m {

    /* renamed from: a  reason: collision with root package name */
    private g f19382a;

    /* renamed from: b  reason: collision with root package name */
    private NavigationBarMenuView f19383b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19384c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f19385d;

    static class SavedState implements Parcelable {
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
        int f19386a;

        /* renamed from: b  reason: collision with root package name */
        ParcelableSparseArray f19387b;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f19386a = parcel.readInt();
            this.f19387b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f19386a);
            parcel.writeParcelable(this.f19387b, 0);
        }
    }

    public void a(int i2) {
        this.f19385d = i2;
    }

    public void a(Context context, g gVar) {
        this.f19382a = gVar;
        this.f19383b.a(gVar);
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f19383b.b(savedState.f19386a);
            this.f19383b.setBadgeDrawables(a.a(this.f19383b.getContext(), savedState.f19387b));
        }
    }

    public void a(g gVar, boolean z2) {
    }

    public void a(m.a aVar) {
    }

    public void a(NavigationBarMenuView navigationBarMenuView) {
        this.f19383b = navigationBarMenuView;
    }

    public void a(boolean z2) {
        if (!this.f19384c) {
            if (z2) {
                this.f19383b.b();
            } else {
                this.f19383b.c();
            }
        }
    }

    public boolean a(g gVar, i iVar) {
        return false;
    }

    public boolean a(r rVar) {
        return false;
    }

    public void b(boolean z2) {
        this.f19384c = z2;
    }

    public boolean b() {
        return false;
    }

    public boolean b(g gVar, i iVar) {
        return false;
    }

    public int c() {
        return this.f19385d;
    }

    public Parcelable f() {
        SavedState savedState = new SavedState();
        savedState.f19386a = this.f19383b.getSelectedItemId();
        savedState.f19387b = a.a(this.f19383b.getBadgeDrawables());
        return savedState;
    }
}
