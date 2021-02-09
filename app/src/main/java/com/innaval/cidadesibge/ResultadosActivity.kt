package com.innaval.cidadesibge

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ResultadosActivity: AppCompatActivity() {

    private lateinit var textViewResultado: TextView

    private val sucesso:(RespostaCidade) -> Unit = {respostaCidade ->
    respostaCidade.municipio.get(0).nome

    val um = respostaCidade.municipio.get(0).nome.get(0)
    val dois = respostaCidade.municipio.get(0).nome.get(1)
    val tres = respostaCidade.municipio.get(0).nome.get(2)
    val quatro = respostaCidade.municipio.get(0).nome.get(3)
    val cinco = respostaCidade.municipio.get(0).nome.get(4)
    val seis = respostaCidade.municipio.get(0).nome.get(5)
    val sete = respostaCidade.municipio.get(0).nome.get(6)

    textViewResultado.text = "${um} ${dois} ${tres} ${quatro} ${cinco} ${seis} ${sete}"
    }

    private val error:(Throwable) -> Unit = {
        textViewResultado.text = "Acesso a Api não Concluido"
        textViewResultado.setTextColor(Color.RED)
        it.printStackTrace()
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        val cidadesBuilder = CidadesBuilder()

        val cidadeApi2 = cidadesBuilder.cidadeApi
        cidadeApi2.getCidades()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(sucesso, error)

        textViewResultado = findViewById(R.id.tv_resultado_final)

    }
}