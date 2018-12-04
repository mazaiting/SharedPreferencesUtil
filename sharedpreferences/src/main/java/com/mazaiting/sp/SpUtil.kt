package com.mazaiting.sp

import android.content.Context
import android.content.SharedPreferences

/**
 * SharedPreferences工具类
 * 单例工具类
 */
class SpUtil private constructor() {
  
  companion object {
    /** 单例 */
    val instance: SpUtil by lazy { SpUtil() }
    /** 文件名 */
    private const val FILE_NAME = "sp_util"
  }
  
  /** 懒加载数据管理对象 */
  private var sPreferences: SharedPreferences? = null
  
  /**
   * 初始化SharedPreferences
   * @param context 上下文
   * @param fileName 文件名
   */
  fun initialize(context: Context, fileName: String) {
    sPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
  }
  
  /**
   * 获取SharedPreferences对象
   * @param context 上下文
   * @return 获取SharedPreferences对象
   */
  private fun getSharedPreferences(context: Context): SharedPreferences =
          sPreferences ?: context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
  
  /**
   * 存入数据
   * @param context 上下文
   * @param key 键
   * @param value 值
   */
  fun put(context: Context, key: String, value: Any) {
    // 获取编辑器
    val editor: SharedPreferences.Editor = getSharedPreferences(context).edit()
    // 判断类型并存入
    when (value) {
      is String -> editor.putString(key, value)
      is Int -> editor.putInt(key, value)
      is Boolean -> editor.putBoolean(key, value)
      is Float -> editor.putFloat(key, value)
      is Long -> editor.putLong(key, value)
      else -> editor.putString(key, value.toString())
    }
    // 提交
    editor.apply()
  }
  
  /**
   * 根据键获取值
   * @param context 上下文
   * @param key 键
   * @param defaultValue 默认值
   * @return 返回对应键的值
   */
  fun getString(context: Context, key: String, defaultValue: String = ""): String? {
    return getSharedPreferences(context).getString(key, defaultValue)
  }
  
  /**
   * 根据键获取值
   * @param context 上下文
   * @param key 键
   * @param defaultValue 默认值
   * @return 返回对应键的值
   */
  fun getBoolean(context: Context, key: String, defaultValue: Boolean = false): Boolean {
    return getSharedPreferences(context).getBoolean(key, defaultValue)
  }
  
  /**
   * 根据键获取值
   * @param context 上下文
   * @param key 键
   * @param defaultValue 默认值
   * @return 返回对应键的值
   */
  fun getInt(context: Context, key: String, defaultValue: Int = 0): Int {
    return getSharedPreferences(context).getInt(key, defaultValue)
  }
  
  /**
   * 根据键获取值
   * @param context 上下文
   * @param key 键
   * @param defaultValue 默认值
   * @return 返回对应键的值
   */
  fun getLong(context: Context, key: String, defaultValue: Long = 0L): Long {
    return getSharedPreferences(context).getLong(key, defaultValue)
  }
  
  /**
   * 移除键
   * @param context 上下文
   * @param key 键
   */
  fun remove(context: Context, key: String) {
    getSharedPreferences(context).edit().remove(key).apply()
  }
  
  /**
   * 判断是否包含键
   * @param context 键
   * @param key 键
   * @return true: 包含; false: 不包含
   */
  fun contains(context: Context, key: String): Boolean {
    return getSharedPreferences(context).contains(key)
  }
}