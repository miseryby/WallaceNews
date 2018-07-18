package com.example.wallace.wallacenews.yang.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.wallace.wallacenews.peng.beans.Key_Value;


/**
 * Created by ubuntu on 18-7-16.
 */

public class NewsCache extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "ly_db";
    private final static int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "book_data";

    private static final String FILED_1 = "key";
    private static final String FILED_2 = "value";
    public NewsCache(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i("在书籍数据库中", "创建对象");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (  " + FILED_1 + " TEXT, " + FILED_2 + " TEXT);";
        db.execSQL(sql);
        Log.i("在书籍数据库中创建表", TABLE_NAME);
    }

    @Override
    //完全更新数据库时调用的方法
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Log.w("在书籍数据库中", "更新对象");
        this.onCreate(db);
    }
    /**
     * 查询表中所有的数据
     *
     * @return 所有数据构成的Book数组
     */
    public Key_Value[] select() {
        Cursor cursor = this.getReadableDatabase()
                .query(TABLE_NAME, null, null, null, null, null, null);
        Key_Value[] data = new Key_Value[cursor.getCount()];
        int count = 0;
        Log.i("在书籍数据库中", "开始获取信息");
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(FILED_1));
            String pic_url = cursor.getString(cursor.getColumnIndex(FILED_2));
            data[count] = new Key_Value(name, pic_url);
            count++;
        }
        cursor.close();
        Log.i("在书籍数据库中", "获取信息结束");
        return data;
    }


    public void insert(String key, String value) {
        ContentValues cv = new ContentValues();
        cv.put(FILED_1, key);
        cv.put(FILED_2, value);
        Log.i("在书籍数据库中", "开始插入");
        this.getWritableDatabase().insert(TABLE_NAME, null, cv);
        Log.i("在书籍数据库中", "插入结束");
    }

    public boolean checkByKey(String key) {
        Key_Value[] books = select();
        for (Key_Value book : books) {
            if (book.getKey().equals(key))
                return true;
        }
        return false;
    }

    public String getReadPageIndexByURL(String key) {
        Key_Value[] books = select();
        for (Key_Value book : books) {
            if (book.getKey().equals(key))
                return book.getValue();
        }
        return "";
    }
    public void updateValue(String key, String value) {
        ContentValues cv = new ContentValues();
        cv.put(FILED_2, value);
        String where = FILED_1 + " = ?";
        String[] whereValues = {key};
        this.getWritableDatabase().update(TABLE_NAME, cv, where, whereValues);
    }

    public void dropTable() {
        this.getWritableDatabase().execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Log.i("在书籍数据库中", "删除表");
        this.onCreate(this.getWritableDatabase());
    }
}