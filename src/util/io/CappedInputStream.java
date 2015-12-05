package util.io;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Johan Strååt
 */
public class CappedInputStream extends InputStream {
  private int cap;
  private InputStream stream;
  
  
  public CappedInputStream (InputStream in, int cap) {
    stream = in;
    this.cap = cap;
  }
  
  @Override
  public int read() throws IOException {
    return cap-- <= 0? -1: stream.read();
  }
  
}
