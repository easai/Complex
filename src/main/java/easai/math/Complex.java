//Complex.java  -- An implementation of a complex number class.

//Copyright (c) 2013 easai

//Author: easai 
//Website: easai.web.fc2.com/homepage/javadev/Trig/
//Created: Wed Dec 18 06:17:27 2013
//Keywords: math, mathematics, complex numbers, imaginary numbers, complex analysis

//Commentary:
//This is an implementation of a complex number class.
//
//Disclaimer:
//There is no way to overload operators in Java, the expressions are rather clumsy, z.add(z0) etc.
//

//Code:

package easai.math;

/**
* The <tt>Complex</tt> class represents a complex number class.   
*   
*  @author easai   
*/
public class Complex
{
 /** 
  * The real part of the complex number.
  */
 public double x=0;
 /** 
  * The imaginary part of the complex number.
  */
 public double y=0;

 /** 
  * The imaginary number i.
  */
 public static final Complex I=new Complex(0,1);

 /** 
  * Constructs a complex number.
  */
 public Complex(double x, double y)
 {
	this.x=x;
	this.y=y;
 }
 /** 
  * Returns the real part of the complex number.
  */
 public double Re()
 {
	return x;
 }
 /** 
  * Returns the imaginary part of the complex number.
  */
 public double Im()
 {
	return y;
 }
 /** 
  * Adds the complex number.
  */
 public Complex add(Complex c)
 {
	return new Complex(x+c.x,y+c.y);
 }
 /** 
  * Subtracts the complex number.
  */
 public Complex subtract(Complex c)
 {
	return new Complex(x-c.x,y-c.y);
 }
 /** 
  * Multiplies the complex number.
  */
 public Complex multiply(Complex c)
 {
	//	(x+iy)*(xx+iyy)=x*xx+x*iyy+iy*xx-y*yy	
	// for debugging purposes only
	//	System.out.println(x+"*"+c.x+"-"+y+"*"+c.y+" = "+(x*c.x-y*c.y));
	return new Complex(x*c.x-y*c.y, x*c.y+y*c.x);
 }
 /** 
  * Returns (-1)*z.
  */
 public Complex minus()
 {
	return multiply(new Complex(-1,0));
 }
 /** 
  * Returns true if the complex number has the same values.
  */
 public boolean equals(Complex c)
 {
	return (x==c.x) && (y==c.y);
 }
 /** 
  * Returns a string representation of the complex number.
  */
 public String toString()
 {
	return x+" + "+y+"*I";
 }
 /** 
  * Returns the absolute values of the complex number, i.e. |z|.
  */
 public double abs()
 {
	return Math.sqrt(x*x+y*y);
 }
 /** 
  * Returns the value of e to the complex number, i.e. e^z.
  */
 public static Complex exp(Complex z)
 {
	// z=x+iy
	// e^x*e^iy
	// e^iy=cosy+i*siny
	// Re e^z=e^x*cosy
	// Im e^z=e^x*siny	
	double ex=Math.pow(Math.E,z.x);
	return new Complex(ex*Math.cos(z.y),ex*Math.sin(z.y));
 }

 /** 
  * Returns sine of the complex number, i.e. sin(z).
  */
 public static Complex sin(Complex z)
 {
	Complex zi=z.multiply(Complex.I);
	Complex diff=exp(zi.minus()).subtract(exp(zi));
	return diff.multiply(new Complex(.5,0)).multiply(Complex.I);
 }

 /** 
  * Returns cosine of the complex number, i.e. cos(z).
  */
 public static Complex cos(Complex z)
 {
	Complex zi=z.multiply(Complex.I);
	Complex sum=exp(zi).add(exp(zi.minus()));	
	return sum.multiply(new Complex(.5,0));
 }

 /** 
  * If successfully complied, it should output the following.
  * <pre>
  * java Complex
  * z = 0.0 + 1.0*I
  * sin(z) = 0.0 + 1.1752011936438014*I
  * cos(z) = 1.5430806348152437 + 0.0*I
  * e^z = 0.5403023058681398 + 0.8414709848078965*I
  * </pre>
  */    
 public static void main(String args[])
 {
	Complex z=new Complex(0,1);
	Complex sin=Complex.sin(z);
	Complex cos=Complex.cos(z);
	Complex exp=Complex.exp(z);
	System.out.println("z = "+z.toString());
	System.out.println("sin(z) = "+sin.toString());
	System.out.println("cos(z) = "+cos.toString());
	System.out.println("e^z = "+exp.toString());	
 }
}

//Complex.java ends here
