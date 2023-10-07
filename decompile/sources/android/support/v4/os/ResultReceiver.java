package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.a;

public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() {
        /* renamed from: a */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* renamed from: a */
        public ResultReceiver[] newArray(int i2) {
            return new ResultReceiver[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final boolean f416a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f417b = null;

    /* renamed from: c  reason: collision with root package name */
    a f418c;

    class a extends a.C0014a {
        a() {
        }

        public void a(int i2, Bundle bundle) {
            if (ResultReceiver.this.f417b != null) {
                ResultReceiver.this.f417b.post(new b(i2, bundle));
            } else {
                ResultReceiver.this.a(i2, bundle);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f420a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f421b;

        b(int i2, Bundle bundle) {
            this.f420a = i2;
            this.f421b = bundle;
        }

        public void run() {
            ResultReceiver.this.a(this.f420a, this.f421b);
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f418c = a.C0014a.a(parcel.readStrongBinder());
    }

    /* access modifiers changed from: protected */
    public void a(int i2, Bundle bundle) {
    }

    public void b(int i2, Bundle bundle) {
        if (this.f416a) {
            Handler handler = this.f417b;
            if (handler != null) {
                handler.post(new b(i2, bundle));
            } else {
                a(i2, bundle);
            }
        } else {
            a aVar = this.f418c;
            if (aVar != null) {
                try {
                    aVar.a(i2, bundle);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            if (this.f418c == null) {
                this.f418c = new a();
            }
            parcel.writeStrongBinder(this.f418c.asBinder());
        }
    }
}
