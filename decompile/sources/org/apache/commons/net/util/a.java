package org.apache.commons.net.util;

import java.nio.charset.Charset;

public class a {
    public static Charset a(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }
}
