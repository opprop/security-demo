import security.qual.TopSecret;
import security.qual.Confidential;
import security.qual.Public;

public class Parameter {

  void method1(String p) {}
  void method2(String p) {}
  void method3(String p) {}
  void method4(String p) {}

  void parameter(String s1, @TopSecret String s2, @Confidential String s3, @Public String s4) {
    method1(s1);
    // :: error: (argument.type.incompatible)
    method2(s2);
    // :: error: (argument.type.incompatible)
    method3(s3);
    method4(s4);
  }
}