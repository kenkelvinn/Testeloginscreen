package com.example.kenkelvin.ondealuga;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    EditText firstName, lastName, email, senha, dtNascimento;
    Button button;
    private SharedPreferences sp;
    private SharedPreferences.Editor spEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        spEdit = sp.edit();

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.paswd);
        dtNascimento = (EditText) findViewById(R.id.dataNascimento);
        button = (Button) findViewById(R.id.button);
    }

    public void cadastrar(View v){
        spEdit.putString("access_token", email.getText().toString());
        spEdit.commit();
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }


}
