package com.example.faxfacil

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.faxfacil.databinding.ActivitySegundaTelaBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class SegundaTela : AppCompatActivity() {
    private lateinit var binding: ActivitySegundaTelaBinding
    //agora criamos outra variavel auth autenticação
    //e puxamos a instancia do nosso fire base auth(servidor)
    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //primeiramente verificaremos se os campos estao corretamente preenchidos!!
        binding.btncadastrar.setOnClickListener {view ->
            val email = binding.crtemail.text.toString()
            val senha = binding.crtsenha.text.toString()
            if (email.isEmpty()||senha.isEmpty()){
                val snackbar = Snackbar.make(view,"Preencha todos os campos!",Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
                //se não preenchidos corretamente aparecerá uma esnackbar ou seja uma mensagem
            // de pedindo que preencha
            } else{
                //aqui conseguiremos capturar o que o usuario escreve nos campos email e senha
                auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener {cadastro->
                    //resultado do cadastro
                    if(cadastro.isSuccessful) {
                        val snackbar = Snackbar.make(view, "Cadastrado com sucesso!", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.show()
                        //para limpar os campos utilizaremos o metodo settext com "vazias"
                  binding.crtemail.setText("")
                        binding.crtsenha.setText("")

                    }

                }//para tratar outros erros esta incompleto
                    .addOnFailureListener {

                }

                }

            }
        }
    }
