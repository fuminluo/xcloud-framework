/*
Navicat PGSQL Data Transfer

Source Server         : postgres
Source Server Version : 90610
Source Host           : localhost:5430
Source Database       : postgres
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90610
File Encoding         : 65001

Date: 2018-10-28 14:14:40
*/


-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_user";
CREATE TABLE "public"."t_user" (
"username" varchar(64) COLLATE "default",
"age" int2,
"address" char(128) COLLATE "default",
"password" varchar(128) COLLATE "default",
"user_id" varchar(64) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."t_user"."username" IS '用户名';
COMMENT ON COLUMN "public"."t_user"."age" IS '年龄';
COMMENT ON COLUMN "public"."t_user"."address" IS '地址';
COMMENT ON COLUMN "public"."t_user"."password" IS '密码';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
