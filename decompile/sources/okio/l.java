package okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class l extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final ByteString[] f32455a;

    /* renamed from: b  reason: collision with root package name */
    final int[] f32456b;

    private l(ByteString[] byteStringArr, int[] iArr) {
        this.f32455a = byteStringArr;
        this.f32456b = iArr;
    }

    private static int a(c cVar) {
        return (int) (cVar.a() / 4);
    }

    public static l a(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new l(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(-1);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i3]), Integer.valueOf(i3));
        }
        if (((ByteString) arrayList.get(0)).g() != 0) {
            int i4 = 0;
            while (i4 < arrayList.size()) {
                ByteString byteString = (ByteString) arrayList.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < arrayList.size()) {
                    ByteString byteString2 = (ByteString) arrayList.get(i6);
                    if (!byteString2.a(byteString)) {
                        continue;
                        break;
                    } else if (byteString2.g() == byteString.g()) {
                        throw new IllegalArgumentException("duplicate option: " + byteString2);
                    } else if (((Integer) arrayList2.get(i6)).intValue() > ((Integer) arrayList2.get(i4)).intValue()) {
                        arrayList.remove(i6);
                        arrayList2.remove(i6);
                    } else {
                        i6++;
                    }
                }
                i4 = i5;
            }
            c cVar = new c();
            a(0, cVar, 0, arrayList, 0, arrayList.size(), arrayList2);
            int a2 = a(cVar);
            int[] iArr = new int[a2];
            for (int i7 = 0; i7 < a2; i7++) {
                iArr[i7] = cVar.k();
            }
            if (cVar.f()) {
                return new l((ByteString[]) byteStringArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    private static void a(long j2, c cVar, int i2, List<ByteString> list, int i3, int i4, List<Integer> list2) {
        int i5;
        int i6;
        c cVar2;
        int i7;
        c cVar3 = cVar;
        int i8 = i2;
        List<ByteString> list3 = list;
        int i9 = i3;
        int i10 = i4;
        List<Integer> list4 = list2;
        if (i9 < i10) {
            int i11 = i9;
            while (i11 < i10) {
                if (list3.get(i11).g() >= i8) {
                    i11++;
                } else {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i3);
            ByteString byteString2 = list3.get(i10 - 1);
            int i12 = -1;
            if (i8 == byteString.g()) {
                i12 = list4.get(i9).intValue();
                i9++;
                byteString = list3.get(i9);
            }
            int i13 = i9;
            if (byteString.a(i8) != byteString2.a(i8)) {
                int i14 = 1;
                for (int i15 = i13 + 1; i15 < i10; i15++) {
                    if (list3.get(i15 - 1).a(i8) != list3.get(i15).a(i8)) {
                        i14++;
                    }
                }
                long a2 = j2 + ((long) a(cVar)) + 2 + ((long) (i14 * 2));
                cVar3.g(i14);
                cVar3.g(i12);
                for (int i16 = i13; i16 < i10; i16++) {
                    byte a3 = list3.get(i16).a(i8);
                    if (i16 == i13 || a3 != list3.get(i16 - 1).a(i8)) {
                        cVar3.g((int) a3 & 255);
                    }
                }
                c cVar4 = new c();
                int i17 = i13;
                while (i17 < i10) {
                    byte a4 = list3.get(i17).a(i8);
                    int i18 = i17 + 1;
                    int i19 = i18;
                    while (true) {
                        if (i19 >= i10) {
                            i6 = i10;
                            break;
                        } else if (a4 != list3.get(i19).a(i8)) {
                            i6 = i19;
                            break;
                        } else {
                            i19++;
                        }
                    }
                    if (i18 == i6 && i8 + 1 == list3.get(i17).g()) {
                        cVar3.g(list4.get(i17).intValue());
                        i7 = i6;
                        cVar2 = cVar4;
                    } else {
                        cVar3.g((int) ((((long) a(cVar4)) + a2) * -1));
                        i7 = i6;
                        cVar2 = cVar4;
                        a(a2, cVar4, i8 + 1, list, i17, i6, list2);
                    }
                    cVar4 = cVar2;
                    i17 = i7;
                }
                c cVar5 = cVar4;
                cVar3.write(cVar5, cVar5.a());
                return;
            }
            int i20 = 0;
            int min = Math.min(byteString.g(), byteString2.g());
            int i21 = i8;
            while (i21 < min && byteString.a(i21) == byteString2.a(i21)) {
                i20++;
                i21++;
            }
            long a5 = 1 + j2 + ((long) a(cVar)) + 2 + ((long) i20);
            cVar3.g(-i20);
            cVar3.g(i12);
            int i22 = i8;
            while (true) {
                i5 = i8 + i20;
                if (i22 >= i5) {
                    break;
                }
                cVar3.g((int) byteString.a(i22) & 255);
                i22++;
            }
            if (i13 + 1 != i10) {
                c cVar6 = new c();
                cVar3.g((int) ((((long) a(cVar6)) + a5) * -1));
                a(a5, cVar6, i5, list, i13, i4, list2);
                cVar3.write(cVar6, cVar6.a());
            } else if (i5 == list3.get(i13).g()) {
                cVar3.g(list4.get(i13).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public ByteString get(int i2) {
        return this.f32455a[i2];
    }

    public final int size() {
        return this.f32455a.length;
    }
}
