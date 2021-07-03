package kg.tutorialapp.homework_47


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val myAction = "kg.tutorialapp.action.MESSAGE"
    private val alarmMessage = "Hello world!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { sendMessage() }

    }

    private fun sendMessage() {
        val intent = Intent()
        intent.action = myAction
        intent.putExtra("kg.tutorialapp.broadcast.MESSAGE", alarmMessage)
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        sendBroadcast(intent)
    }

}