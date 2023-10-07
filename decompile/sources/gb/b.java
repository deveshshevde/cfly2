package gb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.util.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f28379a;

    /* renamed from: b  reason: collision with root package name */
    public final String f28380b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f28381c;

    /* renamed from: d  reason: collision with root package name */
    public final long f28382d;

    /* renamed from: e  reason: collision with root package name */
    public final long f28383e;

    /* renamed from: f  reason: collision with root package name */
    public final e f28384f;

    /* renamed from: g  reason: collision with root package name */
    public final String f28385g;

    /* renamed from: h  reason: collision with root package name */
    public final String f28386h;

    /* renamed from: i  reason: collision with root package name */
    private final String[] f28387i;

    /* renamed from: j  reason: collision with root package name */
    private final HashMap<String, Integer> f28388j;

    /* renamed from: k  reason: collision with root package name */
    private final HashMap<String, Integer> f28389k;

    /* renamed from: l  reason: collision with root package name */
    private List<b> f28390l;

    private b(String str, String str2, long j2, long j3, e eVar, String[] strArr, String str3, String str4) {
        this.f28379a = str;
        this.f28380b = str2;
        this.f28386h = str4;
        this.f28384f = eVar;
        this.f28387i = strArr;
        this.f28381c = str2 != null;
        this.f28382d = j2;
        this.f28383e = j3;
        this.f28385g = (String) a.b(str3);
        this.f28388j = new HashMap<>();
        this.f28389k = new HashMap<>();
    }

    private SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        int i2;
        int i3;
        int length = spannableStringBuilder.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (spannableStringBuilder.charAt(i5) == ' ') {
                int i6 = i5 + 1;
                int i7 = i6;
                while (i7 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i7) == ' ') {
                    i7++;
                }
                int i8 = i7 - i6;
                if (i8 > 0) {
                    spannableStringBuilder.delete(i5, i5 + i8);
                    length -= i8;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i9 = 0;
        while (true) {
            i2 = length - 1;
            if (i9 >= i2) {
                break;
            }
            if (spannableStringBuilder.charAt(i9) == 10) {
                int i10 = i9 + 1;
                if (spannableStringBuilder.charAt(i10) == ' ') {
                    spannableStringBuilder.delete(i10, i9 + 2);
                    length--;
                }
            }
            i9++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i2) == ' ') {
            spannableStringBuilder.delete(i2, length);
            length--;
        }
        while (true) {
            i3 = length - 1;
            if (i4 >= i3) {
                break;
            }
            if (spannableStringBuilder.charAt(i4) == ' ') {
                int i11 = i4 + 1;
                if (spannableStringBuilder.charAt(i11) == 10) {
                    spannableStringBuilder.delete(i4, i11);
                    length--;
                }
            }
            i4++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i3) == 10) {
            spannableStringBuilder.delete(i3, length);
        }
        return spannableStringBuilder;
    }

    private static SpannableStringBuilder a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    public static b a(String str) {
        return new b((String) null, d.a(str), -9223372036854775807L, -9223372036854775807L, (e) null, (String[]) null, "", (String) null);
    }

    public static b a(String str, long j2, long j3, e eVar, String[] strArr, String str2, String str3) {
        return new b(str, (String) null, j2, j3, eVar, strArr, str2, str3);
    }

    private void a(long j2, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f28385g)) {
            str = this.f28385g;
        }
        if (!a(j2) || !"div".equals(this.f28379a) || this.f28386h == null) {
            for (int i2 = 0; i2 < a(); i2++) {
                a(i2).a(j2, str, list);
            }
            return;
        }
        list.add(new Pair(str, this.f28386h));
    }

    private void a(long j2, Map<String, e> map, Map<String, SpannableStringBuilder> map2) {
        int i2;
        if (a(j2)) {
            Iterator<Map.Entry<String, Integer>> it2 = this.f28389k.entrySet().iterator();
            while (true) {
                i2 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                String str = (String) next.getKey();
                if (this.f28388j.containsKey(str)) {
                    i2 = this.f28388j.get(str).intValue();
                }
                int intValue = ((Integer) next.getValue()).intValue();
                if (i2 != intValue) {
                    a(map, map2.get(str), i2, intValue);
                }
            }
            while (i2 < a()) {
                a(i2).a(j2, map, map2);
                i2++;
            }
        }
    }

    private void a(long j2, boolean z2, String str, Map<String, SpannableStringBuilder> map) {
        this.f28388j.clear();
        this.f28389k.clear();
        if (!"metadata".equals(this.f28379a)) {
            if (!"".equals(this.f28385g)) {
                str = this.f28385g;
            }
            if (this.f28381c && z2) {
                a(str, map).append(this.f28380b);
            } else if ("br".equals(this.f28379a) && z2) {
                a(str, map).append(10);
            } else if (a(j2)) {
                for (Map.Entry next : map.entrySet()) {
                    this.f28388j.put((String) next.getKey(), Integer.valueOf(((SpannableStringBuilder) next.getValue()).length()));
                }
                boolean equals = "p".equals(this.f28379a);
                for (int i2 = 0; i2 < a(); i2++) {
                    a(i2).a(j2, z2 || equals, str, map);
                }
                if (equals) {
                    d.a(a(str, map));
                }
                for (Map.Entry next2 : map.entrySet()) {
                    this.f28389k.put((String) next2.getKey(), Integer.valueOf(((SpannableStringBuilder) next2.getValue()).length()));
                }
            }
        }
    }

    private void a(Map<String, e> map, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        e a2 = d.a(this.f28384f, this.f28387i, map);
        if (a2 != null) {
            d.a(spannableStringBuilder, i2, i3, a2);
        }
    }

    private void a(TreeSet<Long> treeSet, boolean z2) {
        boolean equals = "p".equals(this.f28379a);
        boolean equals2 = "div".equals(this.f28379a);
        if (z2 || equals || (equals2 && this.f28386h != null)) {
            long j2 = this.f28382d;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f28383e;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.f28390l != null) {
            for (int i2 = 0; i2 < this.f28390l.size(); i2++) {
                this.f28390l.get(i2).a(treeSet, z2 || equals);
            }
        }
    }

    public int a() {
        List<b> list = this.f28390l;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public b a(int i2) {
        List<b> list = this.f28390l;
        if (list != null) {
            return list.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<com.google.android.exoplayer2.text.b> a(long j2, Map<String, e> map, Map<String, c> map2, Map<String, String> map3) {
        long j3 = j2;
        Map<String, c> map4 = map2;
        ArrayList<Pair> arrayList = new ArrayList<>();
        a(j3, this.f28385g, (List<Pair<String, String>>) arrayList);
        TreeMap treeMap = new TreeMap();
        a(j2, false, this.f28385g, (Map<String, SpannableStringBuilder>) treeMap);
        a(j3, map, (Map<String, SpannableStringBuilder>) treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                c cVar = map4.get(pair.first);
                arrayList2.add(new com.google.android.exoplayer2.text.b(decodeByteArray, cVar.f28392b, 0, cVar.f28393c, cVar.f28395e, cVar.f28396f, cVar.f28397g));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            c cVar2 = map4.get(entry.getKey());
            arrayList2.add(new com.google.android.exoplayer2.text.b((CharSequence) a((SpannableStringBuilder) entry.getValue()), (Layout.Alignment) null, cVar2.f28393c, cVar2.f28394d, cVar2.f28395e, cVar2.f28392b, Integer.MIN_VALUE, cVar2.f28396f, cVar2.f28398h, cVar2.f28399i));
        }
        return arrayList2;
    }

    public void a(b bVar) {
        if (this.f28390l == null) {
            this.f28390l = new ArrayList();
        }
        this.f28390l.add(bVar);
    }

    public boolean a(long j2) {
        long j3 = this.f28382d;
        return (j3 == -9223372036854775807L && this.f28383e == -9223372036854775807L) || (j3 <= j2 && this.f28383e == -9223372036854775807L) || ((j3 == -9223372036854775807L && j2 < this.f28383e) || (j3 <= j2 && j2 < this.f28383e));
    }

    public long[] b() {
        TreeSet treeSet = new TreeSet();
        int i2 = 0;
        a((TreeSet<Long>) treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            jArr[i2] = ((Long) it2.next()).longValue();
            i2++;
        }
        return jArr;
    }
}
