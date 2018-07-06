package edu.csuft.shb.spyder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 *  ��������
 * @author dell
 *
 */
public class Spyder  {
	String url;
	/**
	 * ���췽��
	 * ��վ��·��
	 * @param newurl
	 */
	/**
	 * ��Ӱ���Ͷ���
	 */
	List<Film> filmList;
	public Spyder(String newurl) {
		// TODO Auto-generated constructor stub
		url=newurl;
		filmList = new ArrayList<>();
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			Document doc=Jsoup.connect(url).get();
			//System.out.println(doc.title());
			//System.out.println(doc.text());//�ı�
			//System.out.println(doc.html());//Դ�ļ�
			
			Elements es=doc.select(".grid_view .item");
			//System.out.println("���ݹ�ģ��"+es.size());
			for(Element item:es) {
                Film film = new Film();
				film.title = item.select(".info .title").get(0).text();
				film.poster = item.select(".pic img").get(0).attr("src");
				film.rating = item.select(".star span").get(3).text();
	
				film.quote = item.select(".inq").text();
		
				String id = item.select("em").get(0).text();
				film.id = Integer.parseInt(id);
				String star = item.select(".rating_num").get(0).text();
				film.star = Double.parseDouble(star);
				
				System.out.println(film);
				filmList.add(film);
			}
			//��ûỰ����
			SqlSessionFactory factory=new SqlSessionFactoryBuilder()
					.build(new FileReader("config.xml"));
			SqlSession session=factory.openSession();
			//���һ��mapper(����:��ħ��/�﷨�ǣ�
			FilmMapper mapper=session.getMapper(FilmMapper.class);
			for(Film f:filmList) {
				mapper.insert(f);
			}
			session.commit();
			session.close();
			System.out.println("�洢�ɹ�");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
