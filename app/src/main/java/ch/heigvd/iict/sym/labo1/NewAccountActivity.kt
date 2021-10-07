package ch.heigvd.iict.sym.labo1

import android.content.Intent

/**
 * Activity class where user can create an account
 * @author Allemann, Balestrieri, Gomes
 */
class NewAccountActivity : UserPasswordActivity() {

    override fun setContentView() {
        setContentView(R.layout.activity_new_account)
    }

    override fun onSubmit(email: String, password: String) {
        // Build and return result
        val resultIntent = Intent().apply {
            putExtra(NEW_USER, Pair(email, password))
        }
        setResult(
            RESULT_OK,
            resultIntent
        ) // TODO : demander au prof si c'est une bonne idée de retourner un intent
        finish()
    }

    companion object {
        const val NEW_USER = "ch.heigvd.iict.sym.labo1.NEW_USER"
    }
}