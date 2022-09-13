-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-13 15:21:07.896

-- tables
-- Table: assigned
CREATE TABLE assigned (
    assigned_id int  NOT NULL,
    bonus_id int  NOT NULL,
    employee_id int  NOT NULL,
    salary_id int  NOT NULL,
    hiting_id int  NOT NULL,
    CONSTRAINT assigned_pk PRIMARY KEY (assigned_id)
);

-- Table: bonus
CREATE TABLE bonus (
    bonus_id int  NOT NULL,
    amount int  NOT NULL,
    CONSTRAINT bonus_pk PRIMARY KEY (bonus_id)
);

-- Table: child
CREATE TABLE child (
    child_id int  NOT NULL,
    parent_parent_id int  NOT NULL,
    child_name varchar(45)  NOT NULL,
    age int  NOT NULL,
    group_group_id int  NOT NULL,
    CONSTRAINT child_pk PRIMARY KEY (child_id)
);

-- Table: child_transition
CREATE TABLE child_transition (
    transition_id int  NOT NULL,
    kindergarden_garden_id int  NOT NULL,
    parent_parent_id int  NOT NULL,
    CONSTRAINT child_transition_pk PRIMARY KEY (transition_id)
);

-- Table: employee
CREATE TABLE employee (
    employee_id int  NOT NULL,
    name varchar(45)  NOT NULL,
    garden_id int  NOT NULL,
    CONSTRAINT employee_pk PRIMARY KEY (employee_id)
);

-- Table: group
CREATE TABLE "group" (
    group_id int  NOT NULL,
    name varchar(45)  NOT NULL,
    CONSTRAINT group_pk PRIMARY KEY (group_id)
);

-- Table: hiring
CREATE TABLE hiring (
    hiting_id int  NOT NULL,
    hire_date date  NOT NULL,
    CONSTRAINT hiring_pk PRIMARY KEY (hiting_id)
);

-- Table: kindergarden
CREATE TABLE kindergarden (
    garden_id int  NOT NULL,
    name varchar(45)  NOT NULL,
    adress varchar(45)  NOT NULL,
    employee_count int  NOT NULL,
    CONSTRAINT garden_id PRIMARY KEY (garden_id)
);

-- Table: parent
CREATE TABLE parent (
    parent_id int  NOT NULL,
    name varchar(45)  NOT NULL,
    CONSTRAINT parent_pk PRIMARY KEY (parent_id)
);

-- Table: retiring
CREATE TABLE retiring (
    retiring_id int  NOT NULL,
    employee_employee_id int  NOT NULL,
    kindergarden_garden_id int  NOT NULL,
    CONSTRAINT retiring_pk PRIMARY KEY (retiring_id)
);

-- Table: salary
CREATE TABLE salary (
    salary_id int  NOT NULL,
    amount int  NOT NULL,
    payday date  NOT NULL,
    CONSTRAINT salary_pk PRIMARY KEY (salary_id)
);

-- foreign keys
-- Reference: assigned_hiring (table: assigned)
ALTER TABLE assigned ADD CONSTRAINT assigned_hiring
    FOREIGN KEY (hiting_id)
    REFERENCES hiring (hiting_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: assigned_salary (table: assigned)
ALTER TABLE assigned ADD CONSTRAINT assigned_salary
    FOREIGN KEY (salary_id)
    REFERENCES salary (salary_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: bonus_assigned_bonus (table: assigned)
ALTER TABLE assigned ADD CONSTRAINT bonus_assigned_bonus
    FOREIGN KEY (bonus_id)
    REFERENCES bonus (bonus_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: bonus_assigned_employee (table: assigned)
ALTER TABLE assigned ADD CONSTRAINT bonus_assigned_employee
    FOREIGN KEY (employee_id)
    REFERENCES employee (employee_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: child_group (table: child)
ALTER TABLE child ADD CONSTRAINT child_group
    FOREIGN KEY (group_group_id)
    REFERENCES "group" (group_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: child_parent (table: child)
ALTER TABLE child ADD CONSTRAINT child_parent
    FOREIGN KEY (parent_parent_id)
    REFERENCES parent (parent_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: child_transition_kindergarden (table: child_transition)
ALTER TABLE child_transition ADD CONSTRAINT child_transition_kindergarden
    FOREIGN KEY (kindergarden_garden_id)
    REFERENCES kindergarden (garden_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: child_transition_parent (table: child_transition)
ALTER TABLE child_transition ADD CONSTRAINT child_transition_parent
    FOREIGN KEY (parent_parent_id)
    REFERENCES parent (parent_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: retiring_employee (table: retiring)
ALTER TABLE retiring ADD CONSTRAINT retiring_employee
    FOREIGN KEY (employee_employee_id)
    REFERENCES employee (employee_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: retiring_kindergarden (table: retiring)
ALTER TABLE retiring ADD CONSTRAINT retiring_kindergarden
    FOREIGN KEY (kindergarden_garden_id)
    REFERENCES kindergarden (garden_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

