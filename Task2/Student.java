package Elevate_Labs_Internship.Task2;

public class Student {

	private int rno;
	private String sname;
	private float cgpa;
	
	public Student(int rno , String sname , float cgpa)
	{
		this.rno=rno;
		this.sname=sname;
		this.cgpa=cgpa;
	}
	
	public int getrno() {
		return rno;
	}
	public String getsname() {
		return sname;
	}
	public float getcgpa() {
		return cgpa;
	}
	public void setsname(String sname) {
		this.sname = sname;
	}
	public void setcgpa(float cgpa) {
		this.cgpa = cgpa;
	}
}
