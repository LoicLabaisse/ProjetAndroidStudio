package fr.epsi.projetepsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        showBtnBack()
        setHeaderTitle("Loïc")
    }
}