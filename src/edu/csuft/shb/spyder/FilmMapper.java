package edu.csuft.shb.spyder;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FilmMapper {
	//insert into film() values();
	@Insert("insert into filmss(id,title,poster,star,rating,quote,director,actor,country,years) values(#{id},#{title},#{poster},#{star},#{rating},#{quote},#{director},#{actor},#{year},#{country})")
	void insert(Film film);
	@Select("select * from filmss")
	List<Film> findAll();
	
}
