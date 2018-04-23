import java.lang.Math;

class Complex {
  private double re;   // the real part
  private double im;   // the imaginary part

  public static double PI = Math.PI;
  public static double TAU= 2*PI;
  public static double E  = Math.E;

  // create a new object with the given real and imaginary parts
  public Complex(double real){
    this(real,0.0);
  }
  public Complex(double real, double imag) {
    re = real;
    im = imag;
  }
  
  // return the real or imaginary part
  public double re() { return re; }
  public double im() { return im; }

  // return a string representation of the invoking Complex object
  public String toString() {
    if (im == 0) return re + "";
    if (re == 0) return im + "i";
    if (im <  0) return re + " - " + (-im) + "i";
    return re + " + " + im + "i";
  }

  // return abs/modulus/magnitude
  public double abs() {
    return Math.hypot(re, im);
  }
  // static return abs/modulus/magnitude
  public static double abs(Complex a) {
    return Math.hypot(a.re, a.im);
  }

  // return angle/phase/argument, normalized to be between 0 and tau
  public double phase() {
    return Math.atan2(im, re)+Math.PI;
  }
  // static return angle/phase/argument, normalized to be between 0 and tau
  public static double phase(Complex a) {
    return Math.atan2(a.im, a.re+Math.PI);
  }

  // return a new Complex object whose value is (this + b)
  public Complex add(Complex b) {
    double real = re + b.re;
    double imag = im + b.im;
    return new Complex(real, imag);
  }
  public Complex add(double B) {
    Complex b  = new Complex(B);
    return add(b);
  }
  // static return a new Complex object whose value is (a + b)
  public static Complex add(Complex a, Complex b) {
    double real = a.re + b.re;
    double imag = a.im + b.im;
    return new Complex(real, imag);
  }
  public static Complex add(double A, Complex b) {
    Complex a = new Complex(A);
    return add(a,b);
  }
  public static Complex add(Complex a, double B) {
    Complex b = new Complex(B);
    return add(a,b);
  }

  // return a new Complex object whose value is (this - b)
  public Complex sub(Complex b) {
    Complex a = this;
    double real = a.re - b.re;
    double imag = a.im - b.im;
    return new Complex(real, imag);
  }
  public Complex sub(double B) {
    Complex b = new Complex(B);
    return sub(b);
  }
  // static return a new Complex object whose value is (a - b)
  public static Complex sub(Complex a,Complex b) {
    double real = a.re - b.re;
    double imag = a.im - b.im;
    return new Complex(real, imag);
  }
  public static Complex sub(double A,Complex b) {
    Complex a = new Complex(A);
    return sub(a,b);
  }
  public static Complex sub(Complex a,double B) {
    Complex b = new Complex(B);
    return sub(a,b);
  }

  // return a new Complex object whose value is (this * b)
  public Complex mult(Complex b) {
    Complex a = this;
    double real = a.re * b.re - a.im * b.im;
    double imag = a.re * b.im + a.im * b.re;
    return new Complex(real, imag);
  }
  public Complex mult(double B) {
    Complex b = new Complex(B);
    return mult(b);
  }
  //static
  public static Complex mult(Complex a, Complex b) {
    double real = a.re * b.re - a.im * b.im;
    double imag = a.re * b.im + a.im * b.re;
    return new Complex(real, imag);
  }
  public static Complex mult(double A, Complex b) {
    Complex a = new Complex(A);
    return mult(a,b);
  }
  public static Complex mult(Complex a, double B) {
    Complex b = new Complex(B);
    return mult(a,b);
  }

  // return a new object whose value is (this * alpha)
  public Complex scale(double alpha) {
    return new Complex(alpha * re, alpha * im);
  }
  //static
  public static Complex scale(Complex a,double alpha) {
    return new Complex(alpha * a.re, alpha * a.im);
  }

  // return a new Complex object whose value is the conjugate of this
  public Complex conjugate() {
    return new Complex(re, -im);
  }
  public static Complex conjugate(Complex a) {
    return new Complex(a.re, -a.im);
  }

  // return a new Complex object whose value is the reciprocal of this
  public Complex reciprocal() {
    double scale = re*re + im*im;
    return new Complex(re / scale, -im / scale);
  }
  public static Complex reciprocal(Complex a) {
    double scale = a.re*a.re + a.im*a.im;
    return new Complex(a.re / scale, -a.im / scale);
  }


  // return a / b
  public Complex div(Complex b) {
    Complex a = this;
    return a.mult(b.reciprocal());
  }
  public Complex div(double B) {
    Complex b = new Complex(B);
    return div(b);
  }
  public static Complex div(Complex a, Complex b) {
    return a.mult(b.reciprocal());
  }
  public static Complex div(double A, Complex b) {
    Complex a = new Complex(A);
    return div(a,b);
  }
  public static Complex div(Complex a, double B) {
    Complex b = new Complex(B);
    return div(a,b);
  }

  // return a new Complex object whose value is the complex exponential of this
  public Complex exp() {
    return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
  }
  public static Complex exp(Complex a) {
    return new Complex(Math.exp(a.re) * Math.cos(a.im), Math.exp(a.re) * Math.sin(a.im));
  }
  
  // retrun new Complex object that is the complex log of this
  public Complex ln() {
    Complex a = this;
    return new Complex(Math.log(Complex.abs(a)),phase(a));
  }
  public static Complex ln(Complex a) {
    return new Complex(Math.log(Complex.abs(a)),phase(a));
  }
  public static Complex ln(float a) {
    return new Complex(Math.log(a));
  }
  public static Complex ln(double a) {
    return new Complex(Math.log(a));
  }

  public Complex pow(Complex p) {
    Complex a = this;
    return exp( mult(p, ln(a)) );
  }
  public Complex pow(double P) {
    Complex p = new Complex(P);
    return pow(p);
  }
  public static Complex pow(Complex a,Complex p) {
    return exp(mult(ln(a),p));
  }
  public static Complex pow(Complex a,double P) {
    Complex p = new Complex(P);
    return pow(a,p);
  }
  public static Complex pow(double A,Complex p) {
    Complex a = new Complex(A);
    return pow(a,p);
  }


  // return a new Complex object whose value is the complex sine of this
  public Complex sin() {
    return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
  }
  public static Complex sin(Complex a) {
    return new Complex(Math.sin(a.re) * Math.cosh(a.im), Math.cos(a.re) * Math.sinh(a.im));
  }

  // return a new Complex object whose value is the complex cosine of this
  public Complex cos() {
    return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
  }
  public static Complex cos(Complex a) {
    return new Complex(Math.cos(a.re) * Math.cosh(a.im), -Math.sin(a.re) * Math.sinh(a.im));
  }

  // return a new Complex object whose value is the complex tangent of this
  public Complex tan() {
    return sin().div(cos());
  }
  public static Complex tan(Complex a) {
    return sin(a).div(cos(a));
  }
  

  public boolean equals(Object x) {
    if (x == null) return false;
    if (this.getClass() != x.getClass()) return false;
    Complex that = (Complex) x;
    return (this.re == that.re) && (this.im == that.im);
  }

}
