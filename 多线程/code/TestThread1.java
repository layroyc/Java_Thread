package cn.hp.thread1;

public class TestThread1 {
	public static void main(String[] args) {
		//创建线程对象
		MyThread t1 = new MyThread();
		
		//创建自定义对象
		MyThread2 mythread = new MyThread2();
		//创建Thread对象  把自定义对象当作参数传入
		Thread t2 = new Thread(mythread);
		
		
		//设置线程名称
		t1.setName("我是t1线程");
		//启动线程
		t1.start();
		t2.start();
		
		
		for(int i=1;i<=100; i++){
			System.out.println(i+"我是主线程");
		}
		
		
	}
	
}

//继承Thread类
class MyThread extends Thread{
	//覆盖run()
	public void run(){
		//需要被线程执行的代码
		for(int i=1;i<=100;i++){
			System.out.println(i+this.getName());
		}
	}
}

//实现Runnable接口
class MyThread2 implements Runnable{

	public void run() {
		//需要被线程执行的代码
		for(int i=1;i<=100;i++){
			System.out.println(i+"我是t2线程");
		}
		
	}
	
}

