package eb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private String f26848a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f26849b;

    public b(Context context, int i2) {
        super(context, "RECORD", (SQLiteDatabase.CursorFactory) null, i2);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS" + this.f26848a + "(id Integer primary key autoincrement,ch1 Integer, ch2 Integer, ch3 Integer, ch4 Integer, ch5 Integer, ch6 Integer, ch7 Integer, ch8 Integer)");
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.f26848a);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.i("DB", "sqlite create!");
        sQLiteDatabase.execSQL("create table if not exists RECORD_TAB(_id Integer primary key autoincrement, msg_rc_channels_override text)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (this.f26849b) {
            b(sQLiteDatabase);
        } else {
            a(sQLiteDatabase);
        }
    }
}
