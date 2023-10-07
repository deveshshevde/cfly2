package com.liulishuo.filedownloader.message;

import iq.f;

public interface BlockCompleteMessage {

    public static class BlockCompleteMessageImpl extends MessageSnapshot implements BlockCompleteMessage {

        /* renamed from: b  reason: collision with root package name */
        private final MessageSnapshot f21368b;

        public BlockCompleteMessageImpl(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.m());
            if (messageSnapshot.b() == -3) {
                this.f21368b = messageSnapshot;
            } else {
                throw new IllegalArgumentException(f.a("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
            }
        }

        public byte b() {
            return 4;
        }

        public MessageSnapshot t_() {
            return this.f21368b;
        }
    }

    MessageSnapshot t_();
}
