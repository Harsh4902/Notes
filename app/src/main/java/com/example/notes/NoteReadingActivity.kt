package com.example.notes

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_note_read.*

class NoteReadingActivity: AppCompatActivity() {

    companion object{
        const val text = "context_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_read)

        val content = intent.getStringExtra(text)
        textView.text = content
    }

}