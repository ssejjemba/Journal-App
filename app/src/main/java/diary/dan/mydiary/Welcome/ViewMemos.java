package diary.dan.mydiary.Welcome;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import diary.dan.mydiary.R;
import diary.dan.mydiary.data.DiaryDbHelper;
import diary.dan.mydiary.edit.EditDiary;
import jp.wasabeef.blurry.Blurry;

public class ViewMemos extends AppCompatActivity {
    private ViewGroup rootView;
    private ImageView bg;

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ViewMemos.this, EditDiary.class);
                startActivity(intent);

            }
        });


        DiaryDbHelper dbHelper = new DiaryDbHelper(ViewMemos.this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        mRecyclerView.setHasFixedSize(true);
        loadMemos();
    }

    private void loadMemos() {


        DiaryDbHelper dbHelper = new DiaryDbHelper(ViewMemos.this);

        Welcome adapter = new Welcome(dbHelper.getData());
        LinearLayoutManager layoutManager = new LinearLayoutManager(ViewMemos.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(adapter);
    }


}
