package com.jaques.projetos.minhasanotacoes

import android.content.Context
import android.content.SharedPreferences

class AnotacaoPreferencias(c: Context) {

    private var preferences: SharedPreferences
    private var editor: SharedPreferences.Editor
    private var context: Context = c

    private val NOME_ARQUIVO: String = "anotacao.preferencias"
    private val CHAVE_NOME: String = "nome"


    init {
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0)
        editor = preferences.edit()
    }

    fun salvarAnotacao(anotacao: String): Unit {
        editor.putString(CHAVE_NOME, anotacao).commit()

    }

    fun recuperarAnotacao(): String {

        return preferences.getString(CHAVE_NOME, "").toString()
    }

}