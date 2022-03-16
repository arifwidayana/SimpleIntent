package id.co.arifwidayana.intent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.arifwidayana.intent.MainActivity
import id.co.arifwidayana.intent.databinding.ActivitySerializableIntentBinding
import id.co.arifwidayana.intent.model.Person

class SerializableIntentActivity : AppCompatActivity() {
    private lateinit var bindSerialize: ActivitySerializableIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindSerialize = ActivitySerializableIntentBinding.inflate(layoutInflater)
        setContentView(bindSerialize.root)
        val dataStudent: Person = intent.getSerializableExtra(MainActivity.STUDENT) as Person

        bindSerialize.tvGetMessage.text = dataStudent.name
        bindSerialize.tvGetAge.text = dataStudent.age.toString()
        bindSerialize.tvGetNim.text = dataStudent.nim
    }
}