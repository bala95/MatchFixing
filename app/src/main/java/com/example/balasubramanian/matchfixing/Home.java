package com.example.balasubramanian.matchfixing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends Activity
{
    //DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstancestate)
    {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.home);
        //myDb=new DatabaseHelper(this);
    }

    public void signout(View view){
        Intent i=new Intent(Home.this,MainActivity.class);
        startActivity(i);
        Home.this.finish();
    }

}
