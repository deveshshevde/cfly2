package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.n;
import java.util.Locale;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f16846a;

    public a(Resources resources) {
        this.f16846a = (Resources) com.google.android.exoplayer2.util.a.b(resources);
    }

    private String a(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                } else {
                    str = this.f16846a.getString(R.string.exo_item_list, new Object[]{str, str2});
                }
            }
        }
        return str;
    }

    private String b(Format format) {
        int i2 = format.f15097n;
        int i3 = format.f15098o;
        if (i2 == -1 || i3 == -1) {
            return "";
        }
        return this.f16846a.getString(R.string.exo_track_resolution, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    private String c(Format format) {
        int i2 = format.f15088e;
        if (i2 == -1) {
            return "";
        }
        return this.f16846a.getString(R.string.exo_track_bitrate, new Object[]{Float.valueOf(((float) i2) / 1000000.0f)});
    }

    private String d(Format format) {
        Resources resources;
        int i2;
        int i3 = format.f15105v;
        if (i3 == -1 || i3 < 1) {
            return "";
        }
        if (i3 == 1) {
            resources = this.f16846a;
            i2 = R.string.exo_track_mono;
        } else if (i3 == 2) {
            resources = this.f16846a;
            i2 = R.string.exo_track_stereo;
        } else if (i3 == 6 || i3 == 7) {
            resources = this.f16846a;
            i2 = R.string.exo_track_surround_5_point_1;
        } else if (i3 != 8) {
            resources = this.f16846a;
            i2 = R.string.exo_track_surround;
        } else {
            resources = this.f16846a;
            i2 = R.string.exo_track_surround_7_point_1;
        }
        return resources.getString(i2);
    }

    private String e(Format format) {
        String a2 = a(g(format), h(format));
        return TextUtils.isEmpty(a2) ? f(format) : a2;
    }

    private String f(Format format) {
        return TextUtils.isEmpty(format.f15085b) ? "" : format.f15085b;
    }

    private String g(Format format) {
        String str = format.A;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        return (ad.f11755a >= 21 ? Locale.forLanguageTag(str) : new Locale(str)).getDisplayName();
    }

    private String h(Format format) {
        String string = (format.f15087d & 2) != 0 ? this.f16846a.getString(R.string.exo_track_role_alternate) : "";
        if ((format.f15087d & 4) != 0) {
            string = a(string, this.f16846a.getString(R.string.exo_track_role_supplementary));
        }
        if ((format.f15087d & 8) != 0) {
            string = a(string, this.f16846a.getString(R.string.exo_track_role_commentary));
        }
        if ((format.f15087d & 1088) == 0) {
            return string;
        }
        return a(string, this.f16846a.getString(R.string.exo_track_role_closed_captions));
    }

    private static int i(Format format) {
        int h2 = n.h(format.f15092i);
        if (h2 != -1) {
            return h2;
        }
        if (n.e(format.f15089f) != null) {
            return 2;
        }
        if (n.f(format.f15089f) != null) {
            return 1;
        }
        if (format.f15097n == -1 && format.f15098o == -1) {
            return (format.f15105v == -1 && format.f15106w == -1) ? -1 : 1;
        }
        return 2;
    }

    public String a(Format format) {
        int i2 = i(format);
        String a2 = i2 == 2 ? a(h(format), b(format), c(format)) : i2 == 1 ? a(e(format), d(format), c(format)) : e(format);
        return a2.length() == 0 ? this.f16846a.getString(R.string.exo_track_unknown) : a2;
    }
}
