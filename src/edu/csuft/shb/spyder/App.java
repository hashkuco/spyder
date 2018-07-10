package edu.csuft.shb.spyder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/**		
		for(int i=0;i<250;i=i+25) {
		Spyder spyder = new Spyder("https://movie.douban.com/top250?start="+i);
		spyder.run();
		}
		��д�Ĳ��ö��߳����Ĵ���
**/		
		List<Film> filmList = Collections.synchronizedList(new LinkedList<>()); // ��̬���� �����̳߳�ͬ��

		ExecutorService pool = Executors.newFixedThreadPool(10); // �����̳߳أ��̶�10��
		int j;
		try {
			for (int i = 0; i < 250; i+=25) {
			
				pool.execute(new Spyder("https://movie.douban.com/top250?start=" + i )); // ���̳߳�ִ�в�ͬ��ҳ����ȡ
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.shutdown(); // �ر��̳߳�
		}
		
	}

}
