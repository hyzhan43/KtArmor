
[![Release](https://jitpack.io/v/User/Repo.svg)]
(https://jitpack.io/#User/Repo)

# MVP 框架引入

先在 build.gradle(Project:XXXX) 的 repositories 添加:
```java
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
然后在 build.gradle(Module:app) 的 dependencies 添加:
```java
implementation 'com.hyzhan:KtArmor:1.0.0'
```
