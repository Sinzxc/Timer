package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun click(view: View){

        val input:EditText=findViewById(R.id.editTextNumber);
        val output:TextView=findViewById(R.id.textView);
        val btn:Button=findViewById(R.id.button);
        if(input.text.toString()!=""){
            var time=input.text.toString().toInt();
            var i=time;
            var runnable:Runnable=Runnable{
                view.post {
                    btn.isEnabled=false;
                }
                for (index in 1..time )
                {

                    view.post {
                        output.text=i.toString();
                    }
                    Thread.sleep(1000)
                    i--;
                }
                view.post {
                    output.text=0.toString();
                }
                view.post { btn.isEnabled=true; }
            }
            var thread:Thread=Thread(runnable);
            thread.start();
        }

    }
}