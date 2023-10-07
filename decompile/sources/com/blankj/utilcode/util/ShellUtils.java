package com.blankj.utilcode.util;

import com.blankj.utilcode.util.Utils;
import java.util.List;
import java.util.Objects;

public final class ShellUtils {
    private static final String LINE_SEP = System.getProperty("line.separator");

    public static class CommandResult {
        public String errorMsg;
        public int result;
        public String successMsg;

        public CommandResult(int i2, String str, String str2) {
            this.result = i2;
            this.successMsg = str;
            this.errorMsg = str2;
        }

        public String toString() {
            return "result: " + this.result + "\nsuccessMsg: " + this.successMsg + "\nerrorMsg: " + this.errorMsg;
        }
    }

    private ShellUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static CommandResult execCmd(String str, List<String> list, boolean z2) {
        return execCmd(new String[]{str}, list == null ? null : (String[]) list.toArray(new String[0]), z2, true);
    }

    public static CommandResult execCmd(String str, List<String> list, boolean z2, boolean z3) {
        return execCmd(new String[]{str}, list == null ? null : (String[]) list.toArray(new String[0]), z2, z3);
    }

    public static CommandResult execCmd(String str, boolean z2) {
        return execCmd(new String[]{str}, z2, true);
    }

    public static CommandResult execCmd(String str, boolean z2, boolean z3) {
        return execCmd(new String[]{str}, z2, z3);
    }

