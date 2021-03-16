package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvatarRepository extends JpaRepository<Avatar, String> {
    Avatar findById(int id);

    List<Avatar> findAllByOrderByNameAsc();
}
