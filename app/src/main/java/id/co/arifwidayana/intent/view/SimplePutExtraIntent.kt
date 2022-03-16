package id.co.arifwidayana.intent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.arifwidayana.intent.MainActivity
import id.co.arifwidayana.intent.databinding.ActivitySimplePutExtraIntentBinding

class SimplePutExtraIntent : AppCompatActivity() {
    private lateinit var extra: ActivitySimplePutExtraIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        extra = ActivitySimplePutExtraIntentBinding.inflate(layoutInflater)
        setContentView(extra.root)

        val messsage = intent.getStringExtra(MainActivity.MESSAGE)
        val age = intent.getIntExtra(MainActivity.AGE, 0)

        extra.tvGetMessage.text = messsage
        extra.tvGetAge.text = age.toString()
    }
}