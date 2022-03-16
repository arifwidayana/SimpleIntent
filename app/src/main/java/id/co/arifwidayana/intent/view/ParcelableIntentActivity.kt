package id.co.arifwidayana.intent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.arifwidayana.intent.MainActivity
import id.co.arifwidayana.intent.databinding.ActivityParcelableIntentBinding
import id.co.arifwidayana.intent.model.Animal

class ParcelableIntentActivity : AppCompatActivity() {
    private lateinit var getBind: ActivityParcelableIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBind = ActivityParcelableIntentBinding.inflate(layoutInflater)
        setContentView(getBind.root)
        val getAnimal = intent.getParcelableExtra<Animal>(MainActivity.ANIMAL)

        getBind.tvNameAnimal.text = getAnimal?.name
        getBind.tvColor.text = getAnimal?.color
        getBind.tvLegs.text = getAnimal?.legs.toString()
        getBind.tvEnvi.text = getAnimal?.environment
    }
}