package org.apache.commons.net.ftp.parser;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.commons.net.ftp.d;

public class p extends o {

    /* renamed from: b  reason: collision with root package name */
    private final Pattern f32892b;

    public p() {
        this((d) null);
    }

    public p(d dVar) {
        a(dVar);
        try {
            this.f32892b = Pattern.compile("(.*?);([0-9]+)\\s*.*");
        } catch (PatternSyntaxException unused) {
            throw new IllegalArgumentException("Unparseable regex supplied:  (.*?);([0-9]+)\\s*.*");
        }
    }

    public List<String> a(List<String> list) {
        HashMap hashMap = new HashMap();
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Matcher matcher = this.f32892b.matcher(listIterator.next().trim());
            if (matcher.matches()) {
                MatchResult matchResult = matcher.toMatchResult();
                String group = matchResult.group(1);
                Integer valueOf = Integer.valueOf(matchResult.group(2));
                Integer num = (Integer) hashMap.get(group);
                if (num == null || valueOf.intValue() >= num.intValue()) {
                    hashMap.put(group, valueOf);
                } else {
                    listIterator.remove();
                }
            }
        }
        while (listIterator.hasPrevious()) {
            Matcher matcher2 = this.f32892b.matcher(listIterator.previous().trim());
            if (matcher2.matches()) {
                MatchResult matchResult2 = matcher2.toMatchResult();
                String group2 = matchResult2.group(1);
                Integer valueOf2 = Integer.valueOf(matchResult2.group(2));
                Integer num2 = (Integer) hashMap.get(group2);
                if (num2 != null && valueOf2.intValue() < num2.intValue()) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }
}
