package org.apache.commons.net.ftp.parser;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.commons.net.ftp.f;

public abstract class m extends f {

    /* renamed from: a  reason: collision with root package name */
    protected Matcher f32887a;

    /* renamed from: b  reason: collision with root package name */
    private Pattern f32888b;

    /* renamed from: c  reason: collision with root package name */
    private MatchResult f32889c;

    public m(String str) {
        a(str, 0);
    }

    public m(String str, int i2) {
        a(str, i2);
    }

    private void a(String str, int i2) {
        try {
            this.f32888b = Pattern.compile(str, i2);
        } catch (PatternSyntaxException unused) {
            throw new IllegalArgumentException("Unparseable regex supplied: " + str);
        }
    }

    public String b(int i2) {
        MatchResult matchResult = this.f32889c;
        if (matchResult == null) {
            return null;
        }
        return matchResult.group(i2);
    }

    public boolean c(String str) {
        this.f32889c = null;
        Matcher matcher = this.f32888b.matcher(str);
        this.f32887a = matcher;
        if (matcher.matches()) {
            this.f32889c = this.f32887a.toMatchResult();
        }
        return this.f32889c != null;
    }

    public boolean d(String str) {
        a(str, 0);
        return true;
    }
}
