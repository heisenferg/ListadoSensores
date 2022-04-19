package com.example.listadosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager;
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> listadoSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        generarUI(listadoSensores);
    }


    public void generarUI(List<Sensor> listadoSensores){
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        TextView textView;

        Log.w("Cantidad de sensores: ", ""+ listadoSensores.size());

        for (int i=0; i<listadoSensores.size(); i++){
            String nombreSensor = listadoSensores.get(i).getName();
            textView = new TextView(this);
            textView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            textView.setText("Sensor " + i + "| Nombre: " + nombreSensor);
            textView.setId(View.generateViewId());
            linearLayout.addView(textView);
        }
    }



}