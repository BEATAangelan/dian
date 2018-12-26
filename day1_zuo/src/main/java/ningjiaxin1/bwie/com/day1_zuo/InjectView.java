package ningjiaxin1.bwie.com.day1_zuo;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;

public class InjectView {
    public static void binf(Object object){
        try {
            parse(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parse(Object object) throws Exception {
        Class<?> aClass = object.getClass();
        View view=null;
        Field[] fields=aClass.getDeclaredFields();
        for (Field field:fields) {
            if (field.isAnnotationPresent(InjectViewAnnotion.class)){
                InjectViewAnnotion annotation = field.getAnnotation(InjectViewAnnotion.class);
                int value = annotation.value();
                if (value<0){
                    throw new Exception("error");
                }else {
                    field.setAccessible(true);
                    if (object instanceof  View){
                        view=((View)object).findViewById(value);
                    }else if (object instanceof Activity){
                        view=((Activity)object).findViewById(value);
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("TAG","哇咔咔");
                            }
                        });
                    }
                    field.set(object,view);
                }

            }
        }
    }
}
