package ez;

import java.text.DecimalFormat;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    protected DecimalFormat f27005a;

    /* renamed from: b  reason: collision with root package name */
    protected int f27006b;

    public a(int i2) {
        this.f27006b = i2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f27005a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public int a() {
        return this.f27006b;
    }

    public String a(float f2) {
        return this.f27005a.format((double) f2);
    }
}
