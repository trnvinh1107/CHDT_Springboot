package com.doanjava.nhom9_chdt.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "loaidienthoai")
public class Loaidienthoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenLoai", length = 50, nullable = false)
    private String tenLoai;
    @Column(name = "trangThai", nullable = false)
    private Boolean trangThai;
    @OneToMany(mappedBy = "loaidienthoai", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Dienthoai> dienthoais = new ArrayList<>();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) !=
                Hibernate.getClass(o)) return false;
        Loaidienthoai loaidienthoai = (Loaidienthoai) o;
        return getId() != null && Objects.equals(getId(),
                loaidienthoai.getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
