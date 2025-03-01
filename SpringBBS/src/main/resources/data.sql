
INSERT INTO thread(title,created_at,updated_at) VALUES('TEST',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO bbsuser(name,password) VALUES('TestUser','password');
INSERT INTO message(thread_id,user_id,msg_text,created_at) VALUES(1,1,'Test',CURRENT_TIMESTAMP);