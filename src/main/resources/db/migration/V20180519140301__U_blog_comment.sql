/*
**将blog表中html和text的字段类型由 mediumtext 变为 text
**将comment表中content的字段类型由 mediumtext 变为 text
** mediumtext 长度限制   16777215字节
** text       长度限制   65535字节
** utf-8编码下一个汉字占三个字节
*/

ALTER TABLE blog MODIFY COLUMN html text;
ALTER TABLE blog MODIFY COLUMN text text;
ALTER TABLE comment MODIFY COLUMN content text;
