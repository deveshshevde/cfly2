package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() {
        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: a */
        public ParcelableVolumeInfo[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f391a;

    /* renamed from: b  reason: collision with root package name */
    public int f392b;

    /* renamed from: c  reason: collision with root package name */
    public int f393c;

    /* renamed from: d  reason: collision with root package name */
    public int f394d;

    /* renamed from: e  reason: collision with root package name */
    public int f395e;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f391a = parcel.readInt();
        this.f393c = parcel.readInt();
        this.f394d = parcel.readInt();
        this.f395e = parcel.readInt();
        this.f392b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f391a);
        parcel.writeInt(this.f393c);
        parcel.writeInt(this.f394d);
        parcel.writeInt(this.f395e);
        parcel.writeInt(this.f392b);
    }
}
