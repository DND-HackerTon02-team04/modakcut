package io.dnd.modakcut.domain.room.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.dnd.modakcut.domain.medium.domain.Medium;
import io.dnd.modakcut.domain.result.domain.Result;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_group")
public class Room {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private String UUID;

	@OneToMany(fetch = FetchType.LAZY)
	private final Set<Medium> media = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY)
	private final Set<Result> results = new HashSet<>();

}
