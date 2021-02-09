package com.innaval.cidadesibge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btResultado: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btResultado = findViewById(R.id.bt_mostrar_resultado)

        btResultado.setOnClickListener {

            val abrirResultado = Intent(this, ResultadosActivity::class.java)
            startActivity(abrirResultado)
        }
    }
}