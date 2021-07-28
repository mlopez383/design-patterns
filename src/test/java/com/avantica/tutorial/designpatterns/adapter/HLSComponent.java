package com.avantica.tutorial.designpatterns.adapter;

public class HLSComponent {
    private String audio;

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAudio() {
        return audio;
    }

    public String play() {
        return "Play HLS Audio: " + audio;
    }

    public String stop() {
        return "Stop HLS Audio: " + audio;
    }

    public String transcodeFromWebRTCtoHLS() {
        return "Transcoding from WebRTC to HLS and then ";
    }
}