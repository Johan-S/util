/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import static util.Strings.iter;
import static util.Json.*;

public class JsonTest {
  @Test
  public void testParseChar() {
    char expected = parseChar(iter("a"));
    char actual = 'a';
    assertEquals(actual, expected);
    expected = parseChar(iter("\\n"));
    actual = '\n';
    assertEquals(actual, expected);
    expected = parseChar(iter("\\u00C4"));
    actual = 'Ä';
    assertEquals(actual, expected);
  }
  
  @Test
  public void testParseString() {
    Object actual = parseElement(iter("\"hello world!\""));
    String expected = "hello world!";
    assertEquals(expected, actual);
    
    actual = parseElement(iter("\"h\\u00E4llo world!\\n\""));
    expected = "hällo world!\n";
    assertEquals(expected, actual);
    
    actual = parseElement(iter("\"\\\"\\\\\\/\\b\\f\\n\\r\\t\\u0061\""));
    expected = "\"\\/\b\f\n\r\ta";
    assertEquals(expected, actual);
    
    actual = parseElement(iter("\"\\#\""));
    expected = null;
    assertEquals(expected, actual);
    
    actual = parseElement(iter("\"\\"));
    expected = null;
    assertEquals(expected, actual);
    
    actual = parseElement(iter("\""));
    expected = null;
    assertEquals(expected, actual);
  }
  
  @Test
  public void testParseList() {
    Object actual = parseElement(iter("[]"));
    List expected = new ArrayList();
    assertEquals(expected, actual);
    
    actual = parseElement(iter("[\"hello world!\", \"h\\u00E4llo world!\\n\"]"));
    expected = Arrays.asList("hello world!", "hällo world!\n");
    assertEquals(expected, actual);
  }
  @Test
  public void testParseObject() {
    Object actual = parseElement(iter("{}"));
    Map expected = new HashMap();
    assertEquals(expected, actual);
    
    actual = parseElement(iter("{\"Hello\"  : \"World\"}"));
    expected = new HashMap();
    expected.put("Hello", "World");
    assertEquals(expected, actual);
    
    actual = parseElement(iter("{\"Hello\"  : [\"hello world!\", \"h\\u00E4llo world!\\n\"]}"));
    expected = new HashMap();
    expected.put("Hello", Arrays.asList("hello world!", "hällo world!\n"));
    assertEquals(expected, actual);
  }
  
  @Test
  public void testParseNumber() {
    Object actual = parseElement(iter("1234567890"));
    BigDecimal expected = new BigDecimal("1234567890");
    assertEquals(expected, actual);
    
    actual = parseElement(iter("   1234567890   "));
    expected = new BigDecimal("1234567890");
    assertEquals(expected, actual);
    
    actual = parseElement(iter("    1234567890.123456789      "));
    expected = new BigDecimal("1234567890.123456789");
    assertEquals(expected, actual);
    
    actual = parseElement(iter("    1234567890.123456789e-128      "));
    expected = new BigDecimal("1234567890.123456789e-128");
    assertEquals(expected, actual);
    
    actual = parseElement(iter("    1234567890e-128      "));
    expected = new BigDecimal("1234567890e-128");
    assertEquals(expected, actual);
  }
  
}
