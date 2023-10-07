package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new Parcelable.Creator<IntentSenderRequest>() {
        /* renamed from: a */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        /* renamed from: a */
        public IntentSenderRequest[] newArray(int i2) {
            return new IntentSenderRequest[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final IntentSender f460a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f461b;

    /* renamed from: c  reason: collision with root package name */
    private final int f462c;

    /* renamed from: d  reason: collision with root package name */
    private final int f463d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private IntentSender f464a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f465b;

        /* renamed from: c  reason: collision with root package name */
        private int f466c;

        /* renamed from: d  reason: collision with root package name */
        private int f467d;

        public a(IntentSender intentSender) {
            this.f464a = intentSender;
        }

        public a a(int i2, int i3) {
            this.f467d = i2;
            this.f466c = i3;
            return this;
        }

        public a a(Intent intent) {
            this.f465b = intent;
            return this;
        }

        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.f464a, this.f465b, this.f466c, this.f467d);
        }
    }

    IntentSenderRequest(IntentSender intentSender, Intent intent, int i2, int i3) {
        this.f460a = intentSender;
        this.f461b = intent;
        this.f462c = i2;
        this.f463d = i3;
    }

    IntentSenderRequest(Parcel parcel) {
        this.f460a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f461b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f462c = parcel.readInt();
        this.f463d = parcel.readInt();
    }

    public IntentSender a() {
        return this.f460a;
    }

    public Intent b() {
        return this.f461b;
    }

    public int c() {
        return this.f462c;
    }

    public int d() {
        return this.f463d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f460a, i2);
        parcel.writeParcelable(this.f461b, i2);
        parcel.writeInt(this.f462c);
        parcel.writeInt(this.f463d);
    }
}
