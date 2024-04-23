package uz.octo.mobile_android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import uz.octo.feature_movies.presentation.view.bottom_navigation.DownloadFragment
import uz.octo.feature_movies.presentation.view.bottom_navigation.HomeFragment
import uz.octo.feature_movies.presentation.view.bottom_navigation.SupportFragment
import uz.octo.mobile_android.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_homeFragment -> replaceFragment(HomeFragment())
                R.id.bottom_supportFragment -> replaceFragment(SupportFragment())
                R.id.bottom_downloadsFragment -> replaceFragment(DownloadFragment())
                else -> {}


            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
    }
}