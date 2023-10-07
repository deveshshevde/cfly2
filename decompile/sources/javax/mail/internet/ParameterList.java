package javax.mail.internet;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ParameterList {
    private static boolean applehack = false;
    private static boolean decodeParameters = false;
    private static boolean decodeParametersStrict = false;
    private static boolean encodeParameters = false;
    private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private String lastName;
    private Map list;
    private Set multisegmentNames;
    private Map slist;

    private static class MultiValue extends ArrayList {
        String value;

        private MultiValue() {
        }

        /* synthetic */ MultiValue(MultiValue multiValue) {
            this();
        }
    }

    private static class ParamEnum implements Enumeration {

        /* renamed from: it  reason: collision with root package name */
        private Iterator f29478it;

        ParamEnum(Iterator it2) {
            this.f29478it = it2;
        }

        public boolean hasMoreElements() {
            return this.f29478it.hasNext();
        }

        public Object nextElement() {
            return this.f29478it.next();
        }
    }

    private static class ToStringBuffer {
        private StringBuffer sb = new StringBuffer();
        private int used;

        public ToStringBuffer(int i2) {
            this.used = i2;
        }

        public void addNV(String str, String str2) {
            String access$0 = ParameterList.quote(str2);
            this.sb.append("; ");
            this.used += 2;
            if (this.used + str.length() + access$0.length() + 1 > 76) {
                this.sb.append("\r\n\t");
                this.used = 8;
            }
            StringBuffer stringBuffer = this.sb;
            stringBuffer.append(str);
            stringBuffer.append('=');
            int length = this.used + str.length() + 1;
            this.used = length;
            if (length + access$0.length() > 76) {
                String fold = MimeUtility.fold(this.used, access$0);
                this.sb.append(fold);
                int lastIndexOf = fold.lastIndexOf(10);
                if (lastIndexOf >= 0) {
                    this.used += (fold.length() - lastIndexOf) - 1;
                } else {
                    this.used += fold.length();
                }
            } else {
                this.sb.append(access$0);
                this.used += access$0.length();
            }
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    private static class Value {
        String charset;
        String encodedValue;
        String value;

        private Value() {
        }

        /* synthetic */ Value(Value value2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A[Catch:{ SecurityException -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[Catch:{ SecurityException -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0038 A[Catch:{ SecurityException -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a A[Catch:{ SecurityException -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b A[Catch:{ SecurityException -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c A[Catch:{ SecurityException -> 0x004f }] */
    static {
        /*
            java.lang.String r0 = "mail.mime.encodeparameters"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x004f }
            r1 = 1
            java.lang.String r2 = "true"
            r3 = 0
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x004f }
            if (r0 == 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            encodeParameters = r0     // Catch:{ SecurityException -> 0x004f }
            java.lang.String r0 = "mail.mime.decodeparameters"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x004f }
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x004f }
            if (r0 == 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            decodeParameters = r0     // Catch:{ SecurityException -> 0x004f }
            java.lang.String r0 = "mail.mime.decodeparameters.strict"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x004f }
            if (r0 == 0) goto L_0x003a
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x004f }
            if (r0 == 0) goto L_0x003a
            r0 = 1
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            decodeParametersStrict = r0     // Catch:{ SecurityException -> 0x004f }
            java.lang.String r0 = "mail.mime.applefilenames"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x004f }
            if (r0 == 0) goto L_0x004c
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x004f }
            if (r0 == 0) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r1 = 0
        L_0x004d:
            applehack = r1     // Catch:{ SecurityException -> 0x004f }
        L_0x004f:
            r0 = 16
            char[] r0 = new char[r0]
            r0 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70} // fill-array
            hex = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.<clinit>():void");
    }

    public ParameterList() {
        this.list = new LinkedHashMap();
        this.lastName = null;
        if (decodeParameters) {
            this.multisegmentNames = new HashSet();
            this.slist = new HashMap();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0125, code lost:
        throw new javax.mail.internet.ParseException("Expected ';', got \"" + r8.getValue() + "\"");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ParameterList(java.lang.String r8) throws javax.mail.internet.ParseException {
        /*
            r7 = this;
            r7.<init>()
            javax.mail.internet.HeaderTokenizer r0 = new javax.mail.internet.HeaderTokenizer
            java.lang.String r1 = "()<>@,;:\\\"\t []/?="
            r0.<init>(r8, r1)
        L_0x000a:
            javax.mail.internet.HeaderTokenizer$Token r8 = r0.next()
            int r1 = r8.getType()
            r2 = -4
            if (r1 != r2) goto L_0x0016
            goto L_0x0028
        L_0x0016:
            char r3 = (char) r1
            r4 = 59
            r5 = -1
            java.lang.String r6 = "\""
            if (r3 != r4) goto L_0x00c2
            javax.mail.internet.HeaderTokenizer$Token r8 = r0.next()
            int r1 = r8.getType()
            if (r1 != r2) goto L_0x0031
        L_0x0028:
            boolean r8 = decodeParameters
            if (r8 == 0) goto L_0x0030
            r8 = 0
            r7.combineMultisegmentNames(r8)
        L_0x0030:
            return
        L_0x0031:
            int r1 = r8.getType()
            if (r1 != r5) goto L_0x00a7
            java.lang.String r8 = r8.getValue()
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r8 = r8.toLowerCase(r1)
            javax.mail.internet.HeaderTokenizer$Token r1 = r0.next()
            int r2 = r1.getType()
            char r2 = (char) r2
            r3 = 61
            if (r2 != r3) goto L_0x008c
            javax.mail.internet.HeaderTokenizer$Token r1 = r0.next()
            int r2 = r1.getType()
            if (r2 == r5) goto L_0x0077
            r3 = -2
            if (r2 != r3) goto L_0x005c
            goto L_0x0077
        L_0x005c:
            javax.mail.internet.ParseException r8 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected parameter value, got \""
            r0.<init>(r2)
            java.lang.String r1 = r1.getValue()
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x0077:
            java.lang.String r1 = r1.getValue()
            r7.lastName = r8
            boolean r2 = decodeParameters
            if (r2 == 0) goto L_0x0085
            r7.putEncodedName(r8, r1)
            goto L_0x000a
        L_0x0085:
            java.util.Map r2 = r7.list
            r2.put(r8, r1)
            goto L_0x000a
        L_0x008c:
            javax.mail.internet.ParseException r8 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected '=', got \""
            r0.<init>(r2)
            java.lang.String r1 = r1.getValue()
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x00a7:
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected parameter name, got \""
            r1.<init>(r2)
            java.lang.String r8 = r8.getValue()
            r1.append(r8)
            r1.append(r6)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L_0x00c2:
            boolean r2 = applehack
            if (r2 == 0) goto L_0x010a
            if (r1 != r5) goto L_0x010a
            java.lang.String r1 = r7.lastName
            if (r1 == 0) goto L_0x010a
            java.lang.String r2 = "name"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00de
            java.lang.String r1 = r7.lastName
            java.lang.String r2 = "filename"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x010a
        L_0x00de:
            java.util.Map r1 = r7.list
            java.lang.String r2 = r7.lastName
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2.<init>(r1)
            java.lang.String r1 = " "
            r2.append(r1)
            java.lang.String r8 = r8.getValue()
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            java.util.Map r1 = r7.list
            java.lang.String r2 = r7.lastName
            r1.put(r2, r8)
            goto L_0x000a
        L_0x010a:
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected ';', got \""
            r1.<init>(r2)
            java.lang.String r8 = r8.getValue()
            r1.append(r8)
            r1.append(r6)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            goto L_0x0126
        L_0x0125:
            throw r0
        L_0x0126:
            goto L_0x0125
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d7 A[Catch:{ NumberFormatException -> 0x00f5, UnsupportedEncodingException -> 0x00e2, StringIndexOutOfBoundsException -> 0x00cf, all -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ea A[Catch:{ NumberFormatException -> 0x00f5, UnsupportedEncodingException -> 0x00e2, StringIndexOutOfBoundsException -> 0x00cf, all -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00d8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00eb A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void combineMultisegmentNames(boolean r13) throws javax.mail.internet.ParseException {
        /*
            r12 = this;
            java.util.Set r0 = r12.multisegmentNames     // Catch:{ all -> 0x011a }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x011a }
        L_0x0006:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x011a }
            if (r1 != 0) goto L_0x0050
            java.util.Map r13 = r12.slist
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x0045
            java.util.Map r13 = r12.slist
            java.util.Collection r13 = r13.values()
            java.util.Iterator r13 = r13.iterator()
        L_0x001e:
            boolean r0 = r13.hasNext()
            if (r0 != 0) goto L_0x002c
            java.util.Map r13 = r12.list
            java.util.Map r0 = r12.slist
            r13.putAll(r0)
            goto L_0x0045
        L_0x002c:
            java.lang.Object r0 = r13.next()
            boolean r1 = r0 instanceof javax.mail.internet.ParameterList.Value
            if (r1 == 0) goto L_0x001e
            javax.mail.internet.ParameterList$Value r0 = (javax.mail.internet.ParameterList.Value) r0
            java.lang.String r1 = r0.encodedValue
            javax.mail.internet.ParameterList$Value r1 = decodeValue(r1)
            java.lang.String r2 = r1.charset
            r0.charset = r2
            java.lang.String r1 = r1.value
            r0.value = r1
            goto L_0x001e
        L_0x0045:
            java.util.Set r13 = r12.multisegmentNames
            r13.clear()
            java.util.Map r13 = r12.slist
            r13.clear()
            return
        L_0x0050:
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x011a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x011a }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ all -> 0x011a }
            r2.<init>()     // Catch:{ all -> 0x011a }
            javax.mail.internet.ParameterList$MultiValue r3 = new javax.mail.internet.ParameterList$MultiValue     // Catch:{ all -> 0x011a }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x011a }
            r5 = 0
            r6 = r4
        L_0x0063:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            java.lang.String r8 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x011a }
            r7.<init>(r8)     // Catch:{ all -> 0x011a }
            java.lang.String r8 = "*"
            r7.append(r8)     // Catch:{ all -> 0x011a }
            r7.append(r5)     // Catch:{ all -> 0x011a }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x011a }
            java.util.Map r8 = r12.slist     // Catch:{ all -> 0x011a }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ all -> 0x011a }
            if (r8 != 0) goto L_0x0081
            goto L_0x00b0
        L_0x0081:
            r3.add(r8)     // Catch:{ all -> 0x011a }
            boolean r9 = r8 instanceof javax.mail.internet.ParameterList.Value     // Catch:{ all -> 0x011a }
            if (r9 == 0) goto L_0x0109
            javax.mail.internet.ParameterList$Value r8 = (javax.mail.internet.ParameterList.Value) r8     // Catch:{ NumberFormatException -> 0x00f5, UnsupportedEncodingException -> 0x00e2, StringIndexOutOfBoundsException -> 0x00cf }
            java.lang.String r9 = r8.encodedValue     // Catch:{ NumberFormatException -> 0x00f5, UnsupportedEncodingException -> 0x00e2, StringIndexOutOfBoundsException -> 0x00cf }
            if (r5 != 0) goto L_0x00a9
            javax.mail.internet.ParameterList$Value r10 = decodeValue(r9)     // Catch:{ NumberFormatException -> 0x00a7, UnsupportedEncodingException -> 0x00a5, StringIndexOutOfBoundsException -> 0x00a3 }
            java.lang.String r11 = r10.charset     // Catch:{ NumberFormatException -> 0x00a7, UnsupportedEncodingException -> 0x00a5, StringIndexOutOfBoundsException -> 0x00a3 }
            r8.charset = r11     // Catch:{ NumberFormatException -> 0x00a7, UnsupportedEncodingException -> 0x00a5, StringIndexOutOfBoundsException -> 0x00a3 }
            java.lang.String r6 = r10.value     // Catch:{ NumberFormatException -> 0x00a0, UnsupportedEncodingException -> 0x009e, StringIndexOutOfBoundsException -> 0x009c }
            r8.value = r6     // Catch:{ NumberFormatException -> 0x00a0, UnsupportedEncodingException -> 0x009e, StringIndexOutOfBoundsException -> 0x009c }
            goto L_0x010d
        L_0x009c:
            r6 = move-exception
            goto L_0x00d3
        L_0x009e:
            r6 = move-exception
            goto L_0x00e6
        L_0x00a0:
            r6 = move-exception
            goto L_0x00f9
        L_0x00a3:
            r8 = move-exception
            goto L_0x00d1
        L_0x00a5:
            r8 = move-exception
            goto L_0x00e4
        L_0x00a7:
            r8 = move-exception
            goto L_0x00f7
        L_0x00a9:
            if (r6 != 0) goto L_0x00c6
            java.util.Set r8 = r12.multisegmentNames     // Catch:{ NumberFormatException -> 0x00a7, UnsupportedEncodingException -> 0x00a5, StringIndexOutOfBoundsException -> 0x00a3 }
            r8.remove(r1)     // Catch:{ NumberFormatException -> 0x00a7, UnsupportedEncodingException -> 0x00a5, StringIndexOutOfBoundsException -> 0x00a3 }
        L_0x00b0:
            if (r5 != 0) goto L_0x00b9
            java.util.Map r2 = r12.list     // Catch:{ all -> 0x011a }
            r2.remove(r1)     // Catch:{ all -> 0x011a }
            goto L_0x0006
        L_0x00b9:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x011a }
            r3.value = r2     // Catch:{ all -> 0x011a }
            java.util.Map r2 = r12.list     // Catch:{ all -> 0x011a }
            r2.put(r1, r3)     // Catch:{ all -> 0x011a }
            goto L_0x0006
        L_0x00c6:
            java.lang.String r10 = decodeBytes(r9, r6)     // Catch:{ NumberFormatException -> 0x00a7, UnsupportedEncodingException -> 0x00a5, StringIndexOutOfBoundsException -> 0x00a3 }
            r8.value = r10     // Catch:{ NumberFormatException -> 0x00a7, UnsupportedEncodingException -> 0x00a5, StringIndexOutOfBoundsException -> 0x00a3 }
            r11 = r6
            r6 = r10
            goto L_0x010d
        L_0x00cf:
            r8 = move-exception
            r9 = r4
        L_0x00d1:
            r11 = r6
            r6 = r8
        L_0x00d3:
            boolean r8 = decodeParametersStrict     // Catch:{ all -> 0x011a }
            if (r8 != 0) goto L_0x00d8
            goto L_0x00fd
        L_0x00d8:
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException     // Catch:{ all -> 0x011a }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x011a }
            r0.<init>(r1)     // Catch:{ all -> 0x011a }
            throw r0     // Catch:{ all -> 0x011a }
        L_0x00e2:
            r8 = move-exception
            r9 = r4
        L_0x00e4:
            r11 = r6
            r6 = r8
        L_0x00e6:
            boolean r8 = decodeParametersStrict     // Catch:{ all -> 0x011a }
            if (r8 != 0) goto L_0x00eb
            goto L_0x00fd
        L_0x00eb:
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException     // Catch:{ all -> 0x011a }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x011a }
            r0.<init>(r1)     // Catch:{ all -> 0x011a }
            throw r0     // Catch:{ all -> 0x011a }
        L_0x00f5:
            r8 = move-exception
            r9 = r4
        L_0x00f7:
            r11 = r6
            r6 = r8
        L_0x00f9:
            boolean r8 = decodeParametersStrict     // Catch:{ all -> 0x011a }
            if (r8 != 0) goto L_0x00ff
        L_0x00fd:
            r6 = r9
            goto L_0x010d
        L_0x00ff:
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException     // Catch:{ all -> 0x011a }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x011a }
            r0.<init>(r1)     // Catch:{ all -> 0x011a }
            throw r0     // Catch:{ all -> 0x011a }
        L_0x0109:
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x011a }
            r11 = r6
            r6 = r8
        L_0x010d:
            r2.append(r6)     // Catch:{ all -> 0x011a }
            java.util.Map r6 = r12.slist     // Catch:{ all -> 0x011a }
            r6.remove(r7)     // Catch:{ all -> 0x011a }
            int r5 = r5 + 1
            r6 = r11
            goto L_0x0063
        L_0x011a:
            r0 = move-exception
            if (r13 != 0) goto L_0x011e
            goto L_0x0160
        L_0x011e:
            java.util.Map r13 = r12.slist
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x0156
            java.util.Map r13 = r12.slist
            java.util.Collection r13 = r13.values()
            java.util.Iterator r13 = r13.iterator()
        L_0x0130:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x014f
            java.lang.Object r1 = r13.next()
            boolean r2 = r1 instanceof javax.mail.internet.ParameterList.Value
            if (r2 == 0) goto L_0x0130
            javax.mail.internet.ParameterList$Value r1 = (javax.mail.internet.ParameterList.Value) r1
            java.lang.String r2 = r1.encodedValue
            javax.mail.internet.ParameterList$Value r2 = decodeValue(r2)
            java.lang.String r3 = r2.charset
            r1.charset = r3
            java.lang.String r2 = r2.value
            r1.value = r2
            goto L_0x0130
        L_0x014f:
            java.util.Map r13 = r12.list
            java.util.Map r1 = r12.slist
            r13.putAll(r1)
        L_0x0156:
            java.util.Set r13 = r12.multisegmentNames
            r13.clear()
            java.util.Map r13 = r12.slist
            r13.clear()
        L_0x0160:
            goto L_0x0162
        L_0x0161:
            throw r0
        L_0x0162:
            goto L_0x0161
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.combineMultisegmentNames(boolean):void");
    }

    private static String decodeBytes(String str, String str2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt == '%') {
                charAt = (char) Integer.parseInt(str.substring(i2 + 1, i2 + 3), 16);
                i2 += 2;
            }
            bArr[i3] = (byte) charAt;
            i2++;
            i3++;
        }
        return new String(bArr, 0, i3, MimeUtility.javaCharset(str2));
    }

    private static Value decodeValue(String str) throws ParseException {
        Value value = new Value((Value) null);
        value.encodedValue = str;
        value.value = str;
        try {
            int indexOf = str.indexOf(39);
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int i2 = indexOf + 1;
                int indexOf2 = str.indexOf(39, i2);
                if (indexOf2 >= 0) {
                    str.substring(i2, indexOf2);
                    String substring2 = str.substring(indexOf2 + 1);
                    value.charset = substring;
                    value.value = decodeBytes(substring2, substring);
                    return value;
                } else if (!decodeParametersStrict) {
                    return value;
                } else {
                    throw new ParseException("Missing language in encoded value: " + str);
                }
            } else if (!decodeParametersStrict) {
                return value;
            } else {
                throw new ParseException("Missing charset in encoded value: " + str);
            }
        } catch (NumberFormatException e2) {
            if (decodeParametersStrict) {
                throw new ParseException(e2.toString());
            }
        } catch (UnsupportedEncodingException e3) {
            if (decodeParametersStrict) {
                throw new ParseException(e3.toString());
            }
        } catch (StringIndexOutOfBoundsException e4) {
            if (decodeParametersStrict) {
                throw new ParseException(e4.toString());
            }
        }
    }

    private static Value encodeValue(String str, String str2) {
        if (MimeUtility.checkAscii(str) == 1) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(MimeUtility.javaCharset(str2));
            StringBuffer stringBuffer = new StringBuffer(bytes.length + str2.length() + 2);
            stringBuffer.append(str2);
            stringBuffer.append("''");
            for (byte b2 : bytes) {
                char c2 = (char) (b2 & 255);
                if (c2 <= ' ' || c2 >= 127 || c2 == '*' || c2 == '\'' || c2 == '%' || HeaderTokenizer.MIME.indexOf(c2) >= 0) {
                    stringBuffer.append('%');
                    char[] cArr = hex;
                    stringBuffer.append(cArr[c2 >> 4]);
                    c2 = cArr[c2 & 15];
                }
                stringBuffer.append(c2);
            }
            Value value = new Value((Value) null);
            value.charset = str2;
            value.value = str;
            value.encodedValue = stringBuffer.toString();
            return value;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private void putEncodedName(String str, String str2) throws ParseException {
        Map map;
        Object obj;
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            map = this.list;
            obj = str2;
        } else if (indexOf == str.length() - 1) {
            str = str.substring(0, indexOf);
            map = this.list;
            obj = decodeValue(str2);
        } else {
            String substring = str.substring(0, indexOf);
            this.multisegmentNames.add(substring);
            this.list.put(substring, "");
            Object obj2 = str2;
            if (str.endsWith("*")) {
                Object value = new Value((Value) null);
                Value value2 = (Value) value;
                value2.encodedValue = str2;
                value2.value = str2;
                str = str.substring(0, str.length() - 1);
                obj2 = value;
            }
            map = this.slist;
            obj = obj2;
        }
        map.put(str, obj);
    }

    /* access modifiers changed from: private */
    public static String quote(String str) {
        return MimeUtility.quote(str, HeaderTokenizer.MIME);
    }

    public String get(String str) {
        Object obj = this.list.get(str.trim().toLowerCase(Locale.ENGLISH));
        return obj instanceof MultiValue ? ((MultiValue) obj).value : obj instanceof Value ? ((Value) obj).value : (String) obj;
    }

    public Enumeration getNames() {
        return new ParamEnum(this.list.keySet().iterator());
    }

    public void remove(String str) {
        this.list.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String str, String str2) {
        if (str != null || str2 == null || !str2.equals("DONE")) {
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            if (decodeParameters) {
                try {
                    putEncodedName(lowerCase, str2);
                    return;
                } catch (ParseException unused) {
                }
            }
            this.list.put(lowerCase, str2);
        } else if (decodeParameters && this.multisegmentNames.size() > 0) {
            try {
                combineMultisegmentNames(true);
            } catch (ParseException unused2) {
            }
        }
    }

    public void set(String str, String str2, String str3) {
        Value encodeValue;
        if (!encodeParameters || (encodeValue = encodeValue(str2, str3)) == null) {
            set(str, str2);
        } else {
            this.list.put(str.trim().toLowerCase(Locale.ENGLISH), encodeValue);
        }
    }

    public int size() {
        return this.list.size();
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i2) {
        String str;
        String str2;
        String str3;
        ToStringBuffer toStringBuffer = new ToStringBuffer(i2);
        for (String str4 : this.list.keySet()) {
            Object obj = this.list.get(str4);
            if (obj instanceof MultiValue) {
                MultiValue multiValue = (MultiValue) obj;
                String str5 = String.valueOf(str4) + "*";
                for (int i3 = 0; i3 < multiValue.size(); i3++) {
                    Object obj2 = multiValue.get(i3);
                    if (obj2 instanceof Value) {
                        str2 = String.valueOf(str5) + i3 + "*";
                        str3 = ((Value) obj2).encodedValue;
                    } else {
                        str2 = String.valueOf(str5) + i3;
                        str3 = (String) obj2;
                    }
                    toStringBuffer.addNV(str2, str3);
                }
            } else {
                if (obj instanceof Value) {
                    str4 = String.valueOf(str4) + "*";
                    str = ((Value) obj).encodedValue;
                } else {
                    str = (String) obj;
                }
                toStringBuffer.addNV(str4, str);
            }
        }
        return toStringBuffer.toString();
    }
}
