package com.example.jogo_adivinhacao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.jogo_model.Jogador

class MainActivity : AppCompatActivity() {

    var nivel:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.nivel = 0

        // Declarando opções da tela inicial (main)
        val btnNivel1 = findViewById<Button>(R.id.btnNivel1)
            btnNivel1.setOnClickListener(){
                this.nivel = 30
                this.mudarActivity()
            }
        val btnNivel2 = findViewById<Button>(R.id.btnNivel2)
            btnNivel2.setOnClickListener(){
                this.nivel = 60
                this.mudarActivity()
            }
        val btnNivel3 = findViewById<Button>(R.id.btnNivel3)
            btnNivel3.setOnClickListener(){
                this.nivel = 120
                this.mudarActivity()
            }
    }

    fun mudarActivity(){
        // Levando variáveis para outra activity (jogo)
        var intent:Intent = Intent(this, JogoActivity::class.java)
        var bundle:Bundle = Bundle()

        intent.putExtra("nivel", nivel!!)

        startActivity(intent)
        return
    }
}