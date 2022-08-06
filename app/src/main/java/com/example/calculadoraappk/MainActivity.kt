package com.example.calculadoraappk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalcular = btnCalcular

        buttonCalcular.setOnClickListener{
            calcularPreco(it)
        }
    }

    fun calcularPreco(view: View){

        val precoAlcool = txtAlcool.text.toString()
        val precoGasolina = txtGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if (validaCampos){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            txtResultado.text = "Preencha valores de combustível válidos!!!"
        }

    }

    private fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {

        var valorAlcool = precoAlcool.toDouble()
        var valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina

        if (resultadoPreco >= 0.7){
            txtResultado.text = "Melhor utilizar Gasolina!"
        } else {
            txtResultado.text = "Melhor utilizar Álcool!"
        }


    }

    private fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {
        var camposValidados: Boolean = true

        if (precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados
    }
}