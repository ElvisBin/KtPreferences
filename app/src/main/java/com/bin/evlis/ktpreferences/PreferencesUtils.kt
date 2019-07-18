package com.wnhoo.user.utils.prefs

/**
 * Created by Evlis on 2019/7/17.
 * 存取调取
 */
object PreferencesUtils {

    var _phone: String by Preference(PreStatic.PHONE, PreStatic.DEFAULT)

    var _password: String by Preference(PreStatic.PASSW, PreStatic.DEFAULT)
}

/**
 * 静态量存储
 */
class PreStatic private constructor(val value: String) {

    companion object {

        val DEFAULT: String = ""
        //账号
        @JvmField
        val PHONE: String = "phone"
        //密码
        @JvmField
        val PASSW: String = "password"
    }
}