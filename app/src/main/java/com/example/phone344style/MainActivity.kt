package com.example.phone344style

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 手机号码格式按照344显示
 * 当手机号嘛11位以1开头并且密码大于等于6的时候登录按钮可点击
 */
class MainActivity : AppCompatActivity(), TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_mobile.addTextChangedListener(this)
        et_pwd.addTextChangedListener(this)
    }

    override fun afterTextChanged(p0: Editable?) {
        btn_login.isEnabled = !TextUtils.isEmpty(et_mobile.text.toString())&&et_mobile.text.toString().length == 13&&!TextUtils.isEmpty(et_pwd.text.toString())&&et_pwd.text.toString().length>=6
        et_mobile.setSelection(et_mobile.text.toString().length)
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        val content = p0.toString()
        if(!et_mobile.isFocused||TextUtils.isEmpty(content)||et_mobile.text.toString().length == 13)
            return
        val mobile = content.replace(" ","")
        if(!TextUtils.isEmpty(mobile)) {
            if(mobile.length == 3) {
                if(content!=mobile) {
                    et_mobile.setText(mobile)
                }
            }else if(mobile.length in 4..7) {
                val showMobile = mobile.substring(0,3)+" "+mobile.substring(3,mobile.length)
                if(p0.toString()!=showMobile) {
                    et_mobile.setText(showMobile)
                }
            }else if(mobile.length>7) {
                val showMobile = mobile.substring(0,3)+" "+mobile.substring(3,7)+" "+mobile.substring(7,mobile.length)
                if(content!=showMobile) {
                    et_mobile.setText(showMobile)
                }
            }
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }
}
