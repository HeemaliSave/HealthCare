package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText user,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = (EditText)findViewById(R.id.editTextTextPersonName2);
        pwd = (EditText) findViewById(R.id.editTextTextPassword);



        Button bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name = user.getText().toString();
                String passwd = pwd.getText().toString();
                System.out.println(user_name+" "+passwd);
                if (user_name.equals("heemali") && passwd.equals("123")){
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);

                }
            }
        });
    }

}