package com.blankj.utilcode.util;

import android.util.Log;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public final class BusUtils {
    private static final Object NULL = "nULl";
    private static final String TAG = "BusUtils";
    private final Map<String, Set<Object>> mClassName_BusesMap;
    private final Map<String, Map<String, Object>> mClassName_Tag_Arg4StickyMap;
    private final Map<String, List<String>> mClassName_TagsMap;
    private final Map<String, List<BusInfo>> mTag_BusInfoListMap;

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface Bus {
        int priority() default 0;

        boolean sticky() default false;

        String tag();

        ThreadMode threadMode() default ThreadMode.POSTING;
    }

    private static final class BusInfo {
        String className;
        String funName;
        Method method;
        String paramName;
        String paramType;
        int priority;
        boolean sticky;
        List<String> subClassNames = new CopyOnWriteArrayList();
        String tag;
        String threadMode;

        BusInfo(String str, String str2, String str3, String str4, String str5, boolean z2, String str6, int i2) {
            this.tag = str;
            this.className = str2;
            this.funName = str3;
            this.paramType = str4;
            this.paramName = str5;
            this.sticky = z2;
            this.threadMode = str6;
            this.priority = i2;
        }

        private String getDesc() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(this.className);
            sb.append("#");
            sb.append(this.funName);
            if ("".equals(this.paramType)) {
                str = "()";
            } else {
                str = "(" + this.paramType + " " + this.paramName + ")";
            }
            sb.append(str);
            return sb.toString();
        }

        public String toString() {
            return "BusInfo { tag : " + this.tag + ", desc: " + getDesc() + ", sticky: " + this.sticky + ", threadMode: " + this.threadMode + ", method: " + this.method + ", priority: " + this.priority + " }";
        }
    }

    private static class LazyHolder {
        /* access modifiers changed from: private */
        public static final BusUtils INSTANCE = new BusUtils();

        private LazyHolder() {
        }
    }

    public enum ThreadMode {
        MAIN,
        IO,
        CPU,
        CACHED,
        SINGLE,
        POSTING
    }

    private BusUtils() {
        this.mTag_BusInfoListMap = new ConcurrentHashMap();
        this.mClassName_BusesMap = new ConcurrentHashMap();
        this.mClassName_TagsMap = new ConcurrentHashMap();
        this.mClassName_Tag_Arg4StickyMap = new ConcurrentHashMap();
        init();
    }

    private void consumeSticky(Object obj, String str, Object obj2) {
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            Log.e(TAG, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (BusInfo busInfo : list) {
            if (busInfo.subClassNames.contains(obj.getClass().getName()) && busInfo.sticky) {
                synchronized (this.mClassName_Tag_Arg4StickyMap) {
                    Map map = this.mClassName_Tag_Arg4StickyMap.get(busInfo.className);
                    if (map != null) {
                        if (map.containsKey(str)) {
                            invokeBus(obj, obj2, busInfo, true);
                        }
                    }
                }
            }
        }
    }

    private void consumeStickyIfExist(Object obj) {
        Map map = this.mClassName_Tag_Arg4StickyMap.get(obj.getClass().getName());
        if (map != null) {
            synchronized (this.mClassName_Tag_Arg4StickyMap) {
                for (Map.Entry entry : map.entrySet()) {
                    consumeSticky(obj, (String) entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private Class getClassName(String str) throws ClassNotFoundException {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1325958191:
                if (str.equals("double")) {
                    c2 = 0;
                    break;
                }
                break;
            case 104431:
                if (str.equals("int")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3039496:
                if (str.equals("byte")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3052374:
                if (str.equals("char")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3327612:
                if (str.equals("long")) {
                    c2 = 4;
                    break;
                }
                break;
            case 64711720:
                if (str.equals("boolean")) {
                    c2 = 5;
                    break;
                }
                break;
            case 97526364:
                if (str.equals("float")) {
                    c2 = 6;
                    break;
                }
                break;
            case 109413500:
                if (str.equals("short")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return Double.TYPE;
            case 1:
                return Integer.TYPE;
            case 2:
                return Byte.TYPE;
            case 3:
                return Character.TYPE;
            case 4:
                return Long.TYPE;
            case 5:
                return Boolean.TYPE;
            case 6:
                return Float.TYPE;
            case 7:
                return Short.TYPE;
            default:
                return Class.forName(str);
        }
    }

    private static BusUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    private Method getMethodByBusInfo(BusInfo busInfo) {
        try {
            if ("".equals(busInfo.paramType)) {
                return Class.forName(busInfo.className).getDeclaredMethod(busInfo.funName, new Class[0]);
            }
            return Class.forName(busInfo.className).getDeclaredMethod(busInfo.funName, new Class[]{getClassName(busInfo.paramType)});
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private void init() {
    }

    private void invokeBus(Object obj, BusInfo busInfo, boolean z2) {
        invokeBus((Object) null, obj, busInfo, z2);
    }

    private void invokeBus(Object obj, Object obj2, BusInfo busInfo, boolean z2) {
        if (busInfo.method == null) {
            Method methodByBusInfo = getMethodByBusInfo(busInfo);
            if (methodByBusInfo != null) {
                busInfo.method = methodByBusInfo;
            } else {
                return;
            }
        }
        invokeMethod(obj, obj2, busInfo, z2);
    }

    private void invokeBuses(Object obj, BusInfo busInfo, Set<Object> set) {
        try {
            if (obj == NULL) {
                for (Object invoke : set) {
                    busInfo.method.invoke(invoke, new Object[0]);
                }
                return;
            }
            for (Object next : set) {
                busInfo.method.invoke(next, new Object[]{obj});
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    private void invokeMethod(Object obj, BusInfo busInfo, boolean z2) {
        invokeMethod((Object) null, obj, busInfo, z2);
    }

    private void invokeMethod(Object obj, Object obj2, BusInfo busInfo, boolean z2) {
        ExecutorService singlePool;
        final Object obj3 = obj;
        final Object obj4 = obj2;
        final BusInfo busInfo2 = busInfo;
        final boolean z3 = z2;
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                BusUtils.this.realInvokeMethod(obj3, obj4, busInfo2, z3);
            }
        };
        String str = busInfo.threadMode;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1848936376:
                if (str.equals("SINGLE")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2342:
                if (str.equals("IO")) {
                    c2 = 1;
                    break;
                }
                break;
            case 66952:
                if (str.equals("CPU")) {
                    c2 = 2;
                    break;
                }
                break;
            case 2358713:
                if (str.equals("MAIN")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1980249378:
                if (str.equals("CACHED")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                singlePool = ThreadUtils.getSinglePool();
                break;
            case 1:
                singlePool = ThreadUtils.getIoPool();
                break;
            case 2:
                singlePool = ThreadUtils.getCpuPool();
                break;
            case 3:
                ThreadUtils.runOnUiThread(r0);
                return;
            case 4:
                singlePool = ThreadUtils.getCachedPool();
                break;
            default:
                r0.run();
                return;
        }
        singlePool.execute(r0);
    }

    public static void post(String str) {
        Objects.requireNonNull(str, "Argument 'tag' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        post(str, NULL);
    }

    public static void post(String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'tag' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(obj, "Argument 'arg' of type Object (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        getInstance().postInner(str, obj);
    }

    private void postInner(String str, Object obj) {
        postInner(str, obj, false);
    }

    private void postInner(String str, Object obj, boolean z2) {
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            Log.e(TAG, "The bus of tag <" + str + "> is not exists.");
            if (this.mTag_BusInfoListMap.isEmpty()) {
                Log.e(TAG, "Please check whether the bus plugin is applied.");
                return;
            }
            return;
        }
        for (BusInfo invokeBus : list) {
            invokeBus(obj, invokeBus, z2);
        }
    }

    public static void postSticky(String str) {
        Objects.requireNonNull(str, "Argument 'tag' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        postSticky(str, NULL);
    }

    public static void postSticky(String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'tag' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        getInstance().postStickyInner(str, obj);
    }

    private void postStickyInner(String str, Object obj) {
        boolean z2;
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            Log.e(TAG, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (BusInfo busInfo : list) {
            if (!busInfo.sticky) {
                z2 = false;
            } else {
                synchronized (this.mClassName_Tag_Arg4StickyMap) {
                    Map map = this.mClassName_Tag_Arg4StickyMap.get(busInfo.className);
                    if (map == null) {
                        map = new ConcurrentHashMap();
                        this.mClassName_Tag_Arg4StickyMap.put(busInfo.className, map);
                    }
                    map.put(str, obj);
                }
                z2 = true;
            }
            invokeBus(obj, busInfo, z2);
        }
    }

    /* access modifiers changed from: private */
    public void realInvokeMethod(Object obj, Object obj2, BusInfo busInfo, boolean z2) {
        HashSet hashSet = new HashSet();
        if (obj == null) {
            for (String str : busInfo.subClassNames) {
                Set set = this.mClassName_BusesMap.get(str);
                if (set != null && !set.isEmpty()) {
                    hashSet.addAll(set);
                }
            }
            if (hashSet.size() == 0) {
                if (!z2) {
                    Log.e(TAG, "The " + busInfo + " was not registered before.");
                    return;
                }
                return;
            }
        } else {
            hashSet.add(obj);
        }
        invokeBuses(obj2, busInfo, hashSet);
    }

    private void recordTags(Class<?> cls, String str) {
        if (this.mClassName_TagsMap.get(str) == null) {
            synchronized (this.mClassName_TagsMap) {
                if (this.mClassName_TagsMap.get(str) == null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (Map.Entry next : this.mTag_BusInfoListMap.entrySet()) {
                        for (BusInfo busInfo : (List) next.getValue()) {
                            try {
                                if (Class.forName(busInfo.className).isAssignableFrom(cls)) {
                                    copyOnWriteArrayList.add(next.getKey());
                                    busInfo.subClassNames.add(str);
                                }
                            } catch (ClassNotFoundException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    this.mClassName_TagsMap.put(str, copyOnWriteArrayList);
                }
            }
        }
    }

    public static void register(Object obj) {
        getInstance().registerInner(obj);
    }

    private void registerBus(String str, String str2, String str3, String str4, String str5, boolean z2, String str6) {
        registerBus(str, str2, str3, str4, str5, z2, str6, 0);
    }

    private void registerBus(String str, String str2, String str3, String str4, String str5, boolean z2, String str6, int i2) {
        String str7 = str;
        List list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            list = new CopyOnWriteArrayList();
            this.mTag_BusInfoListMap.put(str, list);
        }
        list.add(new BusInfo(str, str2, str3, str4, str5, z2, str6, i2));
    }

    static void registerBus4Test(String str, String str2, String str3, String str4, String str5, boolean z2, String str6, int i2) {
        getInstance().registerBus(str, str2, str3, str4, str5, z2, str6, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        if (r2 == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        recordTags(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        consumeStickyIfExist(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void registerInner(java.lang.Object r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Class r0 = r7.getClass()
            java.lang.String r1 = r0.getName()
            r2 = 0
            java.util.Map<java.lang.String, java.util.Set<java.lang.Object>> r3 = r6.mClassName_BusesMap
            monitor-enter(r3)
            java.util.Map<java.lang.String, java.util.Set<java.lang.Object>> r4 = r6.mClassName_BusesMap     // Catch:{ all -> 0x0054 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x0054 }
            java.util.Set r4 = (java.util.Set) r4     // Catch:{ all -> 0x0054 }
            if (r4 != 0) goto L_0x0024
            java.util.concurrent.CopyOnWriteArraySet r4 = new java.util.concurrent.CopyOnWriteArraySet     // Catch:{ all -> 0x0054 }
            r4.<init>()     // Catch:{ all -> 0x0054 }
            java.util.Map<java.lang.String, java.util.Set<java.lang.Object>> r2 = r6.mClassName_BusesMap     // Catch:{ all -> 0x0054 }
            r2.put(r1, r4)     // Catch:{ all -> 0x0054 }
            r2 = 1
        L_0x0024:
            boolean r5 = r4.contains(r7)     // Catch:{ all -> 0x0054 }
            if (r5 == 0) goto L_0x0047
            java.lang.String r0 = "BusUtils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r1.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "The bus of <"
            r1.append(r2)     // Catch:{ all -> 0x0054 }
            r1.append(r7)     // Catch:{ all -> 0x0054 }
            java.lang.String r7 = "> already registered."
            r1.append(r7)     // Catch:{ all -> 0x0054 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x0054 }
            android.util.Log.w(r0, r7)     // Catch:{ all -> 0x0054 }
            monitor-exit(r3)     // Catch:{ all -> 0x0054 }
            return
        L_0x0047:
            r4.add(r7)     // Catch:{ all -> 0x0054 }
            monitor-exit(r3)     // Catch:{ all -> 0x0054 }
            if (r2 == 0) goto L_0x0050
            r6.recordTags(r0, r1)
        L_0x0050:
            r6.consumeStickyIfExist(r7)
            return
        L_0x0054:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.BusUtils.registerInner(java.lang.Object):void");
    }

    public static void removeSticky(String str) {
        getInstance().removeStickyInner(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeStickyInner(java.lang.String r5) {
        /*
            r4 = this;
            java.util.Map<java.lang.String, java.util.List<com.blankj.utilcode.util.BusUtils$BusInfo>> r0 = r4.mTag_BusInfoListMap
            java.lang.Object r0 = r0.get(r5)
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = "BusUtils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The bus of tag <"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = "> is not exists."
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            android.util.Log.e(r0, r5)
            return
        L_0x0026:
            java.util.Iterator r0 = r0.iterator()
        L_0x002a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r0.next()
            com.blankj.utilcode.util.BusUtils$BusInfo r1 = (com.blankj.utilcode.util.BusUtils.BusInfo) r1
            boolean r2 = r1.sticky
            if (r2 != 0) goto L_0x003b
            goto L_0x002a
        L_0x003b:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r2 = r4.mClassName_Tag_Arg4StickyMap
            monitor-enter(r2)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r3 = r4.mClassName_Tag_Arg4StickyMap     // Catch:{ all -> 0x0058 }
            java.lang.String r1 = r1.className     // Catch:{ all -> 0x0058 }
            java.lang.Object r1 = r3.get(r1)     // Catch:{ all -> 0x0058 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x0056
            boolean r3 = r1.containsKey(r5)     // Catch:{ all -> 0x0058 }
            if (r3 != 0) goto L_0x0051
            goto L_0x0056
        L_0x0051:
            r1.remove(r5)     // Catch:{ all -> 0x0058 }
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            goto L_0x002a
        L_0x0056:
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            return
        L_0x0058:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            throw r5
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.BusUtils.removeStickyInner(java.lang.String):void");
    }

    public static String toString_() {
        return getInstance().toString();
    }

    public static void unregister(Object obj) {
        getInstance().unregisterInner(obj);
    }

    private void unregisterInner(Object obj) {
        if (obj != null) {
            String name = obj.getClass().getName();
            synchronized (this.mClassName_BusesMap) {
                Set set = this.mClassName_BusesMap.get(name);
                if (set != null) {
                    if (set.contains(obj)) {
                        set.remove(obj);
                        return;
                    }
                }
                Log.e(TAG, "The bus of <" + obj + "> was not registered before.");
            }
        }
    }

    public String toString() {
        return "BusUtils: " + this.mTag_BusInfoListMap;
    }
}
