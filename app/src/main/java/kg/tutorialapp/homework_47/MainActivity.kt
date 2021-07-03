package kg.tutorialapp.homework_47


import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val myReceiver: BroadcastReceiver = Receiver()

    private val myAction = "kg.tutorialapp.action.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { sendMessage() }

    }

    override fun onStart() {
        super.onStart()

        val filter = IntentFilter("kg.tutorialapp.action.MESSAGE")
        registerReceiver(myReceiver, filter)

        Toast.makeText(applicationContext, "Приёмник включен", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(myReceiver)

        Toast.makeText(applicationContext, "Приёмник выключён", Toast.LENGTH_SHORT).show()
    }

    private fun sendMessage() {
        val editMessage = findViewById<EditText>(R.id.editMessage)
        val message = editMessage.text.toString()

        val intent = Intent()
        intent.action = myAction
        intent.putExtra("kg.tutorialapp.broadcast.MESSAGE", message)
        sendBroadcast(intent)
    }



}