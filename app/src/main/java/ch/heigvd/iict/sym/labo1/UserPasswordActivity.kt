package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Abstract activity class where user can enter an email and a password
 * @author Allemann, Balestrieri, Gomes
 */
abstract class UserPasswordActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cancelButton: Button
    private lateinit var validateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()

        // Fields mapping
        email = findViewById(R.id.main_email)
        password = findViewById(R.id.main_password)
        cancelButton = findViewById(R.id.main_cancel)
        validateButton = findViewById(R.id.main_validate)

        // Event definitions
        cancelButton.setOnClickListener {
            email.text?.clear()
            password.text?.clear()
            email.error = null
            password.error = null
        }

        validateButton.setOnClickListener {
            // Reset error states
            email.error = null
            password.error = null

            // Get input values
            val emailInput = email.text?.toString()!! // TODO : !! bonne idée ?
            val passwordInput = password.text?.toString()!!

            if (emailInput.isNullOrEmpty() or passwordInput.isNullOrEmpty()) {
                if (emailInput.isNullOrEmpty())
                    email.error = getString(R.string.main_mandatory_field)
                if (passwordInput.isNullOrEmpty())
                    password.error = getString(R.string.main_mandatory_field)
                return@setOnClickListener
            } else if (!emailInput.contains("@")) {
                Toast.makeText(
                    this,
                    getString(R.string.main_invalid_email),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                onSubmit(emailInput, passwordInput)
            }
        }
    }

    /**
     * Set the content view with a XML layout file
     */
    abstract fun setContentView()

    /**
     * Action performed when fields are valid
     * @param email entered by user
     * @param password entered by user
     */
    abstract fun onSubmit(email: String, password: String)
}