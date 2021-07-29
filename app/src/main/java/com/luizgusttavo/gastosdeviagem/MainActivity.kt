package com.luizgusttavo.gastosdeviagem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id

        if(id == R.id.buttonCalculate){
            calculate()
        }
    }

    private fun calculate(){

        if(validationOK()) {
            try {
                val distance = edit_distance.text.toString().toFloat()
                val price = edit_price.text.toString().toFloat()
                val autonomy = edit_autonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                total_price.text = "R$ ${"%.2f".format(totalValue)}"
            }catch (nfe: NumberFormatException){
                Toast.makeText(this, getString(R.string.zero_validation), Toast.LENGTH_LONG).show()
            }
        }else {
            Toast.makeText(this, getString(R.string.preencha_todos_os_campos), Toast.LENGTH_LONG).show()
        }
    }

    private fun validationOK(): Boolean = (edit_distance.text.toString() != ""
            && edit_price.text.toString() != ""
            && edit_autonomy.text.toString() != "")
}