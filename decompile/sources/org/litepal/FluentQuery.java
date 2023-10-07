package org.litepal;

import java.util.List;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.QueryHandler;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class FluentQuery {
    public String[] mColumns;
    public String[] mConditions;
    public String mLimit;
    public String mOffset;
    public String mOrderBy;

    public double average(Class<?> cls, String str) {
        return average(BaseUtility.changeCase(cls.getSimpleName()), str);
    }

    public double average(String str, String str2) {
        double onAverage;
        synchronized (LitePalSupport.class) {
            onAverage = new QueryHandler(Connector.getDatabase()).onAverage(str, str2, this.mConditions);
        }
        return onAverage;
    }

    public AverageExecutor averageAsync(Class<?> cls, String str) {
        return averageAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str);
    }

    public AverageExecutor averageAsync(final String str, final String str2) {
        final AverageExecutor averageExecutor = new AverageExecutor();
        averageExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final double average = FluentQuery.this.average(str, str2);
                    if (averageExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                averageExecutor.getListener().onFinish(average);
                            }
                        });
                    }
                }
            }
        });
        return averageExecutor;
    }

    public int count(Class<?> cls) {
        return count(BaseUtility.changeCase(cls.getSimpleName()));
    }

    public int count(String str) {
        int onCount;
        synchronized (LitePalSupport.class) {
            onCount = new QueryHandler(Connector.getDatabase()).onCount(str, this.mConditions);
        }
        return onCount;
    }

    public CountExecutor countAsync(Class<?> cls) {
        return countAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())));
    }

    public CountExecutor countAsync(final String str) {
        final CountExecutor countExecutor = new CountExecutor();
        countExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int count = FluentQuery.this.count(str);
                    if (countExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                countExecutor.getListener().onFinish(count);
                            }
                        });
                    }
                }
            }
        });
        return countExecutor;
    }

    public <T> List<T> find(Class<T> cls) {
        return find(cls, false);
    }

    public <T> List<T> find(Class<T> cls, boolean z2) {
        String str;
        List<T> onFind;
        synchronized (LitePalSupport.class) {
            QueryHandler queryHandler = new QueryHandler(Connector.getDatabase());
            if (this.mOffset == null) {
                str = this.mLimit;
            } else {
                if (this.mLimit == null) {
                    this.mLimit = "0";
                }
                str = this.mOffset + "," + this.mLimit;
            }
            onFind = queryHandler.onFind(cls, this.mColumns, this.mConditions, this.mOrderBy, str, z2);
        }
        return onFind;
    }

    public <T> FindMultiExecutor<T> findAsync(Class<T> cls) {
        return findAsync(cls, false);
    }

    public <T> FindMultiExecutor<T> findAsync(final Class<T> cls, final boolean z2) {
        final FindMultiExecutor<T> findMultiExecutor = new FindMultiExecutor<>();
        findMultiExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final List find = FluentQuery.this.find(cls, z2);
                    if (findMultiExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                findMultiExecutor.getListener().onFinish(find);
                            }
                        });
                    }
                }
            }
        });
        return findMultiExecutor;
    }

    public <T> T findFirst(Class<T> cls) {
        return findFirst(cls, false);
    }

    public <T> T findFirst(Class<T> cls, boolean z2) {
        synchronized (LitePalSupport.class) {
            List<T> find = find(cls, z2);
            if (find.size() <= 0) {
                return null;
            }
            T t2 = find.get(0);
            return t2;
        }
    }

    public <T> FindExecutor<T> findFirstAsync(Class<T> cls) {
        return findFirstAsync(cls, false);
    }

    public <T> FindExecutor<T> findFirstAsync(final Class<T> cls, final boolean z2) {
        final FindExecutor<T> findExecutor = new FindExecutor<>();
        findExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object findFirst = FluentQuery.this.findFirst(cls, z2);
                    if (findExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                findExecutor.getListener().onFinish(findFirst);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    public <T> T findLast(Class<T> cls) {
        return findLast(cls, false);
    }

    public <T> T findLast(Class<T> cls, boolean z2) {
        synchronized (LitePalSupport.class) {
            List<T> find = find(cls, z2);
            int size = find.size();
            if (size <= 0) {
                return null;
            }
            T t2 = find.get(size - 1);
            return t2;
        }
    }

    public <T> FindExecutor<T> findLastAsync(Class<T> cls) {
        return findLastAsync(cls, false);
    }

    public <T> FindExecutor<T> findLastAsync(final Class<T> cls, final boolean z2) {
        final FindExecutor<T> findExecutor = new FindExecutor<>();
        findExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object findLast = FluentQuery.this.findLast(cls, z2);
                    if (findExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                findExecutor.getListener().onFinish(findLast);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    public FluentQuery limit(int i2) {
        this.mLimit = String.valueOf(i2);
        return this;
    }

    public <T> T max(Class<?> cls, String str, Class<T> cls2) {
        return max(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public <T> T max(String str, String str2, Class<T> cls) {
        T onMax;
        synchronized (LitePalSupport.class) {
            onMax = new QueryHandler(Connector.getDatabase()).onMax(str, str2, this.mConditions, cls);
        }
        return onMax;
    }

    public <T> FindExecutor<T> maxAsync(Class<?> cls, String str, Class<T> cls2) {
        return maxAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public <T> FindExecutor<T> maxAsync(String str, String str2, Class<T> cls) {
        FindExecutor<T> findExecutor = new FindExecutor<>();
        final String str3 = str;
        final String str4 = str2;
        final Class<T> cls2 = cls;
        final FindExecutor<T> findExecutor2 = findExecutor;
        findExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object max = FluentQuery.this.max(str3, str4, cls2);
                    if (findExecutor2.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                findExecutor2.getListener().onFinish(max);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    public <T> T min(Class<?> cls, String str, Class<T> cls2) {
        return min(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public <T> T min(String str, String str2, Class<T> cls) {
        T onMin;
        synchronized (LitePalSupport.class) {
            onMin = new QueryHandler(Connector.getDatabase()).onMin(str, str2, this.mConditions, cls);
        }
        return onMin;
    }

    public <T> FindExecutor<T> minAsync(Class<?> cls, String str, Class<T> cls2) {
        return minAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public <T> FindExecutor<T> minAsync(String str, String str2, Class<T> cls) {
        FindExecutor<T> findExecutor = new FindExecutor<>();
        final String str3 = str;
        final String str4 = str2;
        final Class<T> cls2 = cls;
        final FindExecutor<T> findExecutor2 = findExecutor;
        findExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object min = FluentQuery.this.min(str3, str4, cls2);
                    if (findExecutor2.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                findExecutor2.getListener().onFinish(min);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    public FluentQuery offset(int i2) {
        this.mOffset = String.valueOf(i2);
        return this;
    }

    public FluentQuery order(String str) {
        this.mOrderBy = str;
        return this;
    }

    public FluentQuery select(String... strArr) {
        this.mColumns = strArr;
        return this;
    }

    public <T> T sum(Class<?> cls, String str, Class<T> cls2) {
        return sum(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public <T> T sum(String str, String str2, Class<T> cls) {
        T onSum;
        synchronized (LitePalSupport.class) {
            onSum = new QueryHandler(Connector.getDatabase()).onSum(str, str2, this.mConditions, cls);
        }
        return onSum;
    }

    public <T> FindExecutor<T> sumAsync(Class<?> cls, String str, Class<T> cls2) {
        return sumAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    public <T> FindExecutor<T> sumAsync(String str, String str2, Class<T> cls) {
        FindExecutor<T> findExecutor = new FindExecutor<>();
        final String str3 = str;
        final String str4 = str2;
        final Class<T> cls2 = cls;
        final FindExecutor<T> findExecutor2 = findExecutor;
        findExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object sum = FluentQuery.this.sum(str3, str4, cls2);
                    if (findExecutor2.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                findExecutor2.getListener().onFinish(sum);
                            }
                        });
                    }
                }
            }
        });
        return findExecutor;
    }

    public FluentQuery where(String... strArr) {
        this.mConditions = strArr;
        return this;
    }
}
