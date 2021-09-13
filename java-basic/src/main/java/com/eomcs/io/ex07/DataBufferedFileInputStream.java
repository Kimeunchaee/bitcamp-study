package com.eomcs.io.ex07;

//DataBufferedFileInputStream 과 DataBufferedFileOutputStream 은 BufferedFileInputStream을 상속받는다
//상속으로 기능을 확장할때 문제점
//기능을 임의로 넣었다 뺐다가 선택적으로 구현할 수 없다

public class DataBufferedFileInputStream extends BufferedFileInputStream {

  public DataBufferedFileInputStream(String filename) throws Exception {
    super(filename);
  }

  public String readUTF() throws Exception {
    // 상속 받은 read() 메서드를 사용하여 문자열 출력
    int size = this.read();
    byte[] bytes = new byte[size];
    this.read(bytes); // 이름 배열 개수 만큼 바이트를 읽어 배열에 저장한다.
    return new String(bytes, "UTF-8");
  }

  public int readInt() throws Exception {
    // 상속 받은 read() 메서드를 사용하여 int 값 출력
    int value = 0;

    value = this.read() << 24;
    value += this.read() << 16;
    value += this.read() << 8;
    value += this.read();
    return value;
  }

  public long readLong() throws Exception {
    // 상속 받은 read() 메서드를 사용하여 long 값 출력
    long value = 0;
    value += (long) this.read() << 56;
    value += (long) this.read() << 48;
    value += (long) this.read() << 40;
    value += (long) this.read() << 32;
    value += (long) this.read() << 24;
    value += (long) this.read() << 16;
    value += (long) this.read() << 8;
    value += this.read();
    return value;
  }

  public boolean readBoolean() throws Exception {
    // 상속 받은 read() 메서드를 사용하여 boolean 값 출력
    if (this.read() == 1)
      return true;
    else
      return false;
  }
}


