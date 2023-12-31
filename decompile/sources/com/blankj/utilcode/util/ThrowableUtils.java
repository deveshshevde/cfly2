package com.blankj.utilcode.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ThrowableUtils {
    private static final String LINE_SEP = System.getProperty("line.separator");

    private ThrowableUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getFullStackTrace(Throwable th) {
        List<String> list;
        String str;
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = th.getCause();
        }
        int size = arrayList.size();
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i2 = size - 1;
        List<String> stackFrameList = getStackFrameList((Throwable) arrayList.get(i2));
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (size != 0) {
                list = getStackFrameList((Throwable) arrayList.get(size - 1));
                removeCommonFrames(stackFrameList, list);
            } else {
                list = stackFrameList;
            }
            if (size == i2) {
                str = ((Throwable) arrayList.get(size)).toString();
            } else {
                str = " Caused by: " + ((Throwable) arrayList.get(size)).toString();
            }
            arrayList2.add(str);
            arrayList2.addAll(stackFrameList);
            stackFrameList = list;
        }
        StringBuilder sb = new StringBuilder();
        for (String append : arrayList2) {
            sb.append(append);
            sb.append(LINE_SEP);
        }
        return sb.toString();
    }

    private static List<String> getStackFrameList(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter, true));
        StringTokenizer stringTokenizer = new StringTokenizer(stringWriter.toString(), LINE_SEP);
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("at");
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().isEmpty()) {
                arrayList.add(nextToken);
                z2 = true;
            } else if (z2) {
                break;
            }
        }
        return arrayList;
    }

    private static void removeCommonFrames(List<String> list, List<String> list2) {
        int size = list.size() - 1;
        int size2 = list2.size() - 1;
        while (size >= 0 && size2 >= 0) {
            if (list.get(size).equals(list2.get(size2))) {
                list.remove(size);
            }
            size--;
            size2--;
        }
    }
}
