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
   TaskID               integer PRIMARY KEY autoincrement ,-- '����id',
   TaskName             varchar(1000) ,-- '��������',
   TaskComment          varchar(5000) ,-- '����ע',
   TomatoCount          int ,-- '������',
   CreateTime           datetime ,-- '���񴴽�ʱ��',
   ExpireTime           datetime ,-- '������ʱ��',
   TaskStatus           tinyint ,-- '����״̬,0Ϊ����,1Ϊ�����',
   Awoke                varchar(1000) ,-- '����ʱ��,�Զ������',
   InsertTime           datetime -- '���ݲ���ʱ��',
);

alter table Task -- '�����';

