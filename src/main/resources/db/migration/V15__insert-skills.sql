INSERT INTO skills (name, topic_id) VALUES ('JAVA', (SELECT id FROM topics WHERE topic_type = 'TECHNOLOGY'));
INSERT INTO skills (name, topic_id) VALUES ('PYTHON', (SELECT id FROM topics WHERE topic_type = 'TECHNOLOGY'));
INSERT INTO skills (name, topic_id) VALUES ('JAVASCRIPT', (SELECT id FROM topics WHERE topic_type = 'TECHNOLOGY'));
INSERT INTO skills (name, topic_id) VALUES ('SQL', (SELECT id FROM topics WHERE topic_type = 'TECHNOLOGY'));
INSERT INTO skills (name, topic_id) VALUES ('ENGLISH', (SELECT id FROM topics WHERE topic_type = 'LANGUAGE'));
INSERT INTO skills (name, topic_id) VALUES ('REACT', (SELECT id FROM topics WHERE topic_type = 'TECHNOLOGY'));
INSERT INTO skills (name, topic_id) VALUES ('ANGULAR', (SELECT id FROM topics WHERE topic_type = 'TECHNOLOGY'));