

import java.util.*;

public class QueueY {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    //add elements to the end of the queue
    public void add (int x) {
        stack1.push(x);
    }

    // remove element from the front of the queue
    public int remove() {
        if (empty()) {
            System.out.println("Queue is empty!");
            return -1;  
        }

        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
     
     // Check if the queue is empty
     public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
     }

     public void printQueue() {
        //Move all elements to stack2 to get them in correct order
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        //print from top to bottom of stack2(front of queue is at top)
        System.out.println("Queue: ");
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }

        //Print remaining elements in stack1 (those added after stack2 was filled)
        for (int i = 0; i < stack1.size(); i++) {
            System.out.print(stack1.get(i) + " ");
        }
        System.out.println();
     }
      
     // Peek the front element
     public int peek() {
        if (empty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
     } 

     public static void main(String[] args) {
        QueueY q = new QueueY();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());
        q.add(6);
        System.out.println("Removed: " + q.remove());

        System.out.println("Peek: " + q.peek());
        q.remove();

        q.printQueue();
        }
     }
