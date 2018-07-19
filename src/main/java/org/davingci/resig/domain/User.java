
package org.davingci.resig.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.davingci.resig.audit.AbstractAuditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value = { "blogs", "roles","upVoteComments" })
@Getter
@Setter
@EqualsAndHashCode(of={"id","username"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractAuditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String salt;

    private String profilePictureUrl;

    @OneToMany (
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<Blog> blogs = new HashSet<>();

    @OneToMany (
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<Comment> comments = new HashSet<>();

    @ManyToMany (
            mappedBy = "upVoteUsers",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private Set<Comment> upVoteComments = new HashSet<>();



    public String getCredentialsSalt() {
        return this.username + this.salt;
    }




}
