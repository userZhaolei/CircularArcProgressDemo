## CircularArcProgress 自定义圆形进度条！！

### APIs:
|Method|Description|
|------|-----------|
|setProgress(int progress)|更新进度|
|setProgressWidth(int width)|设置进度条宽度 (单位: dp)|
|setProgressFrontColor(int color)|设置进度颜色|
|setProgressBehindColor(int color)|设置进度条背景颜色|
|setTextColor(int textColor)|设置文字颜色|
|addCircularArcProgressViewListener(CircularArcProgressViewListener listener)|设置进度条完成监听|


### 使用示例：
```java
        progress_circular = findViewById(R.id.progress_circular);
        progress_circular.setTextColor(Color.BLACK); //设置文字颜色
        progress_circular.setProgress(100);//设置进度
```
```java
    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <com.zl.circulararcprogress.CircularArcProgressView
        android:id="@+id/progress_circular"
        android:layout_width="300dp"
        app:frontColor="@color/colorPrimaryDark"
        app:textColor="#fff"
        android:layout_height="wrap_content">
    </com.zl.circulararcprogress.CircularArcProgressView>

</RelativeLayout>


```

#### 添加依赖：
```
allprojects {
    	repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```
 dependencies {  implementation 'com.github.userZhaolei:CircularArcProgressDemo:v1.0.0'}
```
### 效果：
![preview](https://github.com/userZhaolei/CircularArcProgressDemo/blob/master/image/image1.png) 
![preview](https://github.com/userZhaolei/CircularArcProgressDemo/blob/master/image/image2.jpg)
