package edu.csuft.shb.spyder;

public class Film {
	
	/**
	 * ����
	 */
	int id;
	
	/**
	 * ��Ӱ��
	 */
	String title;
	
	/**
	 * ����
	 */
	String poster;
	
	/**
	 * ��������
	 */
	double star;
	
	/**
	 * 
	 */
	String rating;
	
	/**
	 * ��������
	 */
	String quote;
	/**
	 * ����
	 */
	private String director;
	/**
	 * ����
	 */
	private String actor;
	/**
	 * ��ӳʱ��
	 */
	private int year;
	/**
	 * ����
	 */
	private String country;
	/**
	 * ��������
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
		return "Film [����:" + id + ", ��Ӱ��:" + title +", ����:"+ director+", ����:"+ actor+", ��ӳ���:"+ year+", ����:"+ country+", ��������:" + poster + ", ����:" + star + ", ��������:" + ratingP
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