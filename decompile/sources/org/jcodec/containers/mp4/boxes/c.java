package org.jcodec.containers.mp4.boxes;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.b;
import org.jcodec.common.i;
import org.jcodec.common.logging.Logger;

public abstract class c {

    /* renamed from: i  reason: collision with root package name */
    protected y f33452i;

    public c(y yVar) {
        this.f33452i = yVar;
    }

    public static <T> T a(al alVar, Class<T> cls, String... strArr) {
        T[] a2 = a((c) alVar, cls, strArr);
        if (a2.length > 0) {
            return a2[0];
        }
        return null;
    }

    private void a(Class cls) {
        for (Method name : cls.getDeclaredMethods()) {
            if (name.getName().equals("getModelFields")) {
                Logger.a("Class " + cls.getCanonicalName() + " contains 'getModelFields' of wrong signature.\n" + "Did you mean to define 'protected void " + "getModelFields" + "(List<String> model) ?");
                return;
            }
        }
    }

    private static void a(c cVar, List<String> list, Collection<c> collection) {
        if (list.size() > 0) {
            String remove = list.remove(0);
            if (cVar instanceof al) {
                for (c next : ((al) cVar).b()) {
                    if (remove == null || remove.equals(next.f33452i.b())) {
                        a(next, list, collection);
                    }
                }
            }
            list.add(0, remove);
            return;
        }
        collection.add(cVar);
    }

    public static <T> T[] a(c cVar, Class<T> cls, String... strArr) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (String add : strArr) {
            linkedList2.add(add);
        }
        a(cVar, (List<String>) linkedList2, (Collection<c>) linkedList);
        return linkedList.toArray((Object[]) Array.newInstance(cls, 0));
    }

    /* access modifiers changed from: protected */
    public void a(Class cls, List<String> list) {
        Class<c> cls2 = c.class;
        if (cls2 != cls && cls2.isAssignableFrom(cls)) {
            a(cls.getSuperclass(), list);
            try {
                cls.getDeclaredMethod("getModelFields", new Class[]{List.class}).invoke(this, new Object[]{list});
            } catch (NoSuchMethodException unused) {
                a(cls);
                list.addAll(org.jcodec.common.tools.c.a(cls));
            } catch (Exception unused2) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(StringBuilder sb) {
        sb.append("{\"tag\":\"" + this.f33452i.b() + "\",");
        ArrayList arrayList = new ArrayList(0);
        a(getClass(), arrayList);
        org.jcodec.common.tools.c.a((Object) this, sb, (String[]) arrayList.toArray(new String[0]));
        sb.append("}");
    }

    /* access modifiers changed from: protected */
    public abstract void a(ByteBuffer byteBuffer);

    public void b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        i.b(byteBuffer, 8);
        a(byteBuffer);
        this.f33452i.a((byteBuffer.position() - duplicate.position()) - 8);
        b.a(this.f33452i.a(), 8);
        this.f33452i.a(duplicate);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }
}
