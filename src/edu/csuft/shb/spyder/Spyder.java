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
 *  网络爬虫
 * @author dell
 *
 */
public class Spyder implements Runnable  {
	String url;
	/**
	 * 构造方法
	 * 网站的路径
	 * @param newurl
	 */
	/**
	 * 电影类型对象
	 */
	List<Film> filmList;
	public Spyder(String newurl) {
		// TODO Auto-generated constructor stub
		url=newurl;
		filmList = new ArrayList<>();
	}

	public Spyder(String url, List<Film> filmList2) {
		// TODO Auto-generated constructor stub
		this.url = url;
		this.filmList = filmList2;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			Document doc=Jsoup.connect(url).get();
			//System.out.println(doc.title());
			//System.out.println(doc.text());//文本
			//System.out.println(doc.html());//源文件
			
			Elements es=doc.select(".grid_view .item");
			//System.out.println("数据规模："+es.size());
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
				String info = item.select(".bd p").first().text(); // 取出电影信息具体项目
				
				String s0[] = info.split("\\/");
				String str1[] = s0[0].split("\\: "); // 分出导演和主演
				film.setDirector(str1[1].replaceAll("主演", "")); // 设置导演
				if (str1.length < 3) // 设置演员
				{
					film.setActor(null);
				} else {
					film.setActor(str1[2].split("\\...")[0]);
				}

				String yearS[] = s0[s0.length - 3].split("\\ "); // 含年份的字符串
				try {
					film.setYear(Integer.parseInt(yearS[yearS.length - 1].trim())); // 设置年份
				} catch (NumberFormatException e) {
					String str[] = yearS[yearS.length - 1].split("\\("); // 对于某个特殊格式的年份处理
					film.setYear(Integer.parseInt(str[0]));
				}
				film.setCountry(s0[s0.length - 2]); // 设置国家
				

				String ratingP = item.select(".star span").last().text(); // 评价人数
				String s1[] = ratingP.split("\\人"); // 把评价只取出人数
				film.setratingP(Integer.parseInt(s1[0]));
			

				film.setStar(Integer.parseInt(s1[0]));
				
				System.out.println(film);
				filmList.add(film);
			}
			//获得会话工厂
			SqlSessionFactory factory=new SqlSessionFactoryBuilder()
					.build(new FileReader("config.xml"));
			SqlSession session=factory.openSession();
			//获得一个mapper(反射:黑魔法/语法糖）
			FilmMapper mapper=session.getMapper(FilmMapper.class);
			for(Film f:filmList) {
				mapper.insert(f);
			}
			session.commit();
			session.close();
			System.out.println("存储成功");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
