package mx.edu.ittepic.tpdm_u4u5_practica1_15401020

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var sensorManager : SensorManager?= null
    var oyenteAcelerometro : OyenteAcelerometro ?= null
    var oyenteProximidad : OyenteProximidad ?= null
    var oyenteShake : OyenteShake?=null
    var x = 0f
    var y = 0f
    var z = 0f
    var proximidad = 0f
    var contShake=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        oyenteAcelerometro = OyenteAcelerometro(this)
        sensorManager?.registerListener(oyenteAcelerometro,sensorManager?.getDefaultSensor(
            Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)

        oyenteProximidad = OyenteProximidad(this)
        sensorManager?.registerListener(oyenteProximidad, sensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_UI)

        oyenteShake = OyenteShake(this)
        sensorManager?.registerListener(oyenteShake, sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME)
    }
}
