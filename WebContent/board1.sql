CREATE TABLE  "BOARD_1" 
   (	"NUM_1" NUMBER, 
	"TITLE" VARCHAR2(20), 
	"ID_1" VARCHAR2(10), 
	"DATE_1" DATE, 
	"CONTENTS_1" VARCHAR2(1000), 
	 CONSTRAINT "BOARD_1_PK" PRIMARY KEY ("NUM_1") ENABLE
   ) ;

CREATE OR REPLACE TRIGGER  "BI_BOARD_1" 
  before insert on "BOARD_1"               
  for each row  
begin   
  if :NEW."NUM" is null then 
    select "BOARD_1_SEQ".nextval into :NEW."NUM" from dual; 
  end if; 
end; 

ALTER TRIGGER  "BI_BOARD_1" ENABLE; 

select * from board_1
drop table board_1
