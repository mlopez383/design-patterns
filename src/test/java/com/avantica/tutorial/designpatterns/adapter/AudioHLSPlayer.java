package com.avantica.tutorial.designpatterns.adapter;

public class AudioHLSPlayer implements AudioStreamingPlayer{
    protected HLSComponent HLSTool = new HLSComponent();

    public void setAudio(String audio) {
        HLSTool.setAudio(audio);
    }

    public String getAudio() {
        return HLSTool.getAudio();
    }

    public String play() {
        return HLSTool.transcodeFromWebRTCtoHLS() +  HLSTool.play();
    }

    public String stop() {
        return HLSTool.stop();
    }

}
