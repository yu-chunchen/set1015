package com.example.set1015

import android.media.AudioManager
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var audioManager: AudioManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
    }


    fun ringDevice(view: View?) {
        // 使用铃声管理器获取默认铃声的URI
        val ringtoneUri: Uri? = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)

        // 创建一个铃声对象
        val ringtone = RingtoneManager.getRingtone(applicationContext, ringtoneUri)

        // 播放铃声
        ringtone?.play()
    }
    fun increaseVolume(view: View?) {
        audioManager?.adjustStreamVolume(
            AudioManager.STREAM_RING,
            AudioManager.ADJUST_RAISE,
            AudioManager.FLAG_SHOW_UI
        )
    }

    fun decreaseVolume(view: View?) {
        audioManager?.adjustStreamVolume(
            AudioManager.STREAM_RING,
            AudioManager.ADJUST_LOWER,
            AudioManager.FLAG_SHOW_UI
        )
    }
}
