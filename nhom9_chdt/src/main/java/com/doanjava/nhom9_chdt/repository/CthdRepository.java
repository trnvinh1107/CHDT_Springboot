package com.doanjava.nhom9_chdt.repository;

import com.doanjava.nhom9_chdt.entity.Cthd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CthdRepository extends JpaRepository<Cthd, Long> {
    @Query("SELECT c FROM Cthd c WHERE c.hoadon.id = :hoadon_id")
    List<Cthd> findByHoadonId(Long hoadon_id);
}
