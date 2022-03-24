package com.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.queriesandjoins.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long>  {
	List <Country> findAll();
	
	  @Query("select c.name, l.language, l.percentage from Country c " +
	            "join c.languages l where l.language = 'Slovene' order by l.percentage desc")
	    List <Object []> findByName();

	    @Query("select c.name, count(c) from Country c "
	            + "join c.cities ci group by c.name order by count(c) desc")
	    List <Object []> findByName2();

	    @Query("select c.name, l.language, l.percentage from Country c " +
	            "join c.languages l where l.percentage > 89 order by l.percentage desc")
	    List <Object []> findByName3();

	    @Query("select c.name, c.surface_area, c.population from Country c " +
	            "where c.surface_area < 501 and c.population > 100000")
	    List <Object []> findByName4();

	    @Query("select c.name, c.government_form, c.surface_area, c.life_expectancy from Country c " +
	            "where c.government_form = 'Constitutional Monarchy' and c.surface_area > 200 " +
	            "and c.life_expectancy > 75")
	    List <Object []> findByName5();

	    @Query("select c.name, ci.name, ci.district, ci.population from Country c "
	            + "join c.cities ci where c.name = 'Argentina' and ci.district = 'Buenos Aires' " +
	            "and ci.population > 500000")
	    List <Object []> findByName6();

	    @Query("select c.region, count(c) from Country c " +
	            "group by c.region order by count(c) desc")
	    List <Object []> findByRegion();

}
