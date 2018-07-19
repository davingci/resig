
package org.davingci.resig.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.davingci.resig.audit.AbstractAuditable;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of={"id","content"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "blog","user","parentComment","upVoteUsers" })
public class Comment extends AbstractAuditable<String> implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Type(type="text")
    private String content;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="parent_id")
    private Comment parentComment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="blog_id")
    private Blog blog;

    @ManyToMany (
            cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinTable (
            name="upvote_user_comment",
            joinColumns = {@JoinColumn(name="comment_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")}
    )
    private Set<User> upVoteUsers = new HashSet<>();


}
