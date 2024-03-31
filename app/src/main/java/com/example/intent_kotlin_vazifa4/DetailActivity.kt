package com.example.intent_kotlin_vazifa4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.intent_kotlin_vazifa4.user.Member

class DetailActivity: AppCompatActivity() {
    val TAG = DetailActivity::class.java.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }

    fun initViews(){
        var tv_exit = findViewById<Button>(R.id.tv_exit)
        tv_exit.setOnClickListener {
            var member = Member("Davlat",19)
            backToFinish(member)
        }
        var tv_detail = findViewById<TextView>(R.id.tv_detail)

        var user = intent.getSerializableExtra("user")
        Log.d(TAG, user.toString())

        tv_detail.text = user.toString()
    }

    fun backToFinish(member: Member){
        var returnIntent = Intent()
        returnIntent.putExtra("member",member.toString())
        setResult(RESULT_OK, returnIntent)

        finish()

    }
}