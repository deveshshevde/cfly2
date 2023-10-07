package es;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private File f26956a;

    /* renamed from: b  reason: collision with root package name */
    private File f26957b;

    /* renamed from: c  reason: collision with root package name */
    private b f26958c;

    /* renamed from: d  reason: collision with root package name */
    private String f26959d;

    /* renamed from: e  reason: collision with root package name */
    private String f26960e;

    /* renamed from: f  reason: collision with root package name */
    private String f26961f;

    /* renamed from: g  reason: collision with root package name */
    private String f26962g;

    /* renamed from: h  reason: collision with root package name */
    private String f26963h;

    public a(File file, File file2, b bVar, String str, String str2, String str3, String str4, String str5) {
        this.f26956a = file;
        this.f26957b = file2;
        this.f26958c = bVar;
        this.f26959d = str;
        this.f26960e = str2;
        this.f26961f = str3;
        this.f26962g = str4;
        this.f26963h = str5;
    }

    public void a() {
        try {
            for (File file : this.f26956a.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.endsWith(".tlog");
                }
            })) {
                this.f26958c.a(file);
                String a2 = c.a(file, this.f26959d, this.f26960e, this.f26961f, this.f26962g, this.f26963h);
                this.f26957b.mkdirs();
                file.renameTo(new File(this.f26957b, file.getName()));
                this.f26958c.a(file, a2);
            }
        } catch (IOException e2) {
            this.f26958c.a((File) null, (Exception) e2);
        }
    }
}
