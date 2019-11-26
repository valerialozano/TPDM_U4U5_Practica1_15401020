package mx.edu.ittepic.tpdm_u4u5_practica1_15401020

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.Button

class OyenteAcelerometro (p:MainActivity):  SensorEventListener{
    var puntero = p
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        puntero.x = event!!.values[0]
        puntero.y = event!!.values[1]
        puntero.z = event!!.values[2]
        puntero.setTitle("X: ${puntero.x}, Y: ${puntero.y},  Z: ${puntero.z}")

    }


}