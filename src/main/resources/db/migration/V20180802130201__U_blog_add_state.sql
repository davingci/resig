/*
**增加状态列, 用于表示文章状态，
**枚举类型，deleted,audited,pending,saved,published
*/

ALTER TABLE blog ADD COLUMN blog_state VARCHAR(10) AFTER id;
