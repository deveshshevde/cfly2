package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() {
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: a */
        public PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f396a;

    /* renamed from: b  reason: collision with root package name */
    final long f397b;

    /* renamed from: c  reason: collision with root package name */
    final long f398c;

    /* renamed from: d  reason: collision with root package name */
    final float f399d;

    /* renamed from: e  reason: collision with root package name */
    final long f400e;

    /* renamed from: f  reason: collision with root package name */
    final int f401f;

    /* renamed from: g  reason: collision with root package name */
    final CharSequence f402g;

    /* renamed from: h  reason: collision with root package name */
    final long f403h;

    /* renamed from: i  reason: collision with root package name */
    List<CustomAction> f404i;

    /* renamed from: j  reason: collision with root package name */
    final long f405j;

    /* renamed from: k  reason: collision with root package name */
    final Bundle f406k;

    /* renamed from: l  reason: collision with root package name */
    private Object f407l;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() {
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: a */
            public CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final String f408a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f409b;

        /* renamed from: c  reason: collision with root package name */
        private final int f410c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f411d;

        /* renamed from: e  reason: collision with root package name */
        private Object f412e;

        CustomAction(Parcel parcel) {
            this.f408a = parcel.readString();
            this.f409b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f410c = parcel.readInt();
            this.f411d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.f408a = str;
            this.f409b = charSequence;
            this.f410c = i2;
            this.f411d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(e.a.a(obj), e.a.b(obj), e.a.c(obj), e.a.d(obj));
            customAction.f412e = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f409b + ", mIcon=" + this.f410c + ", mExtras=" + this.f411d;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f408a);
            TextUtils.writeToParcel(this.f409b, parcel, i2);
            parcel.writeInt(this.f410c);
            parcel.writeBundle(this.f411d);
        }
    }

    PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.f396a = i2;
        this.f397b = j2;
        this.f398c = j3;
        this.f399d = f2;
        this.f400e = j4;
        this.f401f = i3;
        this.f402g = charSequence;
        this.f403h = j5;
        this.f404i = new ArrayList(list);
        this.f405j = j6;
        this.f406k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f396a = parcel.readInt();
        this.f397b = parcel.readLong();
        this.f399d = parcel.readFloat();
        this.f403h = parcel.readLong();
        this.f398c = parcel.readLong();
        this.f400e = parcel.readLong();
        this.f402g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f404i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f405j = parcel.readLong();
        this.f406k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f401f = parcel.readInt();
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        Object obj2 = obj;
        Bundle bundle = null;
        if (obj2 == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> h2 = e.h(obj);
        if (h2 != null) {
            ArrayList arrayList2 = new ArrayList(h2.size());
            for (Object a2 : h2) {
                arrayList2.add(CustomAction.a(a2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = f.a(obj);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(e.a(obj), e.b(obj), e.c(obj), e.d(obj), e.e(obj), 0, e.f(obj), e.g(obj), arrayList, e.i(obj), bundle);
        playbackStateCompat.f407l = obj2;
        return playbackStateCompat;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f396a + ", position=" + this.f397b + ", buffered position=" + this.f398c + ", speed=" + this.f399d + ", updated=" + this.f403h + ", actions=" + this.f400e + ", error code=" + this.f401f + ", error message=" + this.f402g + ", custom actions=" + this.f404i + ", active item id=" + this.f405j + "}";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f396a);
        parcel.writeLong(this.f397b);
        parcel.writeFloat(this.f399d);
        parcel.writeLong(this.f403h);
        parcel.writeLong(this.f398c);
        parcel.writeLong(this.f400e);
        TextUtils.writeToParcel(this.f402g, parcel, i2);
        parcel.writeTypedList(this.f404i);
        parcel.writeLong(this.f405j);
        parcel.writeBundle(this.f406k);
        parcel.writeInt(this.f401f);
    }
}
