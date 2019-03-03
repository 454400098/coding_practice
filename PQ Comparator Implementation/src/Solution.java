import java.util.*;
class Student{
	public String name;
	public double cgpa;
	
	//constructor
	public Student(String name, double cgpa) {
		this.name = name;
		this.cgpa = cgpa;
	}
	
	//those getters
	public String getname() {
		return this.name;
	}
}
public class Solution {
	//Use max-heap to store student
	
	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<Student>(100,new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				// TODO Auto-generated method stub
//				if(s2.cgpa > s1.cgpa) return 1;
//				if(s2.cgpa < s1.cgpa ) return -1;
//				return 0;
				return Double.compare(s2.cgpa,s1.cgpa);
		
			}
		});
		
		
		Student a = new Student("chuck",3.9);
		Student b = new Student("alice",3.2);
		Student c = new Student("gustavo",3.99);
		
		
		pq.add(a);
		pq.add(b);
		pq.add(c);
//		pq.poll();
//		pq.poll();
		System.out.println(pq.peek().cgpa);
	
	}
	
	
	
}
