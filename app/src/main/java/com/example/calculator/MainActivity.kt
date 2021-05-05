package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null
    private var tvOutput: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn00 = findViewById<Button>(R.id.btn00)
        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btnDot = findViewById<Button>(R.id.btnDot)
        tvInput = findViewById<TextView>(R.id.tvInput)
        tvOutput = findViewById<TextView>(R.id.tvOutput)
        //Number listeners
        btn00.setOnClickListener { appendOnClick(true, "00") }
        btn0.setOnClickListener { appendOnClick(true, "0") }
        btn1.setOnClickListener { appendOnClick(true, "1") }
        btn2.setOnClickListener { appendOnClick(true, "2") }
        btn3.setOnClickListener { appendOnClick(true, "3") }
        btn4.setOnClickListener { appendOnClick(true, "4") }
        btn5.setOnClickListener { appendOnClick(true, "5") }
        btn6.setOnClickListener { appendOnClick(true, "6") }
        btn7.setOnClickListener { appendOnClick(true, "7") }
        btn8.setOnClickListener { appendOnClick(true, "8") }
        btn9.setOnClickListener { appendOnClick(true, "9") }
        btnDot.setOnClickListener { appendOnClick(true, ".") }

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnLeftB = findViewById<Button>(R.id.btnLeftB)
        val btnRightB = findViewById<Button>(R.id.btnRightB)

        //Operator Listeners
        btnPlus.setOnClickListener { appendOnClick(false, "+") }
        btnMinus.setOnClickListener { appendOnClick(false, "-") }
        btnMultiply.setOnClickListener { appendOnClick(false, "*") }
        btnDivide.setOnClickListener { appendOnClick(false, "/") }
        btnLeftB.setOnClickListener { appendOnClick(false, "(") }
        btnRightB.setOnClickListener { appendOnClick(false, ")") }

        var btnClear = findViewById<Button>(R.id.btnClear)
        var btnEqual = findViewById<Button>(R.id.btnEqual)
        btnClear.setOnClickListener {
            clear()
        }

        btnEqual.setOnClickListener {
            calculate()
        }


    }
    //now create methods

    private fun appendOnClick(clear: Boolean, string: String) {

        if (clear) {
            tvOutput!!.text = ""
            tvInput!!.append(string)
        } else {
            tvInput!!.append(tvOutput!!.text)
            tvInput!!.append(string)
            tvOutput!!.text = ""
        }
    }

    private fun clear() {
        tvInput!!.text = ""
        tvOutput!!.text = ""

    }

    private fun calculate() {

        try {

            val input = ExpressionBuilder(tvInput!!.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if (output == longOutput.toDouble()){
                tvOutput!!.text = longOutput.toString()
            }else{
                tvOutput!!.text = output.toString()
            }

        }catch (e:Exception){
            Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
        }
    }
}
