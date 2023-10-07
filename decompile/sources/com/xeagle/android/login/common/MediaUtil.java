package com.xeagle.android.login.common;

import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MediaUtil {
    public static Map<String, List<GLImage>> divideMedias(List<GLImage> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            GLImage gLImage = list.get(i2);
            String dateString = TimeUtil.getDateString(gLImage.getAddTime());
            List arrayList = linkedHashMap.get(dateString) != null ? (List) linkedHashMap.get(dateString) : new ArrayList(1);
            arrayList.add(gLImage);
            linkedHashMap.put(dateString, arrayList);
        }
        return linkedHashMap;
    }
}
