package com.calymayor.sigoContecon.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.calymayor.sigoContecon.presenters.LoginPresenter;
import com.calymayor.sigoContecon.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        presenter = new LoginPresenter(this);
        presenter.initApp(this);

        //presenter.validateInternet(this);
    }


    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }


    public void setUsernameError() {
        username.setError("El usuario no puede estar vacío");

    }


    public void setPasswordError() {
        password.setError("El password no puede estar vacío");

    }

    public void setCredentialsError() {
        username.setError("Sus credenciales son inválidas");
    }


    public void setInternetError() {
        Toast.makeText(this,"No hay conexión a Internet",Toast.LENGTH_LONG).show();
    }

    //Actualizado 12/07/18
    public void navigateToHome() {
        System.out.println("Ya te dejaré entrar");
        startActivity(new Intent(this, BienvenidaActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        presenter.validateInternet(this);
        presenter.validateCredentials(username.getText().toString(), password.getText().toString(),this);
    }
}
