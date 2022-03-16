package id.co.arifwidayana.intent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.arifwidayana.intent.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {
    private lateinit var secondBind: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondBind = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(secondBind.root)

    }
}