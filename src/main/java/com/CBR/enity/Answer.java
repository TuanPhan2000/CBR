package com.CBR.enity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "cautraloi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Answer {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "cautraloi")
	private String cauTraLoi;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcauhoi")
	private Question question;

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
