package fr.epsi.projetepsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStudents:Button = findViewById(R.id.buttonStudents)
        val buttonShop:Button = findViewById(R.id.buttonShop)


        buttonStudents.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,StudentsActivity::class.java)
            startActivity(newIntent)
        })
        buttonShop.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,CategoriesActivity::class.java)
            startActivity(newIntent)
        })
    }
}