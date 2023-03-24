package com.example.principiante.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.principiante.databinding.ActivityMainBinding
import com.example.principiante.ui.viewmodel.VariableViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val variableViewModel : VariableViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        variableViewModel.onCreate(this)

        variableViewModel.variableModel.observe(this, Observer {
            binding.tvValor.text = it.valor
            binding.tvDescrip.text = it.descrip
        })

        variableViewModel.isLoading.observe(this,Observer{
            binding.progress.isVisible = it
        })

        binding.container.setOnClickListener {
            variableViewModel.ramdonVariable()
        }

    }

    private fun variables(){
        // INT, BOOLEAN, DOUBLE, FLOAT, STRING, BOOL
        //  var = variables , val = constantes
        //dsdkjasd

        val myINT : Int = 2
        val myFloat : Float = 2.2233233F
        var myDouble : Double = 2.2233233666666
        myDouble = 2.24

        var acceso = true

        if ( acceso )
            myDouble = 2.3
        else
            myDouble = 1.0

        print(myDouble)

    }

    private fun operadorWhen (){

        var pais = "España"

        when (pais) {
            "España"  -> {
                println("Se habla español")
            }
            "Italia" -> {
                println("Se habla italiano")
            }"Francia" -> {
                println("Se habla frances")
            }else -> { println("no info")
        }
        }

        val edad = 15

        when (edad){
            1,2,3,4 -> { println("Eres un bebe") }
            in 5..12 -> { println("Eres un niño") }
            in 13..17 -> { println("Eres un adolecesnte") }
            in 18..50 -> { println("Eres un adulto") }
            in 51..115 -> { println("Eres un anciano") }
            else -> { println( "GG" ) }
        }
    }

    private fun operadorArray (){

        var array = arrayListOf<String>()

        array.add("hola")
        array.add("adios")
        array.add("hola")
        println(array)

        array.addAll(listOf("buenas", "tardes"))
        array.forEach { println(it) }

        array.removeAt(2)
        println(array)
        array.clear()
        println(array)


    }

    private fun maps (){
        var myMap: Map<String, Int> = mapOf()
        println(myMap)

        myMap = mutableMapOf("Futbol" to 1 , "Basket" to 2, "volley" to 3)
        println(myMap)
        myMap["Baseball"] = 4
        myMap.put("Hockey",5)

    }

    private fun nullSafe (){

        var nullable : String? = "Hola"

        nullable?.let {
            println(it)
        } ?: run {
            println("Es nulo")
        }
    }

}