package assignment8.Q1;

public class FixedStack implements Stack_Interface {

	private Employee[] stack;
	private int top;
 	


	   public FixedStack() {
	        stack = new Employee[STACK_SIZE];
	        top = -1;
	    }

	@Override
	public void push(Employee emp) {
		if(top == STACK_SIZE-1)
			System.out.println("Stack is full, cant add.\n");
		else {
			stack[++top]=emp;
			System.out.println("Element pused in stack.\n");
		}
		
	}

	@Override
	public Employee pop() {
		if(top==-1) {
			System.out.println("Stack empty!\n");
		}
		else {
			return stack[top--];
		}
		return null;
	}


}
