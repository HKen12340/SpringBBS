INSERT INTO bbsuser(name,password) VALUES('TestUser','password');
INSERT INTO thread(title,create_userId,created_at,updated_at) VALUES('TEST',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO message(thread_id,user_id,msg_text,created_at) VALUES(1,1,'Test',CURRENT_TIMESTAMP);
INSERT INTO message(thread_id,user_id,msg_text,created_at) VALUES(1,1,'Test2',CURRENT_TIMESTAMP);
INSERT INTO message(thread_id,user_id,msg_text,created_at) VALUES(1,1,'Test3',CURRENT_TIMESTAMP);
