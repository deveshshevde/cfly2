package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new Parcelable.Creator<HlsTrackMetadataEntry>() {
        /* renamed from: a */
        public HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }

        /* renamed from: a */
        public HlsTrackMetadataEntry[] newArray(int i2) {
            return new HlsTrackMetadataEntry[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f16179a;

    /* renamed from: b  reason: collision with root package name */
    public final String f16180b;

    /* renamed from: c  reason: collision with root package name */
    public final List<VariantInfo> f16181c;

    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new Parcelable.Creator<VariantInfo>() {
            /* renamed from: a */
            public VariantInfo createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }

            /* renamed from: a */
            public VariantInfo[] newArray(int i2) {
                return new VariantInfo[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final long f16182a;

        /* renamed from: b  reason: collision with root package name */
        public final String f16183b;

        /* renamed from: c  reason: collision with root package name */
        public final String f16184c;

        /* renamed from: d  reason: collision with root package name */
        public final String f16185d;

        /* renamed from: e  reason: collision with root package name */
        public final String f16186e;

        public VariantInfo(long j2, String str, String str2, String str3, String str4) {
            this.f16182a = j2;
            this.f16183b = str;
            this.f16184c = str2;
            this.f16185d = str3;
            this.f16186e = str4;
        }

        VariantInfo(Parcel parcel) {
            this.f16182a = parcel.readLong();
            this.f16183b = parcel.readString();
            this.f16184c = parcel.readString();
            this.f16185d = parcel.readString();
            this.f16186e = parcel.readString();
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
            VariantInfo variantInfo = (VariantInfo) obj;
            return this.f16182a == variantInfo.f16182a && TextUtils.equals(this.f16183b, variantInfo.f16183b) && TextUtils.equals(this.f16184c, variantInfo.f16184c) && TextUtils.equals(this.f16185d, variantInfo.f16185d) && TextUtils.equals(this.f16186e, variantInfo.f16186e);
        }

        public int hashCode() {
            long j2 = this.f16182a;
            int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            String str = this.f16183b;
            int i3 = 0;
            int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f16184c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f16185d;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f16186e;
            if (str4 != null) {
                i3 = str4.hashCode();
            }
            return hashCode3 + i3;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f16182a);
            parcel.writeString(this.f16183b);
            parcel.writeString(this.f16184c);
            parcel.writeString(this.f16185d);
            parcel.writeString(this.f16186e);
        }
    }

    HlsTrackMetadataEntry(Parcel parcel) {
        this.f16179a = parcel.readString();
        this.f16180b = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.f16181c = Collections.unmodifiableList(arrayList);
    }

    public HlsTrackMetadataEntry(String str, String str2, List<VariantInfo> list) {
        this.f16179a = str;
        this.f16180b = str2;
        this.f16181c = Collections.unmodifiableList(new ArrayList(list));
    }

    public /* synthetic */ Format a() {
        return Metadata.Entry.CC.$default$a(this);
    }

    public /* synthetic */ byte[] b() {
        return Metadata.Entry.CC.$default$b(this);
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
        HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
        return TextUtils.equals(this.f16179a, hlsTrackMetadataEntry.f16179a) && TextUtils.equals(this.f16180b, hlsTrackMetadataEntry.f16180b) && this.f16181c.equals(hlsTrackMetadataEntry.f16181c);
    }

    public int hashCode() {
        String str = this.f16179a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f16180b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + this.f16181c.hashCode();
    }

    public String toString() {
        String str;
        String str2 = this.f16179a;
        if (str2 != null) {
            String str3 = this.f16180b;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 5 + String.valueOf(str3).length());
            sb.append(" [");
            sb.append(str2);
            sb.append(", ");
            sb.append(str3);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "";
        }
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "HlsTrackMetadataEntry".concat(valueOf) : new String("HlsTrackMetadataEntry");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f16179a);
        parcel.writeString(this.f16180b);
        int size = this.f16181c.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable(this.f16181c.get(i3), 0);
        }
    }
}
