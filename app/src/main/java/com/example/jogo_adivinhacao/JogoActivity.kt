package com.example.jogo_adivinhacao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.jogo_model.Jogador
import kotlinx.android.synthetic.main.activity_jogo.*
import kotlin.random.Random

class JogoActivity : AppCompatActivity() {

    private var nivel:Int? = null
    private var jogadorAtual:Jogador? = null
    private val jogador1:Jogador = Jogador("Jogador 1", 0)
    private val jogador2:Jogador = Jogador("Jogador 2", 0)
    private var numeroSorteado:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        // Declarando opções da tela secundária (jogo)
        var txtJogador = findViewById<TextView>(R.id.txtJogador)
        var txtSorteado = findViewById<TextView>(R.id.txtSorteado)
        var txtPalpite = findViewById<EditText>(R.id.txtPalpite)
        val btnMarcar = findViewById<Button>(R.id.btnMarcar)

        //Recebendo objetos da activity main
        val extras:Bundle? = intent.extras
        nivel = extras!!.getInt("nivel")

        // Sorteando jogador inicial
        if (Random.nextInt(0,1) == 0) {
            this.jogadorAtual = jogador1
        } else
            this.jogadorAtual = jogador2

        // Sorteando número
        this.sortearNumero()

        // Adicionando listener para o botão
        btnMarcar.setOnClickListener(){
            if (this.validarPalpite(txtPalpite.text.toString())) {
                startActivity(Intent(this, PontuacaoActivity::class.java))
                return@setOnClickListener
            }
        }
    }

    fun trocarJogador(){
        if (this.jogadorAtual!!.nome == "Jogador 1")
            this.jogadorAtual = jogador2
        else
            this.jogadorAtual = jogador1

        txtJogador.text = this.jogadorAtual!!.nome
    }

    fun sortearNumero(){
        for (i in 0 until 10){
            txtSorteado.text = Random.nextInt(0, this.nivel!!).toString()
            Thread.sleep(100)
        }
        txtSorteado.text = "?"
        numeroSorteado = Random.nextInt(0, this.nivel!!)
    }

    fun validarPalpite(palpite: String):Boolean{
        if(palpite.isNullOrBlank())
            return false

        verificarProximidade()
        return true
    }

    fun verificarProximidade() {
        if(txtSorteado.text.toString().toInt() != txtPalpite.text.toString().toInt())
            jogadorAtual?.pontuacao = numeroSorteado!! - txtPalpite.text.toString().toInt()
        else{
            startActivity(Intent(this, FinalActivity::class.java))
        }
    }
}
