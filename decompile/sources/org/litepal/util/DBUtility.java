package org.litepal.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.Const;

public class DBUtility {
    private static final String KEYWORDS_COLUMN_SUFFIX = "_lpcolumn";
    private static final String REG_COLLECTION = "\\s+(not\\s+)?(in)\\s*\\(";
    private static final String REG_FUZZY = "\\s+(not\\s+)?(like|between)\\s+";
    private static final String REG_OPERATOR = "\\s*(=|!=|<>|<|>)";
    private static final String SQLITE_KEYWORDS = ",abort,add,after,all,alter,and,as,asc,autoincrement,before,begin,between,by,cascade,check,collate,column,commit,conflict,constraint,create,cross,database,deferrable,deferred,delete,desc,distinct,drop,each,end,escape,except,exclusive,exists,foreign,from,glob,group,having,in,index,inner,insert,intersect,into,is,isnull,join,like,limit,match,natural,not,notnull,null,of,offset,on,or,order,outer,plan,pragma,primary,query,raise,references,regexp,reindex,release,rename,replace,restrict,right,rollback,row,savepoint,select,set,table,temp,temporary,then,to,transaction,trigger,union,unique,update,using,vacuum,values,view,virtual,when,where,";
    private static final String TAG = "DBUtility";

    private DBUtility() {
    }

