package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.s;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: a */
        public BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int[] f3135a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<String> f3136b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f3137c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f3138d;

    /* renamed from: e  reason: collision with root package name */
    final int f3139e;

    /* renamed from: f  reason: collision with root package name */
    final String f3140f;

    /* renamed from: g  reason: collision with root package name */
    final int f3141g;

    /* renamed from: h  reason: collision with root package name */
    final int f3142h;

    /* renamed from: i  reason: collision with root package name */
    final CharSequence f3143i;

    /* renamed from: j  reason: collision with root package name */
    final int f3144j;

    /* renamed from: k  reason: collision with root package name */
    final CharSequence f3145k;

    /* renamed from: l  reason: collision with root package name */
    final ArrayList<String> f3146l;

    /* renamed from: m  reason: collision with root package name */
    final ArrayList<String> f3147m;

    /* renamed from: n  reason: collision with root package name */
    final boolean f3148n;

    public BackStackState(Parcel parcel) {
        this.f3135a = parcel.createIntArray();
        this.f3136b = parcel.createStringArrayList();
        this.f3137c = parcel.createIntArray();
        this.f3138d = parcel.createIntArray();
        this.f3139e = parcel.readInt();
        this.f3140f = parcel.readString();
        this.f3141g = parcel.readInt();
        this.f3142h = parcel.readInt();
        this.f3143i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3144j = parcel.readInt();
        this.f3145k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3146l = parcel.createStringArrayList();
        this.f3147m = parcel.createStringArrayList();
        this.f3148n = parcel.readInt() != 0;
    }

    public BackStackState(a aVar) {
        int size = aVar.f3427d.size();
        this.f3135a = new int[(size * 5)];
        if (aVar.f3433j) {
            this.f3136b = new ArrayList<>(size);
            this.f3137c = new int[size];
            this.f3138d = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                s.a aVar2 = (s.a) aVar.f3427d.get(i2);
                int i4 = i3 + 1;
                this.f3135a[i3] = aVar2.f3444a;
                this.f3136b.add(aVar2.f3445b != null ? aVar2.f3445b.mWho : null);
                int i5 = i4 + 1;
                this.f3135a[i4] = aVar2.f3446c;
                int i6 = i5 + 1;
                this.f3135a[i5] = aVar2.f3447d;
                int i7 = i6 + 1;
                this.f3135a[i6] = aVar2.f3448e;
                this.f3135a[i7] = aVar2.f3449f;
                this.f3137c[i2] = aVar2.f3450g.ordinal();
                this.f3138d[i2] = aVar2.f3451h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f3139e = aVar.f3432i;
            this.f3140f = aVar.f3435l;
            this.f3141g = aVar.f3318c;
            this.f3142h = aVar.f3436m;
            this.f3143i = aVar.f3437n;
            this.f3144j = aVar.f3438o;
            this.f3145k = aVar.f3439p;
            this.f3146l = aVar.f3440q;
            this.f3147m = aVar.f3441r;
            this.f3148n = aVar.f3442s;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public a a(FragmentManager fragmentManager) {
        a aVar = new a(fragmentManager);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f3135a.length) {
            s.a aVar2 = new s.a();
            int i4 = i2 + 1;
            aVar2.f3444a = this.f3135a[i2];
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i3 + " base fragment #" + this.f3135a[i4]);
            }
            String str = this.f3136b.get(i3);
            aVar2.f3445b = str != null ? fragmentManager.d(str) : null;
            aVar2.f3450g = Lifecycle.State.values()[this.f3137c[i3]];
            aVar2.f3451h = Lifecycle.State.values()[this.f3138d[i3]];
            int i5 = i4 + 1;
            aVar2.f3446c = this.f3135a[i4];
            int i6 = i5 + 1;
            aVar2.f3447d = this.f3135a[i5];
            int i7 = i6 + 1;
            aVar2.f3448e = this.f3135a[i6];
            aVar2.f3449f = this.f3135a[i7];
            aVar.f3428e = aVar2.f3446c;
            aVar.f3429f = aVar2.f3447d;
            aVar.f3430g = aVar2.f3448e;
            aVar.f3431h = aVar2.f3449f;
            aVar.a(aVar2);
            i3++;
            i2 = i7 + 1;
        }
        aVar.f3432i = this.f3139e;
        aVar.f3435l = this.f3140f;
        aVar.f3318c = this.f3141g;
        aVar.f3433j = true;
        aVar.f3436m = this.f3142h;
        aVar.f3437n = this.f3143i;
        aVar.f3438o = this.f3144j;
        aVar.f3439p = this.f3145k;
        aVar.f3440q = this.f3146l;
        aVar.f3441r = this.f3147m;
        aVar.f3442s = this.f3148n;
        aVar.a(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f3135a);
        parcel.writeStringList(this.f3136b);
        parcel.writeIntArray(this.f3137c);
        parcel.writeIntArray(this.f3138d);
        parcel.writeInt(this.f3139e);
        parcel.writeString(this.f3140f);
        parcel.writeInt(this.f3141g);
        parcel.writeInt(this.f3142h);
        TextUtils.writeToParcel(this.f3143i, parcel, 0);
        parcel.writeInt(this.f3144j);
        TextUtils.writeToParcel(this.f3145k, parcel, 0);
        parcel.writeStringList(this.f3146l);
        parcel.writeStringList(this.f3147m);
        parcel.writeInt(this.f3148n ? 1 : 0);
    }
}
