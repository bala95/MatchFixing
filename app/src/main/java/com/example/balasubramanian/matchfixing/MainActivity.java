package com.example.balasubramanian.matchfixing;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText et1,et2;
    Button bt1;
   // boolean flag=false,flag1=false;
    boolean f=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(MainActivity.this, "Please Login.", Toast.LENGTH_SHORT).show();

        myDb=new DatabaseHelper(this);
        et1=(EditText)findViewById(R.id.e1);
        et2=(EditText)findViewById(R.id.e2);
        bt1=(Button)findViewById(R.id.b1);

        check();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

/*
Button b=(Button)findViewById(R.id.button);

        public void onClick(Button b)
        {
            setContentView(R.layout.registration);
        }
*/
    public void register(View view)
    {
        //setContentView(R.layout.registration);
        Intent i=new Intent(MainActivity.this,Registration.class);
        startActivity(i);
        MainActivity.this.finish();
        //startActivity(new Intent(this,Registration.class));
    }

    /*
    public void login()
    {
        //setContentView(R.layout.registration);
        Intent in=new Intent(MainActivity.this,Registration.class);
        startActivity(in);
        MainActivity.this.finish();
        //startActivity(new Intent(this,Registration.class));
    }
    */
    public void check()
    {
        bt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        f=false;
                /*       flag1=false;
                        if(et1.getText().toString()=="" || et2.getText().toString()=="")
                        {
                           flag1=true;
                        }
                        if(flag1 == true){
                            Toast.makeText(MainActivity.this, "Enter the details.", Toast.LENGTH_SHORT).show();
                        }
                 */
                        if (res.getCount() == 0) {
                            Toast.makeText(MainActivity.this, "Please Register.", Toast.LENGTH_SHORT).show();
                           // showMessage("Error","No data found.");
                        }
                        //StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            //buffer.append("username:" + res.getString(1)+"\n");
                            //buffer.append("password:" + res.getString(2)+"\n\n");
                          /*
                           if( (et1.getText().toString().equals(res.getString(1))) &&(et2.getText().toString().equals(res.getString(2))))
                           {
                               flag = true;
                              // break;
                           }
                          */
                            if (et1.getText().toString().equals(res.getString(1)) && et2.getText().toString().equals(res.getString(2)))
                            {
                                Toast.makeText(MainActivity.this, "Login Sucessful.", Toast.LENGTH_SHORT).show();

                                Intent in=new Intent(MainActivity.this,Home.class);
                                startActivity(in);
                                MainActivity.this.finish();
                                f=true;
                            }
                        }
                        /*
                        if(flag==true)
                        {
                            login();
                        }
                        */
                        //else
                       // {
                        if (!f) {
                            Toast.makeText(MainActivity.this, "Invalid Login.", Toast.LENGTH_SHORT).show();
                        }
                       // }
                     //showMessage("Data",buffer.toString());

                    }
                }
        );
    }

/*
     public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
 */
}
