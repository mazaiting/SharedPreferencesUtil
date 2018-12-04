package com.mazaiting.sharedpreferencestest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mazaiting.log.L
import com.mazaiting.sp.SpUtil

class MainActivity : AppCompatActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    // 初始化--如果不写则采用默认文件名
    SpUtil.instance.initialize(this, "linghaoyu")
    // 存入数据
    SpUtil.instance.put(this, "key", "value")
    // 获取数据
    L.d(SpUtil.instance.getString(this, "key"))
    // 判断是否包含数据
    SpUtil.instance.contains(this, "key")
    // 移除数据
    SpUtil.instance.remove(this, "key")
  }
}
