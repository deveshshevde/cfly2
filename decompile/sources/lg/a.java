package lg;

import android.graphics.Typeface;
import android.widget.TextView;
import com.xeagle.android.widgets.checklist.row.ListRow_Type;
import com.xeagle.android.widgets.checklist.row.b;
import com.xeagle.android.widgets.checklist.row.d;

public class a extends lh.a implements d.a {

    /* renamed from: e  reason: collision with root package name */
    private C0217a f30816e;

    /* renamed from: lg.a$a  reason: collision with other inner class name */
    public interface C0217a {
        void a(b bVar);

        void a(b bVar, String str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: com.xeagle.android.widgets.checklist.row.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: com.xeagle.android.widgets.checklist.row.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: com.xeagle.android.widgets.checklist.row.j} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: com.xeagle.android.widgets.checklist.row.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: com.xeagle.android.widgets.checklist.row.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: com.xeagle.android.widgets.checklist.row.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: com.xeagle.android.widgets.checklist.row.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: com.xeagle.android.widgets.checklist.row.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: com.xeagle.android.widgets.checklist.row.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: com.xeagle.android.widgets.checklist.row.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: com.xeagle.android.widgets.checklist.row.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: com.xeagle.android.widgets.checklist.row.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: com.xeagle.android.widgets.checklist.row.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: com.xeagle.android.widgets.checklist.row.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: com.xeagle.android.widgets.checklist.row.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: com.xeagle.android.widgets.checklist.row.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.view.LayoutInflater r6, java.util.List<java.lang.String> r7, java.util.HashMap<java.lang.String, java.util.List<lg.b>> r8) {
        /*
            r5 = this;
            r5.<init>(r6, r7)
            r6 = 2131493207(0x7f0c0157, float:1.8609888E38)
            r5.b(r6)
            java.util.Iterator r6 = r7.iterator()
        L_0x000d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00f5
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Object r1 = r8.get(r7)
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0028:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00ee
            java.lang.Object r2 = r1.next()
            lg.b r2 = (lg.b) r2
            java.lang.String r3 = r2.r()
            java.lang.String r4 = "check_item"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x004e
            com.xeagle.android.widgets.checklist.row.c r3 = new com.xeagle.android.widgets.checklist.row.c
            android.view.LayoutInflater r4 = r5.f30841a
            r3.<init>(r4, r2)
            r3.a((com.xeagle.android.widgets.checklist.row.d.a) r5)
        L_0x004a:
            r0.add(r3)
            goto L_0x0028
        L_0x004e:
            java.lang.String r3 = r2.r()
            java.lang.String r4 = "value_item"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0065
            com.xeagle.android.widgets.checklist.row.k r3 = new com.xeagle.android.widgets.checklist.row.k
            android.view.LayoutInflater r4 = r5.f30841a
            r3.<init>(r4, r2)
            r3.a((com.xeagle.android.widgets.checklist.row.d.a) r5)
            goto L_0x004a
        L_0x0065:
            java.lang.String r3 = r2.r()
            java.lang.String r4 = "radio_item"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x007c
            com.xeagle.android.widgets.checklist.row.g r3 = new com.xeagle.android.widgets.checklist.row.g
            android.view.LayoutInflater r4 = r5.f30841a
            r3.<init>(r4, r2)
            r3.a((com.xeagle.android.widgets.checklist.row.d.a) r5)
            goto L_0x004a
        L_0x007c:
            java.lang.String r3 = r2.r()
            java.lang.String r4 = "select_item"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0093
            com.xeagle.android.widgets.checklist.row.h r3 = new com.xeagle.android.widgets.checklist.row.h
            android.view.LayoutInflater r4 = r5.f30841a
            r3.<init>(r4, r2)
            r3.a((com.xeagle.android.widgets.checklist.row.d.a) r5)
            goto L_0x004a
        L_0x0093:
            java.lang.String r3 = r2.r()
            java.lang.String r4 = "toggle_item"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x00aa
            com.xeagle.android.widgets.checklist.row.j r3 = new com.xeagle.android.widgets.checklist.row.j
            android.view.LayoutInflater r4 = r5.f30841a
            r3.<init>(r4, r2)
            r3.a((com.xeagle.android.widgets.checklist.row.d.a) r5)
            goto L_0x004a
        L_0x00aa:
            java.lang.String r3 = r2.r()
            java.lang.String r4 = "switch_item"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x00c1
            com.xeagle.android.widgets.checklist.row.i r3 = new com.xeagle.android.widgets.checklist.row.i
            android.view.LayoutInflater r4 = r5.f30841a
            r3.<init>(r4, r2)
            r3.a((com.xeagle.android.widgets.checklist.row.d.a) r5)
            goto L_0x004a
        L_0x00c1:
            java.lang.String r3 = r2.r()
            java.lang.String r4 = "level_item"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x00d9
            com.xeagle.android.widgets.checklist.row.e r3 = new com.xeagle.android.widgets.checklist.row.e
            android.view.LayoutInflater r4 = r5.f30841a
            r3.<init>(r4, r2)
            r3.a((com.xeagle.android.widgets.checklist.row.d.a) r5)
            goto L_0x004a
        L_0x00d9:
            java.lang.String r3 = r2.r()
            java.lang.String r4 = "note_item"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0028
            com.xeagle.android.widgets.checklist.row.f r3 = new com.xeagle.android.widgets.checklist.row.f
            android.view.LayoutInflater r4 = r5.f30841a
            r3.<init>(r4, r2)
            goto L_0x004a
        L_0x00ee:
            java.util.HashMap r1 = r5.f30843c
            r1.put(r7, r0)
            goto L_0x000d
        L_0x00f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lg.a.<init>(android.view.LayoutInflater, java.util.List, java.util.HashMap):void");
    }

    private int c(int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildrenCount(i2); i4++) {
            if (((b) getChild(i2, i4)).b().o()) {
                i3++;
            }
        }
        return i3;
    }

    private int d(int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildrenCount(i2); i4++) {
            if (((b) getChild(i2, i4)).b().e()) {
                i3++;
            }
        }
        return i3;
    }

    public void a(TextView textView, int i2) {
        int childrenCount = getChildrenCount(i2);
        int c2 = c(i2);
        int d2 = d(i2);
        textView.setTextColor(c2 < d2 ? -456387 : -16123587);
        textView.setTypeface((Typeface) null, 1);
        textView.setText(String.format("%d/%d [%d]", new Object[]{Integer.valueOf(c2), Integer.valueOf(childrenCount), Integer.valueOf(d2)}));
    }

    public void a(C0217a aVar) {
        this.f30816e = aVar;
    }

    public void a(b bVar) {
        C0217a aVar = this.f30816e;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    public void a(b bVar, String str) {
        C0217a aVar = this.f30816e;
        if (aVar != null) {
            aVar.a(bVar, str);
        }
    }

    public boolean a(int i2) {
        return c(i2) >= d(i2);
    }

    public int getChildTypeCount() {
        return ListRow_Type.values().length;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i2, int i3) {
        return true;
    }
}
