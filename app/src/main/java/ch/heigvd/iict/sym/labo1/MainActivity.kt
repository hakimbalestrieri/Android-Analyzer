package ch.heigvd.iict.sym.labo1

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

/**
 * Main activity class where user can sign in
 * @author Allemann, Balestrieri, Gomes
 */
class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
        const val USER_EMAIL = "ch.heigvd.iict.sym.labo1.USER_EMAIL"
    }

    private val credentials = mutableListOf(
        Pair("user1@heig-vd.ch", "1234"),
        Pair("user2@heig-vd.ch", "abcd")
    )
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cancelButton: Button
    private lateinit var validateButton: Button
    private lateinit var newAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO : factoriser ça ? Si oui, comment ?
        email = findViewById(R.id.new_account_email)
        password = findViewById(R.id.new_account_password)
        cancelButton = findViewById(R.id.new_account_cancel)
        validateButton = findViewById(R.id.new_account_validate)
        newAccount = findViewById(R.id.main_new_account)

        // TODO : factoriser les events ? Si oui, comment ?
        cancelButton.setOnClickListener {
            Utils.resetEditTextFields(listOf(email, password))
        }

        validateButton.setOnClickListener {
            // Validate email and password fields
            if (!Utils.validateEmailAndPassword(email, password, this))
                return@setOnClickListener

            // Get input values
            val emailInput = email.text?.toString()
            val passwordInput = password.text?.toString()

            // Check if user does not exists
            if (!credentials.contains(Pair(emailInput, passwordInput))) {
                // Display an alert
                val builder = AlertDialog.Builder(this)
                builder.setTitle(getString(R.string.main_invalid_user_title))
                builder.setMessage(getString(R.string.main_invalid_user_message))
                builder.setPositiveButton(android.R.string.ok) { _, _ -> }
                builder.show()
            } else {
                // User exists, navigate to user profile activity
                startActivity(
                    Intent(this, UserProfileActivity::class.java).apply {
                        putExtra(USER_EMAIL, emailInput)
                    }
                )
            }
        }

        newAccount.setOnClickListener {
            // Navigate to new account activity with callback function linked
            startForNewUserResult.launch(Intent(this, NewAccountActivity::class.java))
        }
    }

    /**
     * Register for a new user's result and handling it once it is dispatched by the system
     */
    private val startForNewUserResult =
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
}
