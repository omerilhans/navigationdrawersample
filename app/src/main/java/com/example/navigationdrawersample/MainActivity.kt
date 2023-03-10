package com.example.navigationdrawersample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navigationdrawersample.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.drawerLayout.menuConfigure(binding.toolbar, binding.constraint)

        val tvName = binding.navigationView.findNavViewById<TextView>(R.id.tv_name)
        tvName?.setOnClickListener {
            Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show()
        }

        val tvLogout = binding.navigationView.findNavViewById<TextView>(R.id.tv_logout)
        tvLogout?.setOnClickListener {
            Toast.makeText(this, "Hi!", Toast.LENGTH_SHORT).show()
        }
    }

    fun DrawerLayout.menuConfigure(
        toolbar: Toolbar?, constraintLayout: ConstraintLayout?
    ): ActionBarDrawerToggle {
        setScrimColor(Color.TRANSPARENT)
        drawerElevation = 0f

        val toggle = object : ActionBarDrawerToggle(
            this@MainActivity,
            this,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
//                val slideX = drawerView.width * slideOffset
//                constraintLayout?.translationX = slideX
            }
        }
        setScrimColor(Color.TRANSPARENT)
        drawerElevation = 0f

        addDrawerListener(toggle)
        toggle.drawerArrowDrawable.color = Color.BLUE
        toggle.syncState()

        return toggle
    }

    fun <V : View> NavigationView.findNavViewById(@IdRes id: Int): V? {
        val navigationLayout = getChildAt(0)
        val navigationLayout1 = getChildAt(1)
        var view: V? = navigationLayout.findViewById(id)
        if (view == null) view = navigationLayout1.findViewById(id)
        return view
    }

}