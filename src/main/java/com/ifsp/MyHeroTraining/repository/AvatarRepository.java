package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, String> {
    Avatar findById(int id);
}
