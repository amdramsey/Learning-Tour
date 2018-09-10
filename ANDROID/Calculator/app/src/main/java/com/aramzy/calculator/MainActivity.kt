package com.aramzy.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnOne: Button;
    lateinit var btnTwo: Button;
    lateinit var btnThree: Button;
    lateinit var btnFour: Button;
    lateinit var btnFive: Button;
    lateinit var btnSix: Button;
    lateinit var btnSeven: Button;
    lateinit var btnEight: Button;
    lateinit var btnNine: Button;
    lateinit var btnZero: Button;
    lateinit var btnEqual: Button;
    lateinit var btnAdd: Button;
    lateinit var btnSub: Button;
    lateinit var btnMulti: Button;
    lateinit var btnDiv: Button;
    lateinit var btnAC: Button;
    lateinit var btnPlus: Button;
    lateinit var btnPercent: Button;
    lateinit var btnPoint: Button;
    lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}
