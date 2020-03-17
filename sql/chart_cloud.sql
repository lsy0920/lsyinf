prompt PL/SQL Developer Export User Objects for user LISONGYUE@SRM
prompt Created by lisongyue on 2020Äê3ÔÂ17ÈÕ
set define off
spool chart_cloud.log

prompt
prompt Creating table CHART_CLOUD
prompt ==========================
prompt
create table LISONGYUE.CHART_CLOUD
(
  id        VARCHAR2(64) default sys_guid() not null,
  word      VARCHAR2(64),
  word_size VARCHAR2(64)
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
alter table LISONGYUE.CHART_CLOUD
  add constraint PK_CHART_CLOUD primary key (ID)
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
