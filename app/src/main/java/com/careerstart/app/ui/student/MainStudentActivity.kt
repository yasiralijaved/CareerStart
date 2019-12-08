package com.careerstart.app.ui.student

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.careerstart.app.R
import com.careerstart.app.ui.student.ui.myprojects.MyProjectActivity
import com.careerstart.app.utils.CircleTransform
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import java.io.IOException
import java.io.InputStream


class MainStudentActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_student)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Search in Project List", Snackbar.LENGTH_LONG)
                .setAction("Search Now", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        val headerView = navView.getHeaderView(0)
        val profilePic = headerView.findViewById<ImageView>(R.id.iv_profile_pic)

        try { // get input stream
            val ims: InputStream = assets.open("haseeb.jpg")

            val path = "file:///android_asset/haseeb.jpg"

            // load image as Drawable
            val d =
                Drawable.createFromStream(ims, null)
            // set image to ImageView
            profilePic.setImageDrawable(d)

            Picasso.get().load(path).transform(CircleTransform())
                .into(profilePic)

            ims.close()
        } catch (ex: IOException) {
            return
        }

        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener {
            if(it.itemId == R.id.nav_home) {
                val intent = Intent(this, MyProjectActivity::class.java)
                startActivity(intent)
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_student, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
