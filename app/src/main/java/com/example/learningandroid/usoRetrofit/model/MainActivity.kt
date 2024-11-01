package com.example.learningandroid.usoRetrofit.model

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningandroid.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    // Crear el objeto de retrofit.
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Creamos un api Service para manejar peticiones.
    val apiService = retrofit.create( ApiService::class.java )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTodo : TextView = findViewById(R.id.title)
        val recycler : RecyclerView = findViewById(R.id.recycler)
        var todos = listOf<Task>()

        lifecycleScope.launch(Dispatchers.IO) {
            val task = apiService.getTodo(1)
            val tasks = apiService.getTodos()

            withContext( Dispatchers.Main ) {
                titleTodo.text = "${task.id} - ${task.title}"
                todos = tasks
                recycler.apply {
                    layoutManager = LinearLayoutManager( this@MainActivity )
                    adapter = Adapter( this@MainActivity, todos )
                }
            }

        }
    }
}