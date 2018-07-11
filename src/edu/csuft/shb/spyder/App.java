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
		
		while (true) {

			if (pool.isTerminated() == true) { // ���������񶼹��˾Ϳ�ʼд����
				writeData(filmList);
				break;
			} else { // ����˯һ�� 
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	private static void writeData(List<Film> films) { // д�����ݷ��� �浽���ݿ� ��ͼƬ


		ExecutorService pool = Executors.newFixedThreadPool(8); // �����˸��߳� ����ͼƬ
		for (Film film : films) { // ��������
			pool.execute(new ImgDownload(film));
		}
		pool.shutdown();

	}

}
