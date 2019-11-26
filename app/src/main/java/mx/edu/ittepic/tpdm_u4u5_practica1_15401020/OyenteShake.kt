package mx.edu.ittepic.tpdm_u4u5_practica1_15401020

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteShake(p:MainActivity): SensorEventListener {
    var puntero = p
    var fin: Long = 0
    var x = 0f
    var y = 0f
    var z = 0f
    var x2 = 0f
    var y2 = 0f
    var z2 = 0f
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
    override fun onSensorChanged(p0: SensorEvent?) {
        var tiempo: Long = System.currentTimeMillis() //tiempo de la pc en milisegundos
        if((tiempo - fin) > 100){
            var diferencia = tiempo - fin
            fin = tiempo
            x = p0!!.values[0]
            y = p0!!.values[1]
            z = p0!!.values[2]

            var shake : Float = Math.abs(x + y + z - x2 - y2 - z2) / diferencia * 10000
            if(shake > 800){
                puntero.contShake++
                if(puntero.contShake > 3){
                    puntero.contShake= 0
                }
            }
            x2 = x
            y2 = y
            z2 = z
        }
    }
}