package cn.hp.thread1;

public class TestThread1 {
	public static void main(String[] args) {
		//�����̶߳���
		MyThread t1 = new MyThread();
		
		//�����Զ������
		MyThread2 mythread = new MyThread2();
		//����Thread����  ���Զ����������������
		Thread t2 = new Thread(mythread);
		
		
		//�����߳�����
		t1.setName("����t1�߳�");
		//�����߳�
		t1.start();
		t2.start();
		
		
		for(int i=1;i<=100; i++){
			System.out.println(i+"�������߳�");
		}
		
		
	}
	
}

//�̳�Thread��
class MyThread extends Thread{
	//����run()
	public void run(){
		//��Ҫ���߳�ִ�еĴ���
		for(int i=1;i<=100;i++){
			System.out.println(i+this.getName());
		}
	}
}

//ʵ��Runnable�ӿ�
class MyThread2 implements Runnable{

	public void run() {
		//��Ҫ���߳�ִ�еĴ���
		for(int i=1;i<=100;i++){
			System.out.println(i+"����t2�߳�");
		}
		
	}
	
}

