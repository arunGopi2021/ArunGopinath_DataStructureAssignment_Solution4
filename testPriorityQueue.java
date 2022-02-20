import java.util.Collections;
import java.util.PriorityQueue;

public class testPriorityQueue{
    public static void main(String[] args) {
        int [] x = {7,5,3,2,6,4,1};
        PriorityQueue<Integer> y = new PriorityQueue<Integer>(Collections.reverseOrder());       
        
        for(int i =0; i<x.length;i++){
            //System.out.println(x[i]);
            y.add(x[i]);
        }// input

        int count = y.size();
        for(int i=0;i<count;i++){
            System.out.print(y.poll());
        }// output

        System.out.println("\n"); // print a new blank line



        // Testing the Logic for Disk Tower Problem
        PriorityQueue<Integer> z = new PriorityQueue<Integer>(Collections.reverseOrder());
        int reqdFloor = x.length;
        int recdFloor;

        for(int i=0;i<x.length;i++){
            recdFloor = x[i];
            if(reqdFloor==recdFloor){
                System.out.println("Day "+(i+1)+":");
                System.out.print(recdFloor+" ");
                
                while(!(z.isEmpty())){
                    reqdFloor = reqdFloor-1;
                    if(reqdFloor == z.peek()){
                        recdFloor = z.poll();
                        System.out.print(recdFloor+" ");
                    }else{
                        reqdFloor = reqdFloor+1;
                        break;
                    }
                }//while
                System.out.println("\n");
                reqdFloor = reqdFloor-1;
            }else{
                System.out.println("Day "+(i+1)+":\n");
                z.add(recdFloor);
            }//if-else
           
        }//    
        
        
        



    }
}
