package com.example.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> nums=new ArrayList<Word>();
        nums.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        nums.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        nums.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        nums.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        nums.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        nums.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        nums.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        nums.add(new Word("I’m coming","әәnәm",R.raw.phrase_im_coming));
        nums.add(new Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        nums.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));

        WordAdapter adapter=new WordAdapter(this,nums,R.color.category_Phrases);
        ListView list=findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=nums.get(position);
                mediaPlayer= MediaPlayer.create(Phrases.this,word.getAudioResourseID());
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