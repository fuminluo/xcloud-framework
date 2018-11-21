-- Table: public.t_user

-- DROP TABLE public.t_user;

CREATE TABLE public.t_user
(
    username character varying(64) COLLATE pg_catalog."default",
    age smallint,
    address character(128) COLLATE pg_catalog."default",
    password character varying(128) COLLATE pg_catalog."default",
    user_id character varying(64) COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_user
    OWNER to postgres;

COMMENT ON COLUMN public.t_user.username
    IS '用户名';

COMMENT ON COLUMN public.t_user.age
    IS '年龄';

COMMENT ON COLUMN public.t_user.address
    IS '地址';

COMMENT ON COLUMN public.t_user.password
    IS '密码';