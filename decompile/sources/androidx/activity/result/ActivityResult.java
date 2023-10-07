package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() {
        /* renamed from: a */
        public ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* renamed from: a */
        public ActivityResult[] newArray(int i2) {
            return new ActivityResult[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f454a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f455b;

    public ActivityResult(int i2, Intent intent) {
        this.f454a = i2;
        this.f455b = intent;
    }

    ActivityResult(Parcel parcel) {
        this.f454a = parcel.readInt();
        this.f455b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public static String a(int i2) {
        return i2 != -1 ? i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public int a() {
        return this.f454a;
    }

    public Intent b() {
        return this.f455b;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + a(this.f454a) + ", data=" + this.f455b + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f454a);
        parcel.writeInt(this.f455b == null ? 0 : 1);
        Intent intent = this.f455b;
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }
}
