package com.revature.revastudio.repositories;

import com.revature.revastudio.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
