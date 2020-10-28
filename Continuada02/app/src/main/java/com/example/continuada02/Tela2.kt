package com.example.continuada02

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Tela2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)
        consumindoApi()
    }

    fun consumindoApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://5f98bdc050d84900163b7d10.mockapi.io/volpe/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val requests = retrofit.create(ApiVagas::class.java)
        val callFilmes = requests.getVagas()

        callFilmes.enqueue(object: Callback<List<Vagas>> {
            override fun onFailure(call: Call<List<Vagas>>, t: Throwable) {
                Toast.makeText(applicationContext, "ERRO: $t", Toast.LENGTH_SHORT).show()
            }

            @SuppressLint("StringFormatMatches")
            override fun onResponse(call: Call<List<Vagas>>, response: Response<List<Vagas>>) {
                response.body()?.forEach {vagas ->
                    val novoTv = TextView(baseContext)

                    novoTv.text =
                        getString(
                            R.string.txt_vagas,
                            vagas?.nomeEmpresa,
                            vagas?.cargo,
                            vagas?.vagas,
                            vagas?.endereco,
                            vagas?.salario
                        )

                    novoTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                    novoTv.setTextColor(Color.parseColor("#EEEEEE"))

                    ll_vagas.addView(novoTv);
                }
            }
        })
    }
}