package fj;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f27383c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a  reason: collision with root package name */
    public int f27384a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f27385b = -1;

    private boolean a(String str) {
        Matcher matcher = f27383c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1), 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f27384a = parseInt;
            this.f27385b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f27384a == -1 || this.f27385b == -1) ? false : true;
    }

    public boolean a(int i2) {
        int i3 = i2 >> 12;
        int i4 = i2 & 4095;
        if (i3 <= 0 && i4 <= 0) {
            return false;
        }
        this.f27384a = i3;
        this.f27385b = i4;
        return true;
    }

    public boolean a(Metadata metadata) {
        for (int i2 = 0; i2 < metadata.a(); i2++) {
            Metadata.Entry a2 = metadata.a(i2);
            if (a2 instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) a2;
                if ("iTunSMPB".equals(commentFrame.f15904b) && a(commentFrame.f15905c)) {
                    return true;
                }
            } else if (a2 instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) a2;
                if ("com.apple.iTunes".equals(internalFrame.f15911a) && "iTunSMPB".equals(internalFrame.f15912b) && a(internalFrame.f15913c)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
