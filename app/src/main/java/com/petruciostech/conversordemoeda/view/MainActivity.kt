package com.petruciostech.conversordemoeda.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.petruciostech.conversordemoeda.R
import com.petruciostech.conversordemoeda.databinding.ActivityMainBinding
import com.petruciostech.conversordemoeda.util.tools.SHARED_BOOLEAN_INITORNOT
import com.petruciostech.conversordemoeda.util.tools.SHARED_PREF_KEY

class MainActivity : AppCompatActivity() {
    private lateinit var bind:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        fragmentReplace(ConvertFragment())
        initComponents()
    }

    private fun initComponents(){
        bind.navigationNavigationmenuMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item_main_fragment -> fragmentReplace(MainFragment())
                R.id.item_convertcurrence_fragment -> fragmentReplace(ConvertFragment())
            }
            true
        }
    }
    private fun fragmentReplace(fragment:Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(bind.containerFragmentswitherFrame.id, fragment)
        fragmentTransaction.commit()

    }
}