package com.example.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Color extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

       final ArrayList<Word> nums=new ArrayList<Word>();
        nums.add(new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        nums.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        nums.add(new Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        nums.add(new Word("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        nums.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
        nums.add(new Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
        nums.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        nums.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));


        WordAdapter adapter=new WordAdapter(this,nums,R.color.category_Color);
        ListView list=findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=nums.get(position);
                mediaPlayer= MediaPlayer.create(Color.this,word.getAudioResourseID());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
                mediaPlayer.start();

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }

    }
}