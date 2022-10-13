package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayerRight;
    private MediaPlayer mediaPlayerLeft;
    boolean right = false, left=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rightButton =findViewById(R.id.button2);
        Button leftButton =findViewById(R.id.button3);

        mediaPlayerRight = MediaPlayer.create(getApplicationContext(), R.raw.koe);
        mediaPlayerRight.setVolume(0,1);
        mediaPlayerLeft = MediaPlayer.create(getApplicationContext(), R.raw.haruka);
        mediaPlayerLeft.setVolume(1,0);



        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!right) {
                    mediaPlayerRight.start();
                }else {
                    mediaPlayerRight.pause();
                }
                right=!right;
            }
        });
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!left) {
                    mediaPlayerLeft.start();
                }else {
                    mediaPlayerLeft.pause();
                }
                left=!left;
            }
        });

        /*
        Button buttonStart = findViewById(R.id.button);
        buttonStart.setOnClickListener(v -> {
            // 音楽再生
            audioPlay();
        });
        Button buttonStop = findViewById(R.id.button4);
        // リスナーをボタンに登録
        buttonStop.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                // 音楽停止
                audioStop();
            }
        });

    }

    private boolean audioSetup() {
        // インタンスを生成
        mediaPlayer = new MediaPlayer();

        //音楽ファイル名, あるいはパス
        String filePath = "music.mp3";

        boolean fileCheck = false;

        // assetsから mp3 ファイルを読み込み
        try (AssetFileDescriptor afdescripter = getAssets().openFd(filePath)) {
            // MediaPlayerに読み込んだ音楽ファイルを指定
            mediaPlayer.setDataSource(afdescripter.getFileDescriptor(),
                    afdescripter.getStartOffset(),
                    afdescripter.getLength());
            // 音量調整を端末のボタンに任せる
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepare();
            fileCheck = true;
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return fileCheck;
    }

    private void audioPlay() {

        if (mediaPlayer == null) {
            // audio ファイルを読出し
            if (audioSetup()) {
                Toast.makeText(getApplication(), "Rread audio file", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplication(), "Error: read audio file", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            // 繰り返し再生する場合
            mediaPlayer.stop();
            mediaPlayer.reset();
            // リソースの解放
            mediaPlayer.release();
        }

        // 再生する
        mediaPlayer.start();

        // 終了を検知するリスナー
//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                Log.d("debug","end of audio");
//                audioStop();
//            }
//        });
        // lambda
        mediaPlayer.setOnCompletionListener(mp -> {
            Log.d("debug", "end of audio");
            audioStop();
        });
    }
        private void audioStop() {
            // 再生終了
            mediaPlayer.stop();
            // リセット
            mediaPlayer.reset();
            // リソースの解放
            mediaPlayer.release();

            mediaPlayer = null;
        }


         */
    }
}


