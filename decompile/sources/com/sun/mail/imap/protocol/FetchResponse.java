package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import java.io.IOException;
import java.util.Vector;

public class FetchResponse extends IMAPResponse {
    private static final char[] HEADER = {'.', 'H', 'E', 'A', 'D', 'E', 'R'};
    private static final char[] TEXT = {'.', 'T', 'E', 'X', 'T'};
    private Item[] items;

    public FetchResponse(Protocol protocol) throws IOException, ProtocolException {
        super(protocol);
        parse();
    }

    public FetchResponse(IMAPResponse iMAPResponse) throws IOException, ProtocolException {
        super(iMAPResponse);
        parse();
    }

    public static Item getItem(Response[] responseArr, int i2, Class cls) {
        if (responseArr == null) {
            return null;
        }
        for (int i3 = 0; i3 < responseArr.length; i3++) {
            if (responseArr[i3] != null && (responseArr[i3] instanceof FetchResponse) && responseArr[i3].getNumber() == i2) {
                FetchResponse fetchResponse = responseArr[i3];
                int i4 = 0;
                while (true) {
                    Item[] itemArr = fetchResponse.items;
                    if (i4 >= itemArr.length) {
                        continue;
                        break;
                    } else if (cls.isInstance(itemArr[i4])) {
                        return fetchResponse.items[i4];
                    } else {
                        i4++;
                    }
                }
            }
        }
        return null;
    }

    private boolean match(char[] cArr) {
        int length = cArr.length;
        int i2 = this.index;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            int i5 = i3 + 1;
            if (Character.toUpperCase((char) this.buffer[i2]) != cArr[i3]) {
                return false;
            }
            i3 = i5;
            i2 = i4;
        }
        return true;
    }

    private void parse() throws ParsingException {
        int i2;
        int i3;
        int i4;
        int length;
        skipSpaces();
        if (this.buffer[this.index] == 40) {
            Vector vector = new Vector();
            Object obj = null;
            do {
                this.index++;
                if (this.index < this.size) {
                    byte b2 = this.buffer[this.index];
                    if (b2 != 66) {
                        if (b2 != 73) {
                            if (b2 != 82) {
                                if (b2 != 85) {
                                    if (b2 != 69) {
                                        if (b2 == 70 && match(FLAGS.name)) {
                                            this.index += FLAGS.name.length;
                                            obj = new FLAGS(this);
                                        }
                                    } else if (match(ENVELOPE.name)) {
                                        this.index += ENVELOPE.name.length;
                                        obj = new ENVELOPE(this);
                                    }
                                } else if (match(UID.name)) {
                                    this.index += UID.name.length;
                                    obj = new UID(this);
                                }
                            } else if (match(RFC822SIZE.name)) {
                                this.index += RFC822SIZE.name.length;
                                obj = new RFC822SIZE(this);
                            } else if (match(RFC822DATA.name)) {
                                this.index += RFC822DATA.name.length;
                                char[] cArr = HEADER;
                                if (match(cArr)) {
                                    i4 = this.index;
                                    length = cArr.length;
                                } else {
                                    char[] cArr2 = TEXT;
                                    if (match(cArr2)) {
                                        i4 = this.index;
                                        length = cArr2.length;
                                    }
                                    obj = new RFC822DATA(this);
                                }
                                this.index = i4 + length;
                                obj = new RFC822DATA(this);
                            }
                        } else if (match(INTERNALDATE.name)) {
                            this.index += INTERNALDATE.name.length;
                            obj = new INTERNALDATE(this);
                        }
                    } else if (match(BODY.name)) {
                        if (this.buffer[this.index + 4] == 91) {
                            this.index += BODY.name.length;
                            obj = new BODY(this);
                        } else {
                            if (match(BODYSTRUCTURE.name)) {
                                i3 = this.index;
                                i2 = BODYSTRUCTURE.name.length;
                            } else {
                                i3 = this.index;
                                i2 = BODY.name.length;
                            }
                            this.index = i3 + i2;
                            obj = new BODYSTRUCTURE(this);
                        }
                    }
                    if (obj != null) {
                        vector.addElement(obj);
                    }
                } else {
                    throw new ParsingException("error in FETCH parsing, ran off end of buffer, size " + this.size);
                }
            } while (this.buffer[this.index] != 41);
            this.index++;
            Item[] itemArr = new Item[vector.size()];
            this.items = itemArr;
            vector.copyInto(itemArr);
            return;
        }
        throw new ParsingException("error in FETCH parsing, missing '(' at index " + this.index);
    }

    public Item getItem(int i2) {
        return this.items[i2];
    }

    public Item getItem(Class cls) {
        int i2 = 0;
        while (true) {
            Item[] itemArr = this.items;
            if (i2 >= itemArr.length) {
                return null;
            }
            if (cls.isInstance(itemArr[i2])) {
                return this.items[i2];
            }
            i2++;
        }
    }

    public int getItemCount() {
        return this.items.length;
    }
}
