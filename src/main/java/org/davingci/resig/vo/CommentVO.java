
package org.davingci.resig.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.davingci.resig.domain.Comment;
import org.davingci.resig.domain.User;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {

    private String content;

    private LocalDateTime created;

    @JsonProperty("created_by_current_user")
    private Boolean createdByCurrentUser;

    private String fullname;

    private String id;

    private LocalDateTime modified;

    private Integer parent;

    private Integer creator;

    @JsonProperty("profile_picture_url")
    private String profilePictureUrl;

    @JsonProperty("upvote_count")
    private Integer upvoteCount;

    @JsonProperty("user_has_upvoted")
    private Boolean userHasUpvoted;

    public static CommentVO build(Comment comment) {
        CommentVO commentVO =  CommentVO.builder()
                .content(comment.getContent())
                .created(comment.getCreatedDate())
                .createdByCurrentUser(Boolean.FALSE)
                .fullname(comment.getUser().getUsername())
                .id(comment.getId().toString())
                .modified(comment.getLastModifiedDate())
                .creator(comment.getUser().getId())
                .profilePictureUrl(comment.getUser().getProfilePictureUrl())
                .upvoteCount(comment.getUpVoteUsers().size())
                .build();

        //parent
        Integer parent = comment.getParentComment() == null ? null : comment.getParentComment().getId();
        commentVO.setParent(parent);

        //user have upvote
        Boolean userHasUpvoted = Boolean.FALSE;
        Set<User> upVoteUsers = comment.getUpVoteUsers();
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            User currentUser = (User) subject.getPrincipals().getPrimaryPrincipal();

            if(upVoteUsers != null && upVoteUsers.size() > 0) {
                int count =  (int) upVoteUsers.stream().filter(user ->
                    user.getUsername().equals(currentUser.getUsername())).count();
                if(count>0) {
                    userHasUpvoted = Boolean.TRUE;
                }
            }
        }


        commentVO.setUserHasUpvoted(userHasUpvoted);
        return commentVO;
    }


}
