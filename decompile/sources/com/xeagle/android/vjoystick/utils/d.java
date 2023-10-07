package com.xeagle.android.vjoystick.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f25365a = String.format("/%s/Photos", new Object[]{"C-FLY2"});

    /* renamed from: b  reason: collision with root package name */
    public static final String f25366b = String.format("/%s/Videos", new Object[]{"C-FLY2"});

    /* renamed from: c  reason: collision with root package name */
    public static final String f25367c = String.format("/%s/Thumb/Photos", new Object[]{"C-FLY2"});

    /* renamed from: d  reason: collision with root package name */
    public static final String f25368d = String.format("/%s/Thumb/Videos", new Object[]{"C-FLY2"});

    /* renamed from: e  reason: collision with root package name */
    private static ArrayList<String> f25369e = new ArrayList<>();

    public static String a(Context context) {
        if (Build.VERSION.SDK_INT < 30) {
            return Environment.getExternalStorageDirectory().toString();
        }
        File externalFilesDir = context.getExternalFilesDir("");
        Objects.requireNonNull(externalFilesDir);
        return externalFilesDir.getAbsolutePath();
    }

    public static ArrayList<String> a(File file) {
        ArrayList<String> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles(new FileFilter() {
            public boolean accept(File file) {
                if (file.isFile()) {
                    return file.getAbsolutePath().toLowerCase().endsWith(".bmp") || file.getAbsolutePath().toLowerCase().endsWith(".jpg") || file.getAbsolutePath().toLowerCase().endsWith(".png");
                }
                return false;
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (arrayList.indexOf(file2.getAbsolutePath()) == -1) {
                    arrayList.add(file2.getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    public static List<String> b(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles(new FileFilter() {
            public boolean accept(File file) {
                if (file.isFile()) {
                    return file.getAbsolutePath().toLowerCase().endsWith(".bmp") || file.getAbsolutePath().toLowerCase().endsWith(".jpg") || file.getAbsolutePath().toLowerCase().endsWith(".png");
                }
                return false;
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (arrayList.indexOf(file2.getAbsolutePath()) == -1) {
                    arrayList.add(file2.getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<String> c(File file) {
        f25369e.clear();
        d(file);
        return f25369e;
    }

    private static void d(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2].isFile()) {
                    if (listFiles[i2].getAbsolutePath().toLowerCase().endsWith(".avi") || listFiles[i2].getAbsolutePath().toLowerCase().endsWith(".3gp") || listFiles[i2].getAbsolutePath().toLowerCase().endsWith(".mp4") || listFiles[i2].getAbsolutePath().toLowerCase().endsWith(".mkv")) {
                        File file2 = new File(listFiles[i2].getAbsolutePath());
                        if (file2.exists() && arrayList.indexOf(file2.getAbsolutePath()) == -1) {
                            arrayList.add(file2.getAbsolutePath());
                            f25369e.add(file2.toString());
                        }
                    }
                } else if (listFiles[i2].isDirectory() && listFiles[i2].getPath().indexOf("/.") == -1) {
                    d(listFiles[i2]);
                }
            }
        }
    }
}
