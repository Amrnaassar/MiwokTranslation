package com.example.miwok;

public class Word {

    private String DefualtTraslation;
    private String MiwokTranslation;
    private int ImageResoursId=-1;
    private int AudioResourseID;



    public Word(String defualtTraslation, String miwokTranslation, int imageResoursId, int audioResourseID) {
        DefualtTraslation = defualtTraslation;
        MiwokTranslation = miwokTranslation;
        ImageResoursId = imageResoursId;
        AudioResourseID = audioResourseID;
    }
    public int getAudioResourseID() {
        return AudioResourseID;
    }
    public int getImageResoursId() {
        return ImageResoursId;
    }

    public String getDefualtTraslation() {
        return DefualtTraslation;
    }

    public String getMiwokTranslation() {
        return MiwokTranslation;
    }

    public Word(String defualtTraslation, String miwokTranslation, int audioResourseID) {
        DefualtTraslation = defualtTraslation;
        MiwokTranslation = miwokTranslation;
        AudioResourseID = audioResourseID;
    }

    public boolean hasImage()
    {
        return ImageResoursId!=-1;
    }

}
