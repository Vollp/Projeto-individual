package com.example.continuada02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cadastrar(componente: View) {

        val idade = et_idade.text.toString().toDouble()
        val texto = getString(R.string.texto_idadeInvalida)

        if (idade < 18) {
            tv_alerta.text = texto
        }else {
            val tela2 = Intent(this, Tela2::class.java)
            startActivity(tela2)
        }
    }
}