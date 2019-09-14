package com.nac.rm80920

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalhe.*

class DetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        val bundle = intent.extras
        val nome = bundle?.getString("nome")
        val altura = bundle?.getInt("altura")
        val peso = bundle?.getInt("peso")
        val cor_do_cabelo = bundle?.getString("cor_do_cabelo")
        val cor_do_olho = bundle?.getString("cor_do_olho")


        tvNome.text = nome
        tvAltura.text = altura.toString()
        tvPeso.text = peso.toString()
        tvCabelo.text = cor_do_cabelo
        tvOlho.text = cor_do_olho

        btVoltar.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
            finish()
        }


    }
}
