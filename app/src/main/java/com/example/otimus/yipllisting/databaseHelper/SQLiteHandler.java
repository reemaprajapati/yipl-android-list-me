package com.example.otimus.yipllisting.databaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.otimus.yipllisting.model.PostItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Otimus on 7/27/2017.
 */

public class SQLiteHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Lists";
    private static final String TABLE_NAME_POSTS = "Posts";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_BODY = "body";


    public SQLiteHandler(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATION_TABLE_POSTS = (" CREATE TABLE " + TABLE_NAME_POSTS + " (" +
                KEY_USER_ID + " INTEGER, " +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_TITLE + " TEXT, " +
                KEY_BODY + " TEXT )");


        sqLiteDatabase.execSQL(CREATION_TABLE_POSTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_POSTS);
        this.onCreate(sqLiteDatabase);
    }
    public void addPost(PostItem postItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, postItem.getUserId());
        values.put(KEY_ID, postItem.getId());
        values.put(KEY_TITLE, postItem.getTitle());
        values.put(KEY_BODY, postItem.getBody());

        // insert
        try{
        db.insert(TABLE_NAME_POSTS,null, values);}
        catch (Exception e){
            e.printStackTrace();
        }
        db.close();
    }


    public List<PostItem> allPosts() {
        List<PostItem> postItems = new ArrayList<>();
        String query = "SELECT  * FROM " + TABLE_NAME_POSTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        PostItem postItem = null;

        if (cursor.moveToFirst()) {
            do {
                postItem = new PostItem();
                postItem.setUserId(Integer.parseInt(cursor.getString(0)));
                postItem.setId(Integer.parseInt(cursor.getString(1)));
                postItem.setTitle(cursor.getString(2));
                postItem.setBody(cursor.getString(3));
                postItems.add(postItem);
            } while (cursor.moveToNext());
        }
        return postItems;
    }



}
