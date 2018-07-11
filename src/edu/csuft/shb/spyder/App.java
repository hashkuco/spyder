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
		我写的不用多线程爬的代码
**/		
		List<Film> filmList = Collections.synchronizedList(new LinkedList<>()); // 动态数组 并让线程池同步

		ExecutorService pool = Executors.newFixedThreadPool(10); // 容量线程池，固定10个
		int j;
		try {
			for (int i = 0; i < 250; i+=25) {
			
				pool.execute(new Spyder("https://movie.douban.com/top250?start=" + i )); // 让线程池执行不同网页的爬取
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.shutdown(); // 关闭线程池
		}
		
		while (true) {

			if (pool.isTerminated() == true) { // 当所有任务都关了就开始写数据
				writeData(filmList);
				break;
			} else { // 否则睡一秒 
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	private static void writeData(List<Film> films) { // 写入数据方法 存到数据库 下图片


		ExecutorService pool = Executors.newFixedThreadPool(8); // 开启八个线程 下载图片
		for (Film film : films) { // 遍历数组
			pool.execute(new ImgDownload(film));
		}
		pool.shutdown();

	}

}
