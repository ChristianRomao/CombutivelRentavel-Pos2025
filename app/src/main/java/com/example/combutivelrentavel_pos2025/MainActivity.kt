package com.example.combutivelrentavel_pos2025

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.combutivelrentavel_pos2025.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btCalcular.setOnClickListener { btCalcularOnClick() }
    }

    private fun btCalcularOnClick() {
        val precoComb1 = binding.valueFue1.text.toString().toDoubleOrNull()
        val consumoComb1 = binding.consumptionFue1.text.toString().toDoubleOrNull()
        val precoComb2 = binding.valueFue2.text.toString().toDoubleOrNull()
        val consumoComb2 = binding.consumptionFue2.text.toString().toDoubleOrNull()

        if (precoComb1 == null || consumoComb1 == null || precoComb2 == null || consumoComb2 == null) {
            binding.result.text = "Por favor, preencha todos os campos corretamente."
            return
        }

        val custoPorKm1 = precoComb1 / consumoComb1
        val custoPorKm2 = precoComb2 / consumoComb2

        val resultado = when {
            custoPorKm1 < custoPorKm2 -> "O primeiro combustível é mais vantajoso."
            custoPorKm1 > custoPorKm2 -> "O segundo combustível é mais vantajoso."
            else -> "Ambos os combustíveis têm o mesmo custo por km."
        }

        binding.result.text = resultado
    }
}