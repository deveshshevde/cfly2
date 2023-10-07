package org.jsoup.parser;

import java.util.ArrayList;

public class ParseErrorList extends ArrayList<c> {

    /* renamed from: a  reason: collision with root package name */
    private final int f33724a;

    ParseErrorList(int i2, int i3) {
        super(i2);
        this.f33724a = i3;
    }

    public static ParseErrorList b() {
        return new ParseErrorList(0, 0);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return size() < this.f33724a;
    }
}
