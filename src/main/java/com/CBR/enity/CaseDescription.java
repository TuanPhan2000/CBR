package com.CBR.enity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "motacase")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CaseDescription {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcase")
	private Case case1;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcautraloi")
	private Answer answer;

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
