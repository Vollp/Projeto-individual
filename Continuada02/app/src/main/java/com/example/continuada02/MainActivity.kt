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

        val texto = getString(R.string.texto_idadeInvalida)
        val campoVazio = getString(R.string.texto_campoVazio)

        if (et_idade.text.trim().isEmpty()) {
            tv_alerta.text = campoVazio
        }else {
            val idade = et_idade.text.toString().toDouble()

            if (et_nomeDeUsuario.text.trim().isEmpty()) {
                tv_alerta.text = campoVazio
            }else if (et_nome.text.trim().isEmpty()) {
                tv_alerta.text = campoVazio
            }else if (et_sobreNome.text.trim().isEmpty()) {
                tv_alerta.text = campoVazio
            }else if (et_email.text.trim().isEmpty()) {
                tv_alerta.text = campoVazio
            }else if (et_idade.text.trim().isEmpty()){
                tv_alerta.text = campoVazio
            }else if (idade < 18) {
                tv_alerta.text = texto
            }else {
                val tela2 = Intent(this, Tela2::class.java)
                startActivity(tela2)
            }
        }
    }
}