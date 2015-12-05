/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Johan Strååt
 */
public class ParsingTest {
  private static final 
    String[] hexes = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
      "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F"};
  
  @Test
  public void testParseLongHex() {
    for (int i = 0; i < hexes.length; ++i)
      assertEquals(i, Parsing.parseLongHex(hexes[i], 0, hexes[i].length()));
  }
  @Test
  public void testLongToHex() {
    for (int i = 0; i < hexes.length; ++i)
      assertEquals(hexes[i], Parsing.toHexString(i));
  }
  @Test
  public void testLongToHexToLong() {
    long b = 11;
    for (int i = 0; i < 60; ++i) {
      b *= 5;
      assertEquals(b, Parsing.parseLongHex(Parsing.toHexString(b)));
    }
  }
}
