package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.util.Vector;

public class ListInfo {
    public static final int CHANGED = 1;
    public static final int INDETERMINATE = 3;
    public static final int UNCHANGED = 2;
    public String[] attrs;
    public boolean canOpen = true;
    public int changeState = 3;
    public boolean hasInferiors = true;
    public String name = null;
    public char separator = '/';

    public ListInfo(IMAPResponse iMAPResponse) throws ParsingException {
        String[] readSimpleList = iMAPResponse.readSimpleList();
        Vector vector = new Vector();
        if (readSimpleList != null) {
            for (int i2 = 0; i2 < readSimpleList.length; i2++) {
                if (readSimpleList[i2].equalsIgnoreCase("\\Marked")) {
                    this.changeState = 1;
                } else if (readSimpleList[i2].equalsIgnoreCase("\\Unmarked")) {
                    this.changeState = 2;
                } else if (readSimpleList[i2].equalsIgnoreCase("\\Noselect")) {
                    this.canOpen = false;
                } else if (readSimpleList[i2].equalsIgnoreCase("\\Noinferiors")) {
                    this.hasInferiors = false;
                }
                vector.addElement(readSimpleList[i2]);
            }
        }
        String[] strArr = new String[vector.size()];
        this.attrs = strArr;
        vector.copyInto(strArr);
        iMAPResponse.skipSpaces();
        if (iMAPResponse.readByte() == 34) {
            char readByte = (char) iMAPResponse.readByte();
            this.separator = readByte;
            if (readByte == '\\') {
                this.separator = (char) iMAPResponse.readByte();
            }
            iMAPResponse.skip(1);
        } else {
            iMAPResponse.skip(2);
        }
        iMAPResponse.skipSpaces();
        String readAtomString = iMAPResponse.readAtomString();
        this.name = readAtomString;
        this.name = BASE64MailboxDecoder.decode(readAtomString);
    }
}
