package ft;

import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.util.k;
import fj.f;
import fj.u;
import ft.e;

public final class c implements e.b {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f28048a;

    /* renamed from: b  reason: collision with root package name */
    private final n[] f28049b;

    public c(int[] iArr, n[] nVarArr) {
        this.f28048a = iArr;
        this.f28049b = nVarArr;
    }

    public u a(int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = this.f28048a;
            if (i4 >= iArr.length) {
                StringBuilder sb = new StringBuilder(36);
                sb.append("Unmatched track of type: ");
                sb.append(i3);
                k.d("BaseMediaChunkOutput", sb.toString());
                return new f();
            } else if (i3 == iArr[i4]) {
                return this.f28049b[i4];
            } else {
                i4++;
            }
        }
    }

    public void a(long j2) {
        for (n nVar : this.f28049b) {
            if (nVar != null) {
                nVar.b(j2);
            }
        }
    }

    public int[] a() {
        int[] iArr = new int[this.f28049b.length];
        int i2 = 0;
        while (true) {
            n[] nVarArr = this.f28049b;
            if (i2 >= nVarArr.length) {
                return iArr;
            }
            if (nVarArr[i2] != null) {
                iArr[i2] = nVarArr[i2].d();
            }
            i2++;
        }
    }
}
