package com.natrix.blogapi.BlogApiApplication.utils;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Builder<T>{

    private final T instance;

    private Builder(T instance){
        this.instance = instance;
    }

    public static <T> Builder<T> of(Supplier<T> supplier){
        return new Builder<>(supplier.get());
    }

    public <U> Builder<T> with(U value, BiConsumer<T, U> consumer){
        consumer.accept(instance,value);
        return this;
    }

    public T build(){
        return instance;
    }
}
