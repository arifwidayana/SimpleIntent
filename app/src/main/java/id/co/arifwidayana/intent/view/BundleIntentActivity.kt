package id.co.arifwidayana.intent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.arifwidayana.intent.MainActivity
import id.co.arifwidayana.intent.databinding.ActivityBundleIntentBinding

class BundleIntentActivity : AppCompatActivity() {
    private lateinit var bind: ActivityBundleIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityBundleIntentBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val getBundle = intent.getBundleExtra(MainActivity.BUNDLE)

        val messsage = getBundle?.getString(MainActivity.MESSAGE)
        val age = getBundle?.getInt(MainActivity.AGE, 0)

        bind.tvGetMessage.text = messsage
        bind.tvGetAge.text = age.toString()
    }
}