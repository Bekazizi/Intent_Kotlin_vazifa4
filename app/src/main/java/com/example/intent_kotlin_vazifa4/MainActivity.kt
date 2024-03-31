package com.example.intent_kotlin_vazifa4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent_kotlin_vazifa4.user.User

class MainActivity : AppCompatActivity() {

    lateinit var tv_home: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    var dataLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){member->
        if (member.resultCode == Activity.RESULT_OK){
            val data: Intent? = member.data
            var member1 = data!!.getSerializableExtra("member")
            tv_home.text = member1.toString()
        }
    }


    fun initViews(){
        tv_home = findViewById(R.id.tv_home)
        var b_open_detail = findViewById<Button>(R.id.b_open_detail)
        b_open_detail.setOnClickListener {
            var user = User("Azizbek", 20)
            openDetailActivity(user)
        }
    }

    fun openDetailActivity(user: User){
        var intent = Intent(this, DetailActivity::class.java);
        intent.putExtra("user", user.toString())

        dataLauncher.launch(intent)
    }
}