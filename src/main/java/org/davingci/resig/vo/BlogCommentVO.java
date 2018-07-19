
package org.davingci.resig.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BlogCommentVO {

    private Set<CommentUserVO> users;

    private Set<CommentVO> comments;
}
