package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.ab;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.a;
import com.google.android.exoplayer2.trackselection.d;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.util.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f16618a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private final e.b f16619b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<Parameters> f16620c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16621d;

    public static final class Parameters extends TrackSelectionParameters {
        public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() {
            /* renamed from: a */
            public Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            /* renamed from: a */
            public Parameters[] newArray(int i2) {
                return new Parameters[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public static final Parameters f16622a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public static final Parameters f16623b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public static final Parameters f16624c;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> G;
        private final SparseBooleanArray H;

        /* renamed from: d  reason: collision with root package name */
        public final int f16625d;

        /* renamed from: e  reason: collision with root package name */
        public final int f16626e;

        /* renamed from: f  reason: collision with root package name */
        public final int f16627f;

        /* renamed from: g  reason: collision with root package name */
        public final int f16628g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f16629h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f16630i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f16631j;

        /* renamed from: k  reason: collision with root package name */
        public final int f16632k;

        /* renamed from: l  reason: collision with root package name */
        public final int f16633l;

        /* renamed from: m  reason: collision with root package name */
        public final boolean f16634m;

        /* renamed from: n  reason: collision with root package name */
        public final int f16635n;

        /* renamed from: o  reason: collision with root package name */
        public final int f16636o;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f16637p;

        /* renamed from: q  reason: collision with root package name */
        public final boolean f16638q;

        /* renamed from: r  reason: collision with root package name */
        public final boolean f16639r;

        /* renamed from: s  reason: collision with root package name */
        public final boolean f16640s;

        /* renamed from: t  reason: collision with root package name */
        public final boolean f16641t;

        /* renamed from: u  reason: collision with root package name */
        public final boolean f16642u;
        @Deprecated

        /* renamed from: v  reason: collision with root package name */
        public final boolean f16643v;
        @Deprecated

        /* renamed from: w  reason: collision with root package name */
        public final boolean f16644w;

        /* renamed from: x  reason: collision with root package name */
        public final boolean f16645x;

        /* renamed from: y  reason: collision with root package name */
        public final int f16646y;

        static {
            Parameters a2 = new c().b();
            f16622a = a2;
            f16623b = a2;
            f16624c = a2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Parameters(int i2, int i3, int i4, int i5, boolean z2, boolean z3, boolean z4, int i6, int i7, boolean z5, String str, int i8, int i9, boolean z6, boolean z7, boolean z8, boolean z9, String str2, int i10, boolean z10, int i11, boolean z11, boolean z12, boolean z13, int i12, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray) {
            super(str, str2, i10, z10, i11);
            boolean z14 = z3;
            boolean z15 = z4;
            this.f16625d = i2;
            this.f16626e = i3;
            this.f16627f = i4;
            this.f16628g = i5;
            this.f16629h = z2;
            this.f16630i = z14;
            this.f16631j = z15;
            this.f16632k = i6;
            this.f16633l = i7;
            this.f16634m = z5;
            this.f16635n = i8;
            this.f16636o = i9;
            this.f16637p = z6;
            this.f16638q = z7;
            this.f16639r = z8;
            this.f16640s = z9;
            this.f16641t = z11;
            this.f16642u = z12;
            this.f16645x = z13;
            this.f16646y = i12;
            this.f16643v = z14;
            this.f16644w = z15;
            this.G = sparseArray;
            this.H = sparseBooleanArray;
        }

        Parameters(Parcel parcel) {
            super(parcel);
            this.f16625d = parcel.readInt();
            this.f16626e = parcel.readInt();
            this.f16627f = parcel.readInt();
            this.f16628g = parcel.readInt();
            this.f16629h = ad.a(parcel);
            boolean a2 = ad.a(parcel);
            this.f16630i = a2;
            boolean a3 = ad.a(parcel);
            this.f16631j = a3;
            this.f16632k = parcel.readInt();
            this.f16633l = parcel.readInt();
            this.f16634m = ad.a(parcel);
            this.f16635n = parcel.readInt();
            this.f16636o = parcel.readInt();
            this.f16637p = ad.a(parcel);
            this.f16638q = ad.a(parcel);
            this.f16639r = ad.a(parcel);
            this.f16640s = ad.a(parcel);
            this.f16641t = ad.a(parcel);
            this.f16642u = ad.a(parcel);
            this.f16645x = ad.a(parcel);
            this.f16646y = parcel.readInt();
            this.G = a(parcel);
            this.H = (SparseBooleanArray) ad.a(parcel.readSparseBooleanArray());
            this.f16643v = a2;
            this.f16644w = a3;
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> a(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    hashMap.put((TrackGroupArray) com.google.android.exoplayer2.util.a.b((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader())), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        public static Parameters a(Context context) {
            return new c(context).b();
        }

        private static void a(Parcel parcel, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = sparseArray.keyAt(i2);
                Map valueAt = sparseArray.valueAt(i2);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry entry : valueAt.entrySet()) {
                    parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                    parcel.writeParcelable((Parcelable) entry.getValue(), 0);
                }
            }
        }

        private static boolean a(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                if (indexOfKey < 0 || !a(sparseArray.valueAt(i2), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean a(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean a(java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                com.google.android.exoplayer2.source.TrackGroupArray r1 = (com.google.android.exoplayer2.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r0, (java.lang.Object) r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.a(java.util.Map, java.util.Map):boolean");
        }

        public final boolean a(int i2) {
            return this.H.get(i2);
        }

        public final boolean a(int i2, TrackGroupArray trackGroupArray) {
            Map map = this.G.get(i2);
            return map != null && map.containsKey(trackGroupArray);
        }

        public final SelectionOverride b(int i2, TrackGroupArray trackGroupArray) {
            Map map = this.G.get(i2);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
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
            Parameters parameters = (Parameters) obj;
            return super.equals(obj) && this.f16625d == parameters.f16625d && this.f16626e == parameters.f16626e && this.f16627f == parameters.f16627f && this.f16628g == parameters.f16628g && this.f16629h == parameters.f16629h && this.f16630i == parameters.f16630i && this.f16631j == parameters.f16631j && this.f16634m == parameters.f16634m && this.f16632k == parameters.f16632k && this.f16633l == parameters.f16633l && this.f16635n == parameters.f16635n && this.f16636o == parameters.f16636o && this.f16637p == parameters.f16637p && this.f16638q == parameters.f16638q && this.f16639r == parameters.f16639r && this.f16640s == parameters.f16640s && this.f16641t == parameters.f16641t && this.f16642u == parameters.f16642u && this.f16645x == parameters.f16645x && this.f16646y == parameters.f16646y && a(this.H, parameters.H) && a(this.G, parameters.G);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.f16625d) * 31) + this.f16626e) * 31) + this.f16627f) * 31) + this.f16628g) * 31) + (this.f16629h ? 1 : 0)) * 31) + (this.f16630i ? 1 : 0)) * 31) + (this.f16631j ? 1 : 0)) * 31) + (this.f16634m ? 1 : 0)) * 31) + this.f16632k) * 31) + this.f16633l) * 31) + this.f16635n) * 31) + this.f16636o) * 31) + (this.f16637p ? 1 : 0)) * 31) + (this.f16638q ? 1 : 0)) * 31) + (this.f16639r ? 1 : 0)) * 31) + (this.f16640s ? 1 : 0)) * 31) + (this.f16641t ? 1 : 0)) * 31) + (this.f16642u ? 1 : 0)) * 31) + (this.f16645x ? 1 : 0)) * 31) + this.f16646y;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f16625d);
            parcel.writeInt(this.f16626e);
            parcel.writeInt(this.f16627f);
            parcel.writeInt(this.f16628g);
            ad.a(parcel, this.f16629h);
            ad.a(parcel, this.f16630i);
            ad.a(parcel, this.f16631j);
            parcel.writeInt(this.f16632k);
            parcel.writeInt(this.f16633l);
            ad.a(parcel, this.f16634m);
            parcel.writeInt(this.f16635n);
            parcel.writeInt(this.f16636o);
            ad.a(parcel, this.f16637p);
            ad.a(parcel, this.f16638q);
            ad.a(parcel, this.f16639r);
            ad.a(parcel, this.f16640s);
            ad.a(parcel, this.f16641t);
            ad.a(parcel, this.f16642u);
            ad.a(parcel, this.f16645x);
            parcel.writeInt(this.f16646y);
            a(parcel, this.G);
            parcel.writeSparseBooleanArray(this.H);
        }
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() {
            /* renamed from: a */
            public SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            /* renamed from: a */
            public SelectionOverride[] newArray(int i2) {
                return new SelectionOverride[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final int f16647a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f16648b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16649c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16650d;

        /* renamed from: e  reason: collision with root package name */
        public final int f16651e;

        public SelectionOverride(int i2, int... iArr) {
            this(i2, iArr, 2, 0);
        }

        public SelectionOverride(int i2, int[] iArr, int i3, int i4) {
            this.f16647a = i2;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f16648b = copyOf;
            this.f16649c = iArr.length;
            this.f16650d = i3;
            this.f16651e = i4;
            Arrays.sort(copyOf);
        }

        SelectionOverride(Parcel parcel) {
            this.f16647a = parcel.readInt();
            int readByte = parcel.readByte();
            this.f16649c = readByte;
            int[] iArr = new int[readByte];
            this.f16648b = iArr;
            parcel.readIntArray(iArr);
            this.f16650d = parcel.readInt();
            this.f16651e = parcel.readInt();
        }

        public boolean a(int i2) {
            for (int i3 : this.f16648b) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
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
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            return this.f16647a == selectionOverride.f16647a && Arrays.equals(this.f16648b, selectionOverride.f16648b) && this.f16650d == selectionOverride.f16650d && this.f16651e == selectionOverride.f16651e;
        }

        public int hashCode() {
            return (((((this.f16647a * 31) + Arrays.hashCode(this.f16648b)) * 31) + this.f16650d) * 31) + this.f16651e;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f16647a);
            parcel.writeInt(this.f16648b.length);
            parcel.writeIntArray(this.f16648b);
            parcel.writeInt(this.f16650d);
            parcel.writeInt(this.f16651e);
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f16652a;

        /* renamed from: b  reason: collision with root package name */
        public final int f16653b;

        /* renamed from: c  reason: collision with root package name */
        public final String f16654c;

        public a(int i2, int i3, String str) {
            this.f16652a = i2;
            this.f16653b = i3;
            this.f16654c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f16652a == aVar.f16652a && this.f16653b == aVar.f16653b && TextUtils.equals(this.f16654c, aVar.f16654c);
        }

        public int hashCode() {
            int i2 = ((this.f16652a * 31) + this.f16653b) * 31;
            String str = this.f16654c;
            return i2 + (str != null ? str.hashCode() : 0);
        }
    }

    protected static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f16655a;

        /* renamed from: b  reason: collision with root package name */
        private final String f16656b;

        /* renamed from: c  reason: collision with root package name */
        private final Parameters f16657c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f16658d;

        /* renamed from: e  reason: collision with root package name */
        private final int f16659e;

        /* renamed from: f  reason: collision with root package name */
        private final int f16660f;

        /* renamed from: g  reason: collision with root package name */
        private final int f16661g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f16662h;

        /* renamed from: i  reason: collision with root package name */
        private final int f16663i;

        /* renamed from: j  reason: collision with root package name */
        private final int f16664j;

        /* renamed from: k  reason: collision with root package name */
        private final int f16665k;

        public b(Format format, Parameters parameters, int i2) {
            this.f16657c = parameters;
            this.f16656b = DefaultTrackSelector.a(format.A);
            int i3 = 0;
            this.f16658d = DefaultTrackSelector.a(i2, false);
            this.f16659e = DefaultTrackSelector.a(format, parameters.B, false);
            boolean z2 = true;
            this.f16662h = (format.f15086c & 1) != 0;
            this.f16663i = format.f15105v;
            this.f16664j = format.f15106w;
            this.f16665k = format.f15088e;
            if ((format.f15088e != -1 && format.f15088e > parameters.f16636o) || (format.f15105v != -1 && format.f15105v > parameters.f16635n)) {
                z2 = false;
            }
            this.f16655a = z2;
            String[] b2 = ad.b();
            int i4 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            int i5 = 0;
            while (true) {
                if (i5 >= b2.length) {
                    break;
                }
                int a2 = DefaultTrackSelector.a(format, b2[i5], false);
                if (a2 > 0) {
                    i4 = i5;
                    i3 = a2;
                    break;
                }
                i5++;
            }
            this.f16660f = i4;
            this.f16661g = i3;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int a2;
            int b2;
            boolean z2 = this.f16658d;
            int i2 = 1;
            if (z2 != bVar.f16658d) {
                return z2 ? 1 : -1;
            }
            int i3 = this.f16659e;
            int i4 = bVar.f16659e;
            if (i3 != i4) {
                return DefaultTrackSelector.d(i3, i4);
            }
            boolean z3 = this.f16655a;
            if (z3 != bVar.f16655a) {
                return z3 ? 1 : -1;
            }
            if (this.f16657c.f16641t && (b2 = DefaultTrackSelector.c(this.f16665k, bVar.f16665k)) != 0) {
                return b2 > 0 ? -1 : 1;
            }
            boolean z4 = this.f16662h;
            if (z4 != bVar.f16662h) {
                return z4 ? 1 : -1;
            }
            int i5 = this.f16660f;
            int i6 = bVar.f16660f;
            if (i5 != i6) {
                return -DefaultTrackSelector.d(i5, i6);
            }
            int i7 = this.f16661g;
            int i8 = bVar.f16661g;
            if (i7 != i8) {
                return DefaultTrackSelector.d(i7, i8);
            }
            if (!this.f16655a || !this.f16658d) {
                i2 = -1;
            }
            int i9 = this.f16663i;
            int i10 = bVar.f16663i;
            if (i9 != i10 || (i9 = this.f16664j) != (i10 = bVar.f16664j)) {
                a2 = DefaultTrackSelector.d(i9, i10);
            } else if (!ad.a((Object) this.f16656b, (Object) bVar.f16656b)) {
                return 0;
            } else {
                a2 = DefaultTrackSelector.d(this.f16665k, bVar.f16665k);
            }
            return i2 * a2;
        }
    }

    public static final class c extends TrackSelectionParameters.a {
        private final SparseBooleanArray A = new SparseBooleanArray();

        /* renamed from: f  reason: collision with root package name */
        private int f16666f;

        /* renamed from: g  reason: collision with root package name */
        private int f16667g;

        /* renamed from: h  reason: collision with root package name */
        private int f16668h;

        /* renamed from: i  reason: collision with root package name */
        private int f16669i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f16670j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f16671k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f16672l;

        /* renamed from: m  reason: collision with root package name */
        private int f16673m;

        /* renamed from: n  reason: collision with root package name */
        private int f16674n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f16675o;

        /* renamed from: p  reason: collision with root package name */
        private int f16676p;

        /* renamed from: q  reason: collision with root package name */
        private int f16677q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f16678r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f16679s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f16680t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f16681u;

        /* renamed from: v  reason: collision with root package name */
        private boolean f16682v;

        /* renamed from: w  reason: collision with root package name */
        private boolean f16683w;

        /* renamed from: x  reason: collision with root package name */
        private boolean f16684x;

        /* renamed from: y  reason: collision with root package name */
        private int f16685y;

        /* renamed from: z  reason: collision with root package name */
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> f16686z = new SparseArray<>();

        @Deprecated
        public c() {
            c();
        }

        public c(Context context) {
            super(context);
            c();
            a(context, true);
        }

        private void c() {
            this.f16666f = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.f16667g = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.f16668h = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.f16669i = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.f16670j = true;
            this.f16671k = false;
            this.f16672l = true;
            this.f16673m = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.f16674n = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.f16675o = true;
            this.f16676p = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.f16677q = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.f16678r = true;
            this.f16679s = false;
            this.f16680t = false;
            this.f16681u = false;
            this.f16682v = false;
            this.f16683w = false;
            this.f16684x = true;
            this.f16685y = 0;
        }

        /* renamed from: a */
        public Parameters b() {
            return new Parameters(this.f16666f, this.f16667g, this.f16668h, this.f16669i, this.f16670j, this.f16671k, this.f16672l, this.f16673m, this.f16674n, this.f16675o, this.f16696a, this.f16676p, this.f16677q, this.f16678r, this.f16679s, this.f16680t, this.f16681u, this.f16697b, this.f16698c, this.f16699d, this.f16700e, this.f16682v, this.f16683w, this.f16684x, this.f16685y, this.f16686z, this.A);
        }

        public c a(int i2, int i3, boolean z2) {
            this.f16673m = i2;
            this.f16674n = i3;
            this.f16675o = z2;
            return this;
        }

        /* renamed from: a */
        public c b(Context context) {
            super.b(context);
            return this;
        }

        public c a(Context context, boolean z2) {
            Point d2 = ad.d(context);
            return a(d2.x, d2.y, z2);
        }
    }

    protected static final class d implements Comparable<d> {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f16687a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f16688b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f16689c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f16690d;

        /* renamed from: e  reason: collision with root package name */
        private final int f16691e;

        /* renamed from: f  reason: collision with root package name */
        private final int f16692f;

        /* renamed from: g  reason: collision with root package name */
        private final int f16693g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f16694h;

        public d(Format format, Parameters parameters, int i2, String str) {
            boolean z2 = false;
            this.f16688b = DefaultTrackSelector.a(i2, false);
            int i3 = format.f15086c & (parameters.F ^ -1);
            boolean z3 = (i3 & 1) != 0;
            this.f16689c = z3;
            boolean z4 = (i3 & 2) != 0;
            int a2 = DefaultTrackSelector.a(format, parameters.C, parameters.E);
            this.f16691e = a2;
            int bitCount = Integer.bitCount(format.f15087d & parameters.D);
            this.f16692f = bitCount;
            this.f16694h = (format.f15087d & 1088) != 0;
            this.f16690d = (a2 > 0 && !z4) || (a2 == 0 && z4);
            int a3 = DefaultTrackSelector.a(format, str, DefaultTrackSelector.a(str) == null);
            this.f16693g = a3;
            if (a2 > 0 || ((parameters.C == null && bitCount > 0) || z3 || (z4 && a3 > 0))) {
                z2 = true;
            }
            this.f16687a = z2;
        }

        /* renamed from: a */
        public int compareTo(d dVar) {
            boolean z2;
            boolean z3 = this.f16688b;
            if (z3 != dVar.f16688b) {
                return z3 ? 1 : -1;
            }
            int i2 = this.f16691e;
            int i3 = dVar.f16691e;
            if (i2 != i3) {
                return DefaultTrackSelector.d(i2, i3);
            }
            int i4 = this.f16692f;
            int i5 = dVar.f16692f;
            if (i4 != i5) {
                return DefaultTrackSelector.d(i4, i5);
            }
            boolean z4 = this.f16689c;
            if (z4 != dVar.f16689c) {
                return z4 ? 1 : -1;
            }
            boolean z5 = this.f16690d;
            if (z5 != dVar.f16690d) {
                return z5 ? 1 : -1;
            }
            int i6 = this.f16693g;
            int i7 = dVar.f16693g;
            if (i6 != i7) {
                return DefaultTrackSelector.d(i6, i7);
            }
            if (i4 != 0 || (z2 = this.f16694h) == dVar.f16694h) {
                return 0;
            }
            return z2 ? -1 : 1;
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this((e.b) new a.c());
    }

    public DefaultTrackSelector(Context context) {
        this(context, (e.b) new a.c());
    }

    public DefaultTrackSelector(Context context, e.b bVar) {
        this(Parameters.a(context), bVar);
    }

    public DefaultTrackSelector(Parameters parameters, e.b bVar) {
        this.f16619b = bVar;
        this.f16620c = new AtomicReference<>(parameters);
    }

    @Deprecated
    public DefaultTrackSelector(e.b bVar) {
        this(Parameters.f16622a, bVar);
    }

    protected static int a(Format format, String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(format.A)) {
            return 4;
        }
        String a2 = a(str);
        String a3 = a(format.A);
        if (a3 == null || a2 == null) {
            return (!z2 || a3 != null) ? 0 : 1;
        }
        if (a3.startsWith(a2) || a2.startsWith(a3)) {
            return 3;
        }
        return ad.b(a3, "-")[0].equals(ad.b(a2, "-")[0]) ? 2 : 0;
    }

    private static int a(TrackGroup trackGroup, int[] iArr, int i2, String str, int i3, int i4, int i5, int i6, List<Integer> list) {
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            int intValue = list.get(i8).intValue();
            TrackGroup trackGroup2 = trackGroup;
            if (a(trackGroup.a(intValue), str, iArr[intValue], i2, i3, i4, i5, i6)) {
                i7++;
            }
        }
        return i7;
    }

    private static int a(TrackGroup trackGroup, int[] iArr, a aVar, int i2, boolean z2, boolean z3, boolean z4) {
        TrackGroup trackGroup2 = trackGroup;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroup2.f16005a; i4++) {
            if (a(trackGroup.a(i4), iArr[i4], aVar, i2, z2, z3, z4)) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point a(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.util.ad.a((int) r0, (int) r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.ad.a((int) r3, (int) r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a(boolean, int, int, int, int):android.graphics.Point");
    }

    private static e.a a(TrackGroupArray trackGroupArray, int[][] iArr, int i2, Parameters parameters) {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i3 = parameters2.f16631j ? 24 : 16;
        boolean z2 = parameters2.f16630i && (i2 & i3) != 0;
        int i4 = 0;
        while (i4 < trackGroupArray2.f16009b) {
            TrackGroup a2 = trackGroupArray2.a(i4);
            TrackGroup trackGroup = a2;
            int[] a3 = a(a2, iArr[i4], z2, i3, parameters2.f16625d, parameters2.f16626e, parameters2.f16627f, parameters2.f16628g, parameters2.f16632k, parameters2.f16633l, parameters2.f16634m);
            if (a3.length > 0) {
                return new e.a(trackGroup, a3);
            }
            i4++;
            trackGroupArray2 = trackGroupArray;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a3, code lost:
        if (r0 < 0) goto L_0x00a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.trackselection.e.a a(com.google.android.exoplayer2.source.TrackGroupArray r17, int[][] r18, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r19) {
        /*
            r0 = r17
            r1 = r19
            r3 = -1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = -1
            r10 = -1
        L_0x000b:
            int r11 = r0.f16009b
            if (r5 >= r11) goto L_0x00e8
            com.google.android.exoplayer2.source.TrackGroup r11 = r0.a((int) r5)
            int r13 = r1.f16632k
            int r14 = r1.f16633l
            boolean r15 = r1.f16634m
            java.util.List r13 = a((com.google.android.exoplayer2.source.TrackGroup) r11, (int) r13, (int) r14, (boolean) r15)
            r14 = r18[r5]
            r15 = 0
        L_0x0020:
            int r2 = r11.f16005a
            if (r15 >= r2) goto L_0x00df
            com.google.android.exoplayer2.Format r2 = r11.a((int) r15)
            int r12 = r2.f15087d
            r12 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x0030
            goto L_0x00d4
        L_0x0030:
            r12 = r14[r15]
            boolean r4 = r1.f16645x
            boolean r4 = a((int) r12, (boolean) r4)
            if (r4 == 0) goto L_0x00d4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            boolean r4 = r13.contains(r4)
            if (r4 == 0) goto L_0x0075
            int r4 = r2.f15097n
            if (r4 == r3) goto L_0x004e
            int r4 = r2.f15097n
            int r12 = r1.f16625d
            if (r4 > r12) goto L_0x0075
        L_0x004e:
            int r4 = r2.f15098o
            if (r4 == r3) goto L_0x0058
            int r4 = r2.f15098o
            int r12 = r1.f16626e
            if (r4 > r12) goto L_0x0075
        L_0x0058:
            float r4 = r2.f15099p
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r4 == 0) goto L_0x0069
            float r4 = r2.f15099p
            int r12 = r1.f16627f
            float r12 = (float) r12
            int r4 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r4 > 0) goto L_0x0075
        L_0x0069:
            int r4 = r2.f15088e
            if (r4 == r3) goto L_0x0073
            int r4 = r2.f15088e
            int r12 = r1.f16628g
            if (r4 > r12) goto L_0x0075
        L_0x0073:
            r4 = 1
            goto L_0x0076
        L_0x0075:
            r4 = 0
        L_0x0076:
            if (r4 != 0) goto L_0x007e
            boolean r12 = r1.f16629h
            if (r12 != 0) goto L_0x007e
            goto L_0x00d4
        L_0x007e:
            if (r4 == 0) goto L_0x0082
            r12 = 2
            goto L_0x0083
        L_0x0082:
            r12 = 1
        L_0x0083:
            r3 = r14[r15]
            r0 = 0
            boolean r3 = a((int) r3, (boolean) r0)
            if (r3 == 0) goto L_0x008e
            int r12 = r12 + 1000
        L_0x008e:
            if (r12 <= r8) goto L_0x0092
            r0 = 1
            goto L_0x0093
        L_0x0092:
            r0 = 0
        L_0x0093:
            if (r12 != r8) goto L_0x00c4
            int r0 = r2.f15088e
            int r0 = c(r0, r9)
            r16 = r6
            boolean r6 = r1.f16641t
            if (r6 == 0) goto L_0x00a9
            if (r0 == 0) goto L_0x00a9
            if (r0 >= 0) goto L_0x00a7
        L_0x00a5:
            r0 = 1
            goto L_0x00c6
        L_0x00a7:
            r0 = 0
            goto L_0x00c6
        L_0x00a9:
            int r0 = r2.a()
            if (r0 == r10) goto L_0x00b4
            int r0 = c(r0, r10)
            goto L_0x00ba
        L_0x00b4:
            int r0 = r2.f15088e
            int r0 = c(r0, r9)
        L_0x00ba:
            if (r3 == 0) goto L_0x00c1
            if (r4 == 0) goto L_0x00c1
            if (r0 <= 0) goto L_0x00a7
            goto L_0x00a5
        L_0x00c1:
            if (r0 >= 0) goto L_0x00a7
            goto L_0x00a5
        L_0x00c4:
            r16 = r6
        L_0x00c6:
            if (r0 == 0) goto L_0x00d6
            int r0 = r2.f15088e
            int r2 = r2.a()
            r9 = r0
            r10 = r2
            r6 = r11
            r8 = r12
            r7 = r15
            goto L_0x00d8
        L_0x00d4:
            r16 = r6
        L_0x00d6:
            r6 = r16
        L_0x00d8:
            int r15 = r15 + 1
            r0 = r17
            r3 = -1
            goto L_0x0020
        L_0x00df:
            r16 = r6
            int r5 = r5 + 1
            r0 = r17
            r3 = -1
            goto L_0x000b
        L_0x00e8:
            if (r6 != 0) goto L_0x00ec
            r2 = 0
            goto L_0x00f7
        L_0x00ec:
            com.google.android.exoplayer2.trackselection.e$a r2 = new com.google.android.exoplayer2.trackselection.e$a
            r0 = 1
            int[] r0 = new int[r0]
            r1 = 0
            r0[r1] = r7
            r2.<init>(r6, r0)
        L_0x00f7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a(com.google.android.exoplayer2.source.TrackGroupArray, int[][], com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.google.android.exoplayer2.trackselection.e$a");
    }

    protected static String a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    private static List<Integer> a(TrackGroup trackGroup, int i2, int i3, boolean z2) {
        ArrayList arrayList = new ArrayList(trackGroup.f16005a);
        for (int i4 = 0; i4 < trackGroup.f16005a; i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
        if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
            int i5 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            for (int i6 = 0; i6 < trackGroup.f16005a; i6++) {
                Format a2 = trackGroup.a(i6);
                if (a2.f15097n > 0 && a2.f15098o > 0) {
                    Point a3 = a(z2, i2, i3, a2.f15097n, a2.f15098o);
                    int i7 = a2.f15097n * a2.f15098o;
                    if (a2.f15097n >= ((int) (((float) a3.x) * 0.98f)) && a2.f15098o >= ((int) (((float) a3.y) * 0.98f)) && i7 < i5) {
                        i5 = i7;
                    }
                }
            }
            if (i5 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int a4 = trackGroup.a(((Integer) arrayList.get(size)).intValue()).a();
                    if (a4 == -1 || a4 > i5) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    private static void a(d.a aVar, int[][][] iArr, ab[] abVarArr, e[] eVarArr, int i2) {
        boolean z2;
        if (i2 != 0) {
            boolean z3 = false;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (true) {
                if (i3 >= aVar.a()) {
                    z2 = true;
                    break;
                }
                int a2 = aVar.a(i3);
                e eVar = eVarArr[i3];
                if ((a2 == 1 || a2 == 2) && eVar != null && a(iArr[i3], aVar.b(i3), eVar)) {
                    if (a2 == 1) {
                        if (i5 != -1) {
                            break;
                        }
                        i5 = i3;
                    } else if (i4 != -1) {
                        break;
                    } else {
                        i4 = i3;
                    }
                }
                i3++;
            }
            z2 = false;
            if (!(i5 == -1 || i4 == -1)) {
                z3 = true;
            }
            if (z2 && z3) {
                ab abVar = new ab(i2);
                abVarArr[i5] = abVar;
                abVarArr[i4] = abVar;
            }
        }
    }

    protected static boolean a(int i2, boolean z2) {
        int c2 = aa.CC.c(i2);
        return c2 == 4 || (z2 && c2 == 3);
    }

    private static boolean a(Format format, int i2, a aVar, int i3, boolean z2, boolean z3, boolean z4) {
        if (!a(i2, false)) {
            return false;
        }
        if (format.f15088e != -1 && format.f15088e > i3) {
            return false;
        }
        if (!z4 && (format.f15105v == -1 || format.f15105v != aVar.f16652a)) {
            return false;
        }
        if (z2 || (format.f15092i != null && TextUtils.equals(format.f15092i, aVar.f16654c))) {
            return z3 || (format.f15106w != -1 && format.f15106w == aVar.f16653b);
        }
        return false;
    }

    private static boolean a(Format format, String str, int i2, int i3, int i4, int i5, int i6, int i7) {
        if ((format.f15087d & 16384) != 0 || !a(i2, false) || (i2 & i3) == 0) {
            return false;
        }
        if (str != null && !ad.a((Object) format.f15092i, (Object) str)) {
            return false;
        }
        if (format.f15097n != -1 && format.f15097n > i4) {
            return false;
        }
        if (format.f15098o != -1 && format.f15098o > i5) {
            return false;
        }
        if (format.f15099p == -1.0f || format.f15099p <= ((float) i6)) {
            return format.f15088e == -1 || format.f15088e <= i7;
        }
        return false;
    }

    private static boolean a(int[][] iArr, TrackGroupArray trackGroupArray, e eVar) {
        if (eVar == null) {
            return false;
        }
        int a2 = trackGroupArray.a(eVar.g());
        for (int i2 = 0; i2 < eVar.h(); i2++) {
            if (aa.CC.e(iArr[a2][eVar.b(i2)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private static int[] a(TrackGroup trackGroup, int[] iArr, int i2, boolean z2, boolean z3, boolean z4) {
        int a2;
        TrackGroup trackGroup2 = trackGroup;
        HashSet hashSet = new HashSet();
        a aVar = null;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroup2.f16005a; i4++) {
            Format a3 = trackGroup2.a(i4);
            a aVar2 = new a(a3.f15105v, a3.f15106w, a3.f15092i);
            if (hashSet.add(aVar2) && (a2 = a(trackGroup, iArr, aVar2, i2, z2, z3, z4)) > i3) {
                i3 = a2;
                aVar = aVar2;
            }
        }
        if (i3 <= 1) {
            return f16618a;
        }
        com.google.android.exoplayer2.util.a.b(aVar);
        int[] iArr2 = new int[i3];
        int i5 = 0;
        for (int i6 = 0; i6 < trackGroup2.f16005a; i6++) {
            if (a(trackGroup2.a(i6), iArr[i6], aVar, i2, z2, z3, z4)) {
                iArr2[i5] = i6;
                i5++;
            }
        }
        return iArr2;
    }

    private static int[] a(TrackGroup trackGroup, int[] iArr, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3) {
        String str;
        TrackGroup trackGroup2 = trackGroup;
        if (trackGroup2.f16005a < 2) {
            return f16618a;
        }
        List<Integer> a2 = a(trackGroup2, i7, i8, z3);
        if (a2.size() < 2) {
            return f16618a;
        }
        if (!z2) {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i9 = 0;
            for (int i10 = 0; i10 < a2.size(); i10++) {
                String str3 = trackGroup2.a(a2.get(i10).intValue()).f15092i;
                if (hashSet.add(str3)) {
                    String str4 = str3;
                    int a3 = a(trackGroup, iArr, i2, str3, i3, i4, i5, i6, a2);
                    if (a3 > i9) {
                        i9 = a3;
                        str2 = str4;
                    }
                }
            }
            str = str2;
        } else {
            str = null;
        }
        b(trackGroup, iArr, i2, str, i3, i4, i5, i6, a2);
        return a2.size() < 2 ? f16618a : ad.a(a2);
    }

    private static void b(TrackGroup trackGroup, int[] iArr, int i2, String str, int i3, int i4, int i5, int i6, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list2.get(size).intValue();
            TrackGroup trackGroup2 = trackGroup;
            if (!a(trackGroup.a(intValue), str, iArr[intValue], i2, i3, i4, i5, i6)) {
                list2.remove(size);
            }
        }
    }

    /* access modifiers changed from: private */
    public static int c(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        }
        if (i3 == -1) {
            return 1;
        }
        return i2 - i3;
    }

    /* access modifiers changed from: private */
    public static int d(int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        return i3 > i2 ? -1 : 0;
    }

    /* access modifiers changed from: protected */
    public Pair<e.a, d> a(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, String str) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i2 = -1;
        TrackGroup trackGroup = null;
        d dVar = null;
        for (int i3 = 0; i3 < trackGroupArray2.f16009b; i3++) {
            TrackGroup a2 = trackGroupArray2.a(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < a2.f16005a; i4++) {
                if (a(iArr2[i4], parameters2.f16645x)) {
                    d dVar2 = new d(a2.a(i4), parameters2, iArr2[i4], str);
                    if (dVar2.f16687a && (dVar == null || dVar2.compareTo(dVar) > 0)) {
                        trackGroup = a2;
                        i2 = i4;
                        dVar = dVar2;
                    }
                } else {
                    String str2 = str;
                }
            }
            String str3 = str;
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new e.a(trackGroup, i2), (d) com.google.android.exoplayer2.util.a.b(dVar));
    }

    /* access modifiers changed from: protected */
    public final Pair<ab[], e[]> a(d.a aVar, int[][][] iArr, int[] iArr2) throws ExoPlaybackException {
        Parameters parameters = this.f16620c.get();
        int a2 = aVar.a();
        e.a[] a3 = a(aVar, iArr, iArr2, parameters);
        int i2 = 0;
        while (true) {
            e.a aVar2 = null;
            if (i2 >= a2) {
                break;
            }
            if (parameters.a(i2)) {
                a3[i2] = null;
            } else {
                TrackGroupArray b2 = aVar.b(i2);
                if (parameters.a(i2, b2)) {
                    SelectionOverride b3 = parameters.b(i2, b2);
                    if (b3 != null) {
                        aVar2 = new e.a(b2.a(b3.f16647a), b3.f16648b, b3.f16650d, Integer.valueOf(b3.f16651e));
                    }
                    a3[i2] = aVar2;
                }
            }
            i2++;
        }
        e[] a4 = this.f16619b.a(a3, a());
        ab[] abVarArr = new ab[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            abVarArr[i3] = !parameters.a(i3) && (aVar.a(i3) == 6 || a4[i3] != null) ? ab.f15120a : null;
        }
        a(aVar, iArr, abVarArr, a4, parameters.f16646y);
        return Pair.create(abVarArr, a4);
    }

    /* access modifiers changed from: protected */
    public e.a a(int i2, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < trackGroupArray.f16009b; i5++) {
            TrackGroup a2 = trackGroupArray.a(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < a2.f16005a; i6++) {
                if (a(iArr2[i6], parameters.f16645x)) {
                    int i7 = (a2.a(i6).f15086c & 1) != 0 ? 2 : 1;
                    if (a(iArr2[i6], false)) {
                        i7 += 1000;
                    }
                    if (i7 > i4) {
                        trackGroup = a2;
                        i3 = i6;
                        i4 = i7;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new e.a(trackGroup, i3);
    }

    /* access modifiers changed from: protected */
    public e.a a(TrackGroupArray trackGroupArray, int[][] iArr, int i2, Parameters parameters, boolean z2) throws ExoPlaybackException {
        e.a a2 = (parameters.f16642u || parameters.f16641t || !z2) ? null : a(trackGroupArray, iArr, i2, parameters);
        return a2 == null ? a(trackGroupArray, iArr, parameters) : a2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.google.android.exoplayer2.trackselection.DefaultTrackSelector$b} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.trackselection.e.a[] a(com.google.android.exoplayer2.trackselection.d.a r22, int[][][] r23, int[] r24, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r25) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r21 = this;
            r6 = r21
            r7 = r22
            r8 = r25
            int r9 = r22.a()
            com.google.android.exoplayer2.trackselection.e$a[] r10 = new com.google.android.exoplayer2.trackselection.e.a[r9]
            r11 = 0
            r0 = 0
            r12 = 0
            r13 = 0
        L_0x0010:
            r14 = 2
            r15 = 1
            if (r12 >= r9) goto L_0x0044
            int r1 = r7.a(r12)
            if (r14 != r1) goto L_0x0041
            if (r0 != 0) goto L_0x0036
            com.google.android.exoplayer2.source.TrackGroupArray r1 = r7.b(r12)
            r2 = r23[r12]
            r3 = r24[r12]
            r5 = 1
            r0 = r21
            r4 = r25
            com.google.android.exoplayer2.trackselection.e$a r0 = r0.a((com.google.android.exoplayer2.source.TrackGroupArray) r1, (int[][]) r2, (int) r3, (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters) r4, (boolean) r5)
            r10[r12] = r0
            r0 = r10[r12]
            if (r0 == 0) goto L_0x0035
            r0 = 1
            goto L_0x0036
        L_0x0035:
            r0 = 0
        L_0x0036:
            com.google.android.exoplayer2.source.TrackGroupArray r1 = r7.b(r12)
            int r1 = r1.f16009b
            if (r1 <= 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r15 = 0
        L_0x0040:
            r13 = r13 | r15
        L_0x0041:
            int r12 = r12 + 1
            goto L_0x0010
        L_0x0044:
            r12 = -1
            r16 = 0
            r3 = r16
            r4 = r3
            r2 = -1
            r5 = 0
        L_0x004c:
            if (r5 >= r9) goto L_0x00b7
            int r0 = r7.a(r5)
            if (r15 != r0) goto L_0x00a8
            boolean r0 = r6.f16621d
            if (r0 != 0) goto L_0x005e
            if (r13 != 0) goto L_0x005b
            goto L_0x005e
        L_0x005b:
            r17 = 0
            goto L_0x0060
        L_0x005e:
            r17 = 1
        L_0x0060:
            com.google.android.exoplayer2.source.TrackGroupArray r1 = r7.b(r5)
            r18 = r23[r5]
            r19 = r24[r5]
            r0 = r21
            r14 = r2
            r2 = r18
            r15 = r3
            r3 = r19
            r20 = r4
            r4 = r25
            r19 = r5
            r5 = r17
            android.util.Pair r0 = r0.b(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00ae
            if (r15 == 0) goto L_0x008a
            java.lang.Object r1 = r0.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$b r1 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.b) r1
            int r1 = r1.compareTo(r15)
            if (r1 <= 0) goto L_0x00ae
        L_0x008a:
            if (r14 == r12) goto L_0x008e
            r10[r14] = r16
        L_0x008e:
            java.lang.Object r1 = r0.first
            com.google.android.exoplayer2.trackselection.e$a r1 = (com.google.android.exoplayer2.trackselection.e.a) r1
            r10[r19] = r1
            com.google.android.exoplayer2.source.TrackGroup r2 = r1.f16740a
            int[] r1 = r1.f16741b
            r1 = r1[r11]
            com.google.android.exoplayer2.Format r1 = r2.a((int) r1)
            java.lang.String r4 = r1.A
            java.lang.Object r0 = r0.second
            r3 = r0
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$b r3 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.b) r3
            r2 = r19
            goto L_0x00b2
        L_0x00a8:
            r14 = r2
            r15 = r3
            r20 = r4
            r19 = r5
        L_0x00ae:
            r2 = r14
            r3 = r15
            r4 = r20
        L_0x00b2:
            int r5 = r19 + 1
            r14 = 2
            r15 = 1
            goto L_0x004c
        L_0x00b7:
            r20 = r4
            r0 = r16
            r1 = -1
        L_0x00bc:
            if (r11 >= r9) goto L_0x010d
            int r2 = r7.a(r11)
            r3 = 1
            if (r2 == r3) goto L_0x0105
            r4 = 2
            if (r2 == r4) goto L_0x0102
            r5 = 3
            if (r2 == r5) goto L_0x00d8
            com.google.android.exoplayer2.source.TrackGroupArray r5 = r7.b(r11)
            r13 = r23[r11]
            com.google.android.exoplayer2.trackselection.e$a r2 = r6.a((int) r2, (com.google.android.exoplayer2.source.TrackGroupArray) r5, (int[][]) r13, (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters) r8)
            r10[r11] = r2
            goto L_0x0102
        L_0x00d8:
            com.google.android.exoplayer2.source.TrackGroupArray r2 = r7.b(r11)
            r5 = r23[r11]
            r13 = r20
            android.util.Pair r2 = r6.a((com.google.android.exoplayer2.source.TrackGroupArray) r2, (int[][]) r5, (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters) r8, (java.lang.String) r13)
            if (r2 == 0) goto L_0x0108
            if (r0 == 0) goto L_0x00f2
            java.lang.Object r5 = r2.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$d r5 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.d) r5
            int r5 = r5.compareTo(r0)
            if (r5 <= 0) goto L_0x0108
        L_0x00f2:
            if (r1 == r12) goto L_0x00f6
            r10[r1] = r16
        L_0x00f6:
            java.lang.Object r0 = r2.first
            com.google.android.exoplayer2.trackselection.e$a r0 = (com.google.android.exoplayer2.trackselection.e.a) r0
            r10[r11] = r0
            java.lang.Object r0 = r2.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$d r0 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.d) r0
            r1 = r11
            goto L_0x0108
        L_0x0102:
            r13 = r20
            goto L_0x0108
        L_0x0105:
            r13 = r20
            r4 = 2
        L_0x0108:
            int r11 = r11 + 1
            r20 = r13
            goto L_0x00bc
        L_0x010d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a(com.google.android.exoplayer2.trackselection.d$a, int[][][], int[], com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.google.android.exoplayer2.trackselection.e$a[]");
    }

    /* access modifiers changed from: protected */
    public Pair<e.a, b> b(TrackGroupArray trackGroupArray, int[][] iArr, int i2, Parameters parameters, boolean z2) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        e.a aVar = null;
        b bVar = null;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < trackGroupArray2.f16009b; i5++) {
            TrackGroup a2 = trackGroupArray2.a(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < a2.f16005a; i6++) {
                if (a(iArr2[i6], parameters2.f16645x)) {
                    b bVar2 = new b(a2.a(i6), parameters2, iArr2[i6]);
                    if ((bVar2.f16655a || parameters2.f16637p) && (bVar == null || bVar2.compareTo(bVar) > 0)) {
                        i3 = i5;
                        i4 = i6;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        TrackGroup a3 = trackGroupArray2.a(i3);
        if (!parameters2.f16642u && !parameters2.f16641t && z2) {
            int[] a4 = a(a3, iArr[i3], parameters2.f16636o, parameters2.f16638q, parameters2.f16639r, parameters2.f16640s);
            if (a4.length > 0) {
                aVar = new e.a(a3, a4);
            }
        }
        if (aVar == null) {
            aVar = new e.a(a3, i4);
        }
        return Pair.create(aVar, (b) com.google.android.exoplayer2.util.a.b(bVar));
    }
}
