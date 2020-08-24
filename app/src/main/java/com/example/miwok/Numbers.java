package com.example.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            else if(focusChange==AudioManager.AUDIOFOCUS_GAIN)mediaPlayer.start();
            else if(focusChange==AudioManager.AUDIOFOCUS_LOSS)
                releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> nums=new ArrayList<Word>();
        nums.add(new Word("one","lutti",R.drawable.number_one,R.raw.number_one));
        nums.add(new Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        nums.add(new Word("three","tolookosi",R.drawable.number_three,R.raw.number_three));
        nums.add(new Word("four","oyyiso",R.drawable.number_four,R.raw.number_four));
        nums.add(new Word("five","massokka",R.drawable.number_five,R.raw.number_five));
        nums.add(new Word("six","remmokka",R.drawable.number_six,R.raw.number_six));
        nums.add(new Word("seven","kenekako",R.drawable.number_seven,R.raw.number_seven));
        nums.add(new Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        nums.add(new Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        nums.add(new Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter adapter=new WordAdapter(this,nums,R.color.category_numbers);
        ListView list=findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=nums.get(position);
                releaseMediaPlayer();
                int result=audioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_REQUEST_GRANTED);
                if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {


                    mediaPlayer = MediaPlayer.create(Numbers.this, word.getAudioResourseID());
                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });

                }

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
            audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }

    }
}