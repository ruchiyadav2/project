# Java Event Management System

A Java Swing GUI-based Event Management System that allows users to manage event records (Create, Read, Update, Delete) and view/search events stored in a MySQL database. This project also includes SQL triggers and stored procedures for database-level operations.



## Features

- Add New Events  
- Delete Existing Events  
- Update Event Details  
- View All Events  
- Search Events by Title  
- View Today's Events  
- Help & Exit Functionality  
- MySQL Database Integration  
- Includes SQL Triggers & Procedures for backup and automation



## GUI Screens

Built using Java Swing with the following interface screens:

- `Home.java` – Main navigation page  
- `AddEvent.java` – Event creation form  
- `ShowEvent.java` – View all events (in TextArea)  
- `SearchEvent.java` – Search by title  
- `TodaysEvent.java` – View today’s events  
- `DeleteEvent.java` – Remove records  
- `UpdateEvent.java` – Edit event info  
- `Help.java` – Help message  
- `Exit.java` – Exit from application  

---

## Database Details

- **Database Name:** `prepare`  
- **Tables Used:**
  - `events` — Main event records
  - `event_user` — registered users
  - `backup_events` — Used by triggers to store insert/update/delete logs

---

## SQL Triggers and Procedures

All SQL code is included in the `database.sql` file.

### Triggers

- `after_insert_trigger` – Copies new event to `backup_events`  
- `after_update_trigger` – Stores updated event in `backup_events`  
- `after_delete_trigger` – Stores deleted event in `backup_events`  

### Procedures

- `add_event(title, date, time, description)`  
- `update_event(id, new_title, new_date, new_time, new_desc)`  
- `delete_event(id)`  
- `get_all_events()`  

---

## Technologies Used

- Java (Swing GUI)  
- MySQL  
- JDBC  
- SQL Triggers and Procedures  
- IDE: Eclipse or VS Code  



