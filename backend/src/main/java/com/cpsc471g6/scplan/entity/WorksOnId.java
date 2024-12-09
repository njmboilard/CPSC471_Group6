package com.cpsc471g6.scplan.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class WorksOnId implements Serializable {
	private int projectId;
	private int employeeId;
}