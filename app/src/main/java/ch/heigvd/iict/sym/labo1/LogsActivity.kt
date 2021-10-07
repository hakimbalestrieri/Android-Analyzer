package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class LogsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.println(Log.INFO, this.localClassName, "onCreate")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Log.println(Log.INFO, this.localClassName, "onPostCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.println(Log.INFO, this.localClassName, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.println(Log.INFO, this.localClassName, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.println(Log.INFO, this.localClassName, "onResume")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.println(Log.INFO, this.localClassName, "onPostResume")
    }

    override fun onPause() {
        super.onPause()
        Log.println(Log.INFO, this.localClassName, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.println(Log.INFO, this.localClassName, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.println(Log.INFO, this.localClassName, "onDestroy")
    }
}