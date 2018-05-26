package com.udacity.gradle.builditbigger.backend;
import elmajdma.joketeller.Joke;
/** The object model for the data we are sending through endpoints */
public class MyBean {

  //private Joke joke=new Joke();

    private String myData;


    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

}