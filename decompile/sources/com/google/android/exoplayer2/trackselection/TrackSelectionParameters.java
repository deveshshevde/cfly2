package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.ad;
import java.util.Locale;

public class TrackSelectionParameters implements Parcelable {
    @Deprecated
    public static final TrackSelectionParameters A;
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR = new Parcelable.Creator<TrackSelectionParameters>() {
        /* renamed from: a */
        public TrackSelectionParameters createFromParcel(Parcel parcel) {
            return new TrackSelectionParameters(parcel);
        }

        /* renamed from: a */
        public TrackSelectionParameters[] newArray(int i2) {
            return new TrackSelectionParameters[i2];
        }
    };

    /* renamed from: z  reason: collision with root package name */
    public static final TrackSelectionParameters f16695z;
    public final String B;
    public final String C;
    public final int D;
    public final boolean E;
    public final int F;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f16696a;

        /* renamed from: b  reason: collision with root package name */
        String f16697b;

        /* renamed from: c  reason: collision with root package name */
        int f16698c;

        /* renamed from: d  reason: collision with root package name */
        boolean f16699d;

        /* renamed from: e  reason: collision with root package name */
        int f16700e;

        @Deprecated
        public a() {
            this.f16696a = null;
            this.f16697b = null;
            this.f16698c = 0;
            this.f16699d = false;
            this.f16700e = 0;
        }

        public a(Context context) {
            this();
            b(context);
        }

        private void a(Context context) {
            CaptioningManager captioningManager;
            if ((ad.f11755a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f16698c = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f16697b = ad.a(locale);
                }
            }
        }

        public a b(Context context) {
            if (ad.f11755a >= 19) {
                a(context);
            }
            return this;
        }

        public TrackSelectionParameters b() {
            return new TrackSelectionParameters(this.f16696a, this.f16697b, this.f16698c, this.f16699d, this.f16700e);
        }
    }

    static {
        TrackSelectionParameters b2 = new a().b();
        f16695z = b2;
        A = b2;
    }

    TrackSelectionParameters(Parcel parcel) {
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readInt();
        this.E = ad.a(parcel);
        this.F = parcel.readInt();
    }

    TrackSelectionParameters(String str, String str2, int i2, boolean z2, int i3) {
        this.B = ad.b(str);
        this.C = ad.b(str2);
        this.D = i2;
        this.E = z2;
        this.F = i3;
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
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return TextUtils.equals(this.B, trackSelectionParameters.B) && TextUtils.equals(this.C, trackSelectionParameters.C) && this.D == trackSelectionParameters.D && this.E == trackSelectionParameters.E && this.F == trackSelectionParameters.F;
    }

    public int hashCode() {
        String str = this.B;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.C;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((((((hashCode + i2) * 31) + this.D) * 31) + (this.E ? 1 : 0)) * 31) + this.F;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeInt(this.D);
        ad.a(parcel, this.E);
        parcel.writeInt(this.F);
    }
}
