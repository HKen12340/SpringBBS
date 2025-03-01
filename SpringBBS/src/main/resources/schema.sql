DROP TABLE IF EXISTS Thread CASCADE;
DROP TABLE IF EXISTS bbsuser CASCADE;
DROP TABLE IF EXISTS message CASCADE;

CREATE TABLE thread(
	id SERIAL NOT NULL unique,
	title VARCHAR(255) NOT NULL,
	created_at timestamp without time zone,
	updated_at timestamp without time zone
);

CREATE TABLE bbsuser (
	id SERIAL NOT NULL unique,
	name VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
);

CREATE TABLE Message (
	id SERIAL PRIMARY KEY,
	thread_id INT NOT NULL,
	user_id INT NOT NULL,
	msg_text text NOT NULL,
	replay_id INT,
	created_at timestamp without time zone,
	FOREIGN KEY (thread_id) REFERENCES thread(id),
	FOREIGN KEY (user_id) REFERENCES bbsuser(id)
);