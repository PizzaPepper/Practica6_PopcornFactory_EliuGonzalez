package eliu.gonzalez.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import kotlinx.android.synthetic.main.activity_form_movie.view.*

class FormMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_movie)

        val bundle = intent.extras

        var nameText: EditText = findViewById(R.id.name)
        var spin: Spinner = findViewById(R.id.payment)
        var ns: EditText = findViewById(R.id.numberseat)
        var confirmButton: Button = findViewById(R.id.confirm_seat)
        var listSeats: ArrayList<Client>? = null
        var movies:ArrayList<Pelicula>? = null

        var id: Int = -1
        var nameS: String
        var paymentS: String
        var numberS: Int = -1

        if (bundle != null) {
            numberS = bundle.getInt("numberseat")
            id = bundle.getInt("id")
            listSeats = bundle.get("seatslist") as ArrayList<Client>
            movies= bundle.get("movies") as ArrayList<Pelicula>?
        }

        ns.setText(numberS.toString())
        ArrayAdapter.createFromResource(
            this,
            R.array.payment_type,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spin.adapter = adapter
        }


        confirmButton.setOnClickListener {
            nameS = nameText.text.toString()
            paymentS = spin.selectedItem.toString()
            listSeats?.add(Client(nameS, paymentS, numberS))

            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)

            intent.putParcelableArrayListExtra("seatslist", listSeats)
            intent.putExtra("id", id)
            intent.putParcelableArrayListExtra("movies",movies)
            this.startActivity(intent)

            Toast.makeText(this, "Enjoy the movie :D", Toast.LENGTH_LONG).show()
        }


    }
}