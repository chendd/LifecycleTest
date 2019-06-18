package com.longe9.google.lifecycle;

@FunctionalInterface
public interface Action1<T> extends IAction {
    void call(T params);
}
