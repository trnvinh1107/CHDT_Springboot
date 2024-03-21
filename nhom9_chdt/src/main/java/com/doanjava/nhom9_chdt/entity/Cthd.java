package com.doanjava.nhom9_chdt.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cthd")
public class Cthd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "quantity")
    @Positive(message = "Quantity must be positive")
    private int soLuong;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dienthoai_id", referencedColumnName = "id")
    @ToString.Exclude
    private Dienthoai dienthoai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hoadon_id", referencedColumnName = "id")
    @ToString.Exclude
    private Hoadon hoadon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) !=
                Hibernate.getClass(o)) return false;
        Cthd cthd = (Cthd) o;
        return getId() != null && Objects.equals(getId(),
                cthd.getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

