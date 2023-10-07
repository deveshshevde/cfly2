package com.xeagle.android.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.format.Formatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f12764a = 100;

    /* renamed from: b  reason: collision with root package name */
    private static long f12765b;

    /* renamed from: c  reason: collision with root package name */
    private static long f12766c = SystemClock.uptimeMillis();

    /* renamed from: d  reason: collision with root package name */
    private static final File f12767d = new File("/proc/" + Process.myPid() + "/stat");

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f12768e = {"sh", "-c", "getconf CLK_TCK"};

    public static float a() {
        try {
            String readLine = new BufferedReader(new InputStreamReader(new FileInputStream(f12767d))).readLine();
            if (readLine != null) {
                if (!readLine.isEmpty()) {
                    String[] split = readLine.split(" ");
                    long parseLong = Long.parseLong(split[13]) + Long.parseLong(split[14]);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    f12765b = parseLong;
                    f12766c = uptimeMillis;
                    return ((((float) (parseLong - f12765b)) / ((((float) (uptimeMillis - f12766c)) / 1000.0f) * ((float) f12764a))) * 100.0f) / ((float) Runtime.getRuntime().availableProcessors());
                }
            }
            return 0.0f;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    public static String a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return Formatter.formatFileSize(context, memoryInfo.availMem);
    }

    public static long b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static void b() {
        try {
            Process exec = Runtime.getRuntime().exec(f12768e);
            try {
                String readLine = new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine();
                if (readLine == null) {
                    return;
                }
                if (!readLine.isEmpty()) {
                    f12764a = Integer.parseInt(readLine);
                    exec.destroy();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static String c() {
        String str = null;
        try {
            int myPid = Process.myPid();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + myPid + "/status")), 1000);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.replace(" ", "").split("[: k K]");
                if (split[0].equals("VmRSS")) {
                    str = split[1];
                    break;
                }
            }
            bufferedReader.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return str;
    }
}
