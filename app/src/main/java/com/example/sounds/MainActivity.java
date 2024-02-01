package com.example.sounds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SoundPool.OnLoadCompleteListener {
    private SoundPool mSoundPool;
    private int mClapSound, mVoiceSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        mSoundPool.setOnLoadCompleteListener(this);

        mVoiceSound = mSoundPool.load(this, R.raw.voice, 1);
        mClapSound = mSoundPool.load(this, R.raw.clap, 1);
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

    }

    public void onClickClap(View view) {
        mSoundPool.play(mVoiceSound, 1, 1, 1, 0, 2);
        mSoundPool.play(mClapSound, 1, 1, 0, 1, 1);
    }

    public void onClickStop(View view) {
        mSoundPool.stop(mVoiceSound);
        mSoundPool.stop(mClapSound);
    }
}