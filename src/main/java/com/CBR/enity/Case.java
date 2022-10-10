package com.CBR.enity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "ketluan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Case {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "hethong")
	private String heThong;

	@Column(name = "nguyennhan")
	private String nguyenNhan;

	@Column(name = "suachua")
	private String suaChua;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		return false;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
