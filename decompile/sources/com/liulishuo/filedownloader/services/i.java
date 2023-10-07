package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Context;
import com.liulishuo.filedownloader.R;
import iq.d;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private int f21470a;

    /* renamed from: b  reason: collision with root package name */
    private String f21471b;

    /* renamed from: c  reason: collision with root package name */
    private String f21472c;

    /* renamed from: d  reason: collision with root package name */
    private Notification f21473d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21474e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f21475a;

        /* renamed from: b  reason: collision with root package name */
        private String f21476b;

        /* renamed from: c  reason: collision with root package name */
        private String f21477c;

        /* renamed from: d  reason: collision with root package name */
        private Notification f21478d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f21479e;

        public a a(boolean z2) {
            this.f21479e = z2;
            return this;
        }

        public i a() {
            i iVar = new i();
            String str = this.f21476b;
            if (str == null) {
                str = "filedownloader_channel";
            }
            iVar.a(str);
            String str2 = this.f21477c;
            if (str2 == null) {
                str2 = "Filedownloader";
            }
            iVar.b(str2);
            int i2 = this.f21475a;
            if (i2 == 0) {
                i2 = 17301506;
            }
            iVar.a(i2);
            iVar.a(this.f21479e);
            iVar.a(this.f21478d);
            return iVar;
        }
    }

    private i() {
    }

    private Notification b(Context context) {
        String string = context.getString(R.string.default_filedownloader_notification_title);
        String string2 = context.getString(R.string.default_filedownloader_notification_content);
        Notification.Builder builder = new Notification.Builder(context, this.f21471b);
        builder.setContentTitle(string).setContentText(string2).setSmallIcon(17301506);
        return builder.build();
    }

    public int a() {
        return this.f21470a;
    }

    public Notification a(Context context) {
        if (this.f21473d == null) {
            if (d.f29057a) {
                d.c(this, "build default notification", new Object[0]);
            }
            this.f21473d = b(context);
        }
        return this.f21473d;
    }

    public void a(int i2) {
        this.f21470a = i2;
    }

    public void a(Notification notification) {
        this.f21473d = notification;
    }

    public void a(String str) {
        this.f21471b = str;
    }

    public void a(boolean z2) {
        this.f21474e = z2;
    }

    public String b() {
        return this.f21471b;
    }

    public void b(String str) {
        this.f21472c = str;
    }

    public String c() {
        return this.f21472c;
    }

    public boolean d() {
        return this.f21474e;
    }

    public String toString() {
        return "ForegroundServiceConfig{notificationId=" + this.f21470a + ", notificationChannelId='" + this.f21471b + '\'' + ", notificationChannelName='" + this.f21472c + '\'' + ", notification=" + this.f21473d + ", needRecreateChannelId=" + this.f21474e + '}';
    }
}
