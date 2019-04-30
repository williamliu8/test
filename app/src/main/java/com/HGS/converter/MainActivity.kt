package com.HGS.converter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val temperatureFragment = TemperatureFragment()
    val volumeFragment = VolumeFragment()
    val weightFragment = WeightFragment()
    val currencyFragment = CurrencyFragment()

    val fragments = mapOf(R.id.temperature to temperatureFragment,
                         R.id.volume to volumeFragment,
                         R.id.weight to weightFragment,
                         R.id.currency to currencyFragment
                        )

    var activeFragment: Fragment = temperatureFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.content, temperatureFragment)
            .add(R.id.content, volumeFragment).hide(volumeFragment)
            .add(R.id.content, weightFragment).hide(weightFragment)
            .add(R.id.content, currencyFragment).hide(currencyFragment)
            .commit()

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            val fragmentToDisplayOnTheScreen = fragments[menuItem.itemId]!!
            supportFragmentManager.beginTransaction()
                .hide(activeFragment)
                .show(fragmentToDisplayOnTheScreen)
                .commit()
            activeFragment = fragmentToDisplayOnTheScreen
            true
        }
    }
}
