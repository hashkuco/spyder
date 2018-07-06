package edu.csuft.shb.spyder;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FilmMapper {
	//insert into film() values();
	@Insert("insert into film(id,title,poster,satr,ratting,quote) values(#{id},#{title},#{poster},#{star},#{rating},#{quote})")
	void insert(Film film);
	@Select("select * from film")
	List<Film> findAll();
	
}
