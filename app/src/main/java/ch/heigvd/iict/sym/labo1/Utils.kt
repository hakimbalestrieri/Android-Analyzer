package ch.heigvd.iict.sym.labo1

import android.content.Context
import android.widget.EditText
import android.widget.Toast

/**
 * Utility class to manage common actions between activities
 * @author Allemann, Balestrieri, Gomes
 */
class Utils {
    companion object {

        /**
         * Check if [email] and [password] fields are valid
         * Fields are valid if there are not null or empty and if the email contains char '@'
         * @param context current application context
         * @return boolean if fields are valid or not
         */
        fun validateEmailAndPassword(
            email: EditText,
            password: EditText,
            context: Context
        ): Boolean {

            // Reset error states
            email.error = null
            password.error = null

            // Get input values
            val emailInput = email.text?.toString()
            val passwordInput = password.text?.toString()

            var isValid = true;
            if (emailInput.isNullOrEmpty() or passwordInput.isNullOrEmpty()) {
                if (emailInput.isNullOrEmpty())
                    email.error = context.getString(R.string.main_mandatory_field)
                if (passwordInput.isNullOrEmpty())
                    password.error = context.getString(R.string.main_mandatory_field)
                isValid = false;
            } else if (!emailInput!!.contains("@")) { // TODO : !! bonne idée ?
                Toast.makeText(
                    context,
                    context.getString(R.string.main_invalid_email),
                    Toast.LENGTH_LONG
                ).show()
                isValid = false;
            }

            return isValid;
        }

        /**
         * Reset EditText fields (clear text and remove errors)
         * @param fields list of EditText fields to reset
         */
        fun resetEditTextFields(fields: List<EditText>) {
            fields.forEach { f: EditText ->
                f.text?.clear()
                f.error = null
            }
        }
    }
}