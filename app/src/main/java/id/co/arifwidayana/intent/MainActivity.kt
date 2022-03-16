package id.co.arifwidayana.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.co.arifwidayana.intent.databinding.ActivityMainBinding
import id.co.arifwidayana.intent.model.Animal
import id.co.arifwidayana.intent.model.Person
import id.co.arifwidayana.intent.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object{
        const val MESSAGE = "MESSAGE"
        const val AGE = "AGE"
        const val BUNDLE = "BUNDLE"
        const val STUDENT = "STUDENT"
        const val ANIMAL = "ANIMAL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        implicitIntent()
        simpleIntent()
        putExtraIntent()
        intentBundle()
        intentSerializable()
        intentParcelable()
    }

    private fun implicitIntent() {
        binding.btnSend.setOnClickListener{
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, binding.etInputMessage.text.toString())
                type = "text/plain"
            }

            if (sendIntent.resolveActivity(packageManager) != null){
                startActivity(sendIntent)
            }
        }
    }

    private fun simpleIntent() {
        binding.btnSecondScreen.setOnClickListener{
            val intentToSecond = Intent(this, SecondScreenActivity::class.java)
            startActivity(intentToSecond)
        }
    }

    private fun putExtraIntent() {
        binding.btnPutData.setOnClickListener{
            val mess = binding.etInputMessage.text.toString()
            val age = binding.etAge.text.toString().toInt()

            val putExtraIntent = Intent(this, SimplePutExtraIntent::class.java).apply{
                putExtra(MESSAGE, mess)
                putExtra(AGE, age)
            }
            startActivity(putExtraIntent)
        }
    }

    private fun intentBundle() {
        binding.btnPutDataBundle.setOnClickListener{
            if (binding.etAge.text.isNotEmpty()){
                val mess = binding.etInputMessage.text.toString()
                val age = binding.etAge.text.toString().toInt()

                val bundleData = Bundle().apply {
                    putString(MESSAGE, mess)
                    putInt(AGE, age)
                }

                val putExtraIntent = Intent(this, BundleIntentActivity::class.java).apply{
                    putExtra(BUNDLE, bundleData)
                }
                startActivity(putExtraIntent)
            } else {
                Toast.makeText(this, "You must Input Age!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun intentSerializable() {
        binding.btnSerializable.setOnClickListener{
            if (binding.etAge.text.isNotEmpty()){
                val student = Person(
                    binding.etInputMessage.text.toString(),
                    binding.etAge.text.toString().toInt(),
                    binding.etNim.text.toString()
                )

                val intentSerialize = Intent(this, SerializableIntentActivity::class.java).apply {
                    putExtra(STUDENT,student)
                }
                startActivity(intentSerialize)
            } else {
                Toast.makeText(this, "You must Input Age!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun intentParcelable() {
        binding.btnParcelable.setOnClickListener{
            if (binding.etLegs.text.isNotEmpty()){
                val setAnimal = Animal(
                    binding.etNameAnimal.text.toString(),
                    binding.etColor.text.toString(),
                    binding.etLegs.text.toString().toInt(),
                    binding.etEnvi.text.toString()
                )

                val intentParcel = Intent(this, ParcelableIntentActivity::class.java).apply {
                    putExtra(ANIMAL,setAnimal)
                }
                startActivity(intentParcel)
            } else {
                Toast.makeText(this, "You must Input Legs!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}