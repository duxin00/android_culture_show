package com.google.codelabs.mdc.kotlin.shrine

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.text.Editable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.shr_login_fragment.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import kotlinx.android.synthetic.main.culture_list.view.*

class CultureListFragment : Fragment() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        button = findViewById(R.id.button_jie_qi)
//        button.setOnClickListener {
//            // 执行跳转逻辑
//            val intent = Intent(this, ProductGridFragment::class.java)
//            startActivity(intent)
//        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.culture_list, container, false)
        view.button_jie_qi.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.animator.fade_in)
                .setExitAnim(R.animator.fade_out)
                .build()
            (activity as NavigationHost).navigateTo(ProductGridFragment(), true) // Navigate to the next Fragment
//                val intent = Intent(activity, CultureListFragment::class.java)
//                startActivity(intent)
        }
        return view
    }

}


//class CultureListFragment : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.culture_list)
//
//        val button = findViewById<Button>(R.id.button_jie_qi)
//        button.setOnClickListener {
//            val intent = Intent(this, ProductGridFragment::class.java)
//            startActivity(intent)
//        }
//    }
//}