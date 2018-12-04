# SharedPreferencesUtil
SharedPreferences使用工具类

# 使用
- 初始化SharedPreferences
```
// 初始化--如果不写则采用默认文件名
SpUtil.instance.initialize(this, "linghaoyu")
```

- 存入数据
```
SpUtil.instance.put(this, "key", "value")
```

- 读取数据
```
SpUtil.instance.getString(this, "key")
```

- 是否包含数据
```
SpUtil.instance.contains(this, "key")
```

- 移除数据
```
SpUtil.instance.remove(this, "key")
```
