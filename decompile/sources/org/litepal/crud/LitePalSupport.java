package org.litepal.crud;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.Operator;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class LitePalSupport {
    protected static final String AES = "AES";
    protected static final String MD5 = "MD5";
    Map<String, List<Long>> associatedModelsMapForJoinTable;
    private Map<String, Set<Long>> associatedModelsMapWithFK;
    private Map<String, Long> associatedModelsMapWithoutFK;
    long baseObjId;
    private List<String> fieldsToSetToDefault;
    private List<String> listToClearAssociatedFK;
    private List<String> listToClearSelfFK;

    protected LitePalSupport() {
    }

    private void clearFKNameList() {
        getListToClearSelfFK().clear();
        getListToClearAssociatedFK().clear();
    }

    private void clearIdOfModelForJoinTable() {
        for (String str : getAssociatedModelsMapForJoinTable().keySet()) {
            this.associatedModelsMapForJoinTable.get(str).clear();
        }
        this.associatedModelsMapForJoinTable.clear();
    }

    private void clearIdOfModelWithFK() {
        for (String str : getAssociatedModelsMapWithFK().keySet()) {
            this.associatedModelsMapWithFK.get(str).clear();
        }
        this.associatedModelsMapWithFK.clear();
    }

    private void clearIdOfModelWithoutFK() {
        getAssociatedModelsMapWithoutFK().clear();
    }

    /* access modifiers changed from: package-private */
    public void addAssociatedModelForJoinTable(String str, long j2) {
        List list = getAssociatedModelsMapForJoinTable().get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j2));
            this.associatedModelsMapForJoinTable.put(str, arrayList);
            return;
        }
        list.add(Long.valueOf(j2));
    }

    /* access modifiers changed from: package-private */
    public void addAssociatedModelWithFK(String str, long j2) {
        Set set = getAssociatedModelsMapWithFK().get(str);
        if (set == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j2));
            this.associatedModelsMapWithFK.put(str, hashSet);
            return;
        }
        set.add(Long.valueOf(j2));
    }

    /* access modifiers changed from: package-private */
    public void addAssociatedModelWithoutFK(String str, long j2) {
        getAssociatedModelsMapWithoutFK().put(str, Long.valueOf(j2));
    }

    /* access modifiers changed from: package-private */
    public void addAssociatedTableNameToClearFK(String str) {
        List<String> listToClearAssociatedFK2 = getListToClearAssociatedFK();
        if (!listToClearAssociatedFK2.contains(str)) {
            listToClearAssociatedFK2.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void addEmptyModelForJoinTable(String str) {
        if (getAssociatedModelsMapForJoinTable().get(str) == null) {
            this.associatedModelsMapForJoinTable.put(str, new ArrayList());
        }
    }

    /* access modifiers changed from: package-private */
    public void addFKNameToClearSelf(String str) {
        List<String> listToClearSelfFK2 = getListToClearSelfFK();
        if (!listToClearSelfFK2.contains(str)) {
            listToClearSelfFK2.add(str);
        }
    }

    public void assignBaseObjId(int i2) {
        this.baseObjId = (long) i2;
    }

    /* access modifiers changed from: package-private */
    public void clearAssociatedData() {
        clearIdOfModelWithFK();
        clearIdOfModelWithoutFK();
        clearIdOfModelForJoinTable();
        clearFKNameList();
    }

    public void clearSavedState() {
        this.baseObjId = 0;
    }

    public int delete() {
        int onDelete;
        synchronized (LitePalSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                onDelete = new DeleteHandler(database).onDelete(this);
                this.baseObjId = 0;
                database.setTransactionSuccessful();
            } finally {
                database.endTransaction();
            }
        }
        return onDelete;
    }

    public UpdateOrDeleteExecutor deleteAsync() {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int delete = LitePalSupport.this.delete();
                    if (updateOrDeleteExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(delete);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    /* access modifiers changed from: package-private */
    public Map<String, List<Long>> getAssociatedModelsMapForJoinTable() {
        if (this.associatedModelsMapForJoinTable == null) {
            this.associatedModelsMapForJoinTable = new HashMap();
        }
        return this.associatedModelsMapForJoinTable;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Set<Long>> getAssociatedModelsMapWithFK() {
        if (this.associatedModelsMapWithFK == null) {
            this.associatedModelsMapWithFK = new HashMap();
        }
        return this.associatedModelsMapWithFK;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Long> getAssociatedModelsMapWithoutFK() {
        if (this.associatedModelsMapWithoutFK == null) {
            this.associatedModelsMapWithoutFK = new HashMap();
        }
        return this.associatedModelsMapWithoutFK;
    }

    /* access modifiers changed from: protected */
    public long getBaseObjId() {
        return this.baseObjId;
    }

    /* access modifiers changed from: protected */
    public String getClassName() {
        return getClass().getName();
    }

    /* access modifiers changed from: package-private */
    public List<String> getFieldsToSetToDefault() {
        if (this.fieldsToSetToDefault == null) {
            this.fieldsToSetToDefault = new ArrayList();
        }
        return this.fieldsToSetToDefault;
    }

    /* access modifiers changed from: package-private */
    public List<String> getListToClearAssociatedFK() {
        if (this.listToClearAssociatedFK == null) {
            this.listToClearAssociatedFK = new ArrayList();
        }
        return this.listToClearAssociatedFK;
    }

    /* access modifiers changed from: package-private */
    public List<String> getListToClearSelfFK() {
        if (this.listToClearSelfFK == null) {
            this.listToClearSelfFK = new ArrayList();
        }
        return this.listToClearSelfFK;
    }

    /* access modifiers changed from: protected */
    public String getTableName() {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(getClassName()));
    }

    public boolean isSaved() {
        return this.baseObjId > 0;
    }

    public boolean save() {
        try {
            saveThrows();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public SaveExecutor saveAsync() {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final boolean save = LitePalSupport.this.save();
                    if (saveExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                saveExecutor.getListener().onFinish(save);
                            }
                        });
                    }
                }
            }
        });
        return saveExecutor;
    }

    @Deprecated
    public boolean saveIfNotExist(String... strArr) {
        if (!Operator.isExist(getClass(), strArr)) {
            return save();
        }
        return false;
    }

    public boolean saveOrUpdate(String... strArr) {
        synchronized (LitePalSupport.class) {
            if (strArr == null) {
                boolean save = save();
                return save;
            }
            List<?> find = Operator.where(strArr).find(getClass());
            if (find.isEmpty()) {
                boolean save2 = save();
                return save2;
            }
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                Iterator<?> it2 = find.iterator();
                while (it2.hasNext()) {
                    this.baseObjId = ((LitePalSupport) it2.next()).getBaseObjId();
                    new SaveHandler(database).onSave(this);
                    clearAssociatedData();
                }
                database.setTransactionSuccessful();
                database.endTransaction();
                return true;
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                    return false;
                } finally {
                    database.endTransaction();
                }
            }
        }
    }

    public SaveExecutor saveOrUpdateAsync(final String... strArr) {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final boolean saveOrUpdate = LitePalSupport.this.saveOrUpdate(strArr);
                    if (saveExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                saveExecutor.getListener().onFinish(saveOrUpdate);
                            }
                        });
                    }
                }
            }
        });
        return saveExecutor;
    }

    public void saveThrows() {
        synchronized (LitePalSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                new SaveHandler(database).onSave(this);
                clearAssociatedData();
                database.setTransactionSuccessful();
                database.endTransaction();
            } catch (Exception e2) {
                throw new LitePalSupportException(e2.getMessage(), e2);
            } catch (Throwable th) {
                database.endTransaction();
                throw th;
            }
        }
    }

    public void setToDefault(String str) {
        getFieldsToSetToDefault().add(str);
    }

    public int update(long j2) {
        int onUpdate;
        synchronized (LitePalSupport.class) {
            try {
                onUpdate = new UpdateHandler(Connector.getDatabase()).onUpdate(this, j2);
                getFieldsToSetToDefault().clear();
            } catch (Exception e2) {
                throw new LitePalSupportException(e2.getMessage(), e2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return onUpdate;
    }

    public int updateAll(String... strArr) {
        int onUpdateAll;
        synchronized (LitePalSupport.class) {
            try {
                onUpdateAll = new UpdateHandler(Connector.getDatabase()).onUpdateAll(this, strArr);
                getFieldsToSetToDefault().clear();
            } catch (Exception e2) {
                throw new LitePalSupportException(e2.getMessage(), e2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return onUpdateAll;
    }

    public UpdateOrDeleteExecutor updateAllAsync(final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int updateAll = LitePalSupport.this.updateAll(strArr);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(updateAll);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    public UpdateOrDeleteExecutor updateAsync(final long j2) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() {
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int update = LitePalSupport.this.update(j2);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() {
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(update);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }
}
