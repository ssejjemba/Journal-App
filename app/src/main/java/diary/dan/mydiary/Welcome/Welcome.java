package diary.dan.mydiary.Welcome;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import diary.dan.mydiary.R;
import diary.dan.mydiary.data.DiaryDbHelper;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //create database instances
        DiaryDbHelper mDbHelper = new DiaryDbHelper(this);
        SQLiteDatabase mDatabase = mDbHelper.getReadableDatabase();


    }
}
