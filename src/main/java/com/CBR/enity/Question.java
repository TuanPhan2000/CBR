package com.CBR.enity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cauhoi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Question {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "cauhoi")
	private String cauHoi;
	
	@Column(name = "trongso")
	private int trongSo;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		return false;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
