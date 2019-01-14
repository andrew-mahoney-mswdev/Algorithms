package bst;

public class StudentBinarySearchTree {
/**
 * A binary search tree of students in which the right hand node records an older student, and the left hand node records
 * a younger student.
 */
	private Student root; //Object at the top of the tree.
	
	public StudentBinarySearchTree(int age, String name) {
		root = new Student(age, name); //Creates first student.
	}

	public void insert(int age, String name) {
		//Creates a new student and calls the recursive insert method.
		Student student = new Student(age, name);
		insert (student, root);
	}
	
	private void insert(Student newStudent, Student current) {
		if (newStudent.getAge() < current.getAge()) { //If the new student is younger:
			if (current.getLeftChild() != null) { //Check if the left node is vacant.
				insert(newStudent, current.getLeftChild()); //If not, move to the left node.
			} else {
				current.setLeftChild(newStudent);  //If so, insert the new student at this node.
			}
		} else { //If the new student is older:
			if (current.getRightChild() != null) { //Check if the right node is vacant.
				insert(newStudent, current.getRightChild()); //If not, move to the right node.
			} else {
				current.setRightChild(newStudent); //If so, insert the new student at this node.
			}
		}		
	}

	public Student getRoot() {return root;}
	
	public void getMaximumAge(Student current) {
		//The student with the highest age will be the student at the right most side of the tree.
		if (current.getRightChild() != null) getMaximumAge(current.getRightChild()); //Continue scrolling down the right side until we reach the end.
		else System.out.println("The oldest student is " + current.getName() + " aged " + current.getAge() + " years.");
	}
}
