package com.jaques.projetos.minhasanotacoes

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var preferencias: AnotacaoPreferencias
    private lateinit var editAnotacao: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editAnotacao = editText_anotacao
        preferencias = AnotacaoPreferencias(applicationContext)

        fab.setOnClickListener {
            val textoRecuperado = editAnotacao.text.toString()

            if (textoRecuperado.equals("")) {
                Snackbar.make(
                    findViewById(R.id.editText_anotacao),
                    R.string.snackbarVazio,
                    Snackbar.LENGTH_SHORT
                ).setTextColor(Color.parseColor("#FFFFFF")).show()

            } else {
                preferencias.salvarAnotacao(textoRecuperado)
                Snackbar.make(
                    findViewById(R.id.editText_anotacao),
                    R.string.snackbarSucesso,
                    Snackbar.LENGTH_SHORT
                ).show()

            }
        }
        val anotacao = preferencias.recuperarAnotacao()
        if (!anotacao.equals("")) editAnotacao.setText(anotacao)

    }
}
