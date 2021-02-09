package com.innaval.cidadesibge

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ResultadosActivity: AppCompatActivity() {

    private lateinit var textViewResultado: TextView

    private val sucesso:(List<RespostaCidade>) -> Unit = {respostaCidades ->
    respostaCidades.get(0).municipio.nome

    val um = respostaCidades.get(0).municipio.nome
    val dois = respostaCidades.get(1).municipio.nome
    val tres = respostaCidades.get(2).municipio.nome
    val quatro = respostaCidades.get(3).municipio.nome
    val cinco = respostaCidades.get(4).municipio.nome
    val seis = respostaCidades.get(5).municipio.nome
    val sete = respostaCidades.get(6).municipio.nome

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