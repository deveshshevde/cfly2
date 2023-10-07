package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.d;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: a */
            public QueueItem[] newArray(int i2) {
                return new QueueItem[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final MediaDescriptionCompat f384a;

        /* renamed from: b  reason: collision with root package name */
        private final long f385b;

        /* renamed from: c  reason: collision with root package name */
        private Object f386c;

        QueueItem(Parcel parcel) {
            this.f384a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f385b = parcel.readLong();
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j2 != -1) {
                this.f384a = mediaDescriptionCompat;
                this.f385b = j2;
                this.f386c = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public static QueueItem a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.a(d.a.a(obj)), d.a.b(obj));
        }

        public static List<QueueItem> a(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object a2 : list) {
                arrayList.add(a((Object) a2));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f384a + ", Id=" + this.f385b + " }";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.f384a.writeToParcel(parcel, i2);
            parcel.writeLong(this.f385b);
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: a */
            public ResultReceiverWrapper[] newArray(int i2) {
                return new ResultReceiverWrapper[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        ResultReceiver f387a;

        ResultReceiverWrapper(Parcel parcel) {
            this.f387a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.f387a.writeToParcel(parcel, i2);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                return new Token(Build.VERSION.SDK_INT >= 21 ? parcel.readParcelable((ClassLoader) null) : parcel.readStrongBinder());
            }

            /* renamed from: a */
            public Token[] newArray(int i2) {
                return new Token[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final Object f388a;

        /* renamed from: b  reason: collision with root package name */
        private b f389b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f390c;

        Token(Object obj) {
            this(obj, (b) null, (Bundle) null);
        }

        Token(Object obj, b bVar) {
            this(obj, bVar, (Bundle) null);
        }

        Token(Object obj, b bVar, Bundle bundle) {
            this.f388a = obj;
            this.f389b = bVar;
            this.f390c = bundle;
        }

        public static Token a(Object obj) {
            return a(obj, (b) null);
        }

        public static Token a(Object obj, b bVar) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(d.a(obj), bVar);
        }

        public Object a() {
            return this.f388a;
        }

        public void a(Bundle bundle) {
            this.f390c = bundle;
        }

        public void a(b bVar) {
            this.f389b = bVar;
        }

        public b b() {
            return this.f389b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Object obj2 = this.f388a;
            Object obj3 = ((Token) obj).f388a;
            if (obj2 == null) {
                return obj3 == null;
            }
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f388a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f388a, i2);
            } else {
                parcel.writeStrongBinder((IBinder) this.f388a);
            }
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }
}
