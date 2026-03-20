package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cg.entity.Music;
import java.util.*;


@Repository
public interface MusicRepo extends JpaRepository<Music,Integer> {
	
	public List<Music> findBytrackTitle(String title);
	
	

}
