package ch.heigvd.iict.sym.labo1

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

/**
 * Main activity class where user can sign in
 * @author Allemann, Balestrieri, Gomes
 */
class MainActivity : AppCompatActivity() {
    private val credentials = mutableListOf(
        Pair("user1@heig-vd.ch", "1234"),
        Pair("user2@heig-vd.ch", "abcd")
    )
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cancelButton: Button
    private lateinit var validateButton: Button
    private lateinit var newAccount: TextView
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent: Intent? = result.data
                if (intent != null) {
                    credentials.add(
                        0,
                        intent.getSerializableExtra(NewAccountActivity.NEW_USER) as Pair<String, String>
                    )
                    // TODO : demander si on doit vérifier que le user existe pas déjà
                    // TODO : c'est bien de caster comme ca le result et la paire ?
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fields mapping

        email = findViewById(R.id.main_email)
        password = findViewById(R.id.main_password)
        cancelButton = findViewById(R.id.main_cancel)
        validateButton = findViewById(R.id.main_validate)
        newAccount = findViewById(R.id.main_new_account)

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
                Log.d(TAG, "Au moins un des deux champs est vide")
                if (emailInput.isNullOrEmpty())
                    email.error = getString(R.string.main_mandatory_field)
                if (passwordInput.isNullOrEmpty())
                    password.error = getString(R.string.main_mandatory_field)
                return@setOnClickListener
            } else {
                // Email format validation
                if (!emailInput!!.contains("@")) { // TODO : !! bonne idée ?
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.main_invalid_email),
                        Toast.LENGTH_LONG
                    ).show()
                } // Check if user does not exists
                else if (!credentials.contains(Pair(emailInput, passwordInput))) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle(getString(R.string.main_invalid_user_title))
                    builder.setMessage(getString(R.string.main_invalid_user_message))
                    builder.setPositiveButton(android.R.string.ok) { _, _ -> }
                    builder.show()
                } // User exists, navigate to profile activity
                else {
                    val intent = Intent(this, UserProfileActivity::class.java).apply {
                        putExtra(USER_EMAIL, emailInput)
                    }
                    startActivity(intent)
                }
            }
        }

        newAccount.setOnClickListener {
            startForResult.launch(Intent(this, NewAccountActivity::class.java))
        }
    }

    companion object {
        private const val TAG = "MainActivity"
        const val USER_EMAIL = "ch.heigvd.iict.sym.labo1.USER_EMAIL"
    }
}
