package com.example.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family_Member extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> nums=new ArrayList<Word>();
        nums.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        nums.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        nums.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        nums.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        nums.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        nums.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        nums.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        nums.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        nums.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        nums.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter adapter=new WordAdapter(this,nums,R.color.category_Family);
        ListView list=findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=nums.get(position);
                mediaPlayer= MediaPlayer.create(Family_Member.this,word.getAudioResourseID());
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