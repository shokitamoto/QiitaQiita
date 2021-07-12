package com.example.sho.qiitaqiita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.menu_all -> Page1Fragment()
                R.id.menu_favorite -> Page1Fragment()
                else -> null
            }
            fragment ?: return@setOnNavigationItemSelectedListener false

            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    fragment,
                    Page1Fragment.TAG
                )
                .commit()
            return@setOnNavigationItemSelectedListener true
        }

    }
}
