package com.example.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnExibir: Button
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDados()
        initClick()
        }

    private fun initClick(){
        btnDados.setOnClickListener {

           viewModel.Contador()
        }
        btnExibir.setOnClickListener{
            Toast.makeText(applicationContext,"O valor do contador: ${viewModel.nContador.value}",Toast.LENGTH_SHORT ).show()
        }

    }
    private fun initDados(){
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnExibir = findViewById(R.id.btnExibir)
        viewModel.nContador.observe(this, Observer { valor ->
            txtContador.setText(valor)
        })
    }
}