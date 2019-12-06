# 前言
学习了Kotlin有一段时间了, 每次写`项目/Demo`的时候, 总是用到`网络请求`、`MVP`、`MVVM`、`常用工具类`、`通用自定义View`, 索性把这些整合到一起, 搭成一个Android的脚手架——`KtArmor`. 

# 什么是KtArmor ?

`KtArmor` 寓意着 为Android 赋予`战斗装甲`, 方便开发者快速进行Android 开发。节约开发者开发时间。为了满足开发者需求, 我整合了两个分支, 分别对应着 `MVP`, `MVVM`.

- MVP  
  - 架构模式: `MVP` + `Kotlin`  
  - 网络请求: `Retrofit` + `Okhttp` + `Coroutine` + ~~`RxJava`~~    
  - 功能:  
  - `架构模式`: `MVP` + `Kotlin`  
  - `网络请求`: `Retrofit` + `Okhttp` + `Coroutine` + ~~`RxJava`~~    
  - `代码`：简洁优雅, 易扩展
  - `文档`: 有相关的KtArmor-MVP 系列文档说明
  - `插件`：对应 KtArmor-MVP 模板代码生成插件
  - `功能`:  
    - 基本`BaseActivity`、`BaseFragment`、`ToolbarActivity`封装  
    - MVP框架封装 `MvpActivity`、`MvpFragment`、`BasePresenter`、`BaseModel`封装  
    - 网络请求封装 `BaseOkHttpClient`、`BaseRetrofit`、`RetrofitFactory`  
    - 常用控件`PlaceHolderView(占位布局)`， `LoadingView(加载框)`  
    - 常用扩展封装(`SharedPreferences`、`StartActivity`、`Log`、`Toast`(不重复显示))等  
    - MVP代码模板(`Activity`、`Presenter`、`Contract`、`Model`)生成插件  
    - ....

 # MVP框架引入

 先在 build.gradle(Project:XXXX) 的 repositories 添加:
 ```groovy
 allprojects {
     repositories {
         ...
         maven { url "https://jitpack.io" }
     }
 }
 ```
 然后在 build.gradle(Module:app) 的 dependencies 添加:

 ```
 implementation 'com.github.hyzhan43:KtArmor:mvp-1.0.4'  // 根据github 引入最新版本即可
 ```

 # 快速上手
 在Application 中初始化`KtArmor` 框架。新建一个application 类, 如 BaseApplication, 在 BaseApplication 中, 调用KtArmor的 `init` 方法, 进行初始化, 参数如下:
 * 第一个参数是`application`,
 * 第二个参数是对应`RetrofitConfig` 配置。
 ```kotlin
 class BaseApplication: Application(){

     override fun onCreate() {
         super.onCreate()

         // 初始化KtArmor
         KtArmor.init(this, MyRetrofitConfig())
     }
 }
 ```
 再新建一个 RetrofitConfig 配置类, 继承 `BaseRetrofitConfig`. 并复写 `baseUrl` 属性, 添加自己的 baseUrl。


 ```kotlin
 class MyRetrofitConfig : BaseRetrofitConfig() {

     override val baseUrl: String
         get() = API.BASE_URL
 }
 ```
 这样你就创建好了一个拥有`Kotlin` + `Retrofit` + `Okhttp` + `Coroutine`项目了。然后就可以愉快编写自己的业务代码了(●'◡'●)


# 更多用法

## [Kotlin的魔能机甲——KtArmor (一)](https://juejin.im/post/5d319e3651882540be3a2be7)  

## [Kotlin的魔能机甲——KtArmor插件篇（二）](https://juejin.im/post/5d3eb9e7f265da03a31d1072)

## [Kotlin的魔能机甲——KtArmor（三）](https://juejin.im/post/5d4a872e51882575595c40f1)

## [Kotlin的魔能机甲——KtArmor网络调用封装(四)](https://juejin.im/post/5da1a753f265da5b932e6f5b)

## 未完待续


