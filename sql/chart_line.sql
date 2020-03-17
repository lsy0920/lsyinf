prompt PL/SQL Developer Export User Objects for user LISONGYUE@SRM
prompt Created by lisongyue on 2020Äê3ÔÂ17ÈÕ
set define off
spool chart_line.log

prompt
prompt Creating table CHART_LINE
prompt =========================
prompt
create table LISONGYUE.CHART_LINE
(
  id            VARCHAR2(64) default sys_guid() not null,
  line_media    VARCHAR2(64),
  line_pageview VARCHAR2(64),
  line_weekday  VARCHAR2(64)
)
tablespace SRMDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table LISONGYUE.CHART_LINE
  add constraint PK_CHART_LINE primary key (ID)
  using index 
  tablespace SRMDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


prompt Done
spool off
set define on
