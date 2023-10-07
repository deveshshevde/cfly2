package fg;

import android.os.Parcel;
import android.os.Parcelable;
import fg.f;

public class e extends f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final Parcelable.Creator<e> f27220c = new Parcelable.Creator<e>() {
        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            e eVar = new e(0.0f, 0.0f);
            eVar.a(parcel);
            return eVar;
        }

        /* renamed from: a */
        public e[] newArray(int i2) {
            return new e[i2];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static f<e> f27221f;

    /* renamed from: a  reason: collision with root package name */
    public float f27222a;

    /* renamed from: b  reason: collision with root package name */
    public float f27223b;

    static {
        f<e> a2 = f.a(32, new e(0.0f, 0.0f));
        f27221f = a2;
        a2.a(0.5f);
    }

    public e() {
    }

    public e(float f2, float f3) {
        this.f27222a = f2;
        this.f27223b = f3;
    }

    public static e a(float f2, float f3) {
        e a2 = f27221f.a();
        a2.f27222a = f2;
        a2.f27223b = f3;
        return a2;
    }

    public static e a(e eVar) {
        e a2 = f27221f.a();
        a2.f27222a = eVar.f27222a;
        a2.f27223b = eVar.f27223b;
        return a2;
    }

    public static e b() {
        return f27221f.a();
    }

    public static void b(e eVar) {
        f27221f.a(eVar);
    }

    /* access modifiers changed from: protected */
    public f.a a() {
        return new e(0.0f, 0.0f);
    }

    public void a(Parcel parcel) {
        this.f27222a = parcel.readFloat();
        this.f27223b = parcel.readFloat();
    }
}
