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
 dependencies { implementation 'com.github.userZhaolei:CircularArcProgressDemo:Tag'}
```
