package com.example.balasubramanian.matchfixing;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {

DatabaseHelper myDb;
EditText et1,et2,et3,et4,et5;
Button bt1,bt2;
    CheckBox c;
    boolean f1=false;
@Override
protected void onCreate(Bundle savedInstancestate)
{
    super.onCreate(savedInstancestate);
    setContentView(R.layout.reg);
    myDb=new DatabaseHelper(this);
    et1=(EditText)findViewById(R.id.e1);
    et2=(EditText)findViewById(R.id.e2);
    et3=(EditText)findViewById(R.id.e3);
    et4=(EditText)findViewById(R.id.e4);
    et5=(EditText)findViewById(R.id.e5);
    bt1=(Button)findViewById(R.id.button2);
    c=(CheckBox)findViewById(R.id.checkBox);
    //bt2=(Button)findViewById(R.id.button4);
    if (et2.getText().toString().matches("")) {
        Toast.makeText(Registration.this, "Enter the details.", Toast.LENGTH_SHORT).show();
    }

    /*
    if(c.isChecked()){
        bt1.setEnabled(true);
    }
    */
    addData();

    //updateData();
    //deleteData();
}

    public void addData()
    {
        c.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(f1) {
                            bt1.setEnabled(false);
                        }
                        else {
                            bt1.setEnabled(true);
                        }
                        f1=!f1;
                    }
                }
        );

        bt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (et2.getText().toString().matches("") || et3.getText().toString().matches("")) {
                            Toast.makeText(Registration.this, "Please enter the details.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            boolean isInserted = myDb.insertData(et1.getText().toString(),
                                    et2.getText().toString(),
                                    et3.getText().toString(),
                                    et4.getText().toString(),
                                    et5.getText().toString());
                            if (isInserted == true) {
                                Toast.makeText(Registration.this, "Registration sucessful.", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Registration.this, MainActivity.class);
                                startActivity(i);
                                Registration.this.finish();
                            } else {
                                Toast.makeText(Registration.this, "Registration Unsucessful.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );
    }

    /*
    public void updateData(){
    bt2.setOnClickListener(
              new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                  boolean isUpdate = myDb.updateData(et1.getText().toString(),
                                et2.getText().toString(),
                                et3.getText().toString(),
                                et4.getText().toString());
                  if (isUpdate == true) {
                            Toast.makeText(Registration.this, "Data Updated.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Registration.this, "Data NOT Updated.", Toast.LENGTH_SHORT).show();
                        }
                  }
              }
      );

    }
    */

    /*
    public void deleteData(){

      bt2.setOnClickListener(
              new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Integer deletedRows = myDb.deleteData(et2.getText().toString());
                      if (deletedRows >0)
                      {
                          Toast.makeText(Registration.this, "Data Deleted.", Toast.LENGTH_SHORT).show();
                      }
                      else{
                          Toast.makeText(Registration.this, "Data NOT Deleted.", Toast.LENGTH_SHORT).show();
                      }
                  }
              }
      );

    }
   */
    public void back(View view)
    {
        //setContentView(R.layout.activity_main);
        Intent i=new Intent(Registration.this,MainActivity.class);
        startActivity(i);
        Registration.this.finish();
    }
}
