package assignment8.Q1;

import java.util.ArrayList;

public class GrowableStack implements Stack_Interface {
	

    private ArrayList<Employee> stack;
    
	public GrowableStack() {
        stack = new ArrayList<>();
    }

	@Override
	public void push(Employee emp) {

        stack.add(emp);
        System.out.println("Pushed: " + emp);
		
	}

	@Override
	public Employee pop() {
		if (stack.isEmpty()) {
            System.out.println("GrowableStack is empty!");
            return null;
        } else {
            return stack.remove(stack.size() - 1);
        }
	}



}
