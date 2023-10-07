package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.tools.c;

public class al extends c {

    /* renamed from: j  reason: collision with root package name */
    protected List<c> f33331j = new LinkedList();

    /* renamed from: k  reason: collision with root package name */
    protected d f33332k = d.a();

    public al(y yVar) {
        super(yVar);
    }

    /* access modifiers changed from: protected */
    public void a(StringBuilder sb) {
        sb.append("{\"tag\":\"" + this.f33452i.b() + "\",");
        ArrayList arrayList = new ArrayList(0);
        a(getClass(), arrayList);
        c.a((Object) this, sb, (String[]) arrayList.toArray(new String[0]));
        sb.append("\"boxes\": [");
        b(sb);
        sb.append("]");
        sb.append("}");
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        for (c b2 : this.f33331j) {
            b2.b(byteBuffer);
        }
    }

    public void a(aj ajVar) {
        this.f33331j.add(0, ajVar);
    }

    public void a(c cVar) {
        this.f33331j.add(cVar);
    }

    public List<c> b() {
        return this.f33331j;
    }

    /* access modifiers changed from: protected */
    public void b(StringBuilder sb) {
        for (int i2 = 0; i2 < this.f33331j.size(); i2++) {
            this.f33331j.get(i2).a(sb);
            if (i2 < this.f33331j.size() - 1) {
                sb.append(",");
            }
        }
    }
}
