package mx.edu.potros.examen_00000216629

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textCelcius: TextView = findViewById(R.id.etC)
        val textFarenheit: TextView = findViewById(R.id.etF)
        val celsiusButton: Button = findViewById(R.id.btnGC)
        val farenheitButton: Button = findViewById(R.id.btnGF)



        celsiusButton.setOnClickListener {
            var gradosF: Double = 0.0
            var gradosC: Double = 0.0
            try {
                gradosF = textFarenheit.text.toString().toDouble()
                gradosC = convertirGradosCelsius(gradosF)
                val formatNumber1 = "%.1f".format(gradosC)
                textCelcius.text = formatNumber1
            } catch (e: Exception){
                textCelcius.text = "Solamente valores numericos"
            }

        }

        farenheitButton.setOnClickListener {
            var gradosF: Double = 0.0
            var gradosC: Double = 0.0
            try {
                gradosC = textCelcius.text.toString().toDouble()
                gradosF = convertirGradosFarenheit(gradosC)
                val formatNumber2 = "%.1f".format(gradosF)
                textFarenheit.text = formatNumber2
            } catch(e: Exception){
                textFarenheit.text = "Solamente valores numericos"
            }

        }
    }

    fun convertirGradosCelsius(grados: Double): Double {
        return ((grados-32)/1.8)
    }

    fun convertirGradosFarenheit(grados: Double): Double {
        return ((grados*1.8)+32)
    }
}