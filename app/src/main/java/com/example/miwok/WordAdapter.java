package com.example.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int ColorType;
    public WordAdapter(Activity context, ArrayList<Word>words,int ColorType)
    {
        super(context,0,words);
        this.ColorType=ColorType;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View ListItemView =convertView;
        if(ListItemView==null)
        {
            ListItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Word currenWord=getItem(position);
        TextView MiwokTextView=(TextView)ListItemView.findViewById(R.id.miwok_text_view);
        MiwokTextView.setText(currenWord.getMiwokTranslation());
        TextView defualtTextView=(TextView)ListItemView.findViewById(R.id.default_text_view);
        defualtTextView.setText(currenWord.getDefualtTraslation());
        ImageView imageView=(ImageView)ListItemView.findViewById(R.id.description_image);
        if(currenWord.hasImage())
        {imageView.setImageResource(currenWord.getImageResoursId());imageView.setVisibility(View.VISIBLE);}
        else imageView.setVisibility(View.GONE);

        View textContainer=ListItemView.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),ColorType);
        textContainer.setBackgroundColor(color);



        return ListItemView;
    }
}
