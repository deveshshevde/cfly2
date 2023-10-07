package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import j.a;
import java.lang.reflect.Method;

class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f4899d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f4900e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4901f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4902g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4903h;

    /* renamed from: i  reason: collision with root package name */
    private int f4904i;

    /* renamed from: j  reason: collision with root package name */
    private int f4905j;

    /* renamed from: k  reason: collision with root package name */
    private int f4906k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    private b(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f4899d = new SparseIntArray();
        this.f4904i = -1;
        this.f4905j = 0;
        this.f4906k = -1;
        this.f4900e = parcel;
        this.f4901f = i2;
        this.f4902g = i3;
        this.f4905j = i2;
        this.f4903h = str;
    }

    public void a(int i2) {
        this.f4900e.writeInt(i2);
    }

    public void a(Parcelable parcelable) {
        this.f4900e.writeParcelable(parcelable, 0);
    }

    /* access modifiers changed from: protected */
    public void a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f4900e, 0);
    }

    public void a(String str) {
        this.f4900e.writeString(str);
    }

    public void a(boolean z2) {
        this.f4900e.writeInt(z2 ? 1 : 0);
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f4900e.writeInt(bArr.length);
            this.f4900e.writeByteArray(bArr);
            return;
        }
        this.f4900e.writeInt(-1);
    }

    public void b() {
        int i2 = this.f4904i;
        if (i2 >= 0) {
            int i3 = this.f4899d.get(i2);
            int dataPosition = this.f4900e.dataPosition();
            this.f4900e.setDataPosition(i3);
            this.f4900e.writeInt(dataPosition - i3);
            this.f4900e.setDataPosition(dataPosition);
        }
    }

    public boolean b(int i2) {
        while (this.f4905j < this.f4902g) {
            int i3 = this.f4906k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f4900e.setDataPosition(this.f4905j);
            int readInt = this.f4900e.readInt();
            this.f4906k = this.f4900e.readInt();
            this.f4905j += readInt;
        }
        return this.f4906k == i2;
    }

    /* access modifiers changed from: protected */
    public a c() {
        Parcel parcel = this.f4900e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f4905j;
        if (i2 == this.f4901f) {
            i2 = this.f4902g;
        }
        int i3 = i2;
        return new b(parcel, dataPosition, i3, this.f4903h + "  ", this.f4896a, this.f4897b, this.f4898c);
    }

    public void c(int i2) {
        b();
        this.f4904i = i2;
        this.f4899d.put(i2, this.f4900e.dataPosition());
        a(0);
        a(i2);
    }

    public int d() {
        return this.f4900e.readInt();
    }

    public String e() {
        return this.f4900e.readString();
    }

    public byte[] f() {
        int readInt = this.f4900e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f4900e.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public CharSequence g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f4900e);
    }

    public <T extends Parcelable> T h() {
        return this.f4900e.readParcelable(getClass().getClassLoader());
    }

    public boolean i() {
        return this.f4900e.readInt() != 0;
    }
}
