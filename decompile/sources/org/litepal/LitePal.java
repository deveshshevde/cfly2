package org.litepal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Collection;
import java.util.List;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.tablemanager.callback.DatabaseListener;

public class LitePal {
    public static void aesKey(String str) {
        Operator.aesKey(str);
    }

    public static double average(Class<?> cls, String str) {
        return Operator.average(cls, str);
    }

    public static double average(String str, String str2) {
        return Operator.average(str, str2);
    }

    public static AverageExecutor averageAsync(Class<?> cls, String str) {
        return Operator.averageAsync(cls, str);
    }

    public static AverageExecutor averageAsync(String str, String str2) {
        return Operator.averageAsync(str, str2);
    }

    public static int count(Class<?> cls) {
        return Operator.count(cls);
    }

    public static int count(String str) {
        return Operator.count(str);
    }

    public static CountExecutor countAsync(Class<?> cls) {
        return Operator.countAsync(cls);
    }

    public static CountExecutor countAsync(String str) {
        return Operator.countAsync(str);
    }

    public static int delete(Class<?> cls, long j2) {
        return Operator.delete(cls, j2);
    }

    public static int deleteAll(Class<?> cls, String... strArr) {
        return Operator.deleteAll(cls, strArr);
    }

    public static int deleteAll(String str, String... strArr) {
        return Operator.deleteAll(str, strArr);
    }

    public static UpdateOrDeleteExecutor deleteAllAsync(Class<?> cls, String... strArr) {
        return Operator.deleteAllAsync(cls, strArr);
    }

    public static UpdateOrDeleteExecutor deleteAllAsync(String str, String... strArr) {
        return Operator.deleteAllAsync(str, strArr);
    }

    public static UpdateOrDeleteExecutor deleteAsync(Class<?> cls, long j2) {
        return Operator.deleteAsync(cls, j2);
    }

    public static boolean deleteDatabase(String str) {
        return Operator.deleteDatabase(str);
    }

    public static <T> T find(Class<T> cls, long j2) {
        return Operator.find(cls, j2);
    }

    public static <T> T find(Class<T> cls, long j2, boolean z2) {
        return Operator.find(cls, j2, z2);
    }

    public static <T> List<T> findAll(Class<T> cls, boolean z2, long... jArr) {
        return Operator.findAll(cls, z2, jArr);
    }

    public static <T> List<T> findAll(Class<T> cls, long... jArr) {
        return Operator.findAll(cls, jArr);
    }

    public static <T> FindMultiExecutor<T> findAllAsync(Class<T> cls, boolean z2, long... jArr) {
        return Operator.findAllAsync(cls, z2, jArr);
    }

    public static <T> FindMultiExecutor<T> findAllAsync(Class<T> cls, long... jArr) {
        return Operator.findAllAsync(cls, jArr);
    }

    public static <T> FindExecutor<T> findAsync(Class<T> cls, long j2) {
        return Operator.findAsync(cls, j2);
    }

    public static <T> FindExecutor<T> findAsync(Class<T> cls, long j2, boolean z2) {
        return Operator.findAsync(cls, j2, z2);
    }

    public static Cursor findBySQL(String... strArr) {
        return Operator.findBySQL(strArr);
    }

    public static <T> T findFirst(Class<T> cls) {
        return Operator.findFirst(cls);
    }

    public static <T> T findFirst(Class<T> cls, boolean z2) {
        return Operator.findFirst(cls, z2);
    }

    public static <T> FindExecutor<T> findFirstAsync(Class<T> cls) {
        return Operator.findFirstAsync(cls);
    }

    public static <T> FindExecutor<T> findFirstAsync(Class<T> cls, boolean z2) {
        return Operator.findFirstAsync(cls, z2);
    }

    public static <T> T findLast(Class<T> cls) {
        return Operator.findLast(cls);
    }

    public static <T> T findLast(Class<T> cls, boolean z2) {
        return Operator.findLast(cls, z2);
    }

    public static <T> FindExecutor<T> findLastAsync(Class<T> cls) {
        return Operator.findLastAsync(cls);
    }

    public static <T> FindExecutor<T> findLastAsync(Class<T> cls, boolean z2) {
        return Operator.findLastAsync(cls, z2);
    }

