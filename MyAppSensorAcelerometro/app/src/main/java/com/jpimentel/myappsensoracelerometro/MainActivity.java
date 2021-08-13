package com.jpimentel.myappsensoracelerometro;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Sensor sensorAcel;
    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;

    private int movimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorAcel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorAcelerometro();
        iniciarSensor();
    }

    private void sensorAcelerometro(){
        if(sensorAcel == null){
            Toast.makeText(this, "No cuenta con el sensor", Toast.LENGTH_SHORT).show();
            finish();
        }
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float ejeX = sensorEvent.values[0];
                if(ejeX < -5 && movimiento == 0){
                    movimiento++;
                }
                else if(ejeX > 5 && movimiento ==1){
                    movimiento++;
                }
                if(movimiento==2){
                    sonido();
                    movimiento=0;
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }


    //Utilizar un sonido mp3
    private void sonido(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.latigo);
        mediaPlayer.start();
    }


    private void iniciarSensor(){
        sensorManager.registerListener(sensorEventListener,sensorAcel, SensorManager.SENSOR_DELAY_NORMAL);
    }
    private void detenerSensor(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        iniciarSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detenerSensor();
    }
}