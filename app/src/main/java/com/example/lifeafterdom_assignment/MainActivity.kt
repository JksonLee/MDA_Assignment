package com.example.lifeafterdom_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lifeafterdom_assignment.data.Agents
import com.example.lifeafterdom_assignment.data.Favoreds
import com.example.lifeafterdom_assignment.data.Rooms
import com.example.lifeafterdom_assignment.data.Users
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Auto Inset Data when run the code
        dbRef = FirebaseDatabase.getInstance().getReference("Agents")
        val agent = Agents(1, "John", "0123456798", "Male")
        dbRef.child(agent.agentID.toString()).setValue(agent)
            .addOnCompleteListener {
                Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error ${it.toString()}", Toast.LENGTH_LONG).show()
            }

        dbRef = FirebaseDatabase.getInstance().getReference("Favoreds")
        val favored = Favoreds(1, 1, 1)
        dbRef.child(favored.favoredID.toString()).setValue(favored)
            .addOnCompleteListener {
                Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error ${it.toString()}", Toast.LENGTH_LONG).show()
            }

        dbRef = FirebaseDatabase.getInstance().getReference("Rooms")
        val room = Rooms(1, "PV10", "Setapak, 50200 Kuala Lumpur", 440.50, "single","Is a single room", "Male", 1)
        dbRef.child(room.roomID.toString()).setValue(room)
            .addOnCompleteListener {
                Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error ${it.toString()}", Toast.LENGTH_LONG).show()
            }

        dbRef = FirebaseDatabase.getInstance().getReference("Users")
        val user = Users(1, "JJ", "0101234567", "Male", "Setapak,Kuala Lumpur")
        dbRef.child(user.userID.toString()).setValue(user)
            .addOnCompleteListener {
                Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error ${it.toString()}", Toast.LENGTH_LONG).show()
            }
    }
}