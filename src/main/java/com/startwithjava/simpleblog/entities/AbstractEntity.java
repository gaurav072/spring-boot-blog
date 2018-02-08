package com.startwithjava.simpleblog.entities;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import static javax.persistence.TemporalType.TIMESTAMP;

@Data
@MappedSuperclass
public abstract class AbstractEntity {
	 @Id @GeneratedValue(strategy=GenerationType.AUTO) 
	 protected Integer Id;
	 @CreatedDate
     LocalDateTime createdDate;
	 @LastModifiedDate
     LocalDateTime lastModifiedDate;
}
