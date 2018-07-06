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
	public Film() {
		
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
		return "Film [id=" + id + ", title=" + title + ", poster=" + poster + ", star=" + star + ", rating=" + rating
				+ ", quote=" + quote + "]";
	}
	
	
	
}