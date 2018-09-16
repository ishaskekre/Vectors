public class vector{

	protected double i;	    // x vector
	protected double j;		// y vector
	protected double k;     // z vector

	// constructor
	public vector(){
		i = 0;
		j = 0;
		k = 0;
	}

	// constructor
	public vector (double i, double j, double k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    // constructor
	public vector (vector a) {
    // set 
        this.i = a.i;
        this.j = a.j;
        this.k = a.k;
    }

    public void setI(double o){
		i=o;
	}

	// set
	public void setJ(double o){
		j=o;
	}

	// set 
	public void setK(double o){
		k=o;
	}

	// get 
	public double getI(){
		return(i);
	}

	// get 
	public double getJ(){
		return(j);
	}

	// get 
	public double getK(){
		return(k);
	}


	// return string representation of vector object
	public String toString(){
		return(i + "i + " + j + "j + " + k + "k");
	}

	public double magnitude(){
		return(Math.sqrt(this.i*this.i+this.j*this.j+this.k*this.k));
	}

	public double dot(vector b){
		return(this.i*b.i + this.j*b.j + this.k*b.k);
	}

	public vector cross(vector b){
		vector c = new vector();
		c.i = this.j*b.k-this.k*b.j;
		c.j = this.k*b.i-this.i*b.k;
		c.k = this.i*b.j-this.j*b.i;
		return(c);
	}

	public double angle(vector b){
		double x = this.dot(b);
		double c = Math.acos(x/(this.magnitude()*b.magnitude()));
		return(c);
	}

	public vector add(vector b){
		vector c = new vector();
		c.i = this.i+b.i;
		c.j = this.j+b.j;
		c.k = this.k+b.k;
		return(c);
	}

	public vector subtract(vector b){
		vector c = new vector();
		c.i = this.i-b.i;
		c.j = this.j-b.j;
		c.k = this.k-b.k;
		return(c);
	}

	public vector scalar(double x){
		vector c = new vector();
		c.i = this.i*x;
		c.j = this.j*x;
		c.k = this.k*x;
		return(c);
	}

	public vector reflectx(){
		vector c = new vector();
		c.i = this.i;
		c.j = -this.j;
		c.k = this.k;
		return(c);
	}

	public vector reflecty(){
		vector c = new vector();
		c.i = -this.i;
		c.j = this.j;
		c.k = this.k;
		return(c);
	}

	public vector reflectz(){
		vector c = new vector();
		c.i = -this.i;
		c.j = -this.j;
		c.k = this.k;
		return(c);
	}

	public vector reflectxy(){
		vector c = new vector();
		c.i = this.i;
		c.j = this.j;
		c.k = -this.k;
		return(c);
	}
	public double parallelepiped(vector a, vector b){
		double x = Math.abs(this.i*(a.j*b.k-a.k*b.j) - this.j*(a.i*b.k-a.k*b.i) + this.k*(a.i*b.j-a.j*b.i));
		return(x);
	}

	public double anglex(){
		vector b = new vector(5,0,0);
		if(this.i<0){
			b.reflecty();
		}
		double x = this.dot(b);
		double c = Math.acos(x/(this.magnitude()*b.magnitude()));
		return(c);
	}

	public double angley(){
		vector b = new vector(0,5,0);
		if(this.j<0){
			b.reflectx();
		}
		double x = this.dot(b);
		double c = Math.acos(x/(this.magnitude()*b.magnitude()));
		return(c);
	}

	public double anglez(){
		vector b = new vector(0,0,5);
		if(this.k<0){
			b.reflectxy();
		}
		double x = this.dot(b);
		double c = Math.acos(x/(this.magnitude()*b.magnitude()));
		return(c);
	}

	public double anglexy(){
		double x = Math.atan(this.k/Math.sqrt(this.i*this.i+this.j*this.j));
		return(x);
	}

	public double angleyz(){
		double x = Math.atan(this.i/Math.sqrt(this.k*this.k+this.j*this.j));
		return(x);
	}

	public double anglezx(){
		double x = Math.atan(this.j/Math.sqrt(this.i*this.i+this.k*this.k));
		return(x);
	}


}