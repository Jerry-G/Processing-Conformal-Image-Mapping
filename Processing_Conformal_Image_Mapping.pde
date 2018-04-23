/**
 * Author: Jerry G
 * github:
 *   https://github.com/Jerry-G
 * March 2018
 * 
 * ispired by http://davidbau.com/archives/2013/02/10/conformal_map_viewer.html
 */
import java.lang.Math;

PImage img;
PImage out;

public Complex f(Complex z) {
  double x = z.re();
  double y = z.im();
  Complex i = new Complex(0,1);
  Complex n = new Complex(-1,0);
  Complex one = new Complex(1,0);

  return z.pow(2).div(50);
  //return z.pow(3).div(50000);
  //return z.pow(4).div(50000000);
  //return z.ln().mult(150);
  //return Complex.ln(Complex.pow(z,2)).mult(212);
  //return Complex.ln(Complex.pow(z,3)).mult(235);
  //return Complex.ln(Complex.pow(z,4)).mult(210);
  //return Complex.ln(Complex.pow(z,5)).mult(200);
  //return Complex.ln(Complex.pow(z,18)).mult(250);
  //return new Complex(x*y/(y-x),y-x);
  //return new Complex(x*y/32,y-x);//jinx
  //return z.pow( one.div( one.sin().exp().div(2) ) );//16
  //return z.pow(i).mult(1000);



}

  /*
  * Transformation of PImage object
  *
  * will turn every pixel in the result image to complex number
  * then apply the function f to number and calculate what color 
  * that pixel is on the original picture
  *
  * because of this f(z) is in reality the inverse of the function
  * being visualized
  * 
  */
public PImage transform(PImage original){
  PImage result=original.copy();
  original.loadPixels();
  result.loadPixels();
  //loop through all pixels
  for (int i = 0; i < original.pixels.length; i++) {
    //get x and y of current pixel
    int y = i/original.width-original.height/2;
    int x = i%original.width-original.width/2;
    //create Complex number and apply function f to it
    Complex z = new Complex(x,y);
    //scale allows for zoom, scale by < 1 is zoom in 
    //z = z.pow(2).div(100);
    z = f(z);
    //get x and y of the result of appling f(z)
    int xp = (int)(z.re()+original.width/2.0+0.5)%original.width;
    int yp = (int)(z.im()+original.height/2.0+0.5)%original.height;
    //periodicly assign x and y to values in the image
    if (xp < 0) {
      xp = -xp;
      xp = original.width - xp;
    }
    if (yp < 0) {
      yp = -yp;
      yp = original.height - yp;
    }
    //turn that those x and y values back into an index 
    int index = xp+yp*original.width%original.pixels.length;
    result.pixels[i] =original.pixels[index];
  }
  result.updatePixels();
  return result;
}

  /*
  * Save mapping to file when key s
  * is pressed
  */
void keyPressed(){
  if(key=='s')
    saveFrame("result.png");
}


void setup(){
  img = loadImage("img.jpg");
  int w = img.width;
  int h = img.height;
  surface.setSize(w,h);
  out=transform(img);
}
  /*
  * draw transformed image, save it
  * and exit
  */
void draw(){
  image(out,0,0);
  saveFrame("result.png");
  noLoop();
  //exit();
}