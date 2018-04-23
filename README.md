# Processing-Conformal-Image-Mapping
Processing program to transform a picture according to complex function.

One thing to note is the what is being graphed. In order to decide what color the pixel of the resulting picture should be, the fuction is applied to a complex number with the same real part as the x value of the pixel and the same imaginary part as the pixel. That result is then found in the original image and the pixel in the output is set the same color. In short if ```math f(z)=z^{2}``` then the resulting image would be a representation of $f(z)=sqrt{z}$.

Since I wrote most of the complex number logic, it might have some bugs. But nevertheless it produces some nice pictures. Here are a few of its results.


