package it.muratdev.robowars

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = FirebaseDatabase.getInstance()
        val dbState = database.getReference("state")


        // Sağ Sol
        findViewById<Button>(R.id.btnRight).setOnClickListener  { view ->
            Snackbar.make(view, "Sağ", Snackbar.LENGTH_LONG).show()
            dbState.setValue("right")
        }
        findViewById<Button>(R.id.btnLeft).setOnClickListener  { view ->
            Snackbar.make(view, "Sol", Snackbar.LENGTH_LONG).show()
            dbState.setValue("left")
        }

        // İleri Geri
        findViewById<Button>(R.id.btnFw).setOnClickListener { view ->
            Snackbar.make(view, "İleri", Snackbar.LENGTH_LONG).show()
            dbState.setValue("forward")
        }
        findViewById<Button>(R.id.btnBw).setOnClickListener  { view ->
            Snackbar.make(view, "Geri", Snackbar.LENGTH_LONG).show()
            dbState.setValue("backward")
        }
        findViewById<Button>(R.id.btnStop).setOnClickListener  { view ->
            Snackbar.make(view, "Dur", Snackbar.LENGTH_LONG).show()
            dbState.setValue("stop")
        }

    }
}