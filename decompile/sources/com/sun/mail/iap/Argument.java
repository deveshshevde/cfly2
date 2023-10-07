package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class Argument {
    protected Vector items = new Vector(1);

    private void astring(byte[] bArr, Protocol protocol) throws IOException, ProtocolException {
        byte b2;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        if (r1 > 1024) {
            literal(bArr, protocol);
            return;
        }
        boolean z2 = r1 == 0;
        boolean z3 = false;
        for (byte b3 : bArr) {
            if (b3 == 0 || b3 == 13 || b3 == 10 || (b2 = b3 & 255) > Byte.MAX_VALUE) {
                literal(bArr, protocol);
                return;
            }
            if (b3 == 42 || b3 == 37 || b3 == 40 || b3 == 41 || b3 == 123 || b3 == 34 || b3 == 92 || b2 <= 32) {
                if (b3 == 34 || b3 == 92) {
                    z2 = true;
                    z3 = true;
                } else {
                    z2 = true;
                }
            }
        }
        if (z2) {
            dataOutputStream.write(34);
        }
        if (z3) {
            for (byte b4 : bArr) {
                if (b4 == 34 || b4 == 92) {
                    dataOutputStream.write(92);
                }
                dataOutputStream.write(b4);
            }
        } else {
            dataOutputStream.write(bArr);
        }
        if (z2) {
            dataOutputStream.write(34);
        }
    }

    private void literal(Literal literal, Protocol protocol) throws IOException, ProtocolException {
        literal.writeTo(startLiteral(protocol, literal.size()));
    }

    private void literal(ByteArrayOutputStream byteArrayOutputStream, Protocol protocol) throws IOException, ProtocolException {
        byteArrayOutputStream.writeTo(startLiteral(protocol, byteArrayOutputStream.size()));
    }

    private void literal(byte[] bArr, Protocol protocol) throws IOException, ProtocolException {
        startLiteral(protocol, bArr.length).write(bArr);
    }

    private OutputStream startLiteral(Protocol protocol, int i2) throws IOException, ProtocolException {
        Response readResponse;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        boolean supportsNonSyncLiterals = protocol.supportsNonSyncLiterals();
        dataOutputStream.write(123);
        dataOutputStream.writeBytes(Integer.toString(i2));
        dataOutputStream.writeBytes(supportsNonSyncLiterals ? "+}\r\n" : "}\r\n");
        dataOutputStream.flush();
        if (!supportsNonSyncLiterals) {
            do {
                readResponse = protocol.readResponse();
                if (readResponse.isContinuation()) {
                }
            } while (!readResponse.isTagged());
            throw new LiteralException(readResponse);
        }
        return dataOutputStream;
    }

    public void append(Argument argument) {
        Vector vector = this.items;
        vector.ensureCapacity(vector.size() + argument.items.size());
        for (int i2 = 0; i2 < argument.items.size(); i2++) {
            this.items.addElement(argument.items.elementAt(i2));
        }
    }

    public void write(Protocol protocol) throws IOException, ProtocolException {
        String obj;
        Vector vector = this.items;
        int size = vector != null ? vector.size() : 0;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                dataOutputStream.write(32);
            }
            Object elementAt = this.items.elementAt(i2);
            if (elementAt instanceof Atom) {
                obj = ((Atom) elementAt).string;
            } else if (elementAt instanceof Number) {
                obj = ((Number) elementAt).toString();
            } else {
                if (elementAt instanceof AString) {
                    astring(((AString) elementAt).bytes, protocol);
                } else if (elementAt instanceof byte[]) {
                    literal((byte[]) elementAt, protocol);
                } else if (elementAt instanceof ByteArrayOutputStream) {
                    literal((ByteArrayOutputStream) elementAt, protocol);
                } else if (elementAt instanceof Literal) {
                    literal((Literal) elementAt, protocol);
                } else if (elementAt instanceof Argument) {
                    dataOutputStream.write(40);
                    ((Argument) elementAt).write(protocol);
                    dataOutputStream.write(41);
                }
            }
            dataOutputStream.writeBytes(obj);
        }
    }

    public void writeArgument(Argument argument) {
        this.items.addElement(argument);
    }

    public void writeAtom(String str) {
        this.items.addElement(new Atom(str));
    }

    public void writeBytes(Literal literal) {
        this.items.addElement(literal);
    }

    public void writeBytes(ByteArrayOutputStream byteArrayOutputStream) {
        this.items.addElement(byteArrayOutputStream);
    }

    public void writeBytes(byte[] bArr) {
        this.items.addElement(bArr);
    }

    public void writeNumber(int i2) {
        this.items.addElement(new Integer(i2));
    }

    public void writeNumber(long j2) {
        this.items.addElement(new Long(j2));
    }

    public void writeString(String str) {
        this.items.addElement(new AString(ASCIIUtility.getBytes(str)));
    }

    public void writeString(String str, String str2) throws UnsupportedEncodingException {
        if (str2 == null) {
            writeString(str);
        } else {
            this.items.addElement(new AString(str.getBytes(str2)));
        }
    }
}
