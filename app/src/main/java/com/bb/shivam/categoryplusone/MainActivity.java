package com.bb.shivam.categoryplusone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bMenu, bAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bMenu = (Button) findViewById(R.id.bMenu);
        bAdmin = (Button) findViewById(R.id.bAdmin);

        bMenu.setOnClickListener(this);
        bAdmin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.bAdmin:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.bMenu:

                break;
        }
    }
}
