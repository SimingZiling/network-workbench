package org.yiming.networkworkbench.framework.beans.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {

    // bean名称
    String value() default "";

}
