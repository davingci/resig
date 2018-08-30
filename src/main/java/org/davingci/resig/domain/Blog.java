
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
@EqualsAndHashCode(of={"id","title"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "comments","user" })
public class Blog extends AbstractAuditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer counter;
    
    @Enumerated(EnumType.STRING)
    @Column(length=10)
    private  BlogStateEnum blogState;

    private String title;

    @Type(type="text")
    private String html;

    @Type(type="text")
    private String text;

    private String abstractContent;

    private String thumbnailUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany (
            mappedBy = "blog",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<Comment> comments = new HashSet<>();
    


}
