# KtPreferences
对Preferences进行分装，提取  
## 实现逻辑  
由于Kotlin支持代理，特此将Preferences用类代理的方式实现，以变量的方式，使调用更加简单方便，再也不用写一堆多余的代码。

## 版本说明
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)

- **项目地址：** [https://github.com/ElvisBin/KtPreference](https://github.com/ElvisBin/KtPreferences.git)

## 使用步骤
1. 将PreferencesExt.Kt和PreferencesUtils.Kt文件拷贝过来
2. 向PreferencesUtils.Kt 提供一个Context对象
3. 在PreferencesExt.Kt文件增加属性，字段
4. 形如：PreferencesUtils._phone进行存取  

## 感谢





