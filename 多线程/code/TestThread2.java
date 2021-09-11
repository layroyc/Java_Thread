package cn.hp.thread1;

public class TestThread2 {
	public static void main(String[] args) {
		Stack s = new Stack();
		Thread t1 = new PushThread(s);  //创建的入栈线程
		Thread t2 = new PopThread(s);  //创建的出栈线程
		
		//启动线程
		s.print();
		t1.start();
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s.print();
	}
}

//数组  A、B、''、''
class Stack{
	private char[] data={'A','B',' ',' ',' '};
	private int index=2;  //定义下标 为2  从2开始存储
	
	public void push(char c){
		//进入
		System.out.println(c+"进");
		data[index]=c;
		index++;
	}
	
	public void pop(){
		//出
		index--; //每出去一个元素 下标应该自减1
		System.out.println(data[index]+"出");
		data[index]=' '; //元素出去之后重新赋值为空
	}
	
	public void print(){
		//打印数组内容
		for(char c:data){
			System.out.print(c+" ");
		}
		System.out.println();
	}
}


class PushThread extends Thread{
	//入栈
	Stack s ; //创建对象
	public PushThread(Stack s){
		this.s = s;
	}
	public void run(){
		synchronized(s){
			s.push('C');
		}
		
	}
}

class PopThread extends Thread{
	Stack s;
	public PopThread(Stack s){
		this.s = s;
	}
	public void run(){
		synchronized(s){
			s.pop();
		}
		
	}
}
