package com.doanjava.nhom9_chdt.repository;

import com.doanjava.nhom9_chdt.entity.Loaidienthoai;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface LoaidienthoaiRepository extends
        PagingAndSortingRepository<Loaidienthoai, Long>, JpaRepository<Loaidienthoai, Long> {
    default List<Loaidienthoai> findAllLoaidienthoais(Integer pageNo,
                                                      Integer pageSize,
                                                      String sortBy) {
        return findAll(PageRequest.of(pageNo,
                pageSize,
                Sort.by(sortBy)))

                .getContent();
    }
    default List<Loaidienthoai> findAllLoaidienthoais() {
        return findAll();
    }
    @Query("""
        SELECT b FROM Loaidienthoai b
        WHERE b.tenLoai LIKE %?1%
        """)

    List<Loaidienthoai> searchLoaidienthoai(String keyword);
}
