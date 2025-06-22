--Tables
CREATE TABLE events (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    date DATE,
    time VARCHAR(20),
    description VARCHAR(255)
);

CREATE TABLE event_user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    contact BIGINT,
    password VARCHAR(100),
    email VARCHAR(100)
);

-- Backup table
CREATE TABLE backup_events LIKE events;

-- Triggers
DELIMITER //
CREATE TRIGGER after_insert_event
AFTER INSERT ON events
FOR EACH ROW
BEGIN
    INSERT INTO backup_events VALUES (NEW.id, NEW.title, NEW.date, NEW.time, NEW.description);
END;
//

CREATE TRIGGER after_update_event
AFTER UPDATE ON events
FOR EACH ROW
BEGIN
    INSERT INTO backup_events VALUES (NEW.id, NEW.title, NEW.date, NEW.time, NEW.description);
END;
//

CREATE TRIGGER after_delete_event
AFTER DELETE ON events
FOR EACH ROW
BEGIN
    INSERT INTO backup_events VALUES (OLD.id, OLD.title, OLD.date, OLD.time, OLD.description);
END;
//

-- Procedures
CREATE PROCEDURE insert_event(IN p_title VARCHAR(100), IN p_date DATE, IN p_time VARCHAR(20), IN p_description VARCHAR(255))
BEGIN
    INSERT INTO events(title, date, time, description) VALUES (p_title, p_date, p_time, p_description);
END;
//

CREATE PROCEDURE update_event(IN p_id INT, IN p_title VARCHAR(100), IN p_date DATE, IN p_time VARCHAR(20), IN p_description VARCHAR(255))
BEGIN
    UPDATE events SET title=p_title, date=p_date, time=p_time, description=p_description WHERE id=p_id;
END;
//

CREATE PROCEDURE delete_event(IN p_id INT)
BEGIN
    DELETE FROM events WHERE id = p_id;
END;
//

CREATE PROCEDURE show_all_events()
BEGIN
    SELECT * FROM events;
END;
//
DELIMITER ;
