package com.example.jogo_adivinhacao

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.jogo_model.Jogador
import kotlin.random.Random

class PontuacaoActivity : AppCompatActivity() {

    private var jogadorAtual:Jogador? = null
    private val jogador1:Jogador = Jogador("Jogador 1", 0)
    private val jogador2:Jogador = Jogador("Jogador 2", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declarando opções da tela terceária (pontuacao)
        var txtJogadorPonto = findViewById<TextView>(R.id.txtJogador)
        var txtPontuacao = findViewById<TextView>(R.id.txtPontuacao)
        val btnOk = findViewById<Button>(R.id.btnOk)

        // Sorteando jogador inicial
        if (Random.nextInt(0,1) == 0)
            this.jogadorAtual = jogador1
        else
            this.jogadorAtual = jogador2
    }
}
