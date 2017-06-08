/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017-06-08 14:10:11                          */
/*==============================================================*/


drop table if exists Task;

/*==============================================================*/
/* Table: Task                                                  */
/*==============================================================*/
create table Task
(
   TaskID               integer PRIMARY KEY autoincrement ,-- '任务id',
   TaskName             varchar(1000) ,-- '任务名称',
   TaskComment          varchar(5000) ,-- '任务备注',
   TomatoCount          int ,-- '番茄数',
   CreateTime           datetime ,-- '任务创建时间',
   ExpireTime           datetime ,-- '任务到期时间',
   TaskStatus           tinyint ,-- '任务状态,0为正常,1为已完成',
   Awoke                varchar(1000) ,-- '提醒时间,自定义规则',
   InsertTime           datetime -- '数据插入时间',
);

alter table Task -- '任务表';

