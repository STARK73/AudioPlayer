package com.example.mediaplayers;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.RawRes;

public class MediaPlay {

    private static MediaPlayer mediaPlayer;
    private static boolean playOnStop = false;
    private static Context context;

    public static void init(Context context) {
        MediaPlay.context = context;
    }

    public static void setAudioRes(@RawRes int res) {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(context, res);
        mediaPlayer.start();
    }

    public static void playOrPause() {
        if (mediaPlayer != null)
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
    }

    public static void stop() {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }

    public static void pauseOnStop() {
        if (mediaPlayer != null)
            if (mediaPlayer.isPlaying()) {
                playOnStop = true;
                mediaPlayer.pause();
            }
    }

    public static void pauseOnStart() {
        if (mediaPlayer != null)
            if (playOnStop) {
                playOnStop = false;
                mediaPlayer.start();
            }
    }
}
