public class Queue {
    Node front;
    Node back;

    public Queue() {
        this.front = null;
        this.back = null;
    }

    //adds item to queue    
    void add(int item){
        Node temp = new Node(item);

        //if queue is empty make temp node front of queue
        if(this.back == null){
            this.front = temp;
            this.back = temp;
            return;
        }
        
        //back is from Queue and tail is from Node.
        this.back.tail = temp;
        this.back = temp;
    }

    Integer remove(){
        
        if(this.front == null){
            return null;
        }

        Node temp = this.front;
        this.front = this.front.tail;

        if(this.front == null){
            this.back = null;
        }

        return temp.item;
    }


}
