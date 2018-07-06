package edu.csuft.shb.spyder;



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<250;i=i+25) {
		Spyder spyder = new Spyder("https://movie.douban.com/top250?start="+i);
		spyder.run();
		}
	}

}
