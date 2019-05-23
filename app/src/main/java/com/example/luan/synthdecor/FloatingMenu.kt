package com.example.luan.synthdecor

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast

class FloatingMenu : AppCompatActivity() {

    private var fab_main: FloatingActionButton? = null
    private var fab1_mail: FloatingActionButton? = null
    private var fab2_share: FloatingActionButton? = null
    private var fab_open: Animation? = null
    private var fab_close: Animation? = null
    private var fab_clock: Animation? = null
    private var fab_anticlock: Animation? = null
    private lateinit var textview_mail: TextView
    private lateinit var textview_share: TextView

    private var isOpen: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fab)

        fab_main = findViewById(R.id.fab1)
        fab1_mail = findViewById(R.id.fab1)
        fab2_share = findViewById(R.id.fab2)
        fab_close = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_close)
        fab_open = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_open)
        fab_clock = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_rotate_clock)
        fab_anticlock = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_rotate_antilock)

        textview_mail = findViewById<TextView>(R.id.textview_mail)
        textview_share = findViewById<TextView>(R.id.textview_share)

        fab_main!!.setOnClickListener {
            if (isOpen!!) {

                textview_mail.visibility = View.INVISIBLE
                textview_share.visibility = View.INVISIBLE
                fab2_share!!.startAnimation(fab_close)
                fab1_mail!!.startAnimation(fab_close)
                fab_main!!.startAnimation(fab_anticlock)
                fab2_share!!.isClickable = false
                fab1_mail!!.isClickable = false
                isOpen = false
            } else {
                textview_mail.visibility = View.VISIBLE
                textview_share.visibility = View.VISIBLE
                fab2_share!!.startAnimation(fab_open)
                fab1_mail!!.startAnimation(fab_open)
                fab_main!!.startAnimation(fab_clock)
                fab2_share!!.isClickable = true
                fab1_mail!!.isClickable = true
                isOpen = true
            }
        }

        fab2_share!!.setOnClickListener { Toast.makeText(applicationContext, "Share", Toast.LENGTH_SHORT).show() }

        fab1_mail!!.setOnClickListener { Toast.makeText(applicationContext, "Email", Toast.LENGTH_SHORT).show() }


    }
}