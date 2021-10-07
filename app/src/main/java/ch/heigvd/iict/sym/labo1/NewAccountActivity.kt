package ch.heigvd.iict.sym.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        email = findViewById(R.id.new_account_email)
        password = findViewById(R.id.new_account_password)
        cancelButton = findViewById(R.id.new_account_cancel)
        validateButton = findViewById(R.id.new_account_validate)

        cancelButton.setOnClickListener {
            Utils.resetEditTextFields(listOf(email, password))
        }

        validateButton.setOnClickListener {

            // Validate email and password fields
            if (!Utils.validateEmailAndPassword(email, password, this))
                return@setOnClickListener

            // Build and return result
            val resultIntent = Intent().apply {
                putExtra(NEW_USER, Pair(email.text?.toString(), password.text?.toString()))
            }
            setResult(
                RESULT_OK,
                resultIntent
            ) // TODO : demander au prof si c'est une bonne idée de retourner un intent
            finish()
        }
    }

    companion object {
        private const val TAG = "NewAccountActivity"
        const val NEW_USER = "ch.heigvd.iict.sym.labo1.NEW_USER"
    }
}