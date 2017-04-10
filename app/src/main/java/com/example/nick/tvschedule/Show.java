package com.example.nick.tvschedule;

import android.webkit.ConsoleMessage;

import java.io.Console;

/**
 * Created by nick on 14/03/17.
 */

public class Show {
    private String name = "";


    public Show(){}


    public Show(String name){
        this.name = name;
        update();
    }

    @Override
    public String toString() {
        return name;
    }

    public String name() {
        return name;
    }


    /**
     * Checks for new episodes/seasons
     */
    protected void update(){
        try {
            if (name.isEmpty()) {
                throw new Exception();
            }

            // Get Show info from API

        }
        catch (Exception e){
            System.err.println("Empty Show Name. : " + e);
        }

    }
}
