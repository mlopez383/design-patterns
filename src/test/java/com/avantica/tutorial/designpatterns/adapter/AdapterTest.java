package com.avantica.tutorial.designpatterns.adapter;

import org.junit.Assert;
import org.junit.Test;

public class AdapterTest {
    static final String AUDIO_NAME = "symphony music";
    static final String EXPECTED_WEBRTC_PLAY_ACTION = "Play WebRTC Audio: " + AUDIO_NAME;
    static final String EXPECTED_WEBRTC_STOP_ACTION = "Stop WebRTC Audio: " + AUDIO_NAME;
    static final String EXPECTED_HLS_PLAY_ACTION = "Transcoding from WebRTC to HLS and then Play HLS Audio: " + AUDIO_NAME;
    static final String EXPECTED_HLS_STOP_ACTION = "Stop HLS Audio: " + AUDIO_NAME;

    private void executeAudioStreamingPlayerActions(AudioStreamingPlayer audio, String expectedPlayAction, String expectedStopAction){
        audio.setAudio(AUDIO_NAME);
        Assert.assertTrue("Failure - Expected Play Action does not match", expectedPlayAction.equals(audio.play()));
        Assert.assertTrue("Failure - Expected Stop Action does not match", expectedStopAction.equals(audio.stop()));
    }

    private void validateIfAudioIsNull(AudioStreamingPlayer audio){
        audio.setAudio(AUDIO_NAME);
        Assert.assertNotNull("Failure - The audio is null", audio.getAudio());
    }

    @Test
    public void validateWebRTCPlayer() {
        AudioStreamingPlayer audio = new AudioWebRTCPlayer();
        executeAudioStreamingPlayerActions(audio, EXPECTED_WEBRTC_PLAY_ACTION, EXPECTED_WEBRTC_STOP_ACTION);
    }

    @Test
    public void validateHLSPlayer() {
        AudioStreamingPlayer audio = new AudioHLSPlayer();
        executeAudioStreamingPlayerActions(audio, EXPECTED_HLS_PLAY_ACTION, EXPECTED_HLS_STOP_ACTION);
    }

    @Test
    public void validateWebRTCPlayerWithAudioNull(){
        AudioStreamingPlayer audio = new AudioWebRTCPlayer();
        validateIfAudioIsNull(audio);
    }

    @Test
    public void validateHLSPlayerWithAudioNull(){
        AudioStreamingPlayer audio = new AudioHLSPlayer();
        validateIfAudioIsNull(audio);
    }
}

