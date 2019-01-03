# 效果图  
![效果图](https://img-blog.csdnimg.cn/20190103110303583.gif)  
## 如何使用  
dependencies {  
　`implementation 'com.github.OneGreenHand:CompanyEdittext:v1.0'`   
}  
### 属性说明  
ce_text：文本  
ce_text_color：文本颜色   
### for example  
<com.green.hand.library.CompanyEdittext  
　android:layout_width="match_parent"  
　android:layout_height="wrap_content"  
　android:hint="剩余可提现7500元"  
　android:inputType="number"  
　android:paddingTop="10dp"  
　android:paddingBottom="10dp"  
　app:ce_text="元"  
　app:ce_text_color="#CCCCCC" />