package com.example.usedtrade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.usedtrade.chatlist.ChatListFragment
import com.example.usedtrade.databinding.ActivityMainBinding
import com.example.usedtrade.home.HomeFragment
import com.example.usedtrade.mypage.MyPageFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val homeFragment =HomeFragment()
        val chatListFragment = ChatListFragment()
        val myPage = MyPageFragment()

        replaceFragment(homeFragment)
        binding.bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.home->{replaceFragment(homeFragment)}
                R.id.chatList->{replaceFragment(chatListFragment)}
                R.id.myPage->{replaceFragment(myPage)}

            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }
}