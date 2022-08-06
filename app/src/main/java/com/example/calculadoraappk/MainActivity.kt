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
            calcularConversao(it)
        }
    }

    fun calcularConversao(view: View){

        val user = txtUser.text.toString()
        val temperatura = txtTemperatura.text.toString()

        val validaCampo = validarCampo(temperatura)
        if (validaCampo){
            val calculado = calcularFahreinheit(temperatura)

            // Caso o usuário não se identifique, mencione não saber quem é, e informe o resultado
            if (user == ""){
                txtResultado.text = "Sei lá quem é você, mas o valor em graus Fahreinheit é " + calculado.toString()
            }
            // Caso o usuário se identifique, cite seu nome e informe o resultado
            else {
                txtResultado.text = "Caro " + user + ", o valor em graus Fahreinheit é " + calculado.toString()
            }

        } else {
            txtResultado.text = "Preencha valor de temperatura válido!!!"
        }

    }

    // Função para calcular a temperatura em graus Fahreinheit à partir de input em graus Celsius
    private fun calcularFahreinheit(tempCelsius: String): Double {
        val celsius = tempCelsius.toDouble()

        return (celsius * 9.0 / 5.0) + 32.0

    }

    // Validando se o valor informado é nulo ou vazio
    private fun validarCampo(numero: String): Boolean {
        var camposValidados: Boolean = true

        if (numero == null || numero.equals("")) {
            camposValidados = false
        }
        return camposValidados
    }
}