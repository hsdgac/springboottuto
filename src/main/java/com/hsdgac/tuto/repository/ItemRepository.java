package com.hsdgac.tuto.repository;

import com.hsdgac.tuto.enitty.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {
}
