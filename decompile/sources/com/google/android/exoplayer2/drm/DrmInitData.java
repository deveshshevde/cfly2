package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() {
        /* renamed from: a */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        /* renamed from: a */
        public DrmInitData[] newArray(int i2) {
            return new DrmInitData[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15461a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15462b;

    /* renamed from: c  reason: collision with root package name */
    private final SchemeData[] f15463c;

    /* renamed from: d  reason: collision with root package name */
    private int f15464d;

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() {
            /* renamed from: a */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            /* renamed from: a */
            public SchemeData[] newArray(int i2) {
                return new SchemeData[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final String f15465a;

        /* renamed from: b  reason: collision with root package name */
        public final String f15466b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f15467c;

        /* renamed from: d  reason: collision with root package name */
        private int f15468d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final UUID f15469e;

        SchemeData(Parcel parcel) {
            this.f15469e = new UUID(parcel.readLong(), parcel.readLong());
            this.f15465a = parcel.readString();
            this.f15466b = (String) ad.a(parcel.readString());
            this.f15467c = parcel.createByteArray();
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr) {
            this.f15469e = (UUID) a.b(uuid);
            this.f15465a = str;
            this.f15466b = (String) a.b(str2);
            this.f15467c = bArr;
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, (String) null, str, bArr);
        }

        public SchemeData a(byte[] bArr) {
            return new SchemeData(this.f15469e, this.f15465a, this.f15466b, bArr);
        }

        public boolean a() {
            return this.f15467c != null;
        }

        public boolean a(UUID uuid) {
            return e.f15477a.equals(this.f15469e) || uuid.equals(this.f15469e);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return ad.a((Object) this.f15465a, (Object) schemeData.f15465a) && ad.a((Object) this.f15466b, (Object) schemeData.f15466b) && ad.a((Object) this.f15469e, (Object) schemeData.f15469e) && Arrays.equals(this.f15467c, schemeData.f15467c);
        }

        public int hashCode() {
            if (this.f15468d == 0) {
                int hashCode = this.f15469e.hashCode() * 31;
                String str = this.f15465a;
                this.f15468d = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f15466b.hashCode()) * 31) + Arrays.hashCode(this.f15467c);
            }
            return this.f15468d;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f15469e.getMostSignificantBits());
            parcel.writeLong(this.f15469e.getLeastSignificantBits());
            parcel.writeString(this.f15465a);
            parcel.writeString(this.f15466b);
            parcel.writeByteArray(this.f15467c);
        }
    }

    DrmInitData(Parcel parcel) {
        this.f15461a = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) ad.a((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.f15463c = schemeDataArr;
        this.f15462b = schemeDataArr.length;
    }

    public DrmInitData(String str, List<SchemeData> list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.exoplayer2.drm.DrmInitData$SchemeData[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DrmInitData(java.lang.String r1, boolean r2, com.google.android.exoplayer2.drm.DrmInitData.SchemeData... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.f15461a = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r3 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r3
        L_0x000e:
            r0.f15463c = r3
            int r1 = r3.length
            r0.f15462b = r1
            java.util.Arrays.sort(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DrmInitData.<init>(java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData$SchemeData[]):void");
    }

    public DrmInitData(String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    public DrmInitData(List<SchemeData> list) {
        this((String) null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public static DrmInitData a(DrmInitData drmInitData, DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.f15461a;
            for (SchemeData schemeData : drmInitData.f15463c) {
                if (schemeData.a()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.f15461a;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.f15463c) {
                if (schemeData2.a() && !a(arrayList, size, schemeData2.f15469e)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, (List<SchemeData>) arrayList);
    }

    private static boolean a(ArrayList<SchemeData> arrayList, int i2, UUID uuid) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (arrayList.get(i3).f15469e.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        return e.f15477a.equals(schemeData.f15469e) ? e.f15477a.equals(schemeData2.f15469e) ? 0 : 1 : schemeData.f15469e.compareTo(schemeData2.f15469e);
    }

    public SchemeData a(int i2) {
        return this.f15463c[i2];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r3.f15461a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.drm.DrmInitData a(com.google.android.exoplayer2.drm.DrmInitData r3) {
        /*
            r2 = this;
            java.lang.String r0 = r2.f15461a
            if (r0 == 0) goto L_0x0011
            java.lang.String r1 = r3.f15461a
            if (r1 == 0) goto L_0x0011
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = 0
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            com.google.android.exoplayer2.util.a.b((boolean) r0)
            java.lang.String r0 = r2.f15461a
            if (r0 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            java.lang.String r0 = r3.f15461a
        L_0x001c:
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r1 = r2.f15463c
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r3 = r3.f15463c
            java.lang.Object[] r3 = com.google.android.exoplayer2.util.ad.a((T[]) r1, (T[]) r3)
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r3 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r3
            com.google.android.exoplayer2.drm.DrmInitData r1 = new com.google.android.exoplayer2.drm.DrmInitData
            r1.<init>((java.lang.String) r0, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DrmInitData.a(com.google.android.exoplayer2.drm.DrmInitData):com.google.android.exoplayer2.drm.DrmInitData");
    }

    public DrmInitData a(String str) {
        return ad.a((Object) this.f15461a, (Object) str) ? this : new DrmInitData(str, false, this.f15463c);
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
        DrmInitData drmInitData = (DrmInitData) obj;
        return ad.a((Object) this.f15461a, (Object) drmInitData.f15461a) && Arrays.equals(this.f15463c, drmInitData.f15463c);
    }

    public int hashCode() {
        if (this.f15464d == 0) {
            String str = this.f15461a;
            this.f15464d = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f15463c);
        }
        return this.f15464d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15461a);
        parcel.writeTypedArray(this.f15463c, 0);
    }
}
