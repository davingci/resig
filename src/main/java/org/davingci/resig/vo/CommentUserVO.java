
package org.davingci.resig.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.davingci.resig.domain.Comment;
import org.davingci.resig.domain.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentUserVO {

    private Integer id;

    private String fullname;

    @JsonProperty("profile_picture_url")
    private String profilePictureUrl;

    public static CommentUserVO build(Comment comment) {
        User user = comment.getUser();
        return CommentUserVO.builder()
                .id(user.getId())
                .fullname(user.getUsername())
                .profilePictureUrl(user.getProfilePictureUrl())
                .build();
    }


}
