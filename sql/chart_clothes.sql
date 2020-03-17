prompt PL/SQL Developer Export User Objects for user LISONGYUE@SRM
prompt Created by lisongyue on 2020Äê3ÔÂ17ÈÕ
set define off
spool chart_clothes.log

prompt
prompt Creating table CHART_CLOTHES
prompt ============================
prompt
create table LISONGYUE.CHART_CLOTHES
(
  id            VARCHAR2(64) default sys_guid() not null,
  clothes_name  VARCHAR2(64),
  sales         VARCHAR2(64),
  clothes_day   VARCHAR2(64),
  clothes_price VARCHAR2(64)
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
alter table LISONGYUE.CHART_CLOTHES
  add constraint PK_ECHARTS_CLOTHES primary key (ID)
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
