package com.kko.test2;

import java.io.IOException;

public interface LineCallback {
	Integer doSomethingWithLine(String line, Integer value) throws IOException;
}
