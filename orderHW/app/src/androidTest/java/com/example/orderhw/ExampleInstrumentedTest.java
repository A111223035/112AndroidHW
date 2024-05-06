<<<<<<<< HEAD:orderHW/app/src/androidTest/java/com/example/orderhw/ExampleInstrumentedTest.java
package com.example.orderhw;
========
package com.example.tickethw;
>>>>>>>> 3ad892ed46a52245ac9d2de1f15a90b953f6b10b:new_ticketHW/app/src/androidTest/java/com/example/tickethw/ExampleInstrumentedTest.java

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
<<<<<<<< HEAD:orderHW/app/src/androidTest/java/com/example/orderhw/ExampleInstrumentedTest.java
        assertEquals("com.example.orderhw", appContext.getPackageName());
========
        assertEquals("com.example.tickethw", appContext.getPackageName());
>>>>>>>> 3ad892ed46a52245ac9d2de1f15a90b953f6b10b:new_ticketHW/app/src/androidTest/java/com/example/tickethw/ExampleInstrumentedTest.java
    }
}