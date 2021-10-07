package ch.heigvd.iict.sym.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import ch.heigvd.iict.sym.labo1.network.ImageDownloader

/**
 * Activity where user can view his profile
 * @author Allemann, Balestrieri, Gomes
 */
class UserProfileActivity : LogsActivity() {
    private lateinit var email: TextView
    private lateinit var avatar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        email = findViewById(R.id.email)
        email.text = intent.getStringExtra(MainActivity.USER_EMAIL)

        // Loading random avatar image
        avatar = findViewById(R.id.avatar)
        ImageDownloader(avatar, "https://thispersondoesnotexist.com/image").show()
    }

    companion object {
        private const val TAG = "UserProfileActivity"
    }
}