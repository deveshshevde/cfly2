package com.google.protobuf;

import java.io.IOException;

public interface k extends l {

    public interface a extends l, Cloneable {
        a c(k kVar);

        k g();
    }

    ByteString a();

    void a(CodedOutputStream codedOutputStream) throws IOException;

    n<? extends k> d();

    a j();

    int l();
}
