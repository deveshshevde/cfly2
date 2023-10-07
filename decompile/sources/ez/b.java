package ez;

import java.text.DecimalFormat;

public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    protected DecimalFormat f27007a;

    /* renamed from: b  reason: collision with root package name */
    protected int f27008b;

    public b(int i2) {
        a(i2);
    }

    public String a(float f2) {
        return this.f27007a.format((double) f2);
    }

    public void a(int i2) {
        this.f27008b = i2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f27007a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }
}
