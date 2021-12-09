package fr.epsi.projetepsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class StudentsActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)
        showBtnBack()
        setHeaderTitle("Infos")

        val buttonStudentOne:Button = findViewById(R.id.buttonStudentOne)

        buttonStudentOne.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,StudentActivity::class.java)
            startActivity(newIntent)
        })

    }
}