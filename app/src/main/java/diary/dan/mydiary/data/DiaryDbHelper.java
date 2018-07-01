package diary.dan.mydiary.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import diary.dan.mydiary.data.DiaryContract.DiaryEntry;
import diary.dan.mydiary.model.DataModel;

public class DiaryDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = DiaryDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "diary.db";

    private static final int DATABASE_VERSION = 1;

    public DiaryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_DIARY_TABLE =  "CREATE TABLE " + DiaryEntry.TABLE_NAME + " ("
                + DiaryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DiaryEntry.COLUMN_MEMO_TITLE + " TEXT, "
                + DiaryEntry.COLUMN_MEMO_IMAGE + " TEXT, "
                + DiaryEntry.COLUMN_MEMO_CONTENT + " TEXT, "
                + DiaryEntry.COLUMN_MEMO_LOCATION + "TEXT, "
                + DiaryEntry.COLUMN_MEMO_DATE + " INTEGER NOT NULL );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_DIARY_TABLE);
    }

    private void insertData(String title, String date, String location, String content, String image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();


        contentValues.put(DiaryEntry.COLUMN_MEMO_TITLE, title);
        contentValues.put(DiaryEntry.COLUMN_MEMO_DATE, date);
        contentValues.put(DiaryEntry.COLUMN_MEMO_LOCATION,location);
        contentValues.put(DiaryEntry.COLUMN_MEMO_CONTENT,content);
        contentValues.put(DiaryEntry.COLUMN_MEMO_IMAGE,image);

        db.insert(DiaryEntry.TABLE_NAME,null,contentValues);
    }

    private List<DataModel> getData(){


            List<DataModel> data=new ArrayList<>();
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from "+DiaryEntry.TABLE_NAME+" ;",null);
            StringBuffer stringBuffer = new StringBuffer();
            DataModel dataModel = null;
            while (cursor.moveToNext()) {
                dataModel= new DataModel();
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DiaryEntry.COLUMN_MEMO_TITLE));
                int date = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(DiaryEntry.COLUMN_MEMO_DATE)));
                String content = cursor.getString(cursor.getColumnIndexOrThrow(DiaryEntry.COLUMN_MEMO_CONTENT));
                String location = cursor.getString(cursor.getColumnIndexOrThrow(DiaryEntry.COLUMN_MEMO_LOCATION));
                String image = cursor.getString(cursor.getColumnIndexOrThrow(DiaryEntry.COLUMN_MEMO_IMAGE));
                dataModel.setTitle(title);
                dataModel.setDate(date);
                dataModel.setContent(content);
                dataModel.setLocation(location);
                dataModel.setImage(image);
                stringBuffer.append(dataModel);
                // stringBuffer.append(dataModel);
                data.add(dataModel);
            }

            for (DataModel mo:data ) {

                Log.i(LOG_TAG,""+mo.getTitle());
            }

            //

            return data;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
