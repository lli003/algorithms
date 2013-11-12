package cc150.chapter19;

import org.junit.Test;

public class TestSwapTwoNumbers {

  @Test
  public void testSwap() {
    int a = 10000, b = 2;
    SwapTwoNumbers st = new SwapTwoNumbers();
    st.swap(a, b);
    st.swap2(a, b);
  }

}
