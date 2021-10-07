package ch.heigvd.iict.sym.labo1

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

/**
 * Main activity class where user can sign in
 * @author Allemann, Balestrieri, Gomes
 */
class MainActivity : UserPasswordActivity() {
    private val credentials = mutableListOf(
        Pair("user1@heig-vd.ch", "1234"),
        Pair("user2@heig-vd.ch", "abcd")
    )
    private lateinit var newAccount: TextView

    // Register for a new user's result and handling it once it is dispatched by the system
    private val startForNewUserResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent: Intent? = result.data
                if (intent != null) {
                    credentials.add(
                        0,
                        intent.getSerializableExtra(NewAccountActivity.NEW_USER) as Pair<String, String>
                    )
                    // We don't assert that the user doest not already exists...
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newAccount = findViewById(R.id.main_new_account)

        newAccount.setOnClickListener {
            // Navigate to new account activity with callback function linked
            startForNewUserResult.launch(Intent(this, NewAccountActivity::class.java))
        }
    }

    override fun setContentView() {
        setContentView(R.layout.activity_main)
    }

    override fun onSubmit(email: String, password: String) {
        // Check if user does not exists
        if (!credentials.contains(Pair(email, password))) {
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
                    putExtra(USER_EMAIL, email)
                }
            )
        }
    }

    companion object {
        const val USER_EMAIL = "ch.heigvd.iict.sym.labo1.USER_EMAIL"
    }
}
