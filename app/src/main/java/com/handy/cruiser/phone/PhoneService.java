package com.handy.cruiser.phone;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.io.File;
import java.io.IOException;

/**
 * Created by handy on 16/8/7.
 */
public class PhoneService extends Service
{

    @Override
    public IBinder onBind(Intent intent)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        telephonyManager.listen(new PhoneListener(), PhoneStateListener.LISTEN_CALL_STATE);  //注册监听器 监听电话状态
    }


    private final class PhoneListener extends PhoneStateListener
    {
        private String incomeNumber;   //来电号码
        private MediaRecorder mediaRecorder;
        private File file;
        @Override
        public void onCallStateChanged(int state, String incomingNumber)
        {
            try
            {
                switch(state)
                {
                    case TelephonyManager.CALL_STATE_RINGING:   //来电
                        this.incomeNumber = incomingNumber;
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:   //接通电话
                        file = new File(Environment.getExternalStorageDirectory(), this.incomeNumber + System.currentTimeMillis() + ".3gp");
                        mediaRecorder = new MediaRecorder();
                        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);   //获得声音数据源
                        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);   // 按3gp格式输出
                        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        mediaRecorder.setOutputFile(file.getAbsolutePath());   //输出文件
                        mediaRecorder.prepare();    //准备
                        mediaRecorder.start();
                        break;

                    case TelephonyManager.CALL_STATE_IDLE:  //挂掉电话
                        if(mediaRecorder != null)
                        {
                            mediaRecorder.stop();
                            mediaRecorder.release();
                            mediaRecorder = null;
                        }

                        break;

                }
            }
            catch (IllegalStateException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }


}