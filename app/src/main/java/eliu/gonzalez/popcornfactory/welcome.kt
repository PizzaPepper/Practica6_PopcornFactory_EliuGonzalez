package eliu.gonzalez.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var menu: Button= findViewById(R.id.welcome_button) as Button

        menu.setOnClickListener {
            var intent: Intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}