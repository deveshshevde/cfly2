package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.a(a.a(parcel));
        }

        /* renamed from: a */
        public MediaDescriptionCompat[] newArray(int i2) {
            return new MediaDescriptionCompat[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String f337a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f338b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f339c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f340d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f341e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f342f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f343g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f344h;

    /* renamed from: i  reason: collision with root package name */
    private Object f345i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f346a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f347b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f348c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f349d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f350e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f351f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f352g;

        /* renamed from: h  reason: collision with root package name */
        private Uri f353h;

        public a a(Bitmap bitmap) {
            this.f350e = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f351f = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.f352g = bundle;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f347b = charSequence;
            return this;
        }

        public a a(String str) {
            this.f346a = str;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f346a, this.f347b, this.f348c, this.f349d, this.f350e, this.f351f, this.f352g, this.f353h);
        }

        public a b(Uri uri) {
            this.f353h = uri;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f348c = charSequence;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f349d = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f337a = parcel.readString();
        this.f338b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f339c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f340d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.f341e = (Bitmap) parcel.readParcelable(classLoader);
        this.f342f = (Uri) parcel.readParcelable(classLoader);
        this.f343g = parcel.readBundle(classLoader);
        this.f344h = (Uri) parcel.readParcelable(classLoader);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f337a = str;
        this.f338b = charSequence;
        this.f339c = charSequence2;
        this.f340d = charSequence3;
        this.f341e = bitmap;
        this.f342f = uri;
        this.f343g = bundle;
        this.f344h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0080
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x0080
            android.support.v4.media.MediaDescriptionCompat$a r1 = new android.support.v4.media.MediaDescriptionCompat$a
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.a.a((java.lang.Object) r8)
            r1.a((java.lang.String) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.b(r8)
            r1.a((java.lang.CharSequence) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.c(r8)
            r1.b((java.lang.CharSequence) r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.d(r8)
            r1.c(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.a.e(r8)
            r1.a((android.graphics.Bitmap) r2)
            android.net.Uri r2 = android.support.v4.media.a.f(r8)
            r1.a((android.net.Uri) r2)
            android.os.Bundle r2 = android.support.v4.media.a.g(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L_0x004a
            android.support.v4.media.session.MediaSessionCompat.a(r2)
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            goto L_0x004b
        L_0x004a:
            r4 = r0
        L_0x004b:
            if (r4 == 0) goto L_0x0063
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L_0x005d
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L_0x005d
            goto L_0x0064
        L_0x005d:
            r2.remove(r3)
            r2.remove(r5)
        L_0x0063:
            r0 = r2
        L_0x0064:
            r1.a((android.os.Bundle) r0)
            if (r4 == 0) goto L_0x006d
            r1.b((android.net.Uri) r4)
            goto L_0x007a
        L_0x006d:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L_0x007a
            android.net.Uri r0 = android.support.v4.media.b.a(r8)
            r1.b((android.net.Uri) r0)
        L_0x007a:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.f345i = r8
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public String a() {
        return this.f337a;
    }

    public Object b() {
        if (this.f345i != null || Build.VERSION.SDK_INT < 21) {
            return this.f345i;
        }
        Object a2 = a.C0008a.a();
        a.C0008a.a(a2, this.f337a);
        a.C0008a.a(a2, this.f338b);
        a.C0008a.b(a2, this.f339c);
        a.C0008a.c(a2, this.f340d);
        a.C0008a.a(a2, this.f341e);
        a.C0008a.a(a2, this.f342f);
        Bundle bundle = this.f343g;
        if (Build.VERSION.SDK_INT < 23 && this.f344h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f344h);
        }
        a.C0008a.a(a2, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            b.a.a(a2, this.f344h);
        }
        Object a3 = a.C0008a.a(a2);
        this.f345i = a3;
        return a3;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f338b + ", " + this.f339c + ", " + this.f340d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f337a);
            TextUtils.writeToParcel(this.f338b, parcel, i2);
            TextUtils.writeToParcel(this.f339c, parcel, i2);
            TextUtils.writeToParcel(this.f340d, parcel, i2);
            parcel.writeParcelable(this.f341e, i2);
            parcel.writeParcelable(this.f342f, i2);
            parcel.writeBundle(this.f343g);
            parcel.writeParcelable(this.f344h, i2);
            return;
        }
        a.a(b(), parcel, i2);
    }
}
