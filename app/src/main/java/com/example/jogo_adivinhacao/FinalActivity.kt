package com.example.jogo_adivinhacao

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.jogo_model.Jogador
import kotlin.random.Random

class FinalActivity : AppCompatActivity() {

    var nivel:Int? = null
    var jogadorAtual:Jogador? = null
    private val jogador1:Jogador = Jogador("Jogador 1", 0)
    private val jogador2:Jogador = Jogador("Jogador 2", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.nivel = 0

        // Declarando opções da tela inicial (main)
        val btnNivel1 = findViewById<Button>(R.id.btnNivel1)
            btnNivel1.setOnClickListener(){
                this.nivel = 30
            }
        val btnNivel2 = findViewById<Button>(R.id.btnNivel2)
            btnNivel2.setOnClickListener(){
                this.nivel = 60
            }
        val btnNivel3 = findViewById<Button>(R.id.btnNivel3)
            btnNivel3.setOnClickListener(){
                this.nivel = 120
            }

        // Sorteando jogador inicial
        if (Random.nextInt(0,1) == 0)
            this.jogadorAtual = jogador1
        else
            this.jogadorAtual = jogador2
    }

    fun mudarActivity(){

    }


}
