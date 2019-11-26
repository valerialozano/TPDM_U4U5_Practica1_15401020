package mx.edu.ittepic.tpdm_u4u5_practica1_15401020

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Imagen(l:Lienzo, im:Int, posx:Float, posy:Float) {
    val imagen = BitmapFactory.decodeResource(l.resources, im)
    var x = posx
    var y = posy
    var invisible = false

    fun pintar(c: Canvas){
        //if(invisible) return
        c.drawBitmap(imagen,x,y, Paint())
    }
    fun estaEnArea(toqueX:Float, toqueY:Float): Boolean{
        var x2 = x+imagen.width
        var y2 = y+imagen.height
        if(toqueX >= x && toqueX <= x2){
            if(toqueY >= y && toqueY <= y2){
                return true
            }
        }
        return false
    }
    fun mover(x2:Float) {
        x = x - x2

    }


}