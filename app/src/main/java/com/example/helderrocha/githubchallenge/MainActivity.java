package com.example.helderrocha.githubchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Passa uma palavra para a função
        Log.i("PALAVRA:",isPalindroma("Arara"));
    }

    public String isPalindroma(String palavra) {
        String palavraInvertida = "";
        int tamanho, i;
        //Tamanho recebe a quantiade de letras da palavra
        tamanho = palavra.length();
        //pega a ultima letra da  palavra, e inseri na primeira de palavraInvertida e assim em diante, até pegar a primeira, e inserir na ultima.
        for (i = tamanho - 1; i >= 0; i--) {
            palavraInvertida += palavra.charAt(i);
        }
        //Compara as Strings e Exibe o Resultado
        if (palavra.toLowerCase().equals(palavraInvertida.toLowerCase()))
            return  "É uma palavra palindroma";
        return  "Não é uma palavra palindroma";
    }
}
