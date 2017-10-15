package com.example.akash.references;

import java.util.ArrayList;

/**
 * Created by Akash on 9/28/17.
 * Super class for Book, Website, Video, Journal.
 */

public class Source {
    String nickName, option, format;
    ArrayList<Source> history = new ArrayList<Source>();
    public String getNickName(){
        return nickName;
    }
    public String getOption(){
        return option;
    }
    public String getFormat(){
        return format;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    public void setOption(String option){
        this.option = option;
    }
    public void setFormat(String format){
        this.format = format;
    }
    public static String ordinal(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + suffixes[i % 10];

        }
    }
}
