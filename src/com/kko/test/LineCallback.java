package com.kko.test;

public interface LineCallback<T> {
	T doSomethingWithLine(String line, T value);
}
