package org.apache.commons.math3.exception.util;

import java.util.ArrayList;

public class a {
    public static Object[] a(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        if (objArr != null) {
            for (Object[] objArr2 : objArr) {
                if (objArr2 instanceof Object[]) {
                    for (Object add : a(objArr2)) {
                        arrayList.add(add);
                    }
                } else {
                    arrayList.add(objArr2);
                }
            }
        }
        return arrayList.toArray();
    }
}
