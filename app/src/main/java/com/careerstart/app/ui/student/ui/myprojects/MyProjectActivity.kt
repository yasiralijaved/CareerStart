package com.careerstart.app.ui.student.ui.myprojects

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.careerstart.app.R
import com.careerstart.app.utils.CircleTransform
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_my_project.*


class MyProjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_project)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Share it with Social Media", Snackbar.LENGTH_LONG)
                .setAction("Share Now", null).show()
        }

        val ivBanner = findViewById<ImageView>(R.id.iv_banner)

        Picasso.get().load("file:///android_asset/robotics.jpg").into(ivBanner)

        toolbar_layout.isTitleEnabled = true
        toolbar_layout.title = "BetterComm"


        val path = "file:///android_asset/haseeb.jpg"
        val path2 = "file:///android_asset/robotics.jpg"

        val pic1 = findViewById<ImageView>(R.id.iv_profile_pic_1)
        Picasso.get().load(path).transform(CircleTransform())
            .into(pic1)

        val pic2 = findViewById<ImageView>(R.id.iv_profile_pic_2)
        Picasso.get().load(path2).transform(CircleTransform())
            .into(pic2)

        val pic3 = findViewById<ImageView>(R.id.iv_profile_pic_3)
        Picasso.get().load(path).transform(CircleTransform())
            .into(pic3)

        val pic4 = findViewById<ImageView>(R.id.iv_profile_pic_4)
        Picasso.get().load(path2).transform(CircleTransform())
            .into(pic4)

    }
}
