package ch.heigvd.iict.sym.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent

/**
 * Activity class where user can create an account
 * @author Allemann, Balestrieri, Gomes
 */
class NewAccountActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cancelButton: Button
    private lateinit var validateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)

        // Fields mapping

        email = findViewById(R.id.main_email)
        password = findViewById(R.id.main_password)
        cancelButton = findViewById(R.id.main_cancel)
        validateButton = findViewById(R.id.main_validate)

        // Events definitions

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

            // Field verification
            if (emailInput.isNullOrEmpty() or passwordInput.isNullOrEmpty()) {
                if (emailInput.isNullOrEmpty())
                    email.error = getString(R.string.main_mandatory_field)
                if (passwordInput.isNullOrEmpty())
                    password.error = getString(R.string.main_mandatory_field)
                return@setOnClickListener
            }
            else {
                // Email format validation
                if (!emailInput!!.contains("@")) {
                    // Affichage d'un toast
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.main_invalid_email),
                        Toast.LENGTH_LONG
                    ).show()
                } // Valid fields, return new user data
                else {
                    val resultIntent = Intent().apply {
                        putExtra(NEW_USER, Pair(emailInput, passwordInput))
                    }
                    setResult(
                        RESULT_OK,
                        resultIntent
                    ) // TODO : demander au prof si c'est une bonne idée de retourner un intent
                    finish()
                }
            }
        }
    }

    companion object {
        const val NEW_USER = "ch.heigvd.iict.sym.labo1.NEW_USER"
    }
}