    public static String convertOrderByClauseToValidName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.trim().toLowerCase(Locale.US);
        if (!lowerCase.contains(",")) {
            return convertOrderByItem(lowerCase);
        }
        String[] split = lowerCase.split(",");
        StringBuilder sb = new StringBuilder();
        int length = split.length;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < length) {
            String str2 = split[i2];
            if (z2) {
                sb.append(",");
            }
            sb.append(convertOrderByItem(str2));
            i2++;
            z2 = true;
        }
        return sb.toString();
    }

    private static String convertOrderByItem(String str) {
        String str2 = "";
        if (str.endsWith("asc")) {
            str = str.replace("asc", str2).trim();
            str2 = " asc";
        } else if (str.endsWith("desc")) {
            str = str.replace("desc", str2).trim();
            str2 = " desc";
        }
        return convertToValidColumnName(str) + str2;
    }

    public static String[] convertSelectClauseToValidNames(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2[i2] = convertToValidColumnName(strArr[i2]);
        }
        return strArr2;
    }

    public static String convertToValidColumnName(String str) {
        if (!isFieldNameConflictWithSQLiteKeywords(str)) {
            return str;
        }
        return str + KEYWORDS_COLUMN_SUFFIX;
    }

    public static String convertWhereClauseToColumnName(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("(\\w+\\s*(=|!=|<>|<|>)|\\w+\\s+(not\\s+)?(like|between)\\s+|\\w+\\s+(not\\s+)?(in)\\s*\\()").matcher(str);
                while (matcher.find()) {
                    String group = matcher.group();
                    String replaceAll = group.replaceAll("(\\s*(=|!=|<>|<|>)|\\s+(not\\s+)?(like|between)\\s+|\\s+(not\\s+)?(in)\\s*\\()", "");
                    String replace = group.replace(replaceAll, "");
                    String convertToValidColumnName = convertToValidColumnName(replaceAll);
                    matcher.appendReplacement(stringBuffer, convertToValidColumnName + replace);
                }
                matcher.appendTail(stringBuffer);
                return stringBuffer.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static List<String> findAllTableNames(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from sqlite_master where type = ?", new String[]{"table"});
            if (rawQuery.moveToFirst()) {
                do {
                    String string = rawQuery.getString(rawQuery.getColumnIndexOrThrow("tbl_name"));
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                    }
                } while (rawQuery.moveToNext());
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new DatabaseGenerateException(e2.getMessage());
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static TableModel findPragmaTableInfo(String str, SQLiteDatabase sQLiteDatabase) {
        if (isTableExists(str, sQLiteDatabase)) {
            List<String> findUniqueColumns = findUniqueColumns(str, sQLiteDatabase);
            TableModel tableModel = new TableModel();
            tableModel.setTableName(str);
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.rawQuery("pragma table_info(" + str + ")", (String[]) null);
                if (cursor.moveToFirst()) {
                    do {
                        ColumnModel columnModel = new ColumnModel();
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("type"));
                        boolean z2 = true;
                        if (cursor.getInt(cursor.getColumnIndexOrThrow("notnull")) == 1) {
                            z2 = false;
                        }
                        boolean contains = findUniqueColumns.contains(string);
                        String string3 = cursor.getString(cursor.getColumnIndexOrThrow("dflt_value"));
                        columnModel.setColumnName(string);
                        columnModel.setColumnType(string2);
                        columnModel.setNullable(z2);
                        columnModel.setUnique(contains);
                        String str2 = "";
                        if (string3 != null) {
                            str2 = string3.replace("'", str2);
                        }
                        columnModel.setDefaultValue(str2);
                        tableModel.addColumnModel(columnModel);
                    } while (cursor.moveToNext());
                }
                if (cursor != null) {
                    cursor.close();
                }
                return tableModel;
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new DatabaseGenerateException(e2.getMessage());
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            throw new DatabaseGenerateException(DatabaseGenerateException.TABLE_DOES_NOT_EXIST_WHEN_EXECUTING + str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> findUniqueColumns(java.lang.String r8, android.database.sqlite.SQLiteDatabase r9) {
        /*
            java.lang.String r0 = "name"
            java.lang.String r1 = ")"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            r4.<init>()     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            java.lang.String r5 = "pragma index_list("
            r4.append(r5)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            r4.append(r8)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            r4.append(r1)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            java.lang.String r8 = r4.toString()     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            android.database.Cursor r8 = r9.rawQuery(r8, r3)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            boolean r4 = r8.moveToFirst()     // Catch:{ Exception -> 0x0082, all -> 0x007e }
            if (r4 == 0) goto L_0x0073
            r4 = r3
        L_0x0029:
            java.lang.String r5 = "unique"
            int r5 = r8.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            int r5 = r8.getInt(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r6 = 1
            if (r5 != r6) goto L_0x0067
            int r5 = r8.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.lang.String r5 = r8.getString(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r6.<init>()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.lang.String r7 = "pragma index_info("
            r6.append(r7)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r6.append(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r6.append(r1)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            android.database.Cursor r4 = r9.rawQuery(r5, r3)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            boolean r5 = r4.moveToFirst()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            if (r5 == 0) goto L_0x0067
            int r5 = r4.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r2.add(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        L_0x0067:
            boolean r5 = r8.moveToNext()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            if (r5 != 0) goto L_0x0029
            r3 = r4
            goto L_0x0073
        L_0x006f:
            r9 = move-exception
            goto L_0x0080
        L_0x0071:
            r9 = move-exception
            goto L_0x0084
        L_0x0073:
            if (r8 == 0) goto L_0x0078
            r8.close()
        L_0x0078:
            if (r3 == 0) goto L_0x007d
            r3.close()
        L_0x007d:
            return r2
        L_0x007e:
            r9 = move-exception
            r4 = r3
        L_0x0080:
            r3 = r8
            goto L_0x0099
        L_0x0082:
            r9 = move-exception
            r4 = r3
        L_0x0084:
            r3 = r8
            goto L_0x008b
        L_0x0086:
            r9 = move-exception
            r4 = r3
            goto L_0x0099
        L_0x0089:
            r9 = move-exception
            r4 = r3
        L_0x008b:
            r9.printStackTrace()     // Catch:{ all -> 0x0098 }
            org.litepal.exceptions.DatabaseGenerateException r8 = new org.litepal.exceptions.DatabaseGenerateException     // Catch:{ all -> 0x0098 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0098 }
            r8.<init>(r9)     // Catch:{ all -> 0x0098 }
            throw r8     // Catch:{ all -> 0x0098 }
        L_0x0098:
            r9 = move-exception
        L_0x0099:
            if (r3 == 0) goto L_0x009e
            r3.close()
        L_0x009e:
            if (r4 == 0) goto L_0x00a3
            r4.close()
        L_0x00a3:
            goto L_0x00a5
        L_0x00a4:
            throw r9
        L_0x00a5:
            goto L_0x00a4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.util.DBUtility.findUniqueColumns(java.lang.String, android.database.sqlite.SQLiteDatabase):java.util.List");
    }

    public static String getGenericTableName(String str, String str2) {
        String tableNameByClassName = getTableNameByClassName(str);
        return BaseUtility.changeCase(tableNameByClassName + "_" + str2);
    }

    public static String getGenericValueIdColumnName(String str) {
        return BaseUtility.changeCase(getTableNameByClassName(str) + "_id");
    }

    public static String getIntermediateTableName(String str, String str2) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.toLowerCase(Locale.US).compareTo(str2.toLowerCase(Locale.US)) <= 0) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(str2);
        } else {
            sb = new StringBuilder();
            sb.append(str2);
            sb.append("_");
            sb.append(str);
        }
        return sb.toString();
    }

    public static String getM2MSelfRefColumnName(Field field) {
        return BaseUtility.changeCase(field.getName() + "_id");
    }

    public static String getTableNameByClassName(String str) {
        if (TextUtils.isEmpty(str) || '.' == str.charAt(str.length() - 1)) {
            return null;
        }
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public static String getTableNameByForeignColumn(String str) {
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.US).endsWith("_id")) {
            return null;
        }
        return str.substring(0, str.length() - 3);
    }

    public static List<String> getTableNameListByClassNameList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (String tableNameByClassName : list) {
                arrayList.add(getTableNameByClassName(tableNameByClassName));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v4, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        if (r0 != 0) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (r0 == 0) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isColumnExists(java.lang.String r4, java.lang.String r5, android.database.sqlite.SQLiteDatabase r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 != 0) goto L_0x005d
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x000e
            goto L_0x005d
        L_0x000e:
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
            r2.<init>()     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = "pragma table_info("
            r2.append(r3)     // Catch:{ Exception -> 0x004f }
            r2.append(r5)     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = ")"
            r2.append(r5)     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x004f }
            android.database.Cursor r0 = r6.rawQuery(r5, r0)     // Catch:{ Exception -> 0x004f }
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x004f }
            if (r5 == 0) goto L_0x0047
        L_0x002f:
            java.lang.String r5 = "name"
            int r5 = r0.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x004f }
            boolean r5 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x004f }
            if (r5 == 0) goto L_0x0041
            r1 = 1
            goto L_0x0047
        L_0x0041:
            boolean r5 = r0.moveToNext()     // Catch:{ Exception -> 0x004f }
            if (r5 != 0) goto L_0x002f
        L_0x0047:
            if (r0 == 0) goto L_0x0056
        L_0x0049:
            r0.close()
            goto L_0x0056
        L_0x004d:
            r4 = move-exception
            goto L_0x0057
        L_0x004f:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0056
            goto L_0x0049
        L_0x0056:
            return r1
        L_0x0057:
            if (r0 == 0) goto L_0x005c
            r0.close()
        L_0x005c:
            throw r4
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.util.DBUtility.isColumnExists(java.lang.String, java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static boolean isFieldNameConflictWithSQLiteKeywords(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(",");
        sb.append(str.toLowerCase(Locale.US));
        sb.append(",");
        return SQLITE_KEYWORDS.contains(sb.toString());
    }

    public static boolean isGenericTable(String str, SQLiteDatabase sQLiteDatabase) {
        if (TextUtils.isEmpty(str) || !str.matches("[0-9a-zA-Z]+_[0-9a-zA-Z]+")) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query(Const.TableSchema.TABLE_NAME, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (cursor.moveToFirst()) {
                while (true) {
                    if (!str.equalsIgnoreCase(cursor.getString(cursor.getColumnIndexOrThrow("name")))) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                    } else if (cursor.getInt(cursor.getColumnIndexOrThrow("type")) == 2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return true;
                    }
                }
            }
            if (cursor == null) {
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (cursor == null) {
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
        return false;
    }

    public static boolean isIntermediateTable(String str, SQLiteDatabase sQLiteDatabase) {
        if (TextUtils.isEmpty(str) || !str.matches("[0-9a-zA-Z]+_[0-9a-zA-Z]+")) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query(Const.TableSchema.TABLE_NAME, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (cursor.moveToFirst()) {
                while (true) {
                    if (!str.equalsIgnoreCase(cursor.getString(cursor.getColumnIndexOrThrow("name")))) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                    } else if (cursor.getInt(cursor.getColumnIndexOrThrow("type")) == 1) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return true;
                    }
                }
            }
            if (cursor == null) {
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (cursor == null) {
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
        return false;
    }

    public static boolean isTableExists(String str, SQLiteDatabase sQLiteDatabase) {
        try {
            return BaseUtility.containsIgnoreCases(findAllTableNames(sQLiteDatabase), str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
