package com.juanvera.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var txtResultado : TextView? = null
    private lateinit var numero1:String
    private lateinit var operador:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun DarClick(view: View) {
        val tecla = (view as Button).text.toString()
        var display = txtResultado!!.text.toString()
        //txtResultado!!.text="$tecla"
        if(tecla.equals("C")){
            txtResultado!!.text=""
            numero1 = ""
            operador = ""
        }
        else if(tecla.equals("B")){
            display = display.substring(0, display.length-1)
            txtResultado!!.text=display
        }
        else if ("0123456789".indexOf(tecla)!=-1){
            txtResultado!!.text = display+tecla
        }
        else if("+-*/".indexOf(tecla)!=-1) {
            numero1 = display
            operador = tecla
            txtResultado!!.text=""
        }
        else if(tecla.equals("=") && !display.isEmpty()) {
            if(numero1.isEmpty()) {
                numero1 = display
            }
            else {
                when(operador) {
                    "+"->
                        display = (numero1.toDouble()+display.toDouble()).toString()
                    "-"->
                        display = (numero1.toDouble()-display.toDouble()).toString()
                    "*"->
                        display = (numero1.toDouble()*display.toDouble()).toString()
                    "/"->
                        display = (numero1.toDouble()/display.toDouble()).toString()
                }
                txtResultado!!.text= display
            }
            numero1 = ""
            operador = ""

        }
    }
}