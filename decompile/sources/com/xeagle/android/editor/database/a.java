package com.xeagle.android.editor.database;

import java.util.ArrayList;
import java.util.List;
import org.litepal.LitePal;
import org.litepal.crud.callback.UpdateOrDeleteCallback;

public class a {
    public static EditorData a(String str) {
        List<EditorData> find = LitePal.where("path = ?", str).find(EditorData.class);
        if (find == null || find.size() <= 0) {
            return null;
        }
        return find.get(0);
    }

    public static ArrayList<EditorData> a() {
        List<EditorData> findAll = LitePal.findAll(EditorData.class, new long[0]);
        if (findAll == null) {
            return null;
        }
        return (ArrayList) findAll;
    }

    public static void a(EditorData editorData, UpdateOrDeleteCallback updateOrDeleteCallback) {
        if (editorData != null) {
            editorData.updateAllAsync("path = ?", editorData.getPath()).listen(updateOrDeleteCallback);
        }
    }

    public static boolean a(EditorData editorData) {
        if (editorData != null) {
            return editorData.save();
        }
        return false;
    }

    public static void b() {
        LitePal.deleteAll((Class<?>) EditorData.class, new String[0]);
    }
}
