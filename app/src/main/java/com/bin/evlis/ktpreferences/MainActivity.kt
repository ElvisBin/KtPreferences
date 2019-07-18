package com.bin.evlis.ktpreferences

import android.annotation.SuppressLint
import android.content.ContextWrapper
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wnhoo.user.utils.prefs.PreferencesUtils
import kotlinx.android.synthetic.main.activity_main.*

//外部全局调用
@SuppressLint("StaticFieldLeak")
private lateinit var INAPPLICATION: AppCompatActivity

object AppContext : ContextWrapper(INAPPLICATION)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        INAPPLICATION = this

        showContent()

        bt_save.setOnClickListener {
            PreferencesUtils._phone = et_name.text.toString()
            PreferencesUtils._password = et_name.text.toString()
            showContent()
        }
    }

    /**
     * 显示内容
     */
    private fun showContent() {
        show_content_name.text = "账号:"+ PreferencesUtils._phone
        show_content_pass.text = "密码:"+ PreferencesUtils._password
        et_name.hint = PreferencesUtils._phone
        et_pass.hint = PreferencesUtils._password
    }
}
