package com.wnhoo.user.utils.prefs

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import com.bin.evlis.ktpreferences.AppContext
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Evlis on 2019/7/17.
 * Preferences 扩展 -属性代理
 * @param name 传入的键
 * @param default 默认值
 * @param flieName 文件名
 */

class Preference<T>(val key:String, val default: T, val flieName : String = "default") :ReadWriteProperty<Any?,T>{

    //初始化
    private val  prefs by lazy {
        AppContext.getSharedPreferences(flieName,Context.MODE_PRIVATE)
    }
    //获取当前值
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
      return  getPrrefs(key)
    }

   private fun getPrrefs(key: String):T{
     return  when(default){
           is String   -> prefs.getString(key,default)
           is Boolean   -> prefs.getBoolean(key,default)
           is Int   -> prefs.getInt(key,default)
           is Long   -> prefs.getLong(key,default)
           else -> throw IllegalArgumentException("不支持的类型")
       } as T
   }
    //设置当前值
    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPrefs(key,value)
    }

    private fun putPrefs(key:String, value:T){
        with(prefs.edit()){
            when(value){
                is String   -> putString(key,value)
                is Boolean   -> putBoolean(key,value)
                is Float   -> putFloat(key,value)
                is Int   -> putInt(key,value)
                is Long   -> putLong(key,value)
                else -> throw IllegalArgumentException("不支持的类型")
            }.apply()
        }
    }
}
