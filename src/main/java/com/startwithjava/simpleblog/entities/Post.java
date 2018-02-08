package com.startwithjava.simpleblog.entities;
import lombok.Data;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Post extends AbstractEntity{
	private String title;
	private String content;
	private String slug;
	private String postType;

	@ElementCollection (fetch=FetchType.EAGER)
	@CollectionTable(name="post_meta" , joinColumns=@JoinColumn(name="ID"))
	@Column(name = "meta_value",nullable = true)
	public Map<String, String> postMetas = new HashMap<>();

	@ManyToOne
	@JoinColumn(name="author_id")
	private User author;
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster status;
}
