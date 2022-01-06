package com.example.kalkulatorbaru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kalkulatorbaru.adapter.MainAdapter
import com.example.kalkulatorbaru.databinding.ActivityMainBinding
import com.example.kalkulatorbaru.model.MainModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var operator : String
    lateinit var mainAdapter: MainAdapter
    var arrayList : MutableList<MainModel>? = mutableListOf()
    var increment = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupData()
    }

    private fun setupData(){
        binding.btnHitung.setOnClickListener{clickable()}
        val rv : RecyclerView = binding.rvHistory
        mainAdapter = MainAdapter(arrayList)
        rv.adapter = mainAdapter
        rv.layoutManager = LinearLayoutManager(this)






    }

    private fun clickable(){
        var hasil = 0.0F
        var in1 : Float = binding.input1.text.toString().toFloat()
        var in2 : Float = binding.input2.text.toString().toFloat()
        when(operator){
            "*"->{
                hasil =  in1 * in2
            }
            "/"->{
                hasil =  in1 / in2

            }
            "+"->{
                hasil =  in1 + in2

            }
            "-"->{
                hasil =  in1 - in2
            }
        }

        arrayList?.add(MainModel(input1 = in1.toString(), input2 = in2.toString(), operator = operator,hasil = hasil.toString()))
        binding.hasil.text = hasil.toString()
        binding.input1.setText("")
        binding.input2.setText("")

        mainAdapter.notifyDataSetChanged()


    }


    fun onRadioButtonClicked(view: View) {
        when(view){
            binding.rKali ->{
               operator = "*"
            }
            binding.rBagi ->{
                operator = "/"

            }
            binding.rKurang ->{
                operator = "-"
            }
            binding.rTambah ->{
                operator = "+"
            }
        }
    }
}