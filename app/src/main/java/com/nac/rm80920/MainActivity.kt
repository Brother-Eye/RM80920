package com.nac.rm80920

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPesquisa.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(SWAPICALL::class.java)
            service.buscarPessoa(etID.text.toString())
                .enqueue(object : Callback<Personagem>{
                    override fun onFailure(call: Call<Personagem>, t: Throwable) {
                    }

                    override fun onResponse(call: Call<Personagem>, response: Response<Personagem>) {
                       etID.text.clear()
                       val intent = Intent(this@MainActivity,DetalheActivity::class.java)

                       intent.putExtra("nome",response.body()?.name)
                        intent.putExtra("altura",response.body()?.height)
                        intent.putExtra("peso",response.body()?.mass)
                        intent.putExtra("cor_do_cabelo",response.body()?.hair_color)
                        intent.putExtra("cor_do_olho",response.body()?.eye_color)

                        startActivity(intent)
                        finish()
                    }
                })
        }
    }

}
