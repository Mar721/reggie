package com.example.reggie.common;

//将从session中读出employeeId，放入threadLocal的变量空间中，在MyMetaObjectHandler中读出来
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
