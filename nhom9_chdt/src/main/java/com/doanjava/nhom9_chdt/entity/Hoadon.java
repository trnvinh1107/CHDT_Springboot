package com.doanjava.nhom9_chdt.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hoadon")
public class Hoadon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ngayLap")
    private Date ngayLap = new Date();
    @Column(name = "donGia")
    @Positive(message = "Total must be positive")
    private Double donGia;
    @OneToMany(mappedBy = "hoadon", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Cthd> cthds = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ToString.Exclude
    private User user;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) !=
                Hibernate.getClass(o)) return false;
        Hoadon invoice = (Hoadon) o;
        return getId() != null && Objects.equals(getId(),
                invoice.getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
