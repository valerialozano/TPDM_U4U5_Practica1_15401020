package mx.edu.ittepic.tpdm_u4u5_practica1_15401020

import android.graphics.Canvas
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class Lienzo(p:MainActivity) :  View(p){
    val puntero = p
    //color
    val imagen1 = Imagen(this, R.drawable.icono1, 0f, 600f)
    var imagen2 = Imagen(this, R.drawable.icono2, 350f, 600f)
    var imagen3 = Imagen(this, R.drawable.icono3, 700f, 600f)
    var imagen4 = Imagen(this, R.drawable.icono4, 1050f, 600f)
    var imagen5 = Imagen(this, R.drawable.icono5, 1400f, 600f)
    var imagenesColor = arrayListOf<Imagen>(imagen1,imagen2,imagen3,imagen4,imagen5)
    //blanco y negro
    val imagen6 = Imagen(this, R.drawable.bn_icono1, 0f, 600f)
    var imagen7 = Imagen(this, R.drawable.bn_icono2, 350f, 600f)
    var imagen8 = Imagen(this, R.drawable.bn_icono3, 700f, 600f)
    var imagen9 = Imagen(this, R.drawable.bn_icono4, 1050f, 600f)
    var imagen10 = Imagen(this, R.drawable.bn_icono5, 1400f, 600f)
    var imagenesBN = arrayListOf<Imagen>(imagen6,imagen7,imagen8,imagen9,imagen10)
    //antiguas
    val imagen11 = Imagen(this, R.drawable.a_icono1, 0f, 600f)
    var imagen12 = Imagen(this, R.drawable.a_icono2, 350f, 600f)
    var imagen13 = Imagen(this, R.drawable.a_icono3, 700f, 600f)
    var imagen14 = Imagen(this, R.drawable.a_icono4, 1050f, 600f)
    var imagen15 = Imagen(this, R.drawable.a_icono5, 1400f, 600f)
    var imagenesA = arrayListOf<Imagen>(imagen11,imagen12,imagen13,imagen14,imagen15)
    //vintage
    val imagen16 = Imagen(this, R.drawable.vicono1, 0f, 600f)
    var imagen17 = Imagen(this, R.drawable.vicono2, 350f, 600f)
    var imagen18 = Imagen(this, R.drawable.vicono3, 700f, 600f)
    var imagen19 = Imagen(this, R.drawable.vicono4, 1050f, 600f)
    var imagen20 = Imagen(this, R.drawable.vicono5, 1400f, 600f)
    var imagenesV = arrayListOf<Imagen>(imagen16,imagen17,imagen18,imagen19,imagen20)

    var pimagen : Imagen ?= null

    override fun onDraw(c:Canvas) {
        super.onDraw(c)
        if(puntero.proximidad == 0f) { //proximidad 0f no dibujar
            imagen1.invisible = true
            imagen2.invisible = true
            imagen3.invisible = true
            imagen4.invisible = true
            imagen5.invisible = true
            invalidate()
        }else{
            //si x >0 derecha, <0 izq
            if(puntero.contShake==0) {
                //color
                dibujarImagenes(imagenesColor, c)
                moverImagenesDer(imagenesColor, puntero.x)
            }else if(puntero.contShake==1){
                //blanco y negro
                dibujarImagenes(imagenesBN, c)
                moverImagenesDer(imagenesBN, puntero.x)
            }else if(puntero.contShake==2){
                //antiguo
                dibujarImagenes(imagenesA, c)
                moverImagenesDer(imagenesA, puntero.x)
            }else if(puntero.contShake==3){
                //vintage
                dibujarImagenes(imagenesV, c)
                moverImagenesDer(imagenesV, puntero.x)
            }
        }
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when(e.action){
            MotionEvent.ACTION_DOWN->{
                if(imagen1.estaEnArea(e.getX(),e.getY())||imagen6.estaEnArea(e.getX(),e.getY())||imagen11.estaEnArea(e.getX(),e.getY())||imagen16.estaEnArea(e.getX(),e.getY())){
                    Toast.makeText(puntero, "TOCASTE INSTAGRAM",Toast.LENGTH_LONG).show()
                    pimagen = imagen1
                }
                if(imagen2.estaEnArea(e.getX(),e.getY())||imagen7.estaEnArea(e.getX(),e.getY())||imagen12.estaEnArea(e.getX(),e.getY())||imagen17.estaEnArea(e.getX(),e.getY())){
                    Toast.makeText(puntero, "TOCASTE A LARRY",Toast.LENGTH_LONG).show()
                    pimagen = imagen2
                }
                if(imagen3.estaEnArea(e.getX(),e.getY())||imagen8.estaEnArea(e.getX(),e.getY())||imagen13.estaEnArea(e.getX(),e.getY())||imagen18.estaEnArea(e.getX(),e.getY())){
                    Toast.makeText(puntero, "TOCASTE WHATSAPP",Toast.LENGTH_LONG).show()
                    pimagen = imagen3
                }
                if(imagen4.estaEnArea(e.getX(),e.getY())||imagen9.estaEnArea(e.getX(),e.getY())||imagen14.estaEnArea(e.getX(),e.getY())||imagen19.estaEnArea(e.getX(),e.getY())){
                    Toast.makeText(puntero, "TOCASTE YOUTUBE",Toast.LENGTH_LONG).show()
                    pimagen = imagen4
                }
                if(imagen5.estaEnArea(e.getX(),e.getY())||imagen10.estaEnArea(e.getX(),e.getY())||imagen15.estaEnArea(e.getX(),e.getY())||imagen20.estaEnArea(e.getX(),e.getY())){
                    Toast.makeText(puntero, "TOCASTE FACEBOOK",Toast.LENGTH_LONG).show()
                    pimagen = imagen5
                }
            }
            MotionEvent.ACTION_UP->{
                pimagen = null
            }
        }
        return true
    }

    fun dibujarImagenes(arregloImagenes: ArrayList<Imagen>, c:Canvas){
        arregloImagenes.forEach{
            it.pintar(c)
        }
    }
    fun moverImagenesDer(arregloImagenes: ArrayList<Imagen>, x:Float){
        arregloImagenes.forEach {
            it.mover(x)
        }
        invalidate()
    }
}
