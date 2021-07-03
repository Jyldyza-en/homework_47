package kg.tutorialapp.homework_47

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class Receiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Toast.makeText(context, "Новое сообщение: " + intent.getStringExtra("kg.tutorialapp.broadcast.MESSAGE"), Toast.LENGTH_LONG).show()
    }

}