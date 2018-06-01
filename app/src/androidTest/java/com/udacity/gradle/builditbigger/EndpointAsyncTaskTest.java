package com.udacity.gradle.builditbigger;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import android.content.Context;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {

  // create  a signal to know when our task is done.
  final CountDownLatch signal = new CountDownLatch(1);
  Context context;

  @Test
  public void testVerifyJoke() throws InterruptedException {
    assertTrue(true);
   context = InstrumentationRegistry.getContext();
    EndpointsAsyncTask testTask = new EndpointsAsyncTask(context) {
      @Override
      protected void onPostExecute(String result) {
        assertNotNull(result);
        if (!result.isEmpty()) {
          assertFalse(TextUtils.isEmpty(result));
          signal.countDown();
        }
      }
    };
    testTask.execute();
    signal.await();
  }
}
