package util;

import org.junit.Test;
import static org.junit.Assert.*;


public class KMPTest {
  
  public KMPTest() {
  }

  /**
   * Test of step method, of class KMP.
   */
  @Test
  public void testStep() {
    byte[] vals = new byte[]{1, 2, 3, 1, 2, 1, 2, 3, 1, 2, 3};
    int[] expected = new int[]{-1, 0, 0, 0, 1, 2, 1, 2, 3, 4, 5, 3};
    int[] actual = new int[expected.length];
    actual[0] = -1;
    KMP k = new KMP(vals);
    for (int i = 0; i < vals.length; ++i)
      actual[i + 1] = k.step(vals[i], actual[i]);
    assertArrayEquals(expected, actual);
  }
  
}
