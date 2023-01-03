package com.example.notes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_note_read.view.*
import kotlinx.android.synthetic.main.item_note.view.*

class NotesRVAdapter(private val context: Context, private val listner : INotesRvAdapter) : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder> ()  {

    private val allNote = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton: ImageView = itemView.findViewById<ImageView>(R.id.imageButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder{
       val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteButton.setOnClickListener{
            listner.onItemClicked(allNote[viewHolder.adapterPosition])
        }
        viewHolder.textView.setOnClickListener {
            listner.onTextClicked(allNote[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNote[position]
        holder.textView.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allNote.size
    }

    fun updateList(newList : List<Note>){
        allNote.clear()
        allNote.addAll(newList)

        notifyDataSetChanged()
    }
}

interface INotesRvAdapter{
    fun onItemClicked(note: Note)
    fun onTextClicked(note : Note)
}

