package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;

public class UnrecognizedInputFormatException extends ParserException {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f16012a;

    public UnrecognizedInputFormatException(String str, Uri uri) {
        super(str);
        this.f16012a = uri;
    }
}
