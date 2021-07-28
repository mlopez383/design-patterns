package com.avantica.tutorial.designpatterns.adapter;

public class AudioWebRTCPlayer implements AudioStreamingPlayer {
    private String audio;

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAudio(){
        return audio;
    }
    public String play() {
        return "Play WebRTC Audio: " + audio;
    }

    public String stop() {
        return "Stop WebRTC Audio: " + audio;
    }


}
