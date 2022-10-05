package com.example.faxfacil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.faxfacil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //variavel privada para recuperar biblioteca viewbinding para recuperar id dos componentes
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//aqui dentro teremos de inflar o layout n sei pq
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //agora usando o (binding.)conseguimos ver todos id
        binding.btnNOTenhoCadastro.setOnClickListener {
//agora criamos uma val com intencao de navegar entre telas
            val navegarSegundaTela = Intent(this,SegundaTela::class.java)
            startActivity(navegarSegundaTela)

        }
    }
}