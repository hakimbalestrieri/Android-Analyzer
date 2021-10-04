package ch.heigvd.iict.sym.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class NewAccountActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cancelButton: Button
    private lateinit var validateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.main_email)
        password = findViewById(R.id.main_password)
        cancelButton = findViewById(R.id.main_cancel)
        validateButton = findViewById(R.id.main_validate)

        cancelButton.setOnClickListener {
            email.text?.clear()
            password.text?.clear()
            email.error = null
            password.error = null
        }

        validateButton.setOnClickListener {
            email.error = null
            password.error = null

            val emailInput = email.text?.toString()
            val passwordInput = password.text?.toString()

            if(emailInput.isNullOrEmpty() or passwordInput.isNullOrEmpty()) {
                if(emailInput.isNullOrEmpty())
                    email.error = getString(R.string.main_mandatory_field)
                if(passwordInput.isNullOrEmpty())
                    password.error = getString(R.string.main_mandatory_field)
                return@setOnClickListener
            }

        }
    }
}