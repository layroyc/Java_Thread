package cn.hp.thread1;

public class TestThread2 {
	public static void main(String[] args) {
		Stack s = new Stack();
		Thread t1 = new PushThread(s);  //��������ջ�߳�
		Thread t2 = new PopThread(s);  //�����ĳ�ջ�߳�
		
		//�����߳�
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

//����  A��B��''��''
class Stack{
	private char[] data={'A','B',' ',' ',' '};
	private int index=2;  //�����±� Ϊ2  ��2��ʼ�洢
	
	public void push(char c){
		//����
		System.out.println(c+"��");
		data[index]=c;
		index++;
	}
	
	public void pop(){
		//��
		index--; //ÿ��ȥһ��Ԫ�� �±�Ӧ���Լ�1
		System.out.println(data[index]+"��");
		data[index]=' '; //Ԫ�س�ȥ֮�����¸�ֵΪ��
	}
	
	public void print(){
		//��ӡ��������
		for(char c:data){
			System.out.print(c+" ");
		}
		System.out.println();
	}
}


class PushThread extends Thread{
	//��ջ
	Stack s ; //��������
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