    public static SQLiteDatabase getDatabase() {
        return Operator.getDatabase();
    }

    public static void initialize(Context context) {
        Operator.initialize(context);
    }

    public static <T> boolean isExist(Class<T> cls, String... strArr) {
        return Operator.isExist(cls, strArr);
    }

    public static FluentQuery limit(int i2) {
        return Operator.limit(i2);
    }

    public static <T extends LitePalSupport> void markAsDeleted(Collection<T> collection) {
        Operator.markAsDeleted(collection);
    }

    public static <T> T max(Class<?> cls, String str, Class<T> cls2) {
        return Operator.max(cls, str, cls2);
    }

    public static <T> T max(String str, String str2, Class<T> cls) {
        return Operator.max(str, str2, cls);
    }

    public static <T> FindExecutor<T> maxAsync(Class<?> cls, String str, Class<T> cls2) {
        return Operator.maxAsync(cls, str, cls2);
    }

    public static <T> FindExecutor<T> maxAsync(String str, String str2, Class<T> cls) {
        return Operator.maxAsync(str, str2, cls);
    }

    public static <T> T min(Class<?> cls, String str, Class<T> cls2) {
        return Operator.min(cls, str, cls2);
    }

    public static <T> T min(String str, String str2, Class<T> cls) {
        return Operator.min(str, str2, cls);
    }

    public static <T> FindExecutor<T> minAsync(Class<?> cls, String str, Class<T> cls2) {
        return Operator.minAsync(cls, str, cls2);
    }

    public static <T> FindExecutor<T> minAsync(String str, String str2, Class<T> cls) {
        return Operator.minAsync(str, str2, cls);
    }

    public static FluentQuery offset(int i2) {
        return Operator.offset(i2);
    }

    public static FluentQuery order(String str) {
        return Operator.order(str);
    }

    public static void registerDatabaseListener(DatabaseListener databaseListener) {
        Operator.registerDatabaseListener(databaseListener);
    }

    public static <T extends LitePalSupport> void saveAll(Collection<T> collection) {
        Operator.saveAll(collection);
    }

    public static <T extends LitePalSupport> SaveExecutor saveAllAsync(Collection<T> collection) {
        return Operator.saveAllAsync(collection);
    }

    public static FluentQuery select(String... strArr) {
        return Operator.select(strArr);
    }

    public static <T> T sum(Class<?> cls, String str, Class<T> cls2) {
        return Operator.sum(cls, str, cls2);
    }

    public static <T> T sum(String str, String str2, Class<T> cls) {
        return Operator.sum(str, str2, cls);
    }

    public static <T> FindExecutor<T> sumAsync(Class<?> cls, String str, Class<T> cls2) {
        return Operator.sumAsync(cls, str, cls2);
    }

    public static <T> FindExecutor<T> sumAsync(String str, String str2, Class<T> cls) {
        return Operator.sumAsync(str, str2, cls);
    }

    public static int update(Class<?> cls, ContentValues contentValues, long j2) {
        return Operator.update(cls, contentValues, j2);
    }

    public static int updateAll(Class<?> cls, ContentValues contentValues, String... strArr) {
        return Operator.updateAll(cls, contentValues, strArr);
    }

    public static int updateAll(String str, ContentValues contentValues, String... strArr) {
        return Operator.updateAll(str, contentValues, strArr);
    }

    public static UpdateOrDeleteExecutor updateAllAsync(Class<?> cls, ContentValues contentValues, String... strArr) {
        return Operator.updateAllAsync(cls, contentValues, strArr);
    }

    public static UpdateOrDeleteExecutor updateAllAsync(String str, ContentValues contentValues, String... strArr) {
        return Operator.updateAllAsync(str, contentValues, strArr);
    }

    public static UpdateOrDeleteExecutor updateAsync(Class<?> cls, ContentValues contentValues, long j2) {
        return Operator.updateAsync(cls, contentValues, j2);
    }

    public static void use(LitePalDB litePalDB) {
        Operator.use(litePalDB);
    }

    public static void useDefault() {
        Operator.useDefault();
    }

    public static FluentQuery where(String... strArr) {
        return Operator.where(strArr);
    }
}
