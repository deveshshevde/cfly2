package com.google.protobuf;

import com.google.protobuf.k;

public abstract class b<MessageType extends k> implements n<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final f f20111a = f.b();

    private UninitializedMessageException a(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).c() : new UninitializedMessageException(messagetype);
    }

    private MessageType b(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.h()) {
            return messagetype;
        }
        throw a(messagetype).a().a(messagetype);
    }

    public MessageType a(ByteString byteString, f fVar) throws InvalidProtocolBufferException {
        MessageType messagetype;
        try {
            d e2 = byteString.e();
            messagetype = (k) b(e2, fVar);
            e2.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e3) {
            throw e3.a(messagetype);
        } catch (InvalidProtocolBufferException e4) {
            throw e4;
        }
    }

    /* renamed from: b */
    public MessageType c(ByteString byteString, f fVar) throws InvalidProtocolBufferException {
        return b(a(byteString, fVar));
    }
}
