package ningjiaxin1.bwie.com.day1_zuo;

import android.support.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectViewAnnotion {
    //这个是干嘛的？？？
    @IdRes int value();
}
