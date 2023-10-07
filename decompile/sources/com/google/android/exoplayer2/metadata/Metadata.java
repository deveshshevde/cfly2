package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        /* renamed from: a */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        /* renamed from: a */
        public Metadata[] newArray(int i2) {
            return new Metadata[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Entry[] f15841a;

    public interface Entry extends Parcelable {

        /* renamed from: com.google.android.exoplayer2.metadata.Metadata$Entry$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Format $default$a(Entry entry) {
                return null;
            }

            public static byte[] $default$b(Entry entry) {
                return null;
            }
        }

        Format a();

        byte[] b();
    }

    Metadata(Parcel parcel) {
        this.f15841a = new Entry[parcel.readInt()];
        int i2 = 0;
        while (true) {
            Entry[] entryArr = this.f15841a;
            if (i2 < entryArr.length) {
                entryArr[i2] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i2++;
            } else {
                return;
            }
        }
    }

    public Metadata(List<? extends Entry> list) {
        Entry[] entryArr = new Entry[list.size()];
        this.f15841a = entryArr;
        list.toArray(entryArr);
    }

    public Metadata(Entry... entryArr) {
        this.f15841a = entryArr;
    }

    public int a() {
        return this.f15841a.length;
    }

    public Entry a(int i2) {
        return this.f15841a[i2];
    }

    public Metadata a(Metadata metadata) {
        return metadata == null ? this : a(metadata.f15841a);
    }

    public Metadata a(Entry... entryArr) {
        return entryArr.length == 0 ? this : new Metadata((Entry[]) ad.a((T[]) this.f15841a, (T[]) entryArr));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f15841a, ((Metadata) obj).f15841a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f15841a);
    }

    public String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.f15841a));
        return valueOf.length() != 0 ? "entries=".concat(valueOf) : new String("entries=");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f15841a.length);
        for (Entry writeParcelable : this.f15841a) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
