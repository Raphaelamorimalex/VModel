package com.example.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnExibir: Button
    var contador: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logar(valor = "OnCreate")
        initDados()
        initContador()
        initClick()
        validaContador()
        finalizarApp()
        }

    private fun finalizarApp() {
        finish()
    }

    override fun onStart() {
        logar(valor = "OnStart")
        super.onStart()
    }

    override fun onResume() {
        logar(valor = "OnResume")
        super.onResume()
    }

    override fun onPause() {
        logar(valor = "OnPause")
        super.onPause()
    }

    override fun onStop() {
        logar(valor = "OnStop")
        super.onStop()
    }

    override fun onDestroy() {
        logar(valor = "OnDestroy")
        super.onDestroy()
    }

    private fun logar(tag:String = "Ciclo de vida", valor: String){
            Log.d(tag,valor)
    }

    private fun validaContador() {
        if(contador > 5){
            contador = 0
        }
    }

    private fun initClick(){
        btnDados.setOnClickListener {
            contador++
            validaContador()
            initContador()
        }
        btnExibir.setOnClickListener{
            Toast.makeText(this,"O valor do contador: ${contador.toString()}",Toast.LENGTH_SHORT ).show()
        }

    }
    private fun initContador(){
        txtContador.setText(contador.toString())
    }
    private fun initDados(){
        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnExibir = findViewById(R.id.btnExibir)
    }
}