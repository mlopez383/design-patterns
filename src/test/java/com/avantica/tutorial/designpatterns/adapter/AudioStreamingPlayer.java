package com.avantica.tutorial.designpatterns.adapter;

public interface AudioStreamingPlayer {
    void setAudio(String audio);
    String getAudio();
    String play();
    String stop();
}
