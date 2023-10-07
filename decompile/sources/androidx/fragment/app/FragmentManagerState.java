package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* renamed from: a */
        public FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    ArrayList<FragmentState> f3252a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f3253b;

    /* renamed from: c  reason: collision with root package name */
    BackStackState[] f3254c;

    /* renamed from: d  reason: collision with root package name */
    int f3255d;

    /* renamed from: e  reason: collision with root package name */
    String f3256e = null;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<String> f3257f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<Bundle> f3258g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    ArrayList<FragmentManager.LaunchedFragmentInfo> f3259h;

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.f3252a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f3253b = parcel.createStringArrayList();
        this.f3254c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f3255d = parcel.readInt();
        this.f3256e = parcel.readString();
        this.f3257f = parcel.createStringArrayList();
        this.f3258g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f3259h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f3252a);
        parcel.writeStringList(this.f3253b);
        parcel.writeTypedArray(this.f3254c, i2);
        parcel.writeInt(this.f3255d);
        parcel.writeString(this.f3256e);
        parcel.writeStringList(this.f3257f);
        parcel.writeTypedList(this.f3258g);
        parcel.writeTypedList(this.f3259h);
    }
}
