package com.example.novia.androidlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by novia on 19/12/2017.
 */

public class LoginActivity extends BaseActivity {

    private static final String UNAME = "admin";
    private static final String PWD = "password";

    @BindView(R.id.etUsername)
    EditText username;
    @BindView(R.id.etPassword)
    EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);
        ButterKnife.bind(LoginActivity.this);

    }

    @OnClick(R.id.btnLogin)
    void gotoLogin() {
        String u = username.getText().toString();
        String p = password.getText().toString();
        Call<ResponseLogin> call = getApi().doLogin(u, p);
        call.enqueue(new Callback<ResponseLogin>() {

            @Override
            public void onResponse(Call<ResponseLogin> call, retrofit2.Response<ResponseLogin> response) {
                if(response.isSuccessful()){
                    ResponseLogin res = response.body();
                    if(res.getStatus().equals("200")){
                        Intent i = new Intent(LoginActivity.this,MainActivity.class);
                        i.putExtra("username", u);
                        startActivity(i);
                        finish();
                    }else if(res.getStatus().equals("500")){
                        Toast.makeText(LoginActivity.this,res.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this,"Connection Refused",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Connection Refused",Toast.LENGTH_LONG).show();
            }
        });


//        if(validatePwd()){
//        String u = username.getText().toString();
//        Intent i = new Intent(LoginActivity.this, MainActivity.class);
//        i.putExtra("username", u);
//        startActivity(i);
//        finish();
//    } else {
//        Toast.makeText(this, "Username / Password Is Invalid", Toast.LENGTH_LONG).show();
//    }

}


    private boolean validatePwd(){
        String u = username.getText().toString();
        String p = password.getText().toString();

        if(u.equals(UNAME) && p.equals(PWD)){
            return true;
        } else {
            return false;
        }
    }
}
