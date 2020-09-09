package com.example.continuada01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorInt
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    val diciplina = diciplina_texto.text.toString()
    val nota01 = nota01_texto.text.toString().toDouble()
    val nota02 = nota02_texto.text.toString().toDouble()
    val media:Double = (nota01 + nota02) / 2

    fun calcular(componete:View) {
        if (diciplina.length >= 10) {
            if (nota01 > 0.0 && nota01 <= 10.0) {
                if (nota02 > 0.0 && nota02 <= 10.0) {
                    if (media >= 6.0) {
                        resultado.text = "Sua média é: $media, parabéns!!!"
                        resultado.setTextColor(Color.BLUE)
                    }else {
                        resultado.text = "Sua média é: $media, estude mais :("
                        resultado.setTextColor(Color.RED)
                    }
                }else {
                    resultado.text = "Nota 02 inválida"
                    resultado.setTextColor(Color.RED)
                }
            }else {
                resultado.text = "Nota 01 inválida"
                resultado.setTextColor(Color.RED)
            }
        }else {
            resultado.text = "Nome muito grande!"
            resultado.setTextColor(Color.RED)
        }
    }
}