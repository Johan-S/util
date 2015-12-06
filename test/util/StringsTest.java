/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.junit.Test;
import static org.junit.Assert.*;


public class StringsTest {
  /**
   * Test of toHex method, of class Strings.
   */
  @Test
  public void testToHex() {
    byte[] in = {(byte)0x01,(byte)0x23, (byte)0x45, (byte)0x67, (byte)0x89, (byte)0xab, (byte)0xcd, (byte)0xef};
    String out = Strings.toHex(in);
    assertEquals("0123456789abcdef", out);
  }

  /**
   * Test of toQuotedSQLString method, of class Strings.
   */
  @Test
  public void testToQuotedSQLString() {
    String in = "abcd'efgh";
    assertEquals("'abcd''efgh'", Strings.toQuotedSQLString(in));
  }
  
}
