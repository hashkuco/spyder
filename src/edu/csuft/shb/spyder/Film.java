package edu.csuft.shb.spyder;

public class Film {
	
	/**
	 * 排名
	 */
	int id;
	
	/**
	 * 电影名
	 */
	String title;
	
	/**
	 * 海报
	 */
	String poster;
	
	/**
	 * 评价人数
	 */
	double star;
	
	/**
	 * 
	 */
	String rating;
	
	/**
	 * 评论人数
	 */
	String quote;
	/**
	 * 导演
	 */
	private String director;
	/**
	 * 主演
	 */
	private String actor;
	/**
	 * 上映时间
	 */
	private int year;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 评价人数
	 */
	private int ratingP;
	public Film() {
		
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public int getratingP() {
		return ratingP;
	}


	public void setratingP(int ratingP) {
		this.ratingP = ratingP;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public double getStar() {
		return star;
	}


	public void setStar(double star) {
		this.star = star;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getQuote() {
		return quote;
	}


	public void setQuote(String quote) {
		this.quote = quote;
	}


	@Override
	public String toString() {
		return "Film [排名:" + id + ", 电影名:" + title +", 导演:"+ director+", 主演:"+ actor+", 上映年份:"+ year+", 国家:"+ country+", 海报链接:" + poster + ", 评分:" + star + ", 评分人数:" + ratingP
				+ ", quote:" + quote + "]";
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getActor() {
		return actor;
	}


	public void setActor(String actor) {
		this.actor = actor;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}
	
	
	
}