    public static CommandResult execCmd(String str, String[] strArr, boolean z2, boolean z3) {
        return execCmd(new String[]{str}, strArr, z2, z3);
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blankj.utilcode.util.ShellUtils.CommandResult execCmd(java.util.List<java.lang.String> r3, java.util.List<java.lang.String> r4, boolean r5) {
        /*
            r0 = 0
            r1 = 0
            if (r3 != 0) goto L_0x0006
            r3 = r0
            goto L_0x000e
        L_0x0006:
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.Object[] r3 = r3.toArray(r2)
            java.lang.String[] r3 = (java.lang.String[]) r3
        L_0x000e:
            if (r4 != 0) goto L_0x0011
            goto L_0x001a
        L_0x0011:
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.Object[] r4 = r4.toArray(r0)
            r0 = r4
            java.lang.String[] r0 = (java.lang.String[]) r0
        L_0x001a:
            r4 = 1
            com.blankj.utilcode.util.ShellUtils$CommandResult r3 = execCmd((java.lang.String[]) r3, (java.lang.String[]) r0, (boolean) r5, (boolean) r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ShellUtils.execCmd(java.util.List, java.util.List, boolean):com.blankj.utilcode.util.ShellUtils$CommandResult");
    }

    public static CommandResult execCmd(List<String> list, boolean z2) {
        return execCmd(list == null ? null : (String[]) list.toArray(new String[0]), z2, true);
    }

    public static CommandResult execCmd(List<String> list, boolean z2, boolean z3) {
        return execCmd(list == null ? null : (String[]) list.toArray(new String[0]), z2, z3);
    }

    public static CommandResult execCmd(String[] strArr, boolean z2) {
        return execCmd(strArr, z2, true);
    }

    public static CommandResult execCmd(String[] strArr, boolean z2, boolean z3) {
        return execCmd(strArr, (String[]) null, z2, z3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x012d, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x012e, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0133, code lost:
        r9.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0153, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0154, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x015d, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x015e, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0167, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0168, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x016d, code lost:
        r9.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bc, code lost:
        r4 = null;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c3, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c4, code lost:
        r4 = null;
        r5 = null;
        r3 = r10;
        r10 = r8;
        r8 = r11;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f2, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f3, code lost:
        r4 = null;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0119, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x011a, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0123, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0124, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x014f A[SYNTHETIC, Splitter:B:115:0x014f] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0159 A[SYNTHETIC, Splitter:B:120:0x0159] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0163 A[SYNTHETIC, Splitter:B:125:0x0163] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0115 A[SYNTHETIC, Splitter:B:88:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011f A[SYNTHETIC, Splitter:B:93:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0129 A[SYNTHETIC, Splitter:B:98:0x0129] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blankj.utilcode.util.ShellUtils.CommandResult execCmd(java.lang.String[] r8, java.lang.String[] r9, boolean r10, boolean r11) {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = ""
            r2 = -1
            if (r8 == 0) goto L_0x0171
            int r3 = r8.length
            if (r3 != 0) goto L_0x000c
            goto L_0x0171
        L_0x000c:
            r3 = 0
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x010a, all -> 0x0105 }
            if (r10 == 0) goto L_0x0016
            java.lang.String r10 = "su"
            goto L_0x0018
        L_0x0016:
            java.lang.String r10 = "sh"
        L_0x0018:
            java.lang.Process r9 = r4.exec(r10, r9, r3)     // Catch:{ Exception -> 0x010a, all -> 0x0105 }
            java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0102, all -> 0x00ff }
            java.io.OutputStream r4 = r9.getOutputStream()     // Catch:{ Exception -> 0x0102, all -> 0x00ff }
            r10.<init>(r4)     // Catch:{ Exception -> 0x0102, all -> 0x00ff }
            int r4 = r8.length     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            r5 = 0
        L_0x0027:
            if (r5 >= r4) goto L_0x0040
            r6 = r8[r5]     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            if (r6 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            r10.write(r6)     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            java.lang.String r6 = LINE_SEP     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            r10.writeBytes(r6)     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            r10.flush()     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
        L_0x003d:
            int r5 = r5 + 1
            goto L_0x0027
        L_0x0040:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            r8.<init>()     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            java.lang.String r4 = "exit"
            r8.append(r4)     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            java.lang.String r4 = LINE_SEP     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            r8.append(r4)     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            r10.writeBytes(r8)     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            r10.flush()     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            int r2 = r9.waitFor()     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            if (r11 == 0) goto L_0x00cc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            r8.<init>()     // Catch:{ Exception -> 0x00f8, all -> 0x00f2 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c3, all -> 0x00f2 }
            r11.<init>()     // Catch:{ Exception -> 0x00c3, all -> 0x00f2 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00bb, all -> 0x00f2 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00bb, all -> 0x00f2 }
            java.io.InputStream r6 = r9.getInputStream()     // Catch:{ Exception -> 0x00bb, all -> 0x00f2 }
            r5.<init>(r6, r0)     // Catch:{ Exception -> 0x00bb, all -> 0x00f2 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00f2 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.io.InputStream r7 = r9.getErrorStream()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r6.<init>(r7, r0)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r0 = r4.readLine()     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            if (r0 == 0) goto L_0x009a
        L_0x008b:
            r8.append(r0)     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            java.lang.String r0 = r4.readLine()     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            if (r0 == 0) goto L_0x009a
            java.lang.String r3 = LINE_SEP     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            r8.append(r3)     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            goto L_0x008b
        L_0x009a:
            java.lang.String r0 = r5.readLine()     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            if (r0 == 0) goto L_0x00af
        L_0x00a0:
            r11.append(r0)     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            java.lang.String r0 = r5.readLine()     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            if (r0 == 0) goto L_0x00af
            java.lang.String r3 = LINE_SEP     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            r11.append(r3)     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            goto L_0x00a0
        L_0x00af:
            r3 = r4
            goto L_0x00cf
        L_0x00b1:
            r8 = move-exception
            goto L_0x00f5
        L_0x00b3:
            r0 = move-exception
            goto L_0x00be
        L_0x00b5:
            r8 = move-exception
            r5 = r3
            goto L_0x00f5
        L_0x00b8:
            r0 = move-exception
            r5 = r3
            goto L_0x00be
        L_0x00bb:
            r0 = move-exception
            r4 = r3
            r5 = r4
        L_0x00be:
            r3 = r10
            r10 = r8
            r8 = r0
            goto L_0x0110
        L_0x00c3:
            r11 = move-exception
            r4 = r3
            r5 = r4
            r3 = r10
            r10 = r8
            r8 = r11
            r11 = r5
            goto L_0x0110
        L_0x00cc:
            r8 = r3
            r11 = r8
            r5 = r11
        L_0x00cf:
            r10.close()     // Catch:{ IOException -> 0x00d3 }
            goto L_0x00d7
        L_0x00d3:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00d7:
            if (r3 == 0) goto L_0x00e1
            r3.close()     // Catch:{ IOException -> 0x00dd }
            goto L_0x00e1
        L_0x00dd:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00e1:
            if (r5 == 0) goto L_0x00eb
            r5.close()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00eb:
            if (r9 == 0) goto L_0x0137
            r9.destroy()
            goto L_0x0137
        L_0x00f2:
            r8 = move-exception
            r4 = r3
            r5 = r4
        L_0x00f5:
            r3 = r10
            goto L_0x014d
        L_0x00f8:
            r8 = move-exception
            r11 = r3
            r4 = r11
            r5 = r4
            r3 = r10
            r10 = r5
            goto L_0x0110
        L_0x00ff:
            r8 = move-exception
            r4 = r3
            goto L_0x0108
        L_0x0102:
            r8 = move-exception
            r10 = r3
            goto L_0x010d
        L_0x0105:
            r8 = move-exception
            r9 = r3
            r4 = r9
        L_0x0108:
            r5 = r4
            goto L_0x014d
        L_0x010a:
            r8 = move-exception
            r9 = r3
            r10 = r9
        L_0x010d:
            r11 = r10
            r4 = r11
            r5 = r4
        L_0x0110:
            r8.printStackTrace()     // Catch:{ all -> 0x014c }
            if (r3 == 0) goto L_0x011d
            r3.close()     // Catch:{ IOException -> 0x0119 }
            goto L_0x011d
        L_0x0119:
            r8 = move-exception
            r8.printStackTrace()
        L_0x011d:
            if (r4 == 0) goto L_0x0127
            r4.close()     // Catch:{ IOException -> 0x0123 }
            goto L_0x0127
        L_0x0123:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0127:
            if (r5 == 0) goto L_0x0131
            r5.close()     // Catch:{ IOException -> 0x012d }
            goto L_0x0131
        L_0x012d:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0131:
            if (r9 == 0) goto L_0x0136
            r9.destroy()
        L_0x0136:
            r8 = r10
        L_0x0137:
            com.blankj.utilcode.util.ShellUtils$CommandResult r9 = new com.blankj.utilcode.util.ShellUtils$CommandResult
            if (r8 != 0) goto L_0x013d
            r8 = r1
            goto L_0x0141
        L_0x013d:
            java.lang.String r8 = r8.toString()
        L_0x0141:
            if (r11 != 0) goto L_0x0144
            goto L_0x0148
        L_0x0144:
            java.lang.String r1 = r11.toString()
        L_0x0148:
            r9.<init>(r2, r8, r1)
            return r9
        L_0x014c:
            r8 = move-exception
        L_0x014d:
            if (r3 == 0) goto L_0x0157
            r3.close()     // Catch:{ IOException -> 0x0153 }
            goto L_0x0157
        L_0x0153:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0157:
            if (r4 == 0) goto L_0x0161
            r4.close()     // Catch:{ IOException -> 0x015d }
            goto L_0x0161
        L_0x015d:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0161:
            if (r5 == 0) goto L_0x016b
            r5.close()     // Catch:{ IOException -> 0x0167 }
            goto L_0x016b
        L_0x0167:
            r10 = move-exception
            r10.printStackTrace()
        L_0x016b:
            if (r9 == 0) goto L_0x0170
            r9.destroy()
        L_0x0170:
            throw r8
        L_0x0171:
            com.blankj.utilcode.util.ShellUtils$CommandResult r8 = new com.blankj.utilcode.util.ShellUtils$CommandResult
            r8.<init>(r2, r1, r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ShellUtils.execCmd(java.lang.String[], java.lang.String[], boolean, boolean):com.blankj.utilcode.util.ShellUtils$CommandResult");
    }

    public static Utils.Task<CommandResult> execCmdAsync(String str, boolean z2, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(new String[]{str}, z2, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(String str, boolean z2, boolean z3, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(new String[]{str}, z2, z3, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(List<String> list, boolean z2, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(list == null ? null : (String[]) list.toArray(new String[0]), z2, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(List<String> list, boolean z2, boolean z3, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(list == null ? null : (String[]) list.toArray(new String[0]), z2, z3, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(String[] strArr, boolean z2, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(strArr, z2, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(final String[] strArr, final boolean z2, final boolean z3, Utils.Consumer<CommandResult> consumer) {
        Objects.requireNonNull(consumer, "Argument 'consumer' of type Utils.Consumer<CommandResult> (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return UtilsBridge.doAsync(new Utils.Task<CommandResult>(consumer) {
            public CommandResult doInBackground() {
                return ShellUtils.execCmd(strArr, z2, z3);
            }
        });
    }
}
