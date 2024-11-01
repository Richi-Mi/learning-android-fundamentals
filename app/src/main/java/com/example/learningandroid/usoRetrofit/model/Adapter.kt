package com.example.learningandroid.usoRetrofit.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learningandroid.R

class Adapter( val context: Context, val taskList: List<Task> ) : RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = context.getSystemService( Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater
        return TaskViewHolder( layoutInflater.inflate( R.layout.task_element, parent, false) )
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.personaliza( taskList[position] )
    }

}
class TaskViewHolder( itemView: View ) : RecyclerView.ViewHolder( itemView ) {
    fun personaliza( task : Task) {
        val elText : TextView = itemView.findViewById(R.id.el_text)
        elText.text = "${task.id} - ${task.title}"
    }